package com.softtek.Mayo20Testing;

import com.softtek.Mayo20Testing.model.Mascota;
import com.softtek.Mayo20Testing.model.Propietario;
import com.softtek.Mayo20Testing.repository.MascotaRepository;
import com.softtek.Mayo20Testing.repository.MascotaRepositoryImpl;
import com.softtek.Mayo20Testing.service.ExternalService;
import com.softtek.Mayo20Testing.service.ExternalServiceImpl;
import com.softtek.Mayo20Testing.service.MascotaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MascotaService01JUnitTest {

    MascotaService mascotaService;

    @Test
    @DisplayName("Registrar mascota correctamente")
    void testRegistrarMascotaCorrectamente(){

        // Arrange(Preparar)
        MascotaRepository mascotaRepository = new MascotaRepositoryImpl();
        ExternalService externalService = new ExternalServiceImpl();
        mascotaService = new MascotaService(mascotaRepository, externalService);

        Propietario propietario = new Propietario("Dany", "Lima", "987657876");
        Mascota mascota = new Mascota();
        mascota.setNombre("Garfield");
        mascota.setPropietario(propietario);

        // Act (Actuar)
        Mascota registrada = mascotaService.registrarMascota(mascota);

        // Assert (Afirmar)

        // Verificamos si es nulo
        assertNotNull(registrada, "La mascota no deberia ser null");

        // Verifica que dos referencias apunten al mismo objeto, útil para confirmar que la instancia no ha sido clonada o modificada inesperadamente.

        assertSame(mascota, registrada, "La mascota registrada debería ser la misma que la ingresada");

        // Verifica que el valor esperado coincida con el actual.
        assertEquals("Garfield", registrada.getNombre(), "El nombre de la mascota deberia ser  'Garfield' ");

        // Confirma que el propietario de la mascota registrada es el mismo que se proporcionó.
        assertSame(propietario, registrada.getPropietario(), "El propietario de la mascota debería ser el mismo que el ingresado");

        // Comprueba los detalles del propietario para garantizar la precisión de los datos.

        assertEquals("Dany", registrada.getPropietario().getNombre(), "El nombre del propietario debería ser 'Dany' ");

        assertEquals("Lima", registrada.getPropietario().getCiudad(), "La ciudad del propietario debería ser 'Lima' ");

        assertEquals("987657876", registrada.getPropietario().getTelefono(), "El telefono del propietario debería ser '987657876' ");

        // Comprobar con más aserciones de JUNIT 5
        assertTrue(registrada.getId() > 0 , "ID debe ser positivo");

        // Verificacion adicional agrupando varias aserciones. Todas deben pasar el test

        assertAll("Propiedades de la mascota",
                () -> assertEquals("Garfield", registrada.getNombre(), "El nombre deberia coincidir"),
                () -> assertNotNull(registrada.getPropietario(), "El propietario no debe ser null"),
                () -> assertEquals("Dany", registrada.getPropietario().getNombre(), "El nombre del propietario debería ser 'Dany' "),
                () -> assertEquals("Lima", registrada.getPropietario().getCiudad(), "La ciudad del propietario debería ser 'Lima' "),
                () -> assertEquals("987657876", registrada.getPropietario().getTelefono(), "El telefono del propietario debería ser '987657876' ")
        );

        // Comprueba que las siquientes operaciones no lanzan excepciones, lo cual es útil para confirmar que propiedades esenciales estan presentes y son accesibles
        assertDoesNotThrow(() -> registrada.getNombre(),"Obtener el nombre de la mascota no deberia lanzar una excepción.");
        assertDoesNotThrow(() -> registrada.getPropietario().getCiudad(),"Obtener la ciudad del propietario no deberia lanzar una excepción.");

    }
}
