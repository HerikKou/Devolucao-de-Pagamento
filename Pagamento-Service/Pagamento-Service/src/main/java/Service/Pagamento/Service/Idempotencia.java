package Service.Pagamento.Service;

import org.springframework.stereotype.Component;

import Service.Pagamento.DTO.DecisaoEventoDTO;
import Service.Pagamento.Repository.PagamentoRepository;

@Component
public class Idempotencia {

    private final PagamentoRepository repository;

    public Idempotencia(PagamentoRepository repository) {
        this.repository = repository;
    }
    public boolean DecisaoProcessado(Long decisaoId){
        return repository.existByDecisaoId(decisaoId);
    }
}
