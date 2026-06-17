# 💸 Devolução de Pagamento com IA

## O Problema

Muitas vezes pessoas fazem uma transferência Pix por engano e, ao abrir um chamado, a instituição financeira aprova ou reprova sem explicar o motivo. O cliente fica sem resposta, sem transparência e sem entender o que aconteceu com o seu dinheiro.

**Para resolver isso**, desenvolvi um sistema de disputa Pix que utiliza **score de credibilidade** para apoiar a decisão financeira e um **LLM (Claude)** para transformar os fatores da análise em explicações compreensíveis para o cliente.

> *"Porque 'solicitação negada' não é uma resposta."*

---

## Arquitetura

O sistema é composto por **7 microsserviços independentes**, cada um com seu próprio banco de dados e container Docker, comunicando-se de forma assíncrona via **Apache Kafka**.

<img width="925" height="619" alt="image" src="https://github.com/user-attachments/assets/b95897ae-c2ef-4404-bcd4-e283ac4a1436" />


---

## Modelagem

### Transacao
| Campo | Tipo |
|---|---|
| id | BIGSERIAL PK |
| contaOrigem | BIGINT NOT NULL |
| contaDestino | BIGINT NOT NULL |
| valor | NUMERIC(19,2) NOT NULL |
| tipoTransacao | VARCHAR(20) |
| dataHora | TIMESTAMP NOT NULL |
| status | VARCHAR(20) — REALIZADA, CANCELADA, EM_DISPUTA |

### Devolucao
| Campo | Tipo |
|---|---|
| id | BIGSERIAL PK |
| idTransacao | BIGINT UNIQUE NOT NULL |
| motivo | TEXT NOT NULL |
| qntdDisputaAberta | INT |
| qntdDeDisputaRealizada | INT |
| frequencia | INT |
| dataAbertura | TIMESTAMP |
| status | VARCHAR(20) — ABERTA, EM_ANALISE, APROVADA, NEGADA, EXPIRADA |

### Score
| Campo | Tipo |
|---|---|
| id | BIGSERIAL PK |
| idDevolucao | BIGINT UNIQUE NOT NULL |
| qntdDisputaAberta | INT |
| qntdDeDisputaRealizada | INT |
| frequencia | INT |
| statusScore | VARCHAR(10) — ALTO, BAIXO |
| scoreFinal | INT |

### Decisao
| Campo | Tipo |
|---|---|
| id | BIGSERIAL PK |
| idDevolucao | BIGINT NOT NULL |
| idScore | BIGINT UNIQUE |
| idTransacao | BIGINT UNIQUE |
| statusScore | VARCHAR(10) |
| statusDecisao | VARCHAR(10) — APROVADA, NEGADA |
| valor | NUMERIC(19,2) |

### Pagamento
| Campo | Tipo |
|---|---|
| id | BIGSERIAL PK |
| idDevolucao | BIGINT NOT NULL |
| idDecisao | BIGINT UNIQUE NOT NULL |
| valor | NUMERIC(19,2) |
| status | VARCHAR(20) |

### Explicacao
| Campo | Tipo |
|---|---|
| id | BIGSERIAL PK |
| idDecisao | BIGINT UNIQUE NOT NULL |
| idPagamento | BIGINT UNIQUE NOT NULL |
| explicacao | TEXT |

### Historico
| Campo | Tipo |
|---|---|
| id | BIGSERIAL PK |
| idExplicacao | BIGINT UNIQUE NOT NULL |
| idDecisao | BIGINT NOT NULL |
| idPagamento | BIGINT NOT NULL |
| dataRegistro | TIMESTAMP |

---

## Decisões Técnicas

### Por que Microsserviços ao invés de Monolito?

Em um monolito, todas as responsabilidades estariam juntas — score, decisão, pagamento, explicação — com risco de sobrecarga no banco em picos de uso e impacto em toda a aplicação a cada evolução de um componente.

Com microsserviços, cada domínio tem responsabilidade única e pode evoluir de forma independente. O `HistoricoService`, por exemplo, só registra — ele não calcula, não decide, não notifica. Se amanhã a lógica de score mudar, apenas o `ScoreService` é atualizado e redeploy sem afetar os outros 6 serviços.

### Por que Kafka ao invés de RabbitMQ, SNS ou SQS?

| Critério | Kafka | RabbitMQ | SNS/SQS |
|---|---|---|---|
| Retenção de mensagens | ✅ Retém por tempo configurável | ❌ Remove após consumo | ❌ Remove após consumo |
| Reprocessamento | ✅ Permite replay | ❌ Não suporta | ❌ Limitado |
| Throughput | ✅ Altíssimo | Médio | Médio |
| Rastreabilidade | ✅ Offset por partição | ❌ Limitada | ❌ Limitada |
| Ecossistema financeiro | ✅ Padrão de mercado | Menos comum | AWS only |

A comunicação assíncrona via Kafka garante que se um serviço cair, o restante continua operando e os eventos ficam na fila até ele voltar — fundamental para um sistema de disputas financeiras.

### Por que PostgreSQL ao invés de MySQL ou Oracle?

| Critério | PostgreSQL | MySQL | Oracle |
|---|---|---|---|
| Suporte a NUMERIC | ✅ Preciso para financeiro | ✅ | ✅ |
| Open Source | ✅ | ✅ | ❌ Licença cara |
| Tipos avançados | ✅ | Limitado | ✅ |
| Custo | ✅ Gratuito | ✅ Gratuito | ❌ Alto |
| Confiabilidade financeira | ✅ Amplamente usado | Médio | ✅ |

`NUMERIC(19,2)` do PostgreSQL garante precisão absoluta em valores financeiros — nunca use `FLOAT` ou `DOUBLE` em sistemas de pagamento.

### Por que Datadog?

Sistemas de disputas financeiras precisam de **observabilidade em tempo real**. O Datadog oferece:

- **APM** — rastreamento distribuído entre os 7 microsserviços
- **Logs centralizados** — todos os serviços em um único lugar
- **Alertas** — notificação imediata em falhas de processamento
- **Métricas** — tempo de resposta, taxa de erro, throughput por serviço
- **Dashboards** — visibilidade do fluxo completo da disputa

Em um sistema onde cada evento é uma decisão financeira, saber exatamente onde uma falha ocorreu é crítico.

### Por que separação de serviços?

Cada serviço tem uma responsabilidade única e bem definida:

| Serviço | Responsabilidade |
|---|---|
| `TransacaoService` | Registra o Pix realizado |
| `DevolucaoService` | Abre a disputa e calcula métricas comportamentais |
| `ScoreService` | Calcula o score de credibilidade |
| `DecisaoService` | Toma a decisão financeira com base no score |
| `PagamentoService` | Registra o pagamento aprovado |
| `ExplicacaoService` | Gera explicação humanizada via Claude (LLM) |
| `HistoricoService` | Registra o histórico completo para auditoria |

---

## Stack Tecnológica

- **Java 17** + **Spring Boot 3**
- **Apache Kafka** — comunicação assíncrona entre serviços
- **PostgreSQL** — banco de dados por serviço
- **Claude (Anthropic)** — LLM para geração de explicações
- **Docker** + **Docker Compose** — containerização
- **Datadog** — observabilidade e monitoramento
- **Bean Validation** — validação nas bordas do sistema

---

## Próximos Passos

- Adicionar Dockerfile e Docker Compose para containerização de todos os serviços
- Realizar testes unitários por serviço
- Testar o fluxo completo de ponta a ponta

---

## Autor

**Herik Kato**
- GitHub: [HerikKou](https://github.com/HerikKou)
- Site: [HerikKou.github.io](https://HerikKou.github.io)
