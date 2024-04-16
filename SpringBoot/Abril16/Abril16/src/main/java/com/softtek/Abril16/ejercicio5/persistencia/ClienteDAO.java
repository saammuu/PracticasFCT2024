package com.softtek.Abril16.ejercicio5.persistencia;

import com.softtek.Abril16.ejercicio5.modelo.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDAO {
    @Autowired
    private IDAO conexion;

        public String insertar(Cliente c1){
            return conexion.insertar(c1);
        }

}
