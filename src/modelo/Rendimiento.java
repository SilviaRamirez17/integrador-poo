package modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_RENDIMIENTO")
public class Rendimiento {
  @Id
  @GeneratedValue
  Long id;
  @Column(name = "REPETICION_REALIZADA")
  private int repeticionesRealizadas;
  @Column(name = "PESO_ALCANZADO")
 private  double pesoAlcanzado;

  public Rendimiento(){}

  public Rendimiento(int repeticionesRealizadas,double pesoAlcanzado){
    this.repeticionesRealizadas = repeticionesRealizadas;
    this.pesoAlcanzado = pesoAlcanzado;
  }

public void setRepeticionesRealizadas(int repeticionesRealizadas){
  this.repeticionesRealizadas = repeticionesRealizadas;
}
public int getRepeticionesRealizada(){
  return this.repeticionesRealizadas;
}
public void setPesoAlcanzado(double pesoAlcanzado){
  this.pesoAlcanzado = pesoAlcanzado;
}
public double getPesoAlcanzado( double pesoAlcanzado){
  return this.pesoAlcanzado;
}
@Override
public String toString(){
return this.repeticionesRealizadas+" "+this.pesoAlcanzado;
}
}
