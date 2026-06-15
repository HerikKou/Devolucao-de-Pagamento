package Service.Tansacao_Service.DTO;
import Service.Tansacao_Service.Model.Status;
import Service.Tansacao_Service.Model.Tipo;

import java.math.BigDecimal;
import java.time.LocalDateTime;



public class TransacaoResponse {
    private Long id;
    
    private Long contaOrigem;
      
    private Long contaDestino;
    
    private BigDecimal valor;
    private Tipo tipo ;
   
    private LocalDateTime dataHora;
   
    private Status status;
    public TransacaoResponse(){}
    public TransacaoResponse(Long id, Long contaOrigem, Long contaDestino, BigDecimal valor,Tipo tipo, LocalDateTime dataHora,
            Status status) {
        this.id = id;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
        this.valor = valor;
        this.dataHora = dataHora;
        this.status = status;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public Tipo getTipo() {
        return tipo;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
}
