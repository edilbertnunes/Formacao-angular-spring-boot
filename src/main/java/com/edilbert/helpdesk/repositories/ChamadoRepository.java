package com.edilbert.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edilbert.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
