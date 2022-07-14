package modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_GRUPO_DE_MUSCULO")
public class GrupoDeMusculos {

  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "NOMBRE")
  private String nombre;
  //un grupo de musculos está asociado a un ejercicio
  @ManyToOne
  private Ejercicio ejercicio;
  
  
  // constructores
  public GrupoDeMusculos() {
  };

  public GrupoDeMusculos(String nombre) {
    this.nombre = nombre;
  };

  // metodos
  public String getNombre() {
    return this.nombre;
  };

  public void setNombre(String nombre) {
    this.nombre = nombre;

  };

  public String musculosDelGrupo() {
    return "Grupo: " + this.nombre;
  };
}