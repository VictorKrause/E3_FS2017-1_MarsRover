package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;

import data.Planet;

import org.junit.Test;

public class PlanetTester {

	Planet planeta;

	@Before
	public void setUpClass(){
		planeta = new Planet(5,5);		
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