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
	public String getViradoPara(){
		String viradoPara = "";
		
		if(this.viradoPara==1)
			viradoPara="Norte";
		else if(this.viradoPara==2)
			viradoPara= "Leste";
		else if(this.viradoPara==3)
			viradoPara= "Sul";
		else if(this.viradoPara==4)
			viradoPara= "Oeste";
		
		
		return viradoPara;
	}

	//If Norte(1) = y+1 | If Leste(2) = x+1| If Sul(3) = y-1 | If Oeste(4) = x-1
	public boolean moverPorComando(String linhaDeComando){
		int xBackup = this.xAtual;
		int yBackup = this.yAtual;

		for (int i=0; i<linhaDeComando.length(); i++) { 
			String linhaDeComandoToLower = linhaDeComando.toLowerCase();
			char c =linhaDeComandoToLower.charAt(i); 
			if( c == 'm'){
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
				if(viradoPara<1)
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
	
	public void setViradoPara(String ptCardeal){
			String toLower = ptCardeal.toLowerCase();
			
			if(toLower.equals("norte")||toLower.equals("north"))
				viradoPara=1;				
			
			if(toLower.equals("leste")||toLower.equals("east"))
				viradoPara=2;				
			
			if(toLower.equals("sul")||toLower.equals("south"))
				viradoPara=3;				
			
			if(toLower.equals("oeste")||toLower.equals("west"))
				viradoPara=4;			
			
						
		}


}

