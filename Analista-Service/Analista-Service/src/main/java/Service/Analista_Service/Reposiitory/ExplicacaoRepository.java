package Service.Analista_Service.Reposiitory;
import org.springframework.data.jpa.repository.JpaRepository;

import Service.Analista_Service.Model.Explicacao;


public interface ExplicacaoRepository extends JpaRepository<Explicacao, Long> {
    boolean existsByPagamentoId(Long pagamentoId);
}
