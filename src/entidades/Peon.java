package entidades;

public class Peon extends Pieza {
	
	public Peon(char nombre, char colorin, char posix, int posiy, int est){
		name = nombre;
		color = colorin;
		posx = posix;
		posy = posiy;
		estado = est;
	}
	
	
	
	public Boolean movPerm(int y, char x){
		
		Boolean resultado;
		resultado = false;
		
		if( 'b' == this.getcolor()){
			if((y == this.getposy()+1) && (x == this.getposx() )){
				resultado = true;
				return resultado;
			} else if(((y == this.getposy()+1) && (x == this.getposx()+1 )) || ((y == this.getposy()+1) && (x == this.getposx()-1 ))){
				resultado = true;
				return resultado;
			}
		}
		else if( 'w' == this.getcolor()){
			if((y == this.getposy()-1) && (x == this.getposx() )){
				resultado = true;
				return resultado;
			} else if(((y == this.getposy()-1) && (x == this.getposx()+1 )) || ((y == this.getposy()-1) && (x == this.getposx()-1 ))){
				resultado = true;
				return resultado;
			}
		}	
		return resultado;
	}

	
	
}

