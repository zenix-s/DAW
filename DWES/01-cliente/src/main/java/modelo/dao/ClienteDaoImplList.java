package modelo.dao;

import java.util.List;
import java.util.ArrayList;

import modelo.javabeans.Cliente;


public class ClienteDaoImplList implements ClienteDao{
	
	private List<Cliente> lista;
	private static int idAuto;
	
	static {
		idAuto = 0;
	}
	
	public ClienteDaoImplList() {
		lista = new ArrayList<>();
		cargarLista();
	}
	
	private void cargarLista() {
		lista.add(new Cliente(1, "IFP", 128, 1_000_000));
		lista.add(new Cliente(2, "UNIE", 1000, 2_000_000));
		lista.add(new Cliente(3, "VIU", 67, 1_500_000));
		idAuto = 3;
	}
	
	@Override
	public Cliente findById(int idCliente) {
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getIdCliente() == idCliente) return lista.get(i);
		}
		return null;
	}

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Cliente insert(Cliente cliente) {
		
		if (lista.contains(cliente)) return null;
		
		cliente.setIdCliente(++idAuto);
		lista.add(cliente);
		return cliente;
		 
	}

	@Override
	public int delete(int idCliente) {
		Cliente cliente = findById(idCliente);
		if (cliente == null) return 0;
		
		return lista.remove(cliente) ? 1 : 0;
	}
	
}
