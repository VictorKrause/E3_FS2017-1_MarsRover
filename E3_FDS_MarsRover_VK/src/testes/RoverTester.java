package testes;

import static org.junit.Assert.*;

import org.junit.Before;

import data.*;
import org.junit.Test;

public class RoverTester {

	private Planet planet;
	private Rover rover;
	
	@Before
	public void beforeClassSetUp(){
		 planet = new Planet(5, 5);
		 rover = new Rover(planet);
	}

	@Test
	public void testSetXYFailXMaior() {
		assertFalse(rover.setXY(6, 1));
	}
	@Test
	public void testSetXYFailXNegativo() {
		assertFalse(rover.setXY(-6, 1));
	}
	@Test
	public void testSetXYFailYNegativo() {
		assertFalse(rover.setXY(0, -1));
	}
	@Test
	public void testSetXYFailAmbosNegativos() {
		assertFalse(rover.setXY(-1, -1));
	}
	@Test
	public void testSetXYFailYMaior() {
		assertFalse(rover.setXY(1,6));
		
	}
	@Test
	public void testSetXYFailAmbosMaiores() {
		assertFalse(rover.setXY(6, 6));
		
	}
	@Test
	public void testSetXYTrue() {
		assertTrue(rover.setXY(0,0));
		
	}
	@Test
	public void testGetXYSucess(){
		rover.setXY(0, 0);
		String expected = "0, 0";
		assertEquals(expected, rover.getXY());
		}
	@Test
	public void testGetXYFail(){
		rover.setXY(1, 0);
		String expected = "0, 0";
		assertNotEquals(expected, rover.getXY());
	}
	
}

