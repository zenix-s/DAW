package net.unir.prueba.modelo.dao;

import java.util.List;

import net.unir.prueba.modelo.javabean.Producto;

public interface ProductoDao {
	List<Producto> findAll();
	Producto findById(int id);
	int insert (Producto producto);
	int delete(int id);
	int updateOne(Producto producto);
}
