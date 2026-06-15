package Service.Tansacao_Service.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Service.Tansacao_Service.Model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

}
