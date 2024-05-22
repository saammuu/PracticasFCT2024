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

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MascotaServiceFullJTest {
    @Test
    @DisplayName("Registrar mascota correctamente")
    void testRegistrarMascotaCorrectamente() {
        // Arrange
        MascotaRepository mascotaRepository = new MascotaRepositoryImpl();
        ExternalService externalService = new ExternalServiceImpl();
        MascotaService mascotaService = new MascotaService(mascotaRepository, externalService);

        Propietario propietario = new Propietario("Dany", "Lima", "987654321");
        Mascota mascota = new Mascota();
        mascota.setNombre("Garfield");
        mascota.setPropietario(propietario);

        // Act
        Mascota registrada = mascotaService.registrarMascota(mascota);

        // Assert
        assertThat(registrada).isNotNull();
        assertThat(registrada.getNombre()).isEqualTo("Garfield");
        assertThat(registrada.getPropietario()).isNotNull();
        assertThat(registrada.getPropietario().getNombre()).isEqualTo("Dany");
        assertThat(registrada.getPropietario().getCiudad()).isEqualTo("Lima");
        assertThat(registrada.getPropietario().getTelefono()).isEqualTo("987654321");
        assertThat(registrada).isSameAs(mascota);
        assertThat(registrada.getId()).isPositive();
    }

    @Test
    @DisplayName("El nombre de la mascota no puede estar vacío")
    void testNombreMascotaNoPuedeEstarVacio() {
        // Arrange
        MascotaRepository mascotaRepository = new MascotaRepositoryImpl();
        ExternalService externalService = new ExternalServiceImpl();
        MascotaService mascotaService = new MascotaService(mascotaRepository, externalService);
        Mascota mascota = new Mascota();
        mascota.setNombre(null); // o mascota.setNombre("  ");
        mascota.setPropietario(new Propietario("Dany", "Lima", "987654321"));

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            mascotaService.registrarMascota(mascota);
        });
        assertThat(exception).hasMessage("El nombre de la mascota no puede estar vacío.");
    }

    @Test
    @DisplayName("La mascota debe tener un propietario")
    void testMascotaDebeTenerPropietario() {
        // Arrange
        MascotaRepository mascotaRepository = new MascotaRepositoryImpl();
        ExternalService externalService = new ExternalServiceImpl();
        MascotaService mascotaService = new MascotaService(mascotaRepository, externalService);
        Mascota mascota = new Mascota();
        mascota.setNombre("Garfield");
        mascota.setPropietario(null);

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            mascotaService.registrarMascota(mascota);
        });
        assertThat(exception).hasMessage("La mascota debe tener un propietario.");
    }

    @Test
    @DisplayName("El propietario debe tener un teléfono registrado")
    void testPropietarioDebeTenerTelefono() {
        // Arrange
        MascotaRepository mascotaRepository = new MascotaRepositoryImpl();
        ExternalService externalService = new ExternalServiceImpl();
        MascotaService mascotaService = new MascotaService(mascotaRepository, externalService);
        Propietario propietario = new Propietario("Dany", "Lima", null);
        Mascota mascota = new Mascota();
        mascota.setNombre("Garfield");
        mascota.setPropietario(propietario);

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            mascotaService.registrarMascota(mascota);
        });
        assertThat(exception).hasMessage("El propietario debe tener un teléfono registrado.");
    }

    @Test
    @DisplayName("Registrar mascota sin vacunas al día")
    void testRegistrarMascotaSinVacunas() {
        // Arrange
        MascotaRepository mascotaRepository = new MascotaRepositoryImpl();
        ExternalService externalService = new ExternalServiceImpl() {
            @Override
            public boolean validarVacunas(Mascota mascota) {
                return false;
            }
        };
        MascotaService mascotaService = new MascotaService(mascotaRepository, externalService);

        Propietario propietario = new Propietario("Dany", "Lima", "987654321");
        Mascota mascota = new Mascota();
        mascota.setNombre("Garfield");
        mascota.setPropietario(propietario);

        // Act & Assert
        assertThatThrownBy(() -> mascotaService.registrarMascota(mascota))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("La mascota no tiene todas las vacunas al día.");
    }

    @Test
    @DisplayName("Registrar mascota sin registro municipal")
    void testRegistrarMascotaSinRegistroMunicipal() {
        // Arrange
        MascotaRepository mascotaRepository = new MascotaRepositoryImpl();
        ExternalService externalService = new ExternalServiceImpl() {
            @Override
            public boolean verificarRegistroMunicipal(Mascota mascota) {
                return false;
            }
        };
        MascotaService mascotaService = new MascotaService(mascotaRepository, externalService);

        Propietario propietario = new Propietario("Dany", "Lima", "987654321");
        Mascota mascota = new Mascota();
        mascota.setNombre("Garfield");
        mascota.setPropietario(propietario);

        // Act & Assert
        assertThatThrownBy(() -> mascotaService.registrarMascota(mascota))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("La mascota no está registrada en el municipio.");
    }

    @Test
    @DisplayName("Registrar mascota ya registrada")
    void testRegistrarMascotaYaRegistrada() {
        // Arrange
        MascotaRepository mascotaRepository = new MascotaRepositoryImpl() {
            @Override
            public Optional<Mascota> findById(Integer id) {
                return Optional.of(new Mascota());
            }
        };
        ExternalService externalService = new ExternalServiceImpl();
        MascotaService mascotaService = new MascotaService(mascotaRepository, externalService);

        Propietario propietario = new Propietario("Dany", "Lima", "987654321");
        Mascota mascota = new Mascota();
        mascota.setNombre("Garfield");
        mascota.setPropietario(propietario);
        mascota.setId(1);

        // Act & Assert
        assertThatThrownBy(() -> mascotaService.registrarMascota(mascota))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Esta mascota ya está registrada.");
    }

    @Test
    @DisplayName("Buscar mascota por ID")
    void testBuscarMascotaPorId() {
        // Arrange
        MascotaRepository mascotaRepository = new MascotaRepositoryImpl();
        ExternalService externalService = new ExternalServiceImpl();
        MascotaService mascotaService = new MascotaService(mascotaRepository, externalService);

        Mascota mascota = new Mascota();
        mascota.setId(1);
        mascota.setNombre("Garfield");

        mascotaRepository.guardar(mascota);

        // Act
        Optional<Mascota> encontrada = mascotaService.buscarMascotaPorId(1);

        // Assert
        assertThat(encontrada).isPresent();
        assertThat(encontrada.get().getNombre()).isEqualTo("Garfield");
    }

    @Test
    @DisplayName("Eliminar mascota por ID")
    void testEliminarMascotaPorId() {
        // Arrange
        MascotaRepository mascotaRepository = new MascotaRepositoryImpl();
        ExternalService externalService = new ExternalServiceImpl();
        MascotaService mascotaService = new MascotaService(mascotaRepository, externalService);

        Mascota mascota = new Mascota();
        mascota.setId(1);
        mascota.setNombre("Garfield");

        mascotaRepository.guardar(mascota);

        // Act
        mascotaService.eliminarMascotaPorId(1);

        // Assert
        assertThat(mascotaRepository.findById(1)).isNotPresent();
    }

    @Test
    @DisplayName("Eliminar mascota por ID no encontrado")
    void testEliminarMascotaPorIdNoEncontrado() {
        // Arrange
        MascotaRepository mascotaRepository = new MascotaRepositoryImpl();
        ExternalService externalService = new ExternalServiceImpl();
        MascotaService mascotaService = new MascotaService(mascotaRepository, externalService);

        // Act & Assert
        assertThatThrownBy(() -> mascotaService.eliminarMascotaPorId(999))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("No se puede eliminar: No se encontró mascota con el ID proporcionado.");
    }

    //----
    @Test
    @DisplayName("Registrar mascota no registrada previamente")
    void testRegistrarMascotaNoRegistradaPrev() {
        // Arrange
        MascotaRepository mascotaRepository = new MascotaRepositoryImpl();
        ExternalService externalService = new ExternalServiceImpl();
        MascotaService mascotaService = new MascotaService(mascotaRepository, externalService);

        Propietario propietario = new Propietario("Dany", "Lima", "987654321");
        Mascota mascota = new Mascota();
        mascota.setNombre("Garfield");
        mascota.setPropietario(propietario);

        // Act
        Mascota registrada = mascotaService.registrarMascota(mascota);

        // Assert
        assertThat(registrada).isNotNull();
        assertThat(registrada.getNombre()).isEqualTo("Garfield");
        assertThat(registrada.getPropietario()).isNotNull();
        assertThat(registrada.getPropietario().getNombre()).isEqualTo("Dany");
        assertThat(registrada.getPropietario().getCiudad()).isEqualTo("Lima");
        assertThat(registrada.getPropietario().getTelefono()).isEqualTo("987654321");
        assertThat(registrada.getId()).isPositive();
    }

    @Test
    @DisplayName("El nombre de la mascota no puede estar vacío")
    void testNombreMascotaNoPuedeEstarEmpty() {
        // Arrange

        MascotaRepository mascotaRepository = new MascotaRepositoryImpl();
        ExternalService externalService = new ExternalServiceImpl();
        MascotaService mascotaService = new MascotaService(mascotaRepository, externalService);

        Mascota mascota = new Mascota();
        mascota.setNombre("");

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            mascotaService.registrarMascota(mascota);
        });
        assertThat(exception).hasMessage("El nombre de la mascota no puede estar vacío.");
    }

    //---
    @Test
    @DisplayName("El propietario debe tener un teléfono registrado")
    void testPropietarioDebeTenerTelefonoNoVacio() {
        // Arrange
        MascotaRepository mascotaRepository = new MascotaRepositoryImpl();
        ExternalService externalService = new ExternalServiceImpl();
        MascotaService mascotaService = new MascotaService(mascotaRepository, externalService);
        Propietario propietario = new Propietario("Dany", "Lima", "");
        Mascota mascota = new Mascota();
        mascota.setNombre("Garfield");
        mascota.setPropietario(propietario);
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            mascotaService.registrarMascota(mascota);
        });
        assertThat(exception).hasMessage("El propietario debe tener un teléfono registrado.");
    }
}
