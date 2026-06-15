package Service.Analista_Service.DTO;

public class ExplicacaoGerada {
private long explicacaoId;
private Long decisaoId;
private Long pagamentoId;
public ExplicacaoGerada(long explicacaoId, Long decisaoId, Long pagamentoId) {
    this.explicacaoId = explicacaoId;
    this.decisaoId = decisaoId;
    this.pagamentoId = pagamentoId;
}
public long getExplicacaoId() {
    return explicacaoId;
}
public void setExplicacaoId(long explicacaoId) {
    this.explicacaoId = explicacaoId;
}
public Long getDecisaoId() {
    return decisaoId;
}
public void setDecisaoId(Long decisaoId) {
    this.decisaoId = decisaoId;
}
public Long getPagamentoId() {
    return pagamentoId;
}
public void setPagamentoId(Long pagamentoId) {
    this.pagamentoId = pagamentoId;
}


}
