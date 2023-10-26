package aplicacion.controladores;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import aplicacion.entidades.Acceso;
import aplicacion.entidades.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Menu {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		// Insert
		Acceso a1 = new Acceso("Emp", "Empleados de la biblioteca");
		Acceso a2 = new Acceso("Usu", "Usuarios de la biblioteca");
		em.persist(a1);
		em.persist(a2);
		
		Calendar calendario = new GregorianCalendar();
		Date fecha = new Date(2023, 10, 25);
		calendario.setTime(fecha);
		Usuario u1 = new Usuario("53965130T", "Fran", "Gallego Dorado", "643543524", "noemail@no.com", "dwjiadjiwa2", false, null, calendario, null, a2);
		em.persist(u1);
		
		// Commit
		em.getTransaction().commit();
		
		// Cerramos em
		em.close();
	}

}
