package data;

public class Rover {
	
	private int xAtual;
	private int yAtual;
	private int viradoPara; //1 = Norte | 2 = Leste | 3 = Sul | 4 = Oeste
	private Planet planetaAtual;
	
	 public Rover (Planet planeta){
		 this.xAtual = 0;
		 this.yAtual = 0;
		 this.viradoPara = 1;
		 this.planetaAtual = planeta;
	 
	 }
	 
	 public boolean setXY (int x, int y){
		 boolean setado = false;
		 if(planetaAtual.estaDentro(x, y)){
			 this.xAtual = x;
			 this.yAtual=y;
			 setado = true;
		 }	 
		 return setado;
	 }
	

}
