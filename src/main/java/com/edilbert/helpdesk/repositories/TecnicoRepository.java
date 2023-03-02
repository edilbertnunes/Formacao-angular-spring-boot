package com.edilbert.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edilbert.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
