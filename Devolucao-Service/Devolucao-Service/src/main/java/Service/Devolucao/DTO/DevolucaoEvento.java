package Service.Devolucao.DTO;

public class DevolucaoEvento {
    private Long devolucaoid;
    private Long transacaoid;
    private int qntdDisputaAberta;
    private int frequencia;
    private int qntdDeDisputaRealizada;

    public DevolucaoEvento(Long devolucaoid,Long transacaoid, int qntdDisputaAberta,  int frequencia,int qntdDeDisputaRealizada) {
        this.devolucaoid = devolucaoid;
        this.transacaoid = transacaoid;
        this.qntdDisputaAberta = qntdDisputaAberta;
        this.frequencia = frequencia;
        this.qntdDeDisputaRealizada = qntdDeDisputaRealizada;
    }

    public Long getDevolucaoid() {
        return devolucaoid;
    }

    public void setDevolucaoid(Long devolucaoid) {
        this.devolucaoid = devolucaoid;
    }

    public Long getTransacaoid() {
        return transacaoid;
    }

    public void setTransacaoid(Long transacaoid) {
        this.transacaoid = transacaoid;
    }

    public int getQntdDisputaAberta() {
        return qntdDisputaAberta;
    }

    public void setQntdDisputaAberta(int qntdDisputaAberta) {
        this.qntdDisputaAberta = qntdDisputaAberta;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    public int getQntdDeDisputaRealizada() {
        return qntdDeDisputaRealizada;
    }

    public void setQntdDeDisputaRealizada(int qntdDeDisputaRealizada) {
        this.qntdDeDisputaRealizada = qntdDeDisputaRealizada;
    }

   
    
}
