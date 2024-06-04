package com.example.app.controller;

import java.awt.print.Book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {

	private BookService bookService;

	public BookController(BookService theBookService) {
		bookService = theBookService;
	}

	@GetMapping("/list")
	public String listBooks(Model theModel) {

		List<Book> theBooks = bookService.findAll();

		theModel.addAttribute("books", theBooks);

		return "";
	}
}
