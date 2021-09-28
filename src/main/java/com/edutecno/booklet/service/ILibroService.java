package com.edutecno.booklet.service;

import java.util.List;

import com.edutecno.booklet.model.Libro;

public interface ILibroService {

	public List<Libro> getAllLibros();

	public Libro getLibroById(int id);

	public List<Libro> findByText(String text);

	public int addLibro(Libro libro);

	public int editLibro(Libro libro);

	public int delLibro(Libro libro);

	public int setDisponibilidad(int id, int set);
}
