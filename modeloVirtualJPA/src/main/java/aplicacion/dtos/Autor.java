package aplicacion.dtos;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "autores", schema = "gbp_operacional")
public class Autor {
	
	// Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_autor", nullable = false)
	private long id_autor;
	
	@Column(name = "nombre_autor")
	private String nombre_autor;
	
	@Column(name = "apellidos_autor")
	private String apellidos_autor;
	
	@ManyToMany(mappedBy = "autorConLibro")
	List<Libro> libroConAutor = new ArrayList<Libro>();
	
	// Constructores
	
	public Autor() {
		super();
	}
	
	public Autor(String nombre_autor, String apellidos_autor) {
		super();
		this.nombre_autor = nombre_autor;
		this.apellidos_autor = apellidos_autor;
	}
	
	// Getter
	
	public String getNombre_autor() {
		return nombre_autor;
	}

	public String getApellidos_autor() {
		return apellidos_autor;
	}
	
	public List<Libro> getLibroConAutor() {
		return libroConAutor;
	}
	
	// Setter

	public void setNombre_autor(String nombre_autor) {
		this.nombre_autor = nombre_autor;
	}

	public void setApellidos_autor(String apellidos_autor) {
		this.apellidos_autor = apellidos_autor;
	}
	
	// toString
	
	@Override
	public String toString() {
		return "Autor [nombre_autor=" + nombre_autor + ", apellidos_autor=" + apellidos_autor + "]";
	}
	
}
