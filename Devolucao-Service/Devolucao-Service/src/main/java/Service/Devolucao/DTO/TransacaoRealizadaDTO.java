package Service.Devolucao.DTO;

public class TransacaoRealizadaDTO {
    private Long transacaoid;
     public TransacaoRealizadaDTO(){}
    public TransacaoRealizadaDTO(Long transacaoid) {
        this.transacaoid = transacaoid;
    }
    public Long getTransacaoid() {
        return transacaoid;
    }
    public void setTransacaoid(Long transacaoid) {
        this.transacaoid = transacaoid;
    }
    
}
