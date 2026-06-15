package Service.Score.Service;

import org.springframework.stereotype.Component;

import Service.Score.DTO.DevolucaoCriada;
import Service.Score.Enum.Status;

@Component
public class CalculoService {


public int calcularFrequencia(int frequencia ){
  return frequencia >= 5 ? 30 : 100;
}

public int calcularQuantidadeDeDisputa(int aberta ){
    return aberta < 5 ? 100 : 30;
}

public int calcularQuantidadeDeDisputaRealizada(int realizadas){
   return realizadas < 5 ? 100 : 20;
}


public int scoreFinal(int frequencia, int aberta, int realizada){

    int resultadoFinal = calcularFrequencia(frequencia)
     + calcularQuantidadeDeDisputa(aberta) 
    + calcularQuantidadeDeDisputaRealizada(realizada);
     
     return resultadoFinal;
}


public Status definirResultadoFinal(int scorefinal){
    return scorefinal >= 60 ? Status.ALTO : Status.BAIXO;
}






}
