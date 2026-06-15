package Service.Score.DTO;

public class DevolucaoCriada {


    private Long devolucaoId;
    private Long transacaoId;
    private int qntdDeDisputaAberta;
    private int qntdDeDisputaRealizada;
    private int frequencia ;
    
    public DevolucaoCriada(Long devolucaoId, Long transacaoId, int qntdDeDisputaAberta, int qntdDeDisputaRealizada,
            int frequencia) {
        this.devolucaoId = devolucaoId;
        this.transacaoId = transacaoId;
        this.qntdDeDisputaAberta = qntdDeDisputaAberta;
        this.qntdDeDisputaRealizada = qntdDeDisputaRealizada;
        this.frequencia = frequencia;
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
    public int getQntdDeDisputaAberta() {
        return qntdDeDisputaAberta;
    }
    public void setQntdDeDisputaAberta(int qntdDeDisputaAberta) {
        this.qntdDeDisputaAberta = qntdDeDisputaAberta;
    }
    public int getQntdDeDisputaRealizada() {
        return qntdDeDisputaRealizada;
    }
    public void setQntdDeDisputaRealizada(int qntdDeDisputaRealizada) {
        this.qntdDeDisputaRealizada = qntdDeDisputaRealizada;
    }
    public int getFrequencia() {
        return frequencia;
    }
    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }
    
}
