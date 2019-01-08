package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import models.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	public Role findByRoleName(String roleName);

}
