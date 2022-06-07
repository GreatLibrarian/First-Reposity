package com.example.securityexercise.models;

import java.util.Collection;

import javax.persistence.*;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(uniqueConstraints=@UniqueConstraint(columnNames="email"))
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
	@NonNull
	private String email;
	@NonNull
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name="users_roles",
			joinColumns=@JoinColumn(
					name="user_id",referencedColumnName="id"
					),
			inverseJoinColumns=@JoinColumn(
					name="role_id",referencedColumnName="id"
					)
			)
	private Collection<Role> roles;
	
	public User(String firstName, String lastName, String email, String password, Collection<Role> roles) {
	       this.firstName = firstName;
	       this.lastName = lastName;
	       this.email = email;
	       this.password = password;
	       this.roles = roles;
	   }
}
