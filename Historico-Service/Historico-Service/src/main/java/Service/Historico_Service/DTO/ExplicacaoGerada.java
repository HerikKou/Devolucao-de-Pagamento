package Service.Historico.DTO;

public class ExplicacaoGerada {

    private Long explicacaoId;
    private Long decisaoId;
    private Long pagamentoId;

    public ExplicacaoEvento() {}

    public ExplicacaoEvento(Long explicacaoId, Long decisaoId, Long pagamentoId) {
        this.explicacaoId = explicacaoId;
        this.decisaoId = decisaoId;
        this.pagamentoId = pagamentoId;
    }

    public Long getExplicacaoId() { return explicacaoId; }
    public void setExplicacaoId(Long explicacaoId) { this.explicacaoId = explicacaoId; }
    public Long getDecisaoId() { return decisaoId; }
    public void setDecisaoId(Long decisaoId) { this.decisaoId = decisaoId; }
    public Long getPagamentoId() { return pagamentoId; }
    public void setPagamentoId(Long pagamentoId) { this.pagamentoId = pagamentoId; }
}