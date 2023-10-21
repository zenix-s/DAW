package net.unir.prueba.modelo.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.unir.prueba.modelo.javabean.Producto;

public class ProductoDaoImplList implements ProductoDao {
	private List<Producto> lista;
	private static int idAuto;
	
	static {
		idAuto = 0;
	}
	public ProductoDaoImplList() {
		lista = new ArrayList<>();
		cargarLista();
	}
	
	private void cargarLista() {
		lista.add(new Producto(1, "Pantalon corto", "Pantalon", "40", 15, 20, new Date(), "Pantalon corto vaquero"));
		lista.add(new Producto(2, "Camiseta manga larga", "Camiseta", "M", 10, 25, new Date(), "Camiseta manga larga verde"));
		lista.add(new Producto(3, "Sudadera", "Sudadera", "XL", 5, 30, new Date(), "Sudadera azul con capucha"));
		idAuto = 3;
	}

	@Override
	public Producto findById(int id) {
		for (int i = 0; i < lista.size();i++) {
			if (lista.get(i).getId() == id)
				return lista.get(i);
		}
		return null;
	}

	@Override
	public List<Producto> findAll() {
		
		return lista;
	}

	@Override
	public int insert(Producto producto) {
		if (!lista.contains(producto)) {
			producto.setId(++idAuto);
			lista.add(producto);
			
			return 1;
		}
		return 0;
	}

	@Override
	public int delete(int id) {
		Producto producto = findById(id);
		if (producto == null) 
			return 0;
		
		return lista.remove(producto) ? 1 : 0;
	}

	@Override
	public int updateOne(Producto producto) {
		int pos = lista.indexOf(producto);
		if (pos == -1)
			return 0;
		lista.set(pos, producto);
		return 1;
	}

}
