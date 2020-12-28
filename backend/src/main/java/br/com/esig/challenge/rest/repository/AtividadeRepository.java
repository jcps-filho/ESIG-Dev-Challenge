package br.com.esig.challenge.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.esig.challenge.rest.entity.Atividade;
import br.com.esig.challenge.rest.enums.StatusAtividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Integer> {
	
	List<Atividade> findByStatus(StatusAtividade status);
}
