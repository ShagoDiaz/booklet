package com.edutecno.booklet.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class LibroMapper implements RowMapper<Libro> {

	@Override
	public Libro mapRow(ResultSet rs, int rowNum) throws SQLException {
		Libro Libro = new Libro();
		Libro.setId_libro(rs.getInt("id_libro"));
		Libro.setTitulo(rs.getString("titulo"));
		Libro.setAutor(rs.getString("autor"));
		Libro.setPublicacion(rs.getString("publicacion"));
		Libro.setImprenta(rs.getString("imprenta"));
		Libro.setDisponible(rs.getInt("disponible"));
		return Libro;
	}

}
