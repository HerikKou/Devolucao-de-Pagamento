package Service.Pagamento.DTO;

import java.math.BigDecimal;

public class PagamentoProcessadoDTO {

private Long pagamentoId;
private Long decisaoId;
private BigDecimal valorPago;

public PagamentoProcessadoDTO(Long pagamentoId, BigDecimal valorPago) {
    this.pagamentoId = pagamentoId;
    this.valorPago = valorPago;
}
public PagamentoProcessadoDTO(Long pagamentoId, Long decisaoId) {
    this.pagamentoId = pagamentoId;
    this.decisaoId = decisaoId;
}
public Long getPagamentoId() {
    return pagamentoId;
}
public void setPagamentoId(Long pagamentoId) {
    this.pagamentoId = pagamentoId;
}
public Long getDecisaoId() {
    return decisaoId;
}
public void setDecisaoId(Long decisaoId) {
    this.decisaoId = decisaoId;
}
public BigDecimal getValorPago() {
    return valorPago;
}
public void setValorPago(BigDecimal valorPago) {
    this.valorPago = valorPago;
}




}
