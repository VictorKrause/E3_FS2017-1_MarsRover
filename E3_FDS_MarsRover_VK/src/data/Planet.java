package data;

public class Planet {
	
	private int maxX;
	private int maxY;
	
	public Planet (int x, int y){
		this.maxX =x;
		this.maxY=y;
	}

	public boolean estaDentro(int x, int y){
		boolean dentro = true;
		
		if(x>maxX || y>maxY||x<0||y<0)
				return false;
		
		return dentro;
		
	}
	

}
