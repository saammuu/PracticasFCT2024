package com.softtek.Abril16;

import com.softtek.Abril16.ejercicio1.modelo.Saludo;
import com.softtek.Abril16.ejercicio3.modelo.Coche;
import com.softtek.Abril16.ejercicio3.modelo.SeguroCoche;
import com.softtek.Abril16.ejercicio4.modelo.Director;
import com.softtek.Abril16.ejercicio5.modelo.Cliente;
import com.softtek.Abril16.ejercicio5.persistencia.ClienteDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Abril16Application implements CommandLineRunner {
	@Autowired
	//private Saludo s;
	//private SeguroCoche seguro;
	//private Director director;
	private Cliente cliente;
	@Autowired
	private ClienteDAO clienteDAO;

	//@Autowired
	//private Coche c;

	public static void main(String[] args) {
		SpringApplication.run(Abril16Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println(s.getMensaje());
		//System.out.println(seguro.reparar(c));
		//System.out.println(director.getTareas());
		//System.out.println(director.getInformes());
		System.out.println(clienteDAO.insertar(cliente));
	}
}
