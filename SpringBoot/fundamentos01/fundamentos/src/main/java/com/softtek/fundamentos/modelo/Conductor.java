package com.softtek.fundamentos.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Conductor {
	
	@Autowired
	private IVehiculo vehiculo; //El atributo es una interface 

	public String conducir() {
		return vehiculo.moverse();
	}

	
	

}
