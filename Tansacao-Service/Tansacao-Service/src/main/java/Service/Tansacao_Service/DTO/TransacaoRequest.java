package Service.Tansacao_Service.DTO;

import java.math.BigDecimal;

import Service.Tansacao_Service.Model.Tipo;

public class TransacaoRequest {
  private Long contaOrigem;
      
    private Long contaDestino;
    
    private BigDecimal valor = BigDecimal.ZERO;
    private Tipo tipo;
    public TransacaoRequest(){}
    public TransacaoRequest(Long contaOrigem, Long contaDestino, BigDecimal valor, Tipo tipo) {
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
        this.tipo = tipo;
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
    public Tipo getTipo() {
        return tipo;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
    
}
