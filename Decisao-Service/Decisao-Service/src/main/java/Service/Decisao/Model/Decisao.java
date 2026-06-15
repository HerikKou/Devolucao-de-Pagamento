package Service.Decisao.Model;

import java.math.BigDecimal;

import Service.Decisao.Enums.DecisionStatus;
import Service.Decisao.Enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Decisao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    @Column(unique = true)
    private Long scoreId;
    @NotNull
    private Long devolucaoId;
    
    @Column(unique = true)
    private Long transacaoId;
    
    private DecisionStatus decisaoStatus;
   
    private BigDecimal valor;

    private Status statusScore;
    public Decisao(Long id, Long scoreId, Long devolucaoId, Long transacaoId, DecisionStatus decisaoStatus,
            BigDecimal valor, Status statusScore) {
        this.id = id;
        this.scoreId = scoreId;
        this.devolucaoId = devolucaoId;
        this.transacaoId = transacaoId;
        this.decisaoStatus = decisaoStatus;
        this.valor = valor;
        this.statusScore = statusScore;
    }
    public Decisao() {
        //TODO Auto-generated constructor stub
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getScoreId() {
        return scoreId;
    }
    public void setScoreId(Long scoreId) {
        this.scoreId = scoreId;
    }
    public Long getDevolucaoId() {
        return devolucaoId;
    }
    public void setDevolucaoId(Long devolucaoId) {
        this.devolucaoId = devolucaoId;
    }
    public Long getTransacaoId() {
        return transacaoId;
    }
    public void setTransacaoId(Long transacaoId) {
        this.transacaoId = transacaoId;
    }
    public DecisionStatus getDecisaoStatus() {
        return decisaoStatus;
    }
    public void setDecisaoStatus(DecisionStatus decisaoStatus) {
        this.decisaoStatus = decisaoStatus;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    public Status getStatusScore() {
        return statusScore;
    }
    public void setStatusScore(Status statusScore) {
        this.statusScore = statusScore;
    }
    

}
