package Service.Decisao.Service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import Service.Decisao.Enums.DecisionStatus;
import Service.Decisao.Enums.Status;
import Service.Decisao.Model.Decisao;

@Service
public class ServicePrincipal {


public BigDecimal  aprovarValor(Decisao decisao){
    return decisao.getStatusScore() == Status.ALTO ? decisao.getValor() : BigDecimal.ZERO;

    
}

public DecisionStatus definirStatus(BigDecimal valorAprovado) {
    return valorAprovado.compareTo(BigDecimal.ZERO) > 0
        ? DecisionStatus.APROVADA
        : DecisionStatus.NEGADA;
}




}
