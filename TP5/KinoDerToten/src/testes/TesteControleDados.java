package testes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import controller.ControleDados;
import models.Dados;

class TesteControleDados {
	ControleDados d = new ControleDados();
	String s[] = {"0", "a", "b", "c", "d", "e", "f"};
	String s2[] = {"0", "a", "b", "1", "d", "2", "f"};
	String s3[] = {"0", "a", "b", "Shopping3", "c", "d", "2"};
	String s4[] = {"0", "0", "a", "b", "1", "d", "2"};
	
	@Test
	void testInserirEditarFilme() {
		assertFalse(d.inserirEditarFilme(s));
		assertTrue(d.inserirEditarFilme(s2));
	}

	@Test
	void testRemoverUnidade() {
		assertFalse(d.removerUnidade(0));
	}
	
	@Test
	void testInserirEditarCliente() {
		assertFalse(d.inserirEditarCliente(s2));
		assertTrue(d.inserirEditarCliente(s3));
		assertTrue(d.inserirEditarCliente(s4));
	}

}
