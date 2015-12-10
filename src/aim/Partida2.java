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
@WebServlet("/Redirected2")
public class Partida2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Partida2() {
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
		
		HttpSession session = request.getSession();
		Usuario jug1 = (Usuario) session.getAttribute("user");
		String dni=request.getParameter("dnicont");
		char pieza = ((request.getAttribute("nombreficha")).toLowerCase().charAt(0));
		char posix = ((request.getAttribute("posx")).toLowerCase().charAt(0));
		char nposix = ((request.getAttribute("newposx")).toLowerCase().charAt(0));
		int posiy = Integer.parseInt(request.getAttribute("posy"));
		int nposiy = Integer.parseInt(request.getAttribute("newposy"));
		//response.getWriter().append(email).append(": ").append(pass);
		int dni2=Integer.parseInt(dni);
		negocio.ControladorLogin cl= new ControladorLogin();
		Usuario jug2 = cl.getUsuarioByDni(dni2);
		Partida p = new Partida();
		p = request.getAttribute("p");
		int idpart = p.getid();
		cl.movimientovalido(pieza, posix, posiy, nposix, nposiy, jug1, jug2, idpart);
		
			session.setAttribute("user", jug1);
			session.setAttribute("jug2", jug2);
			session.setAttribute("partida", p);
			response.sendRedirect("Partida.jsp");
		
	}
	
}