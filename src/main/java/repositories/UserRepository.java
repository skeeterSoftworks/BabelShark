package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByEmail(String email);
}
