package repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import models.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	public Student findByName(String name);
	
}