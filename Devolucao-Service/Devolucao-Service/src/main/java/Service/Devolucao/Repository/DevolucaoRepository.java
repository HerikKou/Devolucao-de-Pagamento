package Service.Devolucao.Repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;

import Service.Devolucao.Model.Devolucao;
import Service.Devolucao.Model.Status;

public interface DevolucaoRepository extends JpaRepository<Devolucao, Long> {

    int countByIdTransacaoAndStatus(Long transacaoId, Status status);

    int countByIdTransacaoAndDataHora(long transacaoId, LocalDateTime datahora,  LocalDateTime tempo);

    boolean existsByTransacaoId(Long transacaoId);
}
