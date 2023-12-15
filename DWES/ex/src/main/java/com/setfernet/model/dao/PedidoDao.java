package com.setfernet.model.dao;

import java.util.List;

import com.setfernet.model.entity.Pedido;

public interface PedidoDao {
	List<Pedido> findAll();
	Pedido findPedido(int idPedido);
	Pedido createPedido(Pedido pedido);
	int updatePedido(Pedido pedido);
	int deltePedido(int idPedido);
}
