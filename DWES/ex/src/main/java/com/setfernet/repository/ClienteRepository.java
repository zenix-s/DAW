package com.setfernet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.setfernet.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
