package testes;

import static org.junit.Assert.*;
import data.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class RoverTester {

	private Planet planet;
	private Rover rover;
	
	@BeforeClass
	public void beforeClassSetUp(){
		 planet = new Planet(5, 5);
		 rover = new Rover(planet);
	}

	@Test
	public void testSetXYFail() {
		
	}

}
