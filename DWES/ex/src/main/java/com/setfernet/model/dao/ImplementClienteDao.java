package com.setfernet.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.setfernet.model.entity.Cliente;
import com.setfernet.repository.ClienteRepository;

@Repository
public class ImplementClienteDao implements ClienteDao{

	@Autowired
	private ClienteRepository crep;
	
	@Override
	public List<Cliente> findAll() {
		return crep.findAll();
	}

	@Override
	public Cliente findCliente(int idCliente) {
		return crep.findById(idCliente).orElse(null);
	}

	@Override
	public Cliente createCliente(Cliente cliente) {
		return crep.save(cliente);
	}

	@Override
	public int updateCliente(Cliente cliente) {
		try {
			crep.save(cliente);
			return 1;
		} catch(Exception e) {
			System.err.println(e.getMessage());
			return 0;
		}
	}

	@Override
	public int delteCliente(int idCliente) {
		if(crep.existsById(idCliente)) {
			crep.deleteById(idCliente);
			return 1;
		}else {
			return 0;
		}
	}

}
