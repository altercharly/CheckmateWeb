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
@WebServlet("/Partidaservlet")
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
		Usuario jug1 = (Usuario) session.getAttribute("userSession");
		Partida p = (Partida) session.getAttribute("partida");
		String dni=request.getParameter("dnicont");
		char pieza = ((request.getParameter("nombreficha")).toLowerCase().charAt(0));
		char posix = ((request.getParameter("posx")).toLowerCase().charAt(0));
		char nposix = ((request.getParameter("newposx")).toLowerCase().charAt(0));
		int posiy = Integer.parseInt(request.getParameter("posy"));
		int nposiy = Integer.parseInt(request.getParameter("newposy"));
		boolean resp;
		//response.getWriter().append(email).append(": ").append(pass);
		int dni2=Integer.parseInt(dni);
		negocio.ControladorLogin cl= new ControladorLogin();
		Usuario jug2 = cl.getUsuarioByDni(dni2);
		int idp =p.getid();
		resp=cl.movimientovalido(pieza, posix, posiy, nposix, nposiy, jug1, jug2, idp);
		
			session.setAttribute("userSession", jug1);
			session.setAttribute("jug2", jug2);
			session.setAttribute("partida", p);
			session.setAttribute("valido",resp);
			response.sendRedirect("mensaje.jsp");
		
	}
	
}
