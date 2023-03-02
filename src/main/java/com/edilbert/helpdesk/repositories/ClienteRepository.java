package com.edilbert.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edilbert.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
