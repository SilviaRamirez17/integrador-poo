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
@Table(name = "T_EJERCICIO")
public class Ejercicio {

  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "NOMBRE")
  private String nombre;
  @Column(name = "TIEMPODEDESCANSO")
  private int tiempoDeDescanso;
  @Column(name = "REPETICIONE")
  private int repeticiones;
  @Column(name = "PESO")
  private double peso;
  //un ejercicio tiene muchos musculos
  @OneToMany (mappedBy = "ejercicio")
  private List<GrupoDeMusculos> listaDeMusculo = new ArrayList<>();
  //un ejercicio pertenece a una semana
  @ManyToOne
  private SemanaDeEjercicio semana;

  //constructores
  public Ejercicio() {};

  public Ejercicio(String nombre, int tiempoDeDescanso, int repeticiones, double peso) {
    this.nombre = nombre;
    this.tiempoDeDescanso = tiempoDeDescanso;
    this.repeticiones = repeticiones;
    this.peso = peso;
  };

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getNomre() {
    return this.nombre;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

  public double getPeso() {
    return this.peso;
  }

  public void setRepeticiones(int repeticiones) {
    this.repeticiones = repeticiones;

  }

  public int getRepeticiones() {
    return this.repeticiones;
  }

  public void setTiempoDeDescanso(int tiempoDeDescanso) {
    this.tiempoDeDescanso = tiempoDeDescanso;

  }

  public int getTiempoDeDescanso() {
    return this.tiempoDeDescanso;
  }

  public boolean setListaDeMusculos(GrupoDeMusculos grupo) {
    return this.listaDeMusculo.add(grupo);
  }

  public Object getListaDeMusculos() {
    return this.listaDeMusculo;
  }

  public String toString() {
    return this.nombre + " " + this.tiempoDeDescanso + "  " + this.repeticiones + " " + this.peso;
  }
}
