package com.edilbert.helpdesk;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edilbert.helpdesk.domain.Chamado;
import com.edilbert.helpdesk.domain.Cliente;
import com.edilbert.helpdesk.domain.Tecnico;
import com.edilbert.helpdesk.domain.enums.Perfil;
import com.edilbert.helpdesk.domain.enums.Prioridade;
import com.edilbert.helpdesk.domain.enums.Status;
import com.edilbert.helpdesk.repositories.ChamadoRepository;
import com.edilbert.helpdesk.repositories.ClienteRepository;
import com.edilbert.helpdesk.repositories.TecnicoRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tecnico tec1 = new Tecnico(null, "Edilbert Nunes", "805.402.130-55", "email@mail.com", "1234");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Linus Torvalds", "864.195.130-06", "torvalds@mail.com", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
	
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
		
		
	
	
	
	
	
	}

}
