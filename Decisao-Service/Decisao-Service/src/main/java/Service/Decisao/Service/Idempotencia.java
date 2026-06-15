package Service.Decisao.Service;

import org.springframework.stereotype.Component;

import Service.Decisao.Repository.DecisaoRepository;

@Component
public class Idempotencia {
private final DecisaoRepository repository;


public Idempotencia(DecisaoRepository repository) {
    this.repository = repository;
}
public boolean transacaojaProcessado(Long transacaoId){
    return repository.existsByTransacaoId(transacaoId);

}

public boolean scorejaProcessado(Long scoreId){
    return repository.existsByScoreId(scoreId);

}





}
