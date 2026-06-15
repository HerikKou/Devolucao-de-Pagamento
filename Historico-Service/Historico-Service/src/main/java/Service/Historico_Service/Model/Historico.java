package Service.Historico_Service.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private Long explicacaoId;

    private Long decisaoId;
    private Long pagamentoId;
    private LocalDateTime dataRegistro;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getExplicacaoId() { return explicacaoId; }
    public void setExplicacaoId(Long explicacaoId) { this.explicacaoId = explicacaoId; }
    public Long getDecisaoId() { return decisaoId; }
    public void setDecisaoId(Long decisaoId) { this.decisaoId = decisaoId; }
    public Long getPagamentoId() { return pagamentoId; }
    public void setPagamentoId(Long pagamentoId) { this.pagamentoId = pagamentoId; }
    public LocalDateTime getDataRegistro() { return dataRegistro; }
    public void setDataRegistro(LocalDateTime dataRegistro) { this.dataRegistro = dataRegistro; }
}