package com.setfernet.model.dao;

import java.util.List;

import com.setfernet.model.entity.Cliente;

public interface ClienteDao {
	List<Cliente> findAll();
	Cliente findCliente(int idCliente);
	Cliente createCliente(Cliente cliente);
	int updateCliente(Cliente cliente);
	int delteCliente(int idCliente);
}
