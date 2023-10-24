package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplList;
import modelo.javabeans.Cliente;

/**
 * Servlet implementation class ClientController
 */
@WebServlet("/client")
public class ClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ClienteDao cdao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientController() {
    	super();
    	cdao = new ClienteDaoImplList();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		switch(opcion) {
		case "todos":
			System.out.println("todos");
			procesarTodos(request, response);
			break;
		case "ver":
			System.out.println("VER");
			procesarVerUno(request, response);
			break;
		case "eliminar":
			System.out.println("ELIMINAR");
			procesarEliminarUno(request, response);
			break;
		case "altaCliente":
			System.out.println("NUEVO");
			procesoFormularioNuevoCliente(request, response);
			break;
		default:
			System.out.println("Metodo incorrecto");
			procesarTodos(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensaje = null;
		Cliente cliente = new Cliente();
		cliente.setNombre(request.getParameter("nombre"));
		cliente.setCantidadEmpleados(Integer.parseInt(request.getParameter("cantidadEmpleados")));
		cliente.setFacturacionAnual(Double.parseDouble(request.getParameter("facturacionAnual")));
		
		if (cdao.insert(cliente) != null)  mensaje = "Cliente dado de alta";
		else mensaje = "Error al dar de alta al usuario";
		
		request.setAttribute("mensaje", mensaje);
		request.setAttribute("clientes", cdao.findAll());
		request.getRequestDispatcher("inicio.jsp").forward(request, response);
	}
	
	
	
	protected void procesarTodos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("clientes", cdao.findAll());
		request.getRequestDispatcher("inicio.jsp").forward(request, response);
	}
	protected void procesarVerUno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cliente cliente = cdao.findById(Integer.parseInt(request.getParameter("idCliente")));
		request.setAttribute("cliente", cliente);
		request.getRequestDispatcher("verCliente.jsp").forward(request, response);
	}
	protected void procesarEliminarUno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mensaje = null;
		if (cdao.delete(Integer.parseInt(request.getParameter("idCliente"))) == 1) mensaje = "Cliente eliminado";
		else mensaje = "Cliente no eliminado";
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("client?opcion=todos").forward(request, response);
	}
	protected void procesoFormularioNuevoCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("altaCliente.jsp").forward(request, response);
	}

}
