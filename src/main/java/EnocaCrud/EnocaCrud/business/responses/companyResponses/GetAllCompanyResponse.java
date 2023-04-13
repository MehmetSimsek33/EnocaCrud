package EnocaCrud.EnocaCrud.business.responses.companyResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCompanyResponse {
    private int id;
    private String name;
    private String adress;
    private String phoneNumber;
}