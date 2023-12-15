package com.setfernet.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.setfernet.model.entity.Pedido;
import com.setfernet.repository.PedidoRepository;

@Repository
public class ImplementPedidoDao implements PedidoDao{

	@Autowired
	private PedidoRepository prep;
	
	@Override
	public List<Pedido> findAll() {
		return prep.findAll();
	}

	@Override
	public Pedido findPedido(int idPedido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pedido createPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updatePedido(Pedido pedido) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deltePedido(int idPedido) {
		// TODO Auto-generated method stub
		return 0;
	}

}
