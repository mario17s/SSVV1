package org.example.repository;


import org.example.domain.Student;
import org.example.validation.Validator;

public class StudentRepository extends AbstractCRUDRepository<String, Student> {
    public StudentRepository(Validator<Student> validator) {
        super(validator);
    }
}

