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
@Table(name = "estados_prestamos", schema = "gbp_operacional")
public class EstadoPrestamo {
	// Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estado_prestamo")
	private long id_estado_prestamo;
	
	@Column(name = "codigo_estado_prestamo")
	private String codigo_estado_prestamo;
	
	@Column(name = "descripcion_estado_prestamo")
	private String descripcion_estado_prestamo;
	
	@OneToMany(mappedBy = "estadoPrestamo")
	List<Prestamo> prestamoConEstadoPrestamo;
	
	// Constructores

	public EstadoPrestamo() {
		super();
	}

	public EstadoPrestamo(String codigo_estado_prestamo, String descripcion_estado_prestamo) {
		super();
		this.codigo_estado_prestamo = codigo_estado_prestamo;
		this.descripcion_estado_prestamo = descripcion_estado_prestamo;
	}
	
}
