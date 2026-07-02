package com.example.Institute_Pagination.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="institute")
public class Institute_Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;
private String surname;
private String gender;
private String email;
}
