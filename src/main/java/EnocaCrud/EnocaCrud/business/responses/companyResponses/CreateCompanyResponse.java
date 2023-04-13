package EnocaCrud.EnocaCrud.business.responses.companyResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCompanyResponse {

	private String name;
	private String adress;
	private String phoneNumber;
}