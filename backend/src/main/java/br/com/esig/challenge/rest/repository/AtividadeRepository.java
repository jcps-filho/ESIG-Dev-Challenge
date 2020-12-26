package br.com.esig.challenge.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.esig.challenge.rest.entity.Atividade;

@Repository
public interface AtividadeRepository extends JpaRepository<Atividade, Integer> {
}
