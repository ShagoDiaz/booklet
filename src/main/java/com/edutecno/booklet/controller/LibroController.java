package com.edutecno.booklet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edutecno.booklet.model.Libro;
import com.edutecno.booklet.service.ILibroService;

@Controller
@RequestMapping(value = "/booklet")
public class LibroController {

	@Autowired
	private ILibroService libroService;

	@GetMapping(value = "/libros")
	public String getBookList(ModelMap model) {
		model.addAttribute("libro", new Libro());
		model.addAttribute("libros", libroService.getAllLibros());
		return "booklet";
	}

	@GetMapping(value = "/filtrar")
	public String findByText(ModelMap model, @ModelAttribute("texto") String texto) {
		Libro libro = new Libro();
		libro.setDisponible(1);
		model.addAttribute("libro", libro);
		model.addAttribute("libros", libroService.findByText(texto));
		return "booklet";
	}

	@GetMapping(value = "/editStock")
	public String editStock(ModelMap model, @ModelAttribute("idLibro") String idLibro,
			@ModelAttribute("set") String set) {
		libroService.setDisponibilidad(Integer.parseInt(idLibro), Integer.parseInt(set));
		return "redirect:/booklet/libros";
	}

	@PostMapping(value = "/addLibro")
	public String addLibro(ModelMap model, @ModelAttribute("libro") Libro libro) {
		libroService.addLibro(libro);
		return "redirect:/booklet/libros";
	}

	@GetMapping(value = "/editLibro")
	public String editLibrotGet(ModelMap model, @ModelAttribute("idLibro") String idLibro) {
		Libro libro = libroService.getLibroById(Integer.parseInt(idLibro));
		model.addAttribute("libro", libro);
		model.addAttribute("libros", libroService.getAllLibros());
		return "booklet";
	}

	@PostMapping(value = "/editLibro")
	public String editLibrotPost(ModelMap model, @ModelAttribute("libro") Libro libro) {
		libroService.editLibro(libro);
		return "redirect:/booklet/libros";
	}

	@PostMapping(value = "/deleteLibro")
	public String deleteLibro(ModelMap model, @ModelAttribute("libro") Libro libro) {
		libroService.delLibro(libro);
		return "redirect:/booklet/libros";
	}
}
