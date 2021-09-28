package com.edutecno.booklet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.edutecno.booklet.AppConfig;
import com.edutecno.booklet.dao.ILibroDao;
import com.edutecno.booklet.dao.LibroDaoImpl;
import com.edutecno.booklet.model.Libro;

@Service
public class LibroServiceImpl implements ILibroService {

	@Autowired
	ILibroDao libroDao;

	private static int counter = 0;

	@Override
	public List<Libro> getAllLibros() {
		return libroDao.getAllLibros();
	}

	@Override
	public Libro getLibroById(int id) {
		return libroDao.getLibroById(id);
	}

	@Override
	public List<Libro> findByText(String text) {
		return libroDao.findByText(text);
	}

	@Override
	public int addLibro(Libro libro) {
		libro.setId_libro(++counter);
		return libroDao.addLibro(libro);
	}

	@Override
	public int editLibro(Libro libro) {
		return libroDao.editLibro(libro);
	}

	@Override
	public int delLibro(Libro libro) {
		return libroDao.delLibro(libro);
	}

	@Override
	public int setDisponibilidad(int id, int set) {
		return libroDao.setDisponibilidad(id, set);
	}

}
