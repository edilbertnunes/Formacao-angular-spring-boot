package com.edilbert.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edilbert.helpdesk.domain.Tecnico;
import com.edilbert.helpdesk.domain.dtos.TecnicoDTO;
import com.edilbert.helpdesk.repositories.TecnicoRepository;
import com.edilbert.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {
	
	@Autowired
	private TecnicoRepository repository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado " +id));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}

	public Tecnico create(TecnicoDTO objDTO) {
		objDTO.setId(null);
		// primeiro deve ser convertido o DTO para entidade
		Tecnico newObj = new Tecnico(objDTO);
		return repository.save(newObj);
	}


}
