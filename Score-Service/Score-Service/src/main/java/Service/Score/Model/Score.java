package Service.Score.Model;

import Service.Score.Enum.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Score {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     @NotNull
     @Column(unique = true)
    private Long devolucaoId;
     @NotNull
    private Long transacaoId;
     @NotNull
    private int qntdDeDisputaAberta;
     @NotNull
    private int qntdDeDisputaRealizada;
     @NotNull
    private int frequencia ;
    @Enumerated(EnumType.STRING)
    private Status status;
    
    private int scorefinal;
     public Score(){}
    public Score(Long id, Long devolucaoId, Long transacaoId, int qntdDeDisputaAberta, int qntdDeDisputaRealizada,
            int frequencia, Status status, int scorefinal) {
        this.id = id;
        this.devolucaoId = devolucaoId;
        this.transacaoId = transacaoId;
        this.qntdDeDisputaAberta = qntdDeDisputaAberta;
        this.qntdDeDisputaRealizada = qntdDeDisputaRealizada;
        this.frequencia = frequencia;
        this.status = status;
        this.scorefinal = scorefinal;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public int getScorefinal() {
        return scorefinal;
    }
    public void setScorefinal(int scorefinal) {
        this.scorefinal = scorefinal;
    }
    








}
