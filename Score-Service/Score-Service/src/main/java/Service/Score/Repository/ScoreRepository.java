package Service.Score.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Service.Score.Model.Score;

public interface ScoreRepository extends JpaRepository<Score, Long>{
 boolean existsByDevolucaoId(Long devolucaoId);
}
