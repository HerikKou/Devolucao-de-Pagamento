package Service.Devolucao.Service;

import org.springframework.stereotype.Component;

import Service.Devolucao.Repository.DevolucaoRepository;

@Component
public class Idempotencia {


    private final DevolucaoRepository repository;

    public Idempotencia(DevolucaoRepository repository) {
        this.repository = repository;
    }

    public boolean transacaoJaProcessado(long transacaoId){
        return repository.existsByTransacaoId(transacaoId);
    }
}
