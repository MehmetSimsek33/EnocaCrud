package EnocaCrud.EnocaCrud.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "companies")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_ıd")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "adress")
	private String adress;

	@Column(name = "phone_number")
	private String phoneNumber;

	@OneToMany(mappedBy = "company")
	private List<Employee> employees;

}