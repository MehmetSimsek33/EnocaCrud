package EnocaCrud.EnocaCrud.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_ıd")
	private int id;

	@Column(name = "first_name")

	private String firstName;

	@Column(name = "last_name")
	private String lastName;
 
	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "adress")
	private String adress;

	@ManyToOne
	@JoinColumn(name = "company_ıd")
	private Company company;

}