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
@Table(name = "colecciones", schema = "gbp_operacional")
public class Coleccion {

	// Atributos

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_coleccion", nullable = false)
	private long id_coleccion;

	@Column(name = "nombre_coleccion")
	private String nombre_coleccion;
	
	@OneToMany(mappedBy = "coleccion")
	List<Libro> librosColeccion;

	// Constructores

	public Coleccion() {
			super();
		}

	public Coleccion(String nombre_coleccion) {
			super();
			this.nombre_coleccion = nombre_coleccion;
		}
}
