
package com.example.studentcourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.studentcourse.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
