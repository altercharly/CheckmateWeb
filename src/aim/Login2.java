package aim;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidades.Usuario;
import negocio.ControladorLogin;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login2")
public class Login2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login2() {
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
		// TODO Auto-generated method stub
		//doGet(request, response);
		//response.getWriter().append(email).append(": ").append(pass);
		negocio.ControladorLogin cl= new ControladorLogin();
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		Usuario u = cl.getUsuarioByEmailAndPassword(email, pass);
		if (u != null){
			
			HttpSession session = request.getSession(true);
			session.setAttribute("userSession", u);
			request.getRequestDispatcher("redirected2.jsp").forward(request, response);
		} else {
			System.out.println("error por no encontrar contrincante");
			response.sendRedirect("signin2.html");
		}
	}

}