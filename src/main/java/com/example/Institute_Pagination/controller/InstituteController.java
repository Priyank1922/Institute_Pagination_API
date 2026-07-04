package com.example.Institute_Pagination.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.example.Institute_Pagination.entity.Institute_Student;
import com.example.Institute_Pagination.service.InstituteService;

@RestController
@RequestMapping("/institute")
@CrossOrigin(origins = "https://institute-pagination-front-end.vercel.app/")
//@CrossOrigin(origins = "https://institute-pagination-front-end-nklw.vercel.app")
public class InstituteController {

	@Autowired
	private InstituteService service;

	@PostMapping
	public Institute_Student createStudent(@RequestBody Institute_Student student) {
		return service.saveStudent(student);
	}

	@GetMapping("/all")
	public List<Institute_Student> getAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Institute_Student> getById(@PathVariable Long id) {
		return service.findById(id);
	}

	@PutMapping("/{id}")
	public Institute_Student updateStudent(@PathVariable Long id, @RequestBody Institute_Student student) {
		return service.updateStudent(id, student);
	}

	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable Long id) {
		service.deleteStudent(id);
		return "Student with ID " + id + " deleted successfully!";
	}

//	Pagination + Sorting + Search
	@GetMapping
	public Page<Institute_Student> getAllByPagination(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size, 
			@RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc") String sortDir,
			@RequestParam(required = false) String search) {
		if (search != null && !search.trim().isEmpty()) {
			return service.searchStudents(search, page, size, sortBy, sortDir);
		}
		return service.findAllByPagination(page, size, sortBy, sortDir);
	}

	// Search + Pagination + Sorting
	@GetMapping("/search")
	public Page<Institute_Student> searchByName(@RequestParam String name, @RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "id") String sortBy,
			@RequestParam(defaultValue = "asc") String sortDir) {
		return service.searchByName(name, page, size, sortBy, sortDir);
	}
}
