package negocio;

import capadata.Catalogopartidas;
import capadata.Catpiezas;
import capadata.Catusuario;
import entidades.*;

public class ControladorLogin {

	Catusuario catu = new Catusuario();
	Catalogopartidas cpa = new Catalogopartidas();
	Catpiezas cp = new Catpiezas();
	
	
	public Usuario getUsuarioByEmailAndPassword(String email, String password){
		
		Usuario usu =catu.buscarusuario(email, password);
		
		/*
		 * Este método debería invocar a la capa de datos en el packages data y pedir que traiga el usuario
		 * por el email, luego validar contra la contraseña encriptada
		 * 
		 * El método de la capa de datos debería hacer un select a la base de datos por los datos del usuario
		 * con el email y luego crear un objeto Usuario de la capa modelo y devolverlo a negocio
		 *
		 * Aquí no hacemos eso para hacer el ejemplo más facil de comprender
		 * 
		 */
		
		if (email.equalsIgnoreCase(usu.getEmail()) && password.equalsIgnoreCase(usu.getPassword())){
			/* el usuario se logueo correctamente
             */
		}
		return usu;
	}
}