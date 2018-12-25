package repositories;


import org.springframework.data.repository.CrudRepository;
import models.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

	public Student findByName(String name);

}