package Service.Pagamento.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Service.Pagamento.Model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento , Long> {
    boolean existByDecisaoId(Long decisaoId);
}
