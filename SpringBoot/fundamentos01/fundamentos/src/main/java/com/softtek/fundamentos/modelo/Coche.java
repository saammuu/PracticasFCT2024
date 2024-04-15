package com.softtek.fundamentos.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Coche implements IVehiculo {
	@Value("5")
	private int deposito;

	public String moverse() {
		// TODO Auto-generated method stub
		if(deposito>0)
		return "El coche se está moviendo ...";
		else{
			return "Hay que cargar gasolina ...";
		}
	}
	

	

}
