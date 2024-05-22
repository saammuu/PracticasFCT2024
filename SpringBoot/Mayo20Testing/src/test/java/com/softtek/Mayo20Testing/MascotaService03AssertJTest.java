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

import static org.assertj.core.api.Assertions.assertThat;


public class MascotaService03AssertJTest {

    @Test
    @DisplayName("Registrar mascota correctamente")
    void testRegistrarMascotaCorrectamente(){
        // Arrange(Preparar)
        MascotaRepository mascotaRepository = new MascotaRepositoryImpl();
        ExternalService externalService = new ExternalServiceImpl();
        MascotaService mascotaService = new MascotaService(mascotaRepository, externalService);

        Propietario propietario = new Propietario("Dany", "Lima", "987654321");
        Mascota mascota = new Mascota();
        mascota.setNombre("Garfield");
        mascota.setPropietario(propietario);

        //Act(Actuar)
        Mascota registrada = mascotaService.registrarMascota(mascota);

        //Assert(Afirmar) : Hamcrest

        // Verificar las propiedades de la mascota registrada
        assertThat(registrada).isNotNull();
        assertThat(registrada.getNombre()).isEqualTo( "Garfield");
        assertThat(registrada.getPropietario()).isNotNull();
        assertThat(registrada.getPropietario().getNombre()).isEqualTo( "Dany");
        assertThat(registrada. getPropietario().getCiudad()).isEqualTo( "Lima");
        assertThat(registrada.getPropietario().getTelefono()).isEqualTo( "987654321");
        assertThat(registrada).isSameAs(mascota);


        assertThat(registrada.getId()).isPositive();
    }
}
