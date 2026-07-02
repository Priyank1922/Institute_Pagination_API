package com.example.Institute_Pagination.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.Institute_Pagination.entity.Institute_Student;
import com.example.Institute_Pagination.repository.InstituteRepository;

@Service
public class InstituteService {

	@Autowired
	private InstituteRepository repo;

	public Institute_Student saveStudent(Institute_Student student) {
		return repo.save(student);
	}

	public List<Institute_Student> findAll() {
		return repo.findAll();
	}

	public Optional<Institute_Student> findById(Long id) {
		return repo.findById(id);
	}

	public Institute_Student updateStudent(Long id, Institute_Student student) {
		student.setId(id);
		return repo.save(student);
	}

	public void deleteStudent(Long id) {
		repo.deleteById(id);
	}

	public Page<Institute_Student> findAllByPagination(int page, int size, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(page, size, sort);
		return repo.findAll(pageable);
	}

	public Page<Institute_Student> searchByName(String name, int page, int size, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(page, size, sort);
		return repo.findByNameContainingIgnoreCase(name, pageable);
	}

	public Page<Institute_Student> searchStudents(String search, int page, int size, String sortBy, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
		Pageable pageable = PageRequest.of(page, size, sort);
		return repo.searchStudents(search, pageable);
	}
}
