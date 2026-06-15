package Service.Tansacao_Service.DTO;

import java.math.BigDecimal;

public class TransacaoEvento {
    private Long transacaoid;
    private BigDecimal valor ;
    public TransacaoEvento(){}
    public TransacaoEvento(Long transacaoid) {
        this.transacaoid = transacaoid;
    }
     public TransacaoEvento(Long transacaoid, BigDecimal valor) {
        this.transacaoid = transacaoid;
        this.valor = valor;
    }
    public Long getTransacaoid() {
        return transacaoid;
    }
    public void setTransacaoid(Long transacaoid) {
        this.transacaoid = transacaoid;
    }
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
}
