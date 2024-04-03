package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class InscripcionTest {

  private Alumno alumnoTest;
  private Materia materiaTestAprobada1, materiaTestAprobada2, materiaTestFirmada1, materiaTestFirmada2,
      materiaInscripcionTest1, materiaInscripcionTest2, materiaInscripcionTest3;
  private Inscripcion inscripcionTestAprobada, incripcionTestRechazada;

  @BeforeEach
  public void setup() {
    //Creo al alumno
    alumnoTest = new Alumno("AlumnoTest1", "1111111");
    //Creo materias aprobadas y las agrego
    materiaTestAprobada1 = new Materia("Sistemas y Organizaciones");
    materiaTestAprobada2 = new Materia("Paradigmas de Programacion");
    alumnoTest.agregarMateriaAprobada(materiaTestAprobada1);
    alumnoTest.agregarMateriaAprobada(materiaTestAprobada2);
    //Creo materias firmadas y las agrego
    materiaTestFirmada1 = new Materia("Matematica Discreta");
    materiaTestFirmada2 = new Materia("Analisis Matematico I");
    alumnoTest.agregarMateriaFirmada(materiaTestFirmada1);
    alumnoTest.agregarMateriaFirmada(materiaTestFirmada2);
    //Creo las materias a inscribir
    materiaInscripcionTest1 = new Materia("Diseño de Sistemas");
    materiaInscripcionTest2 = new Materia("Economia");
    materiaInscripcionTest3 = new Materia("Sistemas Oerativos");
    //Seteo las correlativas
    materiaInscripcionTest1.agregarCorrelativa(materiaTestAprobada1);
    materiaInscripcionTest1.agregarCorrelativa(materiaTestAprobada2);
    materiaInscripcionTest2.agregarCorrelativa(materiaTestAprobada2);
    materiaInscripcionTest3.agregarCorrelativa(materiaTestFirmada1);
    materiaInscripcionTest3.agregarCorrelativa(materiaTestFirmada2);
    //Inscripcion Aprobada
    inscripcionTestAprobada = new Inscripcion("Ing. en Sistemas", alumnoTest);
    inscripcionTestAprobada.agregarMateria(materiaInscripcionTest1);
    inscripcionTestAprobada.agregarMateria(materiaInscripcionTest2);
    //Inscripcion Rechazada
    incripcionTestRechazada = new Inscripcion("Ing. en Sistemas", alumnoTest);
    incripcionTestRechazada.agregarMateria(materiaInscripcionTest1);
    incripcionTestRechazada.agregarMateria(materiaInscripcionTest2);
    incripcionTestRechazada.agregarMateria(materiaInscripcionTest3);
  }

  @Test
  public void chequeoQueLaCantidadDeMateriasInscriptasSean2() {
    assertEquals(2, this.inscripcionTestAprobada.getMaterias().size());
  }

  @Test
  public void chequeoQueAlQuitarUnaMateriaIncriptaQuede1() {
    inscripcionTestAprobada.quitarMateria(materiaInscripcionTest2);
    assertEquals(1, this.inscripcionTestAprobada.getMaterias().size());
  }

  @Test
  public void chequeoQueNoValidaLaInscripcionSiNoTieneMaterias() {
    inscripcionTestAprobada.quitarMateria(materiaInscripcionTest1);
    inscripcionTestAprobada.quitarMateria(materiaInscripcionTest2);
    assertFalse(inscripcionTestAprobada.aprobada());
  }

  @Test
  public void chequeoIncripcionAprobada() {
    assertTrue(inscripcionTestAprobada.aprobada());
  }

  @Test
  public void chequeoInscripcionRechazada() {
    assertFalse(incripcionTestRechazada.aprobada());
  }

  @Test
  public void chequeoIncripcionAprobadaAgregandoMateriaNoAprobada() {
    //Agrego una materia que solo esta firmada a la inscripcion para ver si la rechaza
    inscripcionTestAprobada.agregarMateria(materiaInscripcionTest3);
    assertFalse(inscripcionTestAprobada.aprobada());
  }

}
