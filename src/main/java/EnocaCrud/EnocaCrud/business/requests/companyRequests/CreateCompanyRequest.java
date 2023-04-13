package EnocaCrud.EnocaCrud.business.requests.companyRequests;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCompanyRequest {

	@NotNull
	private String name;
	@NotNull
	private String adress;
	@NotNull
	private String phoneNumber;
}