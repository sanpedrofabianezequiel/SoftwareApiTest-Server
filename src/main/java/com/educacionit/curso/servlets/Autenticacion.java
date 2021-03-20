package com.educacionit.curso.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.educacionit.curso.entidades.Usuario;

@WebServlet(name="login",urlPatterns = "/Home")
public class Autenticacion extends HttpServlet {
	
	List<Usuario> usuarios =null;
	
	private static final long serialVersionUID = 1L;
   
    public Autenticacion() {
        super();
    }
    @Override
    public void init() throws ServletException {//LOAD .C#
    	usuarios = LLenarUsuarios();
    	super.init();
    }
   
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//Detruimos la session
    	Boolean accion=Boolean.valueOf(request.getParameter("accion"));
    	if(accion)
    		request.getSession().invalidate();
    	request.setAttribute("alerta", "cerro session exitosamente");
		request.getRequestDispatcher("index.jsp").forward(request, response);

    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obtenemos los nombre de los tag en HTML
		//Setiamos en HTML el form action="Home" metthod="post";
		String correo= request.getParameter("correo");
		String clave= request.getParameter("clave");
		Usuario search= Buscar(correo, clave);
		
		//Session para mantener la informacion en las pestañas
		HttpSession session =null;
		String redireccion="index.jsp";
		if (search == null ) {
			//se valida y mantemos la session si el objeto o persona se logio
			request.setAttribute("alerta", "Credenciales incorrectas");
		}else {
			session =request.getSession();//Se logio correctamente
			session.setAttribute("usuario", search);
			redireccion="bienvenido.jsp";
		}
		
		/*if (search == null) {
			request.setAttribute("alerta", "Credenciales incorrectas");
		}else {
			request.setAttribute("alerta", "Bienvenido "+ search.getCorreo());		
		}*/
		request.getRequestDispatcher(redireccion).forward(request, response);;
		/*PrintWriter out = response.getWriter();//Respuesta simple HTTP 
		out.print("<html>");
			out.print("<body>");
			 out.print((search == null) ? "Credenciales incorrectas" : search);
			out.print("</body>");
		out.print("</html>");
		
		out.flush();
		out.close();*/
	}
	
	private List<Usuario> LLenarUsuarios(){
	    	List<Usuario> aux= new ArrayList<Usuario>();
	    	aux.add(new Usuario("user1@gmail.com", "1234", true));
	    	aux.add(new Usuario("user2@gmail.com", "1234", true));
	    	aux.add(new Usuario("user3@gmail.com", "1234", true));
	    	aux.add(new Usuario("user4@gmail.com", "1234", true));
	    	return aux;
	   }
	private Usuario Buscar(String correo,String clave) {
		for (Usuario item : usuarios) {
			if(item.getCorreo().equalsIgnoreCase(correo) && item.getClave().equals(clave)) {
				return item;// Si lo encuentra retornamos un USUARIO
			}
		}
		return null;
	}
}
