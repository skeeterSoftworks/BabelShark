package models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@Table (name = "users")
public class User {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	@Column(name="username")
	@NotEmpty
	@Size(max=15)
	private String username;
	
	@Column(name="password")
	@Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
	private String password;
	
	@Column(name="email")
	@NotEmpty
	@Email
	private String email;
	
	@Column(name = "active")
	private int active;
	  
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_role", joinColumns=@JoinColumn(name="user_id"),
	inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Role> roles;
	
	
	public User(){}


	public User(int id, @NotEmpty @Size(max = 15) String username, @NotEmpty @Size(min = 8, max = 15) String password,
			@NotEmpty @Email String email, int active, Set<Role> roles) {
		super();
		Id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.active = active;
		this.roles = roles;
	}


	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}


	public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	

}
