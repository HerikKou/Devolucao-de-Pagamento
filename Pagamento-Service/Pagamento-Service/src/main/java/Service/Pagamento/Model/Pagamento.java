package Service.Pagamento.Model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private Long decisaoId;
    private Long devolucaoId;
    private BigDecimal valorPago;

    @Enumerated(EnumType.STRING)
    private Status status;
     public Pagamento(){}
    public Pagamento(Long id, Long decisaoId, Long devolucaoId, BigDecimal valorPago, Status status) {
        this.id = id;
        this.decisaoId = decisaoId;
        this.devolucaoId = devolucaoId;
        this.valorPago = valorPago;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDecisaoId() {
        return decisaoId;
    }

    public void setDecisaoId(Long decisaoId) {
        this.decisaoId = decisaoId;
    }

    public Long getDevolucaoId() {
        return devolucaoId;
    }

    public void setDevolucaoId(Long devolucaoId) {
        this.devolucaoId = devolucaoId;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
}
