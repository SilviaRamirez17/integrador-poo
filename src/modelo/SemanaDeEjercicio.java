package modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_SEMANA_DE_EJERCICIO")
public class SemanaDeEjercicio {
  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "NOMBRE")
  private String nombre;
  //una semana tiene muchos ejercicios
  @OneToMany (mappedBy = "semana")
  private List<Ejercicio> listaDeEjercicios = new ArrayList<>();
  //una semana pertenece a un entrenamiento
  @ManyToOne
  Entrenamiento entrenamiento;

  //constructor
  public SemanaDeEjercicio(){}

  public SemanaDeEjercicio( String nombre){
     this.nombre = nombre;
  }

  public void setNombre(String nombre){
    this.nombre = nombre;
  }

  public String getNombre(){
    return this.nombre;
  }

  //public  double VolumenSemanal(){}

}
