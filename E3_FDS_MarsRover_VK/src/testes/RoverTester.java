package testes;

import static org.junit.Assert.*;

import org.junit.Before;

import data.*;
import org.junit.Test;

public class RoverTester {

	private Plateu planet;
	private Rover rover;

	@Before
	public void beforeClassSetUp(){
		planet = new Plateu(5, 5, "Marte");
		rover = new Rover(planet);
		rover.setXY(0, 0);
	}

	@Test
	public void testSetXYFailXMaior() {
		assertFalse(rover.setXY(6,1));
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
	@Test
	public void testVirarParaADireitaAteRodar(){
		rover.moverPorComando("RRRR");
		String expected = "Norte";
		String actual = rover.getViradoPara();

		assertEquals(expected,actual);
	}
	@Test
	public void testVirarParaAEsquerdaAteRodar(){
		rover.moverPorComando("AALLLL");
		String expected = "Norte";
		String actual = rover.getViradoPara();
		assertEquals(expected,actual);
	}
	@Test
	public void testSubirDuasViradoProNort(){
		rover.moverPorComando("MM");
		assertEquals("0, 2",rover.getXY());
	}
	@Test
	public void testSairDoPlateuParaNegativo(){
		rover.moverPorComando("RRSS");
		String expected = "0, 0";
		String actual = rover.getXY();
		
		assertEquals(expected,actual);
	}
	@Test
	public void testSairDoPlateuParaCima(){
		rover.moverPorComando("MMMMMMMMMMMM");
		String expected = "0, 0";
		String actual = rover.getXY();
		
		assertEquals(expected,actual);
	}
	@Test
	public void testDefinidoNoEnunciado1(){
		rover.setXY(1, 2);
		rover.moverPorComando("LMLMLMLMM");
		String expected = ("1, 3 Norte");
		String actual = rover.getXY()+" "+ rover.getViradoPara();
		assertEquals(expected,actual);
	}
	@Test
	public void testDefinidoNoEnunciado2(){
		rover.setXY(3, 3);
		rover.setViradoPara("east");
		rover.moverPorComando("MMRMMRMRRM");
		String expected = ("5, 1 Leste");
		String actual = rover.getXY()+" "+ rover.getViradoPara();
		assertEquals(expected,actual);
	}
	@Test
	public void testSetViradoParaNorte(){
		rover.setViradoPara("nORTe");
		assertEquals("Norte",rover.getViradoPara());
	}
	@Test
	public void testSetViradoParaDeveFalhar(){
		rover.setViradoPara("soutH");
		assertNotEquals(1,rover.getViradoPara());
	}
	
	
}

