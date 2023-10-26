package aplicacion.entidades;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "autor", schema = "gbp_operacional")
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
	List<Libro> libroConAutor;
	
	// Constructores
	
	public Autor() {
		super();
	}
	
	public Autor(String nombre_autor, String apellidos_autor) {
		super();
		this.nombre_autor = nombre_autor;
		this.apellidos_autor = apellidos_autor;
	}
}
