package aplicacion.entidades;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "libros", schema = "gbp_operacional")
public class Libro {
	
	// Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_libro", nullable = false)
	private long id_libro;
	
	@Column(name = "isbn_libro")
	private String isbn_libro;
	
	@Column(name = "titulo_libro")
	private String titulo_libro;
	
	@Column(name = "edicion_libro")
	private String edicion_libro;
	
	@ManyToOne
	@JoinColumn(name = "id_genero")
	Genero genero;
	
	@ManyToOne
	@JoinColumn(name = "id_editorial")
	Editorial editorial;
	
	@ManyToOne
	@JoinColumn(name = "id_coleccion")
	Coleccion coleccion;
	
	@ManyToMany
	@JoinTable(
	        name = "rel_autores_libros",
	        schema = "gbp_operacional",
	        joinColumns = @JoinColumn(referencedColumnName = "id_libro", name = "id_libro"),
	        inverseJoinColumns = @JoinColumn(referencedColumnName = "id_autor", name = "id_autor"))
	List<Autor> autorConLibro;
	
	@ManyToMany
	@JoinTable(
	        name = "rel_prestamos_libros",
	        schema = "gbp_operacional",
	        joinColumns = @JoinColumn(referencedColumnName = "id_libro", name = "id_libro"),
	        inverseJoinColumns = @JoinColumn(referencedColumnName = "id_prestamo", name = "id_prestamo"))
	List<Prestamo> prestamoConLibro;
	
	
	
	
	// Constructores
	
	public Libro() {
		super();
	}
	
	public Libro(String isbn_libro, String titulo_libro, String edicion_libro, Genero genero, Editorial editorial,
			Coleccion coleccion) {
		super();
		this.isbn_libro = isbn_libro;
		this.titulo_libro = titulo_libro;
		this.edicion_libro = edicion_libro;
		this.genero = genero;
		this.editorial = editorial;
		this.coleccion = coleccion;
	}
}
