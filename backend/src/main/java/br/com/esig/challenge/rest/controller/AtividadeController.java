package br.com.esig.challenge.rest.controller;

import java.net.URI;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.esig.challenge.rest.entity.Atividade;
import br.com.esig.challenge.rest.enums.StatusAtividade;
import br.com.esig.challenge.rest.service.AtividadeService;

@RestController
@RequestMapping(value="/atividade")
public class AtividadeController {
	
	@Autowired
	private AtividadeService atividadeService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findId(@PathVariable Integer id) throws ObjectNotFoundException {
		
		Atividade response = atividadeService.findById(id);
		
		return ResponseEntity.ok().body(response);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<?> listAll() throws ObjectNotFoundException {
		
		List<Atividade> response = atividadeService.listAll();
		
		return ResponseEntity.ok().body(response);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/listByStatus", method = RequestMethod.GET)
	public ResponseEntity<?> listByStatus(@RequestParam int status) throws ObjectNotFoundException {
		
		List<Atividade> response = atividadeService.listByStatus(StatusAtividade.values()[status]);
		
		return ResponseEntity.ok().body(response);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/adicionar", method = RequestMethod.PUT)
	public ResponseEntity<Atividade> adicionar(@RequestBody Atividade atividade) {
		
		Atividade response = atividadeService.adicionar(atividade);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(response.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/feito", method = RequestMethod.POST)
	public ResponseEntity<?> feito(@RequestBody Integer id) {
		Atividade response = atividadeService.alterarStatus(id, StatusAtividade.FEITO);
		return ResponseEntity.ok().body(response);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/fazer", method = RequestMethod.POST)
	public ResponseEntity<Atividade> aFazer(@RequestBody Integer id) {
		Atividade response = atividadeService.alterarStatus(id, StatusAtividade.A_FAZER);
		return ResponseEntity.ok().body(response);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/excluir", method = RequestMethod.DELETE)
	public ResponseEntity<?> excluir(@RequestParam int id) {
		Atividade response = atividadeService.excluir(id);
		return ResponseEntity.ok().body(response);
	}

}
