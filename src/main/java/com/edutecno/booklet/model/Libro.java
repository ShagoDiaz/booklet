package com.edutecno.booklet.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component("libro")
public class Libro {

	private int id_libro;
	private String titulo;
	private String autor;
	private String publicacion;
	private String imprenta;
	private int disponible;

}
