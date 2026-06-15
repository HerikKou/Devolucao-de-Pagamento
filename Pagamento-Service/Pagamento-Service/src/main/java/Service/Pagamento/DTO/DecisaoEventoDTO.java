package Service.Pagamento.DTO;

import java.math.BigDecimal;

public class DecisaoEventoDTO {
 private Long decisaoId;
 private Long devolucaoId;
 private BigDecimal valorAprovado;
 public DecisaoEventoDTO(Long decisaoId, Long devolucaoId, BigDecimal valorAprovado) {
    this.decisaoId = decisaoId;
    this.devolucaoId = devolucaoId;
    this.valorAprovado = valorAprovado;
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
 public BigDecimal getValorAprovado() {
    return valorAprovado;
 }
 public void setValorAprovado(BigDecimal valorAprovado) {
    this.valorAprovado = valorAprovado;
 }

}
