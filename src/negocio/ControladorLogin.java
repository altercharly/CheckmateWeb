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
		 * Este m�todo deber�a invocar a la capa de datos en el packages data y pedir que traiga el usuario
		 * por el email, luego validar contra la contrase�a encriptada
		 * 
		 * El m�todo de la capa de datos deber�a hacer un select a la base de datos por los datos del usuario
		 * con el email y luego crear un objeto Usuario de la capa modelo y devolverlo a negocio
		 *
		 * Aqu� no hacemos eso para hacer el ejemplo m�s facil de comprender
		 * 
		 */
		
		if (email.equalsIgnoreCase(usu.getEmail()) && password.equalsIgnoreCase(usu.getPassword())){
			/* el usuario se logueo correctamente
             */
		}
		return usu;
	}
}