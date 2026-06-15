package Service.Tansacao_Service.Model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long contaOrigem;
    @NotNull
    private Long contaDestino;
    @Positive
    private BigDecimal valor;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    private LocalDateTime dataHora;
    @Enumerated(EnumType.STRING)
    private Status status;
    public Transacao(){}
    public Transacao(Long id, Long contaOrigem, Long contaDestino, BigDecimal valor,Tipo tipo, LocalDateTime dataHora,
            Status status) {
        this.id = id;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;

        this.valor = valor;
        this.tipo = tipo;
        this.dataHora = dataHora;
        this.status = status;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getContaOrigem() {
        return contaOrigem;
    }
    public void setContaOrigem(Long contaOrigem) {
        this.contaOrigem = contaOrigem;
    }
    public Long getContaDestino() {
        return contaDestino;
    }
    public void setContaDestino(Long contaDestino) {
        this.contaDestino = contaDestino;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public Tipo getTipo() {
        return tipo;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    

}
