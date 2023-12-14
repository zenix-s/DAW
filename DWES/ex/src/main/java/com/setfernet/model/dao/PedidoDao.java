package com.setfernet.model.dao;

import java.util.List;

import com.setfernet.model.entity.Pedido;

public interface PedidoDao {
	List<Pedido> findAll();
	Pedido findPedido();
	Pedido createPedido();
	int updatePedido();
	int deltePedido();
}
