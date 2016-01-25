package aim;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Partida;
import entidades.Usuario;
import negocio.ControladorLogin;

/**
 * Servlet implementation class Redirected2
 * 
 */
@WebServlet("/Redirected2servlet")
public class Redirected2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Redirected2() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		Usuario jug1 = (Usuario) session.getAttribute("user");
		String dni = request.getParameter("dnicont");
		//response.getWriter().append(email).append(": ").append(pass);
		int dni2 = Integer.parseInt(dni);
		negocio.ControladorLogin cl= new ControladorLogin();
		Usuario jug2 = cl.getUsuarioByDni(dni2);
		System.out.println(jug2.getApellido());
		Partida p = new Partida();
		p = cl.nuevapartida(jug1, jug2);
		p = cl.guardarpartida(p); 
		System.out.println(p.getid());
		if(jug2 != null){		
			session.setAttribute("user", jug1);
			session.setAttribute("jug2", jug2);
			session.setAttribute("partida", p);
			response.sendRedirect("partida.jsp");
		} 
				
	}

}