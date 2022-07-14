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
@Table(name = "T_ENTRENAMIENTO")
public class Entrenamiento {

  //fecha en la que iniciara el entrenamiento
  @Id
  @GeneratedValue
  long ID;
  @Column(name = "SEMANA_DE_INICIO")
  private String semanaDeIncio;
  @Column(name = "NOMBRE")
  private String nombre;
  @Column(name = "SEMANA_DE_ENTRENAMIENTO")
  private  int semanasDeEtrenamiento;
  @Column(name = "CALIFICACION_DEL_TUTOR")
  private int calificacionDelTutor;
  //clientes que siguen el entrenamiento
  @OneToMany (mappedBy = "entrenamiento")
  private List<Cliente> clientes = new ArrayList<>();
  //tutor a cargo de un entrenamiento
  @ManyToOne
  private Tutor tutor;
  //un entrenamiento tiene muchas semanas
  //falta controlar que sean 1 a 4 semanas
  @OneToMany (mappedBy = "entrenamiento")
  private List<SemanaDeEjercicio> listaDeSemanas = new ArrayList<>();
  
  
  public Entrenamiento() {};

  /* public  double volumenEntrenamiento(){}; */

  public Entrenamiento(String semanadeinicio, String nombre) {
    this.semanaDeIncio = semanadeinicio;
    this.nombre = nombre;
    this.calificacionDelTutor = 0;
    this.semanasDeEtrenamiento = 4;
  };
  public void setCalificacion(int calificacion){
    this.calificacionDelTutor = calificacion;
  }

  public int getCalificacion(){
    return this.calificacionDelTutor;
  }

  public String getSemanaDeInicio() {
    return this.semanaDeIncio;
  }

  public void setSemanaDeInicio(String semanadeinicio) {
    this.semanaDeIncio = semanadeinicio;
  }
public String getNombre() {
    return this.nombre;
  };

  public void setNombre(String nombre) {
    this.nombre = nombre;
  };

  //agregar clientes al entrenamiento
  public void setClientesAlEntrenamiento(Cliente cliente) {
    this.clientes.add(cliente);
    cliente.setEntrenamiento(this);
  };

  //quitar cliente del entrenamiento
  public void removeCliente(Cliente cliente) {
    if (this.clientes.contains(cliente)) {
      //verificar que quede bien en la BD
      //manejar errores
      this.clientes.remove(cliente);
      //el cliente ya no esté asociado al entrenamiento
    };
  };

  //asignar tutor al antrenamiento
  public void setTutor(Tutor tutor) {
    this.tutor = tutor;
    tutor.setEntrenamiento(this);
  };

  //ver el tutor del entrenamiento
  public Tutor getTutor() {
    return this.tutor;
  };

  //public void musculosDelEntrenamiento() {};

  //equipamiento

  @Override
  public String toString() {
    return "Ejercicio: " +  this.calificacionDelTutor+"  "+this.nombre+" " + "Semana de inicio del Entrenamiento: " + this.semanaDeIncio;
  }

  public void setCliente(Cliente cliente) {
  }
}