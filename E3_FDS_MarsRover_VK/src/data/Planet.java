package data;

public class Planet {
	
	private int maxX;
	private int maxY;
	private String nome;
	
	public Planet (int x, int y, String nome){
		this.maxX =x;
		this.maxY=y;
		this.nome = nome;
	}

	public String getNome(){
		return nome;
	}
	
	public boolean estaDentro(int x, int y){
		boolean dentro = true;
		
		if(x>maxX || y>maxY||x<0||y<0)
				return false;
		
		return dentro;
		
	}
	

}
