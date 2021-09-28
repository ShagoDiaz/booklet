package com.edutecno.booklet.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.edutecno.booklet.model.Libro;
import com.edutecno.booklet.model.LibroMapper;

@Repository
public class LibroDaoImpl implements ILibroDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public LibroDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Libro> getAllLibros() {
		return jdbcTemplate.query("SELECT * FROM LIBROS", new LibroMapper());
	}

	@Override
	public Libro getLibroById(int id) {
		String sql = "select * from libros where id_libro=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new LibroMapper());
	}

	@Override
	public List<Libro> findByText(String text) {
		String sql = "select * from libros where titulo like ? or autor like ?";
		return jdbcTemplate.query(sql, new Object[] { "%" + text + "%", "%" + text + "%" }, new LibroMapper());
	}

	@Override
	public int addLibro(Libro libro) {
		String sql = "insert into libros (id_libro, titulo, autor, publicacion,imprenta,disponible) values (?,?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, libro.getId_libro(), libro.getTitulo(), libro.getAutor(),
				libro.getPublicacion(), libro.getImprenta(), libro.getDisponible());
	}

	@Override
	public int editLibro(Libro libro) {
		String sql = "UPDATE libros set titulo=?, autor=?, publicacion=?,imprenta=?, disponible=? WHERE id_libro=?";
		return jdbcTemplate.update(sql, libro.getTitulo(), libro.getAutor(), libro.getPublicacion(),
				libro.getImprenta(), libro.getDisponible(), libro.getId_libro());
	}

	@Override
	public int delLibro(Libro libro) {
		String sql = "DELETE FROM libros WHERE id_libro=?";
		return jdbcTemplate.update(sql, libro.getId_libro());
	}

	@Override
	public int setDisponibilidad(int id, int set) {
		String sql = "UPDATE libros set disponible=? WHERE id_libro=?";
		return jdbcTemplate.update(sql, set, id);
	}

}
