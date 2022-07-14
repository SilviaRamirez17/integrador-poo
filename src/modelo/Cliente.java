package modelo;

//import java.util.Date;

import jakarta.persistence.*;


@Entity
@Table(name = "T_CLIENTE")
public class Cliente {

  //private static final string Entrenamiento = null;
  @Id
  private Integer dni;
  @Column(name = "NOMBRE")
  private String nombres;
  @Column( name = "APELLIDO")
  private String apellidos;
  @Column( name = "FECHA_DE_NACIMIENTO")
  private String fechanacimiento;
  @Column(name = "SEXO")
  private char sexo;
  //entrenamiento
  //falta get y set.
  @ManyToOne
  Entrenamiento entrenamiento;
  public Cliente() {
  }

  public Cliente(Integer dni,String nombres, String apellidos, String fechanacimiento,char sexo) {
    this.nombres = nombres;
    this.sexo = sexo;
    this.dni = dni;
    this.apellidos = apellidos;
    this.fechanacimiento = fechanacimiento;
  }

  public <alertType> Cliente(alertType tipo) {
  }

public void setsexo(char sexo) {
    this.sexo = sexo;
  }

  public char getsexo() {
    return this.sexo;
  }

  public Integer getdni() {
    return this.dni;
  };

  public void setdni(Integer dni) {
    this.dni = dni;
  }

  public String getNombres() {
    return this.nombres;
  };

  public String getnombres() {
    return this.nombres;
  }

  public void setNombres(String nombres) {
    this.nombres = nombres;
  }

  //asignar entrenamiento al cliente
  public void setEntrenamiento (Entrenamiento entrenamiento) {
    this.entrenamiento = entrenamiento;
  };

  //ver el entrenamiento del cliente
  public Entrenamiento getEntrenamiento() {
    return this.entrenamiento;
  };

  @Override
  public String toString() {
    return this.nombres + " " + this.apellidos + " " + this.dni + " "
    + this.sexo + " " + this.fechanacimiento;
  };

};