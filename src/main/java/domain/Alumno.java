package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Alumno {
  String nombre;
  String legajo;
  List<Materia> materiasFirmadas;
  List<Materia> materiasAprobadas;

  public Alumno(String nombre, String legajo) {
    this.setNombre(nombre);
    this.setlegajo(legajo);
    this.materiasFirmadas = new ArrayList();
    this.materiasAprobadas = new ArrayList();
  }

  //Setters
  private void setlegajo(String legajo) {
    this.legajo = legajo;
  }
  private void setNombre(String nombre) {
    this.nombre = nombre;
  }

  //Getters
  public String getNombre() {
    return this.nombre;
  }

  public String getLegajo() {
    return this.legajo;
  }

  public List<Materia> getMateriasAprobadas() {
    return materiasAprobadas;
  }

  public List<Materia> getMateriasFirmadas() {
    return materiasFirmadas;
  }

  public void agregarMateriaAprobada(Materia materia) {
    this.materiasAprobadas.add(materia);
  }

  public void agregarMateriaFirmada(Materia materia) {
    this.materiasFirmadas.add(materia);
  }

  public Boolean tieneCorretaslivaAprobadas(Materia materiaParaVerificar) {
    AtomicReference<Boolean> respuesta = new AtomicReference<>(Boolean.TRUE);
    materiaParaVerificar.getCorrelativas().forEach(
        unaCorrelativa -> {
          respuesta.set(this.materiasAprobadas.contains(unaCorrelativa));
        }
    );
    return respuesta.get();
  }
}
