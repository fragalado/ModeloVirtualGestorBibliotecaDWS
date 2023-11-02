package aplicacion.dtos;

import java.text.SimpleDateFormat;
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
	
	// Getter
	
	public Calendar getFch_inicio_prestamo() {
		return fch_inicio_prestamo;
	}

	public Calendar getFch_fin_prestamo() {
		return fch_fin_prestamo;
	}

	public Calendar getFch_entrega_prestamo() {
		return fch_entrega_prestamo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public EstadoPrestamo getEstadoPrestamo() {
		return estadoPrestamo;
	}
	
	// Setter

	public void setFch_inicio_prestamo(Calendar fch_inicio_prestamo) {
		this.fch_inicio_prestamo = fch_inicio_prestamo;
	}

	public void setFch_fin_prestamo(Calendar fch_fin_prestamo) {
		this.fch_fin_prestamo = fch_fin_prestamo;
	}

	public void setFch_entrega_prestamo(Calendar fch_entrega_prestamo) {
		this.fch_entrega_prestamo = fch_entrega_prestamo;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setEstadoPrestamo(EstadoPrestamo estadoPrestamo) {
		this.estadoPrestamo = estadoPrestamo;
	}

	// toString
	
	@Override
	public String toString() {
		
		String fch_inicio_prestamoString, fch_fin_prestamoString;
		if(fch_inicio_prestamo == null)
			fch_inicio_prestamoString = null;
		else
			fch_inicio_prestamoString  = new SimpleDateFormat("dd-MM-yyyy").format(fch_inicio_prestamo.getTime());
		
		if(fch_fin_prestamo == null)
			fch_fin_prestamoString = null;
		else
			fch_fin_prestamoString  = new SimpleDateFormat("dd-MM-yyyy").format(fch_fin_prestamo.getTime());
		
		String fch_entrega_prestamoString  = fch_entrega_prestamo==null ? null : new SimpleDateFormat("dd-MM-yyyy").format(fch_entrega_prestamo.getTime());
		
		
		return "Prestamo [fch_inicio_prestamo=" + fch_inicio_prestamoString + ", fch_fin_prestamo=" + fch_fin_prestamoString
				+ ", fch_entrega_prestamo=" + fch_entrega_prestamoString + ", usuario=" + usuario.getDni_usuario() + ", estadoPrestamo="
				+ estadoPrestamo.getCodigo_estado_prestamo() + "]";
	}
	
}
