package EnocaCrud.EnocaCrud.business.requests.employeeRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequest {

	@NotNull
	@Min(1)
	private int id;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private String phoneNumber;
	@NotNull
	private String adress;
	@NotNull
	@Min(1)
	private int companyId;

}