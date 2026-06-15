package Service.Analista_Service.DTO;


public class PagamentoProcessado {
    private Long pagamentoId;
    private Long decisdaoId;
    public PagamentoProcessado(Long pagamentoId, Long decisdaoId) {
        this.pagamentoId = pagamentoId;
        this.decisdaoId = decisdaoId;
    }
    public Long getPagamentoId() {
        return pagamentoId;
    }
    public void setPagamentoId(Long pagamentoId) {
        this.pagamentoId = pagamentoId;
    }
    public Long getDecisdaoId() {
        return decisdaoId;
    }
    public void setDecisdaoId(Long decisdaoId) {
        this.decisdaoId = decisdaoId;
    }
    
}
