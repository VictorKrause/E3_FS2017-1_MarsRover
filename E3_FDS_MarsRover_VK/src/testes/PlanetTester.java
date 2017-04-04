package testes;

import static org.junit.Assert.*;

import org.junit.Before;


import data.Plateu;

import org.junit.Test;

public class PlanetTester {

	private Plateu planeta;

	@Before
	public void setUpClass(){
		planeta = new Plateu(5,5, "Marte");		
	}

	@Test
	public void testEstaDentroTrue() {
		assertTrue(planeta.estaDentro(5,5));
	}

	@Test
	public void testEstaDentroFalseXMaior(){
		assertFalse(planeta.estaDentro(6, 5));
	}

	@Test
	public void testEstaDentroFalseYMaior(){
		assertFalse(planeta.estaDentro(5, 6));
	}

	@Test
	public void testEstaDentroFalseAmbosMaiores(){
		assertFalse(planeta.estaDentro(6, 6));
	}
}