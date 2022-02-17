package org.simarro.adt6_ejemplo4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "personajes")
public class Personaje implements Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "vida")
	private int vida;

	@Column(name = "puntos")
	private int puntos;

	@ManyToMany(cascade = CascadeType.ALL)   // Cuando se elimine un personaje se desvinculará el arma 
												// pero ésta no se borrará (DETACH)
	@JoinTable(name = "personaje_arma", 
	    joinColumns = { @JoinColumn(name = "id_personaje") }, 
	    inverseJoinColumns = {@JoinColumn(name = "id_arma") })
	private List<Arma> armas = new ArrayList<Arma>();

	// Constructor vacío. Hibernate puede mostrar algún error si no está
	// implementado
	public Personaje() {
	}

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

	public List<Arma> getArmas() {
		return armas;
	}

	public void setArma(List<Arma> armas) {
		this.armas = armas;
	}

}