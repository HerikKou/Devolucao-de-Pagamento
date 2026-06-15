package Service.Decisao.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import Service.Decisao.Model.Decisao;

public interface DecisaoRepository extends JpaRepository<Decisao, Long> {
    boolean existsByTransacaoId(Long transacaoId);
     boolean existsByScoreId(Long scoreId);


     Decisao findByDevolucaoId(long devolucaoId);
}
