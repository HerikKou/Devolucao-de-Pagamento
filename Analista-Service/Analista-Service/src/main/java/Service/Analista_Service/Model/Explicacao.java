package Service.Analista_Service.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Explicacao {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private Long decisaoId;
private Long pagamentoId;
private String  explicacao;
public Explicacao(long id, Long decisaoId, Long pagamentoId, String explicacao) {
    this.id = id;
    this.decisaoId = decisaoId;
    this.pagamentoId = pagamentoId;
    this.explicacao = explicacao;
}
public Explicacao() {
    //TODO Auto-generated constructor stub
}
public long getId() {
    return id;
}
public void setId(long id) {
    this.id = id;
}
public Long getDecisaoId() {
    return decisaoId;
}
public void setDecisaoId(Long decisaoId) {
    this.decisaoId = decisaoId;
}
public Long getPagamentoId() {
    return pagamentoId;
}
public void setPagamentoId(Long pagamentoId) {
    this.pagamentoId = pagamentoId;
}
public String getExplicacao() {
    return explicacao;
}
public void setExplicacao(String explicacao) {
    this.explicacao = explicacao;
}

}
