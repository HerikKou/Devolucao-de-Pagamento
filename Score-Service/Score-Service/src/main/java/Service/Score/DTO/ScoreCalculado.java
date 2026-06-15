package Service.Score.DTO;

import Service.Score.Enum.Status;

public class ScoreCalculado {
    private Long scoreId;
    private Long devolucaoId;
    
    private Status status;
    public ScoreCalculado(Long scoreId, Long devolucaoId, Status status) {
        this.scoreId = scoreId;
        this.devolucaoId = devolucaoId;
      
        this.status = status;
    }
    public Long getScoreId() {
        return scoreId;
    }
    public void setScoreId(Long scoreId) {
        this.scoreId = scoreId;
    }
    public Long getDevolucaoId() {
        return devolucaoId;
    }
    public void setDevolucaoId(Long devolucaoId) {
        this.devolucaoId = devolucaoId;
    }
    
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    
    
}
