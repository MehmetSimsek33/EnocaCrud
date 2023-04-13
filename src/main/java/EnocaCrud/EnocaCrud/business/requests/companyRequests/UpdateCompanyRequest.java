package EnocaCrud.EnocaCrud.business.requests.companyRequests;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCompanyRequest {

    @NotNull
    @Min(1)
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String adress;
    @NotNull
    private String phoneNumber;
}