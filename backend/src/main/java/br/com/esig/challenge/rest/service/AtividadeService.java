package br.com.esig.challenge.rest.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.esig.challenge.rest.entity.Atividade;
import br.com.esig.challenge.rest.enums.StatusAtividade;
import br.com.esig.challenge.rest.repository.AtividadeRepository;

@Service
public class AtividadeService {
	
	@Autowired
	private AtividadeRepository atividadeRepository;
	
	public Atividade adicionar(Atividade atividade) {
		atividade.setExcluido(0);
		atividade.setStatus(StatusAtividade.A_FAZER);
		atividade.setData(new Date());
		return atividadeRepository.save(atividade);
	}
	
	public Atividade alterarStatus(Integer id, StatusAtividade novoStatus) {
		Optional<Atividade> optionalAtividade = atividadeRepository.findById(id);
		
		optionalAtividade.orElseThrow(() -> new ObjectNotFoundException(
				"Atividade com o id " + id + " não encontrada", null));
		
		Atividade atividade = optionalAtividade.get();
		
		atividade.setStatus(novoStatus);
		
		return atividadeRepository.saveAndFlush(atividade);
		
	}
	
	public Atividade excluir(Integer id) {
		Optional<Atividade> optionalAtividade = atividadeRepository.findById(id);
		
		optionalAtividade.orElseThrow(() -> new ObjectNotFoundException(
				"Atividade com o id " + id + " não encontrada", null));
		
		Atividade atividade = optionalAtividade.get();
		
		atividade.setExcluido(1);
		
		return atividadeRepository.saveAndFlush(atividade);
	}

	public Atividade findById(Integer id) {
		
		 Optional<Atividade> aluguel = atividadeRepository.findById(id);
		 
		 return aluguel.orElseThrow(() -> new ObjectNotFoundException(
					"Livro com o id " + id + " não encontrado", null)); 
	}
	
	public List<Atividade> listAll() {
		return atividadeRepository.findAll();
	}
	
	public List<Atividade> listByStatus(StatusAtividade status) {
		return atividadeRepository.findByStatus(status);
	}

}
