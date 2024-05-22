package com.softtek.Mayo20Testing;

import com.softtek.Mayo20Testing.model.Mascota;
import com.softtek.Mayo20Testing.model.Propietario;
import com.softtek.Mayo20Testing.repository.MascotaRepository;
import com.softtek.Mayo20Testing.service.ExternalService;
import com.softtek.Mayo20Testing.service.MascotaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MascotaService06JUnitTestMockitoSpyTest {
    // @Spy
    @InjectMocks
    MascotaService mascotaService;

    @Mock
    MascotaRepository mascotaRepository;

    @Mock
    ExternalService externalService;

    @Test
    @DisplayName("Registrar mascota correctamente")
    void testRegistrarMascotaCorrectamente(){
        // Arrange (Preparar)
        Propietario propietario = new Propietario("Dany", "Lima", "987654321");
        Mascota mascota = new Mascota();
        mascota.setNombre("Garfield");
        mascota.setPropietario(propietario);

        when(externalService.validarVacunas(any(Mascota.class))).thenReturn(true);
        when(externalService.verificarRegistroMunicipal(any(Mascota.class))).thenReturn(true);
        when(mascotaRepository.findById(any())).thenReturn(Optional.empty());
        when(mascotaRepository.guardar(any(Mascota.class))).thenReturn(mascota);

        // Act (Actuar)
        Mascota registrado = mascotaService.registrarMascota(mascota);

        //Assert

        //Verificar que el objeto no es null
        assertNotNull(registrado, "La mascota no debería ser null");

        // Verifica que dos referencias al mismo objeto, utili para confirmar que la instancia no ha sido clonada o modificada inesperadamente
        assertSame(mascota, registrado, "La mascota registrada debería ser la misma que la mascota ingresadaa");

        //verify(mascotaService).enviarCorreoNotificacion(mascota);
    }

}
