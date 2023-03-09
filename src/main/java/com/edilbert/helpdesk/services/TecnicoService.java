package com.edilbert.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edilbert.helpdesk.domain.Pessoa;
import com.edilbert.helpdesk.domain.Tecnico;
import com.edilbert.helpdesk.domain.dtos.TecnicoDTO;
import com.edilbert.helpdesk.repositories.PessoaRepository;
import com.edilbert.helpdesk.repositories.TecnicoRepository;
import com.edilbert.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.edilbert.helpdesk.services.exceptions.ObjectNotFoundException;

import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class TecnicoService {
	
	@Autowired
	private TecnicoRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado " +id));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}

	public Tecnico create(TecnicoDTO objDTO) {
		objDTO.setId(null);
		validaPorCpfEEmail(objDTO);
		// primeiro deve ser convertido o DTO para entidade
		Tecnico newObj = new Tecnico(objDTO);
		return repository.save(newObj);
	}

	private void validaPorCpfEEmail(TecnicoDTO objDTO) {
		Optional<Pessoa> obj =  pessoaRepository.findByCpf(objDTO.getCpf());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema");
		}
		
		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Email já cadastrado no sistema");
		}
				
	}


}
