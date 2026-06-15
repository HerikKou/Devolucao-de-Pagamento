package Service.Analista_Service.Service;

import org.springframework.stereotype.Component;

import Service.Analista_Service.Reposiitory.ExplicacaoRepository;

@Component
public class Idempotencia {
    private final ExplicacaoRepository repository;

    public Idempotencia(ExplicacaoRepository repository) {
        this.repository = repository;
    }

    public boolean pagamentoJaProcessado(Long pagamentoId){
        return repository.existsByPagamentoId(pagamentoId);
    }
}
