package aplicacion.servicios;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import aplicacion.entidades.Acceso;
import aplicacion.entidades.Usuario;
import jakarta.persistence.EntityManager;

public class UsuarioImplementacion implements UsuarioInterfaz{

	@Override
	public void insertUsuario(EntityManager em) {
		
		// Scanner para leer
		Scanner sc = new Scanner(System.in);
		
		// Iniciamos la transaccion
		em.getTransaction().begin();
		
		// Pedimos los datos del usuario a insertar
		// DNI
		System.out.flush();
		System.out.print("Introduzca el dni del usuario: ");
		String dni = sc.nextLine();
				
		// Nombre
		System.out.print("Introduzca el nombre del usuario: ");
		String nombre = sc.nextLine();
		
		// Apellidos
		System.out.print("Introduzca los apellidos del usuario: ");
		String apellidos = sc.nextLine();
		
		// Telefono
		System.out.print("Introduzca el telefono del usuario: ");
		String tlf = sc.nextLine();
		
		// Email
		System.out.print("Introduzca el email del usuario: ");
		String email = sc.nextLine();
		
		// Clave
		System.out.print("Introduzca la clave del usuario: ");
		String clave = sc.nextLine();
		
		// La fecha de alta de usuario se creara automaticamente con el dia y hora actual
		LocalDateTime fechaActual = LocalDateTime.now();
		Calendar calendario = new GregorianCalendar();
		calendario.set(fechaActual.getYear(), fechaActual.getMonthValue(), fechaActual.getDayOfMonth(), fechaActual.getHour(), fechaActual.getMinute(), fechaActual.getSecond());
		
		// Creamos el usuario con los datos
		Usuario usu = new Usuario(dni, nombre, apellidos, tlf, email, clave, false, null, calendario, null, new Acceso("Usu", "Usuarios de la biblioteca"));
	
		// Insertamos el usuario
		em.persist(usu);
		
		// Hacemos el commit
		em.getTransaction().commit();
	}

	@Override
	public void selectUsuario(EntityManager em) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUsuario(EntityManager em) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUsuario(EntityManager em) {
		// TODO Auto-generated method stub
		
	}

}
