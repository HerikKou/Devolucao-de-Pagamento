package Service.Historico.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Service.Historico_Service.Model.Historico;

public interface HistoricoRepository extends JpaRepository<Historico, Long> {
    boolean existsByExplicacaoId(Long explicacaoId);
}