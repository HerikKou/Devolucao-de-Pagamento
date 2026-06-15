package Service.Decisao.DTO;
import Service.Decisao.Enums.*;
import java.math.BigDecimal;

public class DecisaoEvento {
    private Long idDecisao;
    private Long idDevolucao;
    private BigDecimal valorAprovado;
    private Status statusScore;
    private DecisionStatus decisaoStatus;

    

    public DecisaoEvento(Long idDecisao, BigDecimal valorAprovado, Status statusScore, DecisionStatus decisaoStatus) {
        this.idDecisao = idDecisao;
        this.valorAprovado = valorAprovado;
        this.statusScore = statusScore;
        this.decisaoStatus = decisaoStatus;
    }
    public DecisaoEvento(Long idDecisao, Long idDevolucao, BigDecimal valorAprovado) {
        this.idDecisao = idDecisao;
        this.idDevolucao = idDevolucao;
        this.valorAprovado = valorAprovado;
    }
    public Long getIdDecisao() {
        return idDecisao;
    }
    public void setIdDecisao(Long idDecisao) {
        this.idDecisao = idDecisao;
    }
    public Long getIdDevolucao() {
        return idDevolucao;
    }
    public void setIdDevolucao(Long idDevolucao) {
        this.idDevolucao = idDevolucao;
    }
    public BigDecimal getValorAprovado() {
        return valorAprovado;
    }
    public void setValorAprovado(BigDecimal valorAprovado) {
        this.valorAprovado = valorAprovado;
    }
    public Status getStatusScore() {
        return statusScore;
    }
    public void setStatusScore(Status statusScore) {
        this.statusScore = statusScore;
    }
    public DecisionStatus getDecisaoStatus() {
        return decisaoStatus;
    }
    public void setDecisaoStatus(DecisionStatus decisaoStatus) {
        this.decisaoStatus = decisaoStatus;
    }
    

    
}
