package Service.Devolucao.Model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
public class Devolucao {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private Long transacaoid;

    @NotNull
    private String motivo;

    @NotNull
    private int qntdDisputaAberta;
    @NotNull
    private int qntdDeDisputaRealizada;
    @NotNull
    private int frequencia; 
    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime dataAbertura;
    public Devolucao(){}
    public Devolucao(Long id,  Long transacaoid,  String motivo,  int qntdDisputaAberta,
             int qntdDeDisputaRealizada, int frequencia,Status status,  LocalDateTime dataAbertura) {
        this.id = id;
        this.transacaoid = transacaoid;
        this.motivo = motivo;
        this.qntdDisputaAberta = qntdDisputaAberta;
        this.qntdDeDisputaRealizada = qntdDeDisputaRealizada;
        this.frequencia = frequencia;
        this.status = status;
        this.dataAbertura = dataAbertura;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getTransacaoid() {
        return transacaoid;
    }
    public void setTransacaoid(Long transacaoid) {
        this.transacaoid = transacaoid;
    }
    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public int getQntdDisputaAberta() {
        return qntdDisputaAberta;
    }
    public void setQntdDisputaAberta(int qntdDisputaAberta) {
        this.qntdDisputaAberta = qntdDisputaAberta;
    }
    public int getQntdDeDisputaRealizada() {
        return qntdDeDisputaRealizada;
    }
    public void setQntdDeDisputaRealizada(int qntdDeDisputaRealizada) {
        this.qntdDeDisputaRealizada = qntdDeDisputaRealizada;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }
    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
    public int getFrequencia() {
        return frequencia;
    }
    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }
    
    

}
