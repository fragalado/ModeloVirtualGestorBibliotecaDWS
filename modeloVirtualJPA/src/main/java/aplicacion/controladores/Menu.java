package aplicacion.controladores;

import java.util.Calendar;
import java.util.GregorianCalendar;

import aplicacion.daos.AccesoDao;
import aplicacion.daos.AutorDao;
import aplicacion.daos.ColeccionDao;
import aplicacion.daos.EditorialDao;
import aplicacion.daos.EstadoPrestamoDao;
import aplicacion.daos.GeneroDao;
import aplicacion.daos.LibroDao;
import aplicacion.daos.PrestamoDao;
import aplicacion.daos.RelAutorLibroDao;
import aplicacion.daos.UsuarioDao;
import aplicacion.dtos.Acceso;
import aplicacion.dtos.Autor;
import aplicacion.dtos.Coleccion;
import aplicacion.dtos.Editorial;
import aplicacion.dtos.EstadoPrestamo;
import aplicacion.dtos.Genero;
import aplicacion.dtos.Libro;
import aplicacion.dtos.Prestamo;
import aplicacion.dtos.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Menu {

	public static void main(String[] args) {
		
		// EntityManagerFactory y EntityManager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
		EntityManager em = emf.createEntityManager();
		
		// Instanciamos los daos para poder hacer los cruds
		AccesoDao accesoDao = new AccesoDao(em);
		UsuarioDao usuarioDao = new UsuarioDao(em);
		EstadoPrestamoDao estadoPrestamoDao = new EstadoPrestamoDao(em);
		PrestamoDao prestamoDao = new PrestamoDao(em);
		GeneroDao generoDao = new GeneroDao(em);
		EditorialDao editorialDao = new EditorialDao(em);
		ColeccionDao coleccionDao = new ColeccionDao(em);
		AutorDao autorDao = new AutorDao(em);
		LibroDao libroDao = new LibroDao(em);
		RelAutorLibroDao relAutorLibroDao = new RelAutorLibroDao(em);
		
		// Acceso
		Acceso acc1 = new Acceso("Usu", "Usuarios de la biblioteca");
		Acceso acc2 = new Acceso("Emp", "Empleados de la biblioteca");
		Acceso acc3 = new Acceso("Prueba", "prueba para update");
		Acceso acc4 = new Acceso("Prueba2", "prueba para delete");
		
		// Usuario
		Usuario usu1 = new Usuario("53965130T", "Francisco", "Gallego", "43242342", "fa@noemia", "dadwao21", false, null, null, null, acc1);
		Usuario usu2 = new Usuario("432432D", "Pepe", "Perez", "3424543543", "noemail@no.com", "ngfdgrlL2", false, null, null, null, acc2);
		Usuario usu3 = new Usuario("876987A", "Prueba", "PruebaApellido", "543534", "prueba@nomail.no", "pruebaClave", false, null, null, null, acc1);
		
		// EstadoPrestamo
		EstadoPrestamo estadoPrestamo1 = new EstadoPrestamo("Dev", "Prestamo devuelto");
		EstadoPrestamo estadoPrestamo2 = new EstadoPrestamo("Sin", "Prestamo no devuelto");
		
		// Prestamo
		Calendar calendarioFechaInicio = new GregorianCalendar();
		Calendar calendarioFechaFin = new GregorianCalendar();
		Calendar calendarioFechaEntrega = Calendar.getInstance();
		calendarioFechaFin.add(Calendar.DATE, 7);
		calendarioFechaEntrega.add(Calendar.DATE, 7);
		Prestamo p1 = new Prestamo(calendarioFechaInicio, calendarioFechaFin, calendarioFechaEntrega, usu1, estadoPrestamo1);
		Prestamo p2 = new Prestamo(calendarioFechaInicio, null, null, usu2, estadoPrestamo2);
		
		// Editorial
		Editorial edi1 = new Editorial("Bilbo");
		
		// Genero
		Genero g1 = new Genero("Terror", "Esta etiqueta la tendrán los libros de terror");
		
		// Coleccion
		Coleccion c1 = new Coleccion("Coleccion prueba");
		
		// Autor
		Autor au1 = new Autor("Fran", "Fran autor");
		Autor au2 = new Autor("Federico", "Fedez");
		
		// Libro
		Libro l1 = new Libro("123", "Harry Potter", "Ralv", 3, g1, edi1, c1);
		Libro l2 = new Libro("456", "Diario de Greg", "Greg", 2, g1, edi1, c1);
		
		// Insert
		accesoDao.insertAcceso(acc1); // Acceso 1
		accesoDao.insertAcceso(acc2); // Acceso 2
		accesoDao.insertAcceso(acc3); // Acceso 3
		accesoDao.insertAcceso(acc4); // Acceso 4
		usuarioDao.insertUsuario(usu1); // Usuario 1
		usuarioDao.insertUsuario(usu2); // Usuario 2
		usuarioDao.insertUsuario(usu3); // Usuario 3
		estadoPrestamoDao.insertEstadoPrestamo(estadoPrestamo1); // EstadoPrestamo 1
		estadoPrestamoDao.insertEstadoPrestamo(estadoPrestamo2); // EstadoPrestamo 2
		prestamoDao.insertPrestamo(p1); // Prestamo 1
		prestamoDao.insertPrestamo(p2); // Prestamo 2
		editorialDao.insertEditorial(edi1); // Editorial 1
		generoDao.insertGenero(g1); // Genero 1
		coleccionDao.insertColeccion(c1); // Coleccion 1
		autorDao.insertAutor(au2);
		libroDao.insertLibro(l2);
		relAutorLibroDao.insertRelAutorLibroDao(au1, l1);
		
		// Select
		accesoDao.selectAcceso("SELECT a FROM Acceso a");
		accesoDao.selectAcceso("SELECT a FROM Acceso a WHERE a.codigo_acceso = :codigoAcceso");
		usuarioDao.selectUsuario("SELECT u FROM Usuario u");
		estadoPrestamoDao.selectEstadoPrestamo("SELECT ep FROM EstadoPrestamo ep");
		prestamoDao.selectPrestamo("SELECT p FROM Prestamo p");
		prestamoDao.selectPrestamo("SELECT p FROM Prestamo p WHERE p.id_prestamo = :idPrestamo");
		editorialDao.selectEditorial("SELECT e FROM Editorial e");
		generoDao.selectGenero("SELECT g FROM Genero g");
		coleccionDao.selectColeccion("SELECT c FROM Coleccion c");
		autorDao.selectAutor("SELECT au FROM Autor au");
		libroDao.selectLibro("SELECT l FROM Libro l");
		
		// Update
		// Delete
		
	}

}
