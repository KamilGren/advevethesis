package pl.gren.advevethesis.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PROJECT")
public class Project {
	@Id
	@GeneratedValue
	private long id;

	@Column(name = "NAME")
	private String name;

	@ManyToMany
//	@JoinTable(
//			name = "pracownicy_w_projektach",
//			joinColumns = {@JoinColumn(name = "id_projektu")},
//			inverseJoinColumns = {@JoinColumn(name = "id_pracownika")}
//			)
	private List<Employee> employees;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
