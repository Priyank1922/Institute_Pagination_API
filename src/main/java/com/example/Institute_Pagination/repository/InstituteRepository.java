package com.example.Institute_Pagination.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Institute_Pagination.entity.Institute_Student;

@Repository
public interface InstituteRepository extends JpaRepository<Institute_Student, Long> {

	Page<Institute_Student> findByNameContainingIgnoreCase(String name, Pageable pageable);

	@Query("SELECT s FROM Institute_Student s WHERE " +
		   "LOWER(s.name) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
		   "LOWER(s.surname) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
		   "LOWER(s.email) LIKE LOWER(CONCAT('%', :search, '%'))")
	Page<Institute_Student> searchStudents(@Param("search") String search, Pageable pageable);
}

