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
@Table(name = "generos", schema = "gbp_operacional")
public class Genero {
	
	// Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_genero", nullable = false)
	private long id_genero;
	
	@Column(name = "nombre_genero")
	private String nombre_genero;
	
	@Column(name = "descripcion_genero")
	private String descripcion_genero;
	
	@OneToMany(mappedBy = "genero")
	List<Libro> librosConGenero;
	
	// Constructores
	
	public Genero() {
		super();
	}
	
	public Genero(String nombre_genero, String descripcion_genero) {
		super();
		this.nombre_genero = nombre_genero;
		this.descripcion_genero = descripcion_genero;
	}
	
	// Getter
	
	public String getNombre_genero() {
		return nombre_genero;
	}

	public String getDescripcion_genero() {
		return descripcion_genero;
	}
	
	// Setter
	
	public void setNombre_genero(String nombre_genero) {
		this.nombre_genero = nombre_genero;
	}

	public void setDescripcion_genero(String descripcion_genero) {
		this.descripcion_genero = descripcion_genero;
	}
	
	// toString
	
	@Override
	public String toString() {
		return "Genero [nombre_genero=" + nombre_genero + ", descripcion_genero=" + descripcion_genero + "]";
	}
	
}
