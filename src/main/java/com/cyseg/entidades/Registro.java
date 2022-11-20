package com.cyseg.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import com.cyseg.entidades.Estado;

@Entity
@Table(name= "registro")//Anotacion para el nombre de la tabla en la bd
public class Registro {

	//atributos
		@Id
		@GeneratedValue(generator ="uuid") //Generador automatico de ID
		@GenericGenerator(name = "uuid", strategy = "uuid2")
		private String id;
		private String enlace;
		@OneToOne //Anotacion que indica la relacion que va a tener con la otra clase en la bd
		private Estado estado;

		//constructores
		//con todos los atributos
		public Registro(String id, String enlace, Estado estado) {
			this.id = id;
			this.enlace = enlace;
			this.estado = estado;
		}
		
		//constructor por defecto sin atributos
		public Registro() {
		}
		
		//getters y setters
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getEnlace() {
			return enlace;
		}

		public void setEnlace(String enlace) {
			this.enlace = enlace;
		}

		public Estado getEstado() {
			return estado;
		}

		public void setEstado(Estado estado) {
			this.estado = estado;
		}
}
