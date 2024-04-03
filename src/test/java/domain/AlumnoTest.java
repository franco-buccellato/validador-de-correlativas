package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlumnoTest {
  private Alumno alumnoTest;
  private Materia materiaTestAprobada, materiaTestFirmada;

  @BeforeEach
  public void setup() {
    alumnoTest = new Alumno("AlumnoTest1", "1111111");
    materiaTestAprobada = new Materia("MateriaTest1");
    materiaTestFirmada = new Materia("MateriaTest2");
    alumnoTest.agregarMateriaAprobada(materiaTestAprobada);
  }

  @Test
  public void chequeoNombreDeAlumno1() {
    assertEquals("AlumnoTest1", alumnoTest.getNombre());
  }

  @Test
  public void chequeoLegajoeDeAlumno1() {
    assertEquals("1111111", alumnoTest.getLegajo());
  }

  @Test
  public void chequeoListaDeMateriasAprobadasTenga1() {
    assertEquals(1, alumnoTest.getMateriasAprobadas().size());
  }

  @Test
  public void chequeoListaDeMateriasFirmadasEsteVacia() {
    assertEquals(0, alumnoTest.getMateriasFirmadas().size());
  }

  @Test
  public void chequeoListaDeMateriasFirmadasTenga1DespuesDeAgregarla() {
    alumnoTest.agregarMateriaFirmada(materiaTestFirmada);
    assertEquals(1, alumnoTest.getMateriasFirmadas().size());
  }
}
