//package pl.gren.advevethesis.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//public class Role {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
//
//	@Enumerated(EnumType.STRING)
//	private EnumRole name;
//
//	public Role(EnumRole name) {
//		this.name = name;
//	}
//
//	@JsonIgnore
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
//	private Set<User> users;
//
//	public Role() {
//
//	}
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public EnumRole getName() {
//		return name;
//	}
//
//	public void setName(EnumRole name) {
//		this.name = name;
//	}
//
//	public Set<User> getUsers() {
//		return users;
//	}
//	public void setUsers(Set<User> users) {
//		this.users = users;
//	}
//}