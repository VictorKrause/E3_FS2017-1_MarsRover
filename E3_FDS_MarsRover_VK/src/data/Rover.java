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
	public String getXY(){
		String XY = xAtual+", "+yAtual;
		return XY;	
	}
	public int getViradoPara(){
		return viradoPara;
	}

	//If Norte(1) = y+1 | If Leste(2) = x+1| If Sul(3) = y-1 | If Oeste(4) = x-1
	public boolean moverPorComando(String linhaDeComando){
		int xBackup = this.xAtual;
		int yBackup = this.yAtual;

		for (int i=0; i<linhaDeComando.length(); i++) { 
			linhaDeComando.toLowerCase();
			char c =linhaDeComando.charAt(i); 
			if( c == 'w'){
				if(viradoPara == 1)
					yAtual++;
				else if(viradoPara == 2)
					xAtual++;
				else if(viradoPara ==3)
					yAtual--;
				else if(viradoPara==4)
					xAtual--;
			}
			else if(c=='r'){
				this.viradoPara++;
				if(viradoPara>4)
					viradoPara=1;
			}
			else if(c=='l'){
				this.viradoPara--;
				if(viradoPara<0)
					viradoPara=4;
			}

		}	

		if(!planetaAtual.estaDentro(xAtual, yAtual)){
			xAtual = xBackup;
			yAtual = yBackup;
			return false;
		}

		return true;
	}


}

