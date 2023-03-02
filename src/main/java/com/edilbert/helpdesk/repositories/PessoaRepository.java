package com.edilbert.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edilbert.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
