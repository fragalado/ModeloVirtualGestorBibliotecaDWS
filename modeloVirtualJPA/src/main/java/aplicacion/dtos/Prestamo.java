package aplicacion.dtos;

import java.util.Calendar;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "prestamos", schema = "gbp_operacional")
public class Prestamo {
	
	// Atributos
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_prestamo")
	private long id_prestamo;
	
	@Column(name = "fch_inicio_prestamo")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fch_inicio_prestamo;
	
	@Column(name = "fch_fin_prestamo")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fch_fin_prestamo;
	
	@Column(name = "fch_entrega_prestamo")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fch_entrega_prestamo;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_estado_prestamo")
	EstadoPrestamo estadoPrestamo;
	
	@ManyToMany(mappedBy = "prestamoConLibro")
	List<Libro> libroConPrestamo;
	
	
	// Constructores
	
	public Prestamo() {
		super();
	}
	
	public Prestamo(Calendar fch_inicio_prestamo, Calendar fch_fin_prestamo, Calendar fch_entrega_prestamo,
			Usuario usuario, EstadoPrestamo estadoPrestamo) {
		super();
		this.fch_inicio_prestamo = fch_inicio_prestamo;
		this.fch_fin_prestamo = fch_fin_prestamo;
		this.fch_entrega_prestamo = fch_entrega_prestamo;
		this.usuario = usuario;
		this.estadoPrestamo = estadoPrestamo;
	}
}
