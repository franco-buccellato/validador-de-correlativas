package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MateriaTest {
  private Materia materiaTest1, materiaTest2, materiaCorrelativaTest1;

  @BeforeEach
  public void setup() {
    materiaTest1 = new Materia("MateriaTest1");
    materiaTest2 = new Materia("MateriaTest2");
    materiaCorrelativaTest1 = new Materia("MateriaCorrelativaTest1");
    materiaTest2.agregarCorrelativa(materiaCorrelativaTest1);
  }

  @Test
  public void chequeoMateriaTest1NoTieneCorrelativa() {
    assertEquals(Boolean.FALSE, materiaTest1.tiereCorrelativa());
  }

  @Test
  public void chequeoMateriaTest2TieneCorrelativa() {
    assertEquals(Boolean.TRUE, materiaTest2.tiereCorrelativa());
  }

}
