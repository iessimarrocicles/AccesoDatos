package org.simarro.adt6_ejemplo2;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="armas")
public class Arma implements Serializable{

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="dano")
	private int dano;
	
	@OneToOne(mappedBy = "arma")
	private Personaje personaje;
	
	public Arma() {}
	
	public Arma(String nombre, String descripcion, int dano) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.dano = dano;
	}
	
	public Arma(int id, String nombre, String descripcion, int dano) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.dano = dano;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDano() {
		return dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}
	
	public Personaje getPersonaje() {
		return personaje;
	}
	
	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}
	
	
}