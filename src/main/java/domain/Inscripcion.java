package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Inscripcion {
  public String carrera; //Podría ser una clase Carrera

  public List<Materia> materias;
  public Alumno alumno;

  public Inscripcion(String carrera, Alumno alumno) {
    this.carrera = carrera;
    this.alumno = alumno;
    this.materias = new ArrayList();
  }

  public List<Materia> getMaterias() {
    return materias;
  }

  public void agregarMateria(Materia materia) {
    this.materias.add(materia);
  }

  public void quitarMateria(Materia materia) {
    this.materias.remove(materia);
  }

  public Boolean aprobada() {
    AtomicReference<Boolean> respuesta = new AtomicReference<>(Boolean.FALSE);
      this.materias.forEach(
          unaMateria ->
          {
            if(unaMateria.tiereCorrelativa()) {
              respuesta.set(alumno.tieneCorretaslivaAprobadas(unaMateria));
            }
          }
      );
      return respuesta.get();
    }
}
