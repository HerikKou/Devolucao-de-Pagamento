package Service.Score.Service;

import org.springframework.stereotype.Component;

import Service.Score.Repository.ScoreRepository;

@Component
public class Idempotencia {
        private final ScoreRepository repository;


    public Idempotencia(ScoreRepository repository) {
            this.repository = repository;
        }
    public boolean devolucaoProcessada(Long devolucaoId){
        return repository.existsByDevolucaoId(devolucaoId);
    }
}
