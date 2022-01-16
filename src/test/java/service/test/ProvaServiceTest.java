package service.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import bean.Prova;
import service.ProvaService;
import service.impl.ProvaServiceImpl;

public class ProvaServiceTest {
	
	List<Prova> provas;
	ProvaService service;
	
	@Before
	public void setUp () throws Exception{
		service = new ProvaServiceImpl();
				
		
	}	
	
	@Test
	public void testMediaNotas() {
		provas = new ArrayList<Prova>();
		provas.add(new Prova("diogo", 7));
		provas.add(new Prova("pedro", 8));
		float media = ((float)(7 + 8) / (float) provas.size());
		
		try {
			assertEquals(String.format("%.2f", media), service.mediaNotas(provas));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test
	public void testMaiorNota() {
		provas = new ArrayList<Prova>();
		provas.add(new Prova("jose", 3));
		provas.add(new Prova("pedrito", 2));
		
		
		try {
			assertEquals("3", service.maiorNota(provas));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testMenorNota() {
		provas = new ArrayList<Prova>();
		provas.add(new Prova("jose", 3));
		provas.add(new Prova("pedrito", 10));
		
		
		try {
			assertEquals( "3", service.menorNota(provas));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
