package aplicacion.dtos;


import java.util.ArrayList;
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
	
	@Column(name = "cantidad_libro")
	private int cantidad_libro;
	
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
	List<Autor> autorConLibro = new ArrayList<Autor>();
	
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
	
	public Libro(String isbn_libro, String titulo_libro, String edicion_libro, int cantidadLibro, Genero genero, Editorial editorial,
			Coleccion coleccion) {
		super();
		this.isbn_libro = isbn_libro;
		this.titulo_libro = titulo_libro;
		this.edicion_libro = edicion_libro;
		this.genero = genero;
		this.editorial = editorial;
		this.coleccion = coleccion;
		this.cantidad_libro = cantidadLibro;
	}
	
	// Getter
	
	public Coleccion getColeccion() {
		return coleccion;
	}

	public String getIsbn_libro() {
		return isbn_libro;
	}

	public String getTitulo_libro() {
		return titulo_libro;
	}

	public String getEdicion_libro() {
		return edicion_libro;
	}
	
	public int getCantidadLibro() {
		return cantidad_libro;
	}

	public Genero getGenero() {
		return genero;
	}

	public Editorial getEditorial() {
		return editorial;
	}
	
	public List<Autor> getAutorConLibro() {
		return autorConLibro;
	}

	public List<Prestamo> getPrestamoConLibro() {
		return prestamoConLibro;
	}
	
	// Setter

	public void setColeccion(Coleccion coleccion) {
		this.coleccion = coleccion;
	}
	
	public void setIsbn_libro(String isbn_libro) {
		this.isbn_libro = isbn_libro;
	}

	public void setTitulo_libro(String titulo_libro) {
		this.titulo_libro = titulo_libro;
	}
	
	public void setCantidad_libro(int cantidad_libro) {
		this.cantidad_libro = cantidad_libro;
	}

	public void setEdicion_libro(String edicion_libro) {
		this.edicion_libro = edicion_libro;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	
	// toString
	
	@Override
	public String toString() {
		return "Libro [isbn_libro=" + isbn_libro + ", titulo_libro=" + titulo_libro + ", edicion_libro=" + edicion_libro
				+ ", genero=" + genero + ", cantidad libro="+cantidad_libro+ ", editorial=" + editorial + ", coleccion=" + coleccion + ", autor="+autorConLibro+"]";
	}
}
