package aplicacion.daos;


import aplicacion.dtos.Autor;
import aplicacion.dtos.Libro;
import jakarta.persistence.EntityManager;

public class RelAutorLibroDao {

	private EntityManager em;

	public RelAutorLibroDao(EntityManager em) {
		this.em = em;
	}

	public void insertRelAutorLibroDao(Autor autor, Libro libro) {

		// Añadimos el autor a la lista de libro
		libro.getAutorConLibro().add(autor);
		autor.getLibroConAutor().add(libro);
		
		// Hacemos el begin
		em.getTransaction().begin();

		// Hacemos el persist de autor y libro
		em.persist(libro);
		em.persist(autor);

		// Hacemos el commit
		em.getTransaction().commit();
	}
}
