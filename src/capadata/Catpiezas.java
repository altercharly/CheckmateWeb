package capadata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;





import entidades.Alfil;
import entidades.Caballo;
import entidades.Peon;
import entidades.Pieza;
import entidades.Reina;
import entidades.Rey;
import entidades.Torre;
import entidades.Usuario;



public class Catpiezas {
	
	public void guardarpieza(ArrayList<Pieza> pie1, ArrayList<Pieza> pie2, int id1, int id2, int idpart){
		
		ArrayList<Pieza> pieza1 = new ArrayList<Pieza>();
		ArrayList<Pieza> pieza2 = new ArrayList<Pieza>();
		pieza1 = pie1;
		pieza2 = pie2;
		char nombre;
		int posy;
		char posx;
		char color;
		int estado;
		//String sql;
		
		
		PreparedStatement sentencia=null;
		Connection con = FactoryConexion.getInstancia().getConn();
		
		for (Pieza i: pieza1) {
			nombre = i.getname();
			posx = i.getposx();
			posy = i.getposy();
			color = i.getcolor();
			estado = i.getestado();
			
			//falta terminar de corregir la consulta
			//sql = "INSERT into `pieza` VALUES ( `nombre` = ?, `color`= ?, `posx` = ?, `posy` = ?,  `estado` = ?, `idpartida` = ?, `idusuario` = ?);";
			
			try {
			sentencia= FactoryConexion.getInstancia().getConn().prepareStatement(
			"insert into pieza (nombre,color,posx,posy,estado,idpart,id1) values (?,?,?,?,?,?,?)");
		
				sentencia.setInt(1, nombre);
				sentencia.setInt(2, color);
				sentencia.setInt(3, posx);
				sentencia.setInt(4,posy);
				sentencia.setInt(5, estado);
				sentencia.setInt(6, idpart);
				sentencia.setInt(7, id1);
				sentencia.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		for (Pieza j: pieza2) {
			nombre = j.getname();
			posx = j.getposx();
			posy = j.getposy();
			color = j.getcolor();
			estado = j.getestado();
				
			try {									
			//sql = "INSERT into `pieza` VALUES ( `nombre` = ?, `color`= ?, `posx` = ?, `posy` = ?,  `estado` = ?, `idpartida` = ?, `idusuario` = ?);";
			sentencia= FactoryConexion.getInstancia().getConn().prepareStatement("insert into pieza (nombre,color,posx,posy,estado,idpart,id1) values (?,?,?,?,?,?,?)");
			
				sentencia.setInt(1,nombre);
				sentencia.setInt(2, color);
				sentencia.setInt(3, posx);
				sentencia.setInt(4,posy);
				sentencia.setInt(5, estado);
				sentencia.setInt(6, idpart);
				sentencia.setInt(7, id1);
				sentencia.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
			
				}
			}
		}
	}
	
	
	public void actualizarpieza(ArrayList<Pieza> pie1, ArrayList<Pieza> pie2, int id1, int id2, int idpart){
		
		ArrayList<Pieza> pieza1 = new ArrayList<Pieza>();
		ArrayList<Pieza> pieza2 = new ArrayList<Pieza>();
		pieza1 = pie1;
		pieza2 = pie2;
		char nombre;
		int posy;
		char posx;
		char color;
		int estado;
		String sql;
		
		PreparedStatement sentencia=null;
		Connection con = FactoryConexion.getInstancia().getConn();
		
		for (Pieza i: pieza1){
			nombre = i.getname();
			posx = i.getposx();
			posy = i.getposy();
			color = i.getcolor();
			estado = i.getestado();
			try {
			//falta corregir la consulta
			sql = "UPDATE pieza SET nombre = ?, posx = ?, posy = ?, color= ?, estado = ? WHERE id = ? AND idpartida = ?";
			
			
				sentencia = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				sentencia.setInt(1,nombre);
				sentencia.setInt(2, posx);
				sentencia.setInt(3,posy);
				sentencia.setInt(4, color);
				sentencia.setInt(5, estado);
				sentencia.setInt(6, id1);
				sentencia.setInt(7, idpart);
				sentencia.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		for (Pieza j: pieza2) {
			nombre = j.getname();
			posx = j.getposx();
			posy = j.getposy();
			color = j.getcolor();
			estado = j.getestado();
				
												
			sql = "UPDATE `pieza` SET `nombre` = ?, `posx` = ?, `posy` = ?, `color`= ?, `estado` = ? WHERE `id` = ? AND `idpartida` = ? ;";
			try {
				sentencia = (PreparedStatement) con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				sentencia.setInt(1,nombre);
				sentencia.setInt(2, posx);
				sentencia.setInt(3,posy);
				sentencia.setInt(4, color);
				sentencia.setInt(5, estado);
				sentencia.setInt(6, id2);
				sentencia.setInt(7, idpart);
				sentencia.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
			
				}
			}
		}
	}
	
	
	
	
}

