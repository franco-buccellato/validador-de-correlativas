package domain;

import java.util.ArrayList;
import java.util.List;

public class Materia {
  String nombreMateria;

  List<Materia> correlativas;

  public Materia(String nombreMateria) {
    this.nombreMateria = nombreMateria;
    this.correlativas = new ArrayList();
  }

  public List<Materia> getCorrelativas() {
    return correlativas;
  }

  public void agregarCorrelativa(Materia correlativa) {
    this.correlativas.add(correlativa);
  }

  public Boolean tiereCorrelativa() {
    return !correlativas.isEmpty();
  }

}
