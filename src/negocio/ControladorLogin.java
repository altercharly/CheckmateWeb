package negocio;

import java.util.ArrayList;

import javax.swing.JOptionPane;

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
	
	public Partida nuevapartida(Usuario jug1,Usuario jug2){
		Partida partn = new Partida();
		partn.iniciarpartida(jug1, jug2);
		partn = guardarpartida(partn);
		// recorro cada conjunto de piezas y las guardo en la DB
		int id1,id2,idpart;
		Usuario ju1 = new Usuario();
		ju1 = partn.getjugador(1);
		ArrayList<Pieza> pieza1 = new ArrayList<Pieza>();
		id1 = ju1.getId();
		pieza1 = ju1.getpiezas(); 
		Usuario ju2 = new Usuario();
		ju2 = partn.getjugador(2);
		ArrayList<Pieza> pieza2 = new ArrayList<Pieza>();
		id2 = ju2.getId();
		pieza2 = ju2.getpiezas(); 
		idpart = partn.getid();
		cp.guardarpieza(pieza1, pieza2, id1, id2, idpart);
		return partn;
	}

	public Usuario getUsuarioByDni(int dni2) {
		
		Usuario jug2 = catu.buscarusuario(dni2);
		return jug2;
	}
	
	public Partida guardarpartida(Partida p){
		Partida par = new Partida();
		par = cpa.guardarPartida(p);
		return par;
	}
	
	public boolean movimientovalido(char pieza, char posix, int posiy,char nposix, int nposiy, Usuario jug1, Usuario jug2,int idpart){
		
		String message = "Movimiento invalido";
		boolean puede;
		boolean puedepeon;
		char nombre;
		int posy;
		char posx;
		char color;
		int estado;
		int id1;
		int id2;
		
		ArrayList<Pieza> pieza1 = new ArrayList<Pieza>();
		ArrayList<Pieza> pieza2 = new ArrayList<Pieza>();
		pieza1 = jug1.getpiezas();
		pieza2 = jug2.getpiezas();
		id1 = jug1.getId();
		id2 = jug2.getId();
		puede = false;
		for (int i = 0; i < 16; i++) {
			nombre = pieza1.get(i).getname();
			posx = pieza1.get(i).getposx();
			posy = pieza1.get(i).getposy();
			if((nombre == pieza)&&(posiy == posy)&&(posix==posx)){
				for(int j=0; j < 6; i++){
					switch(i){
						case 0:
							if ( 'a' == nombre){
								color = pieza1.get(i).getcolor();
								estado = pieza1.get(i).getestado();
								Alfil alf = new Alfil(nombre, color, posix, posiy, estado);
								puede = alf.movPerm(nposiy, nposix);
								if (true == puede){
									for (int k = 0; k < 16; k++) {
										if(( nposix == pieza2.get(k).getposx())&&(nposiy == pieza2.get(k).getposy())&&(1 == pieza2.get(k).getestado())){
											pieza2.get(k).setestado(0);
										}
									}
									alf.setposx(nposix);
									alf.setposy(nposiy);
									pieza1.set(i,alf);
									cp.actualizarpieza(pieza1,pieza2, id1, id2,idpart);
									message = "Movimiento exitoso";
									JOptionPane.showMessageDialog(null, message);
									puede = true;
								}
								return puede ;
							}
							break;
						case 1:
							if ( 'c' == nombre){
								color = pieza1.get(i).getcolor();
								estado = pieza1.get(i).getestado();
								Caballo cab = new Caballo(nombre, color, posix, posiy, estado);
								puede = cab.movPerm(nposiy, nposix);
								if (true == puede){
									for (int k = 0; k < 16; k++) {
										if(( nposix == pieza2.get(k).getposx())&&(nposiy == pieza2.get(k).getposy())&&(1 == pieza2.get(k).getestado())){
											pieza2.get(k).setestado(0);
										}
									}
									cab.setposx(nposix);
									cab.setposy(nposiy);
									pieza1.set(i,cab);
									cp.actualizarpieza(pieza1,pieza2,id1, id2,idpart);
									message = "Movimiento exitoso";
									JOptionPane.showMessageDialog(null, message);
									puede = true;
								}
								return puede ;
							}
							break;
						case 2:
							if ( 'd' == nombre){
								color = pieza1.get(i).getcolor();
								estado = pieza1.get(i).getestado();
								Reina reina = new Reina(nombre, color, posix, posiy, estado);
								puede = reina.movPerm(nposiy, nposix);
								if (true == puede){
									for (int k = 0; k < 16; k++) {
										if(( nposix == pieza2.get(k).getposx())&&(nposiy == pieza2.get(k).getposy())&&(1 == pieza2.get(k).getestado())){
											pieza2.get(k).setestado(0);
										}
									}
									reina.setposx(nposix);
									reina.setposy(nposiy);
									pieza1.set(i,reina);
									cp.actualizarpieza(pieza1,pieza2,id1,id2,idpart);
									message = "Movimiento exitoso";
									JOptionPane.showMessageDialog(null, message);
									puede = true;
								}
								return puede ;
							};
							break;
						case 3:
							if ( 'r' == nombre){
								color = pieza1.get(i).getcolor();
								estado = pieza1.get(i).getestado();
								Rey rey = new Rey(nombre, color, posix, posiy, estado);
								puede = rey.movPerm(nposiy, nposix);
								if (true == puede){
									for (int k = 0; k < 16; k++) {
										if(( nposix == pieza2.get(k).getposx())&&(nposiy == pieza2.get(k).getposy())&&(1 == pieza2.get(k).getestado())){
											pieza2.get(k).setestado(0);
										}
									}
									rey.setposx(nposix);
									rey.setposy(nposiy);
									pieza1.set(i,rey);
									cp.actualizarpieza(pieza1,pieza2,id1,id2,idpart);
									message = "Movimiento exitoso";
									JOptionPane.showMessageDialog(null, message);
									puede = true;
								}
								return puede ;
							};
							break;
						case 4:
							if ( 't' == nombre){
								color = pieza1.get(i).getcolor();
								estado = pieza1.get(i).getestado();
								Torre torr = new Torre(nombre, color, posix, posiy, estado);
								puede = torr.movPerm(nposiy, nposix);
								if (true == puede){
									for (int k = 0; k < 16; k++) {
										if(( nposix == pieza2.get(k).getposx())&&(nposiy == pieza2.get(k).getposy())&&(1 == pieza2.get(k).getestado())){
											pieza2.get(k).setestado(0);
										}
									}
									torr.setposx(nposix);
									torr.setposy(nposiy);
									pieza1.set(i,torr);
									cp.actualizarpieza(pieza1,pieza2,id1,id2,idpart);
									message = "Movimiento exitoso";
									JOptionPane.showMessageDialog(null, message);
									puede = true;
								}
								return puede ;
							};
							break;
						case 5:
							if ( 'p' == nombre){
								color = pieza1.get(i).getcolor();
								estado = pieza1.get(i).getestado();
								Peon peon = new Peon(nombre, color, posix, posiy, estado);
								puedepeon = peon.movPerm(nposiy, nposix);
								if (true == puedepeon){
									for (int k = 0; k < 16; k++) {
										if(( nposix == pieza2.get(k).getposx())&&(nposiy == pieza2.get(k).getposy())&&(1 == pieza2.get(k).getestado())){
											pieza2.get(k).setestado(0);
										}
										else if(nposix != posix){
											message ="Movimiento invalido";
											JOptionPane.showMessageDialog(null, message);
											puede = false;
											break;
										}
									}
									peon.setposx(nposix);
									peon.setposy(nposiy);
									pieza1.set(i,peon);
									cp.actualizarpieza(pieza1,pieza2,id1,id2,idpart);
									message = "Movimiento exitoso";
									JOptionPane.showMessageDialog(null, message);
									puede = true;
								}
								return puede ;
							};
							break;					
						}
				}
			}
		}
		return puede;
	}
	
	public ArrayList<Partida> buscarpartida(int dni1){
		ArrayList<Partida> p = new ArrayList<Partida> ();
		p =	cpa.buscarpartida(dni1);
		
		return p;
		
		
	}
	

}