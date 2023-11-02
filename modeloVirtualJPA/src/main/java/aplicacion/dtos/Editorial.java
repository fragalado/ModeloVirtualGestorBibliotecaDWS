package aplicacion.dtos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "editoriales", schema = "gbp_operacional")
public class Editorial {
	
	// Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_editorial", nullable = false)
	private long id_editorial;
	
	@Column(name = "nombre_editorial")
	private String nombre_editorial;
	
	@OneToMany(mappedBy = "editorial")
	List<Libro> librosConEditorial;
	
	// Constructores

	public Editorial() {
		super();
	}
	
	public Editorial(String nombre_editorial) {
		super();
		this.nombre_editorial = nombre_editorial;
	}
	
	// Getter
	
	public String getNombre_editorial() {
		return nombre_editorial;
	}
	
	// Setter
	
	public void setNombre_editorial(String nombre_editorial) {
		this.nombre_editorial = nombre_editorial;
	}
	
	// toString
	
	@Override
	public String toString() {
		return "Editorial [nombre_editorial=" + nombre_editorial + "]";
	}
	
}
