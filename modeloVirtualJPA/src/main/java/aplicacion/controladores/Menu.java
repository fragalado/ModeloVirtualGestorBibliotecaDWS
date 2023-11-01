package aplicacion.controladores;

import java.util.ArrayList;
import java.util.List;

import aplicacion.daos.AccesoDao;
import aplicacion.daos.Crud;
import aplicacion.daos.UsuarioDao;
import aplicacion.dtos.Acceso;
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
		
		// Lista para guardar los objetos
		List<Object> lista = new ArrayList<Object>();
		
		// Instanciamos crud para poder hacer el crud a la base de datos
		Crud crud = new Crud();
		
		// Acceso
		Acceso acc1 = new Acceso("Usu", "Usuarios de la biblioteca");
		Acceso acc2 = new Acceso("Emp", "Empleados de la biblioteca");
		Acceso acc3 = new Acceso("Prueba", "prueba para update");
		Acceso acc4 = new Acceso("Prueba2", "prueba para delete");
		
		// Usuario
		Usuario usu1 = new Usuario("53965130T", "Francisco", "Gallego", "43242342", "fa@noemia", "dadwao21", false, null, null, null, acc1);
		Usuario usu2 = new Usuario();
		
		// Prestamo
		
		// Insert
		crud.insert(em, acc1);
		crud.insert(em, acc2);
		crud.insert(em, acc3);
		crud.insert(em, acc4);
		crud.insert(em, usu1);
		// Select
		lista = crud.select(em, "SELECT u FROM Usuario u", lista);
		lista = crud.select(em, "SELECT a FROM Acceso a", lista);
		// Update
		// Delete
		
	}

}
