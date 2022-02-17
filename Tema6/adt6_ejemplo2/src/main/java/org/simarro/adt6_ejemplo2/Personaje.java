package org.simarro.adt6_ejemplo2;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="personajes")
public class Personaje implements Serializable {

	@Id					
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="vida")
	private int vida;
	
	@Column(name="puntos")
	private int puntos;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_arma")
	private Arma arma;
	
	// Constructor vacío. Hibernate puede mostrar algún error si no está implementado
	public Personaje() {}
	
	public Personaje(String nombre, int vida, int puntos) {
		this.nombre = nombre;
		this.vida = vida;
		this.puntos = puntos;
	}
	
	public Personaje(int id, String nombre, int vida, int puntos) {
		this.id = id;
		this.nombre = nombre;
		this.vida = vida;
		this.puntos = puntos;
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

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public Arma getArma() {
		return arma;
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}
	
	
}