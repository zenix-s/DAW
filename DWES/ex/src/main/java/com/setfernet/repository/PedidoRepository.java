package com.setfernet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.setfernet.model.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
