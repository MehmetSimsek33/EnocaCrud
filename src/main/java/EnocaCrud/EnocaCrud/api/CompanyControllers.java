package EnocaCrud.EnocaCrud.api;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EnocaCrud.EnocaCrud.business.abstracts.CompanyService;
import EnocaCrud.EnocaCrud.business.requests.companyRequests.CreateCompanyRequest;
import EnocaCrud.EnocaCrud.business.requests.companyRequests.UpdateCompanyRequest;
import EnocaCrud.EnocaCrud.business.responses.companyResponses.CreateCompanyResponse;
import EnocaCrud.EnocaCrud.business.responses.companyResponses.DeleteCompanyResponse;
import EnocaCrud.EnocaCrud.business.responses.companyResponses.GetAllCompanyResponse;
import EnocaCrud.EnocaCrud.business.responses.companyResponses.GetCompanyResponse;
import EnocaCrud.EnocaCrud.business.responses.companyResponses.UpdateCompanyResponse;
import EnocaCrud.EnocaCrud.core.results.DataResult;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/company")
@AllArgsConstructor
public class CompanyControllers {
    private final CompanyService companyService;

    @PostMapping("/add")
    public DataResult<CreateCompanyResponse> add(@RequestBody CreateCompanyRequest createCompanyRequest) {
        return this.companyService.add(createCompanyRequest);
    }

    @GetMapping("/getAll")
    public DataResult<List<GetAllCompanyResponse>> getAll() {
        return this.companyService.getAll();
    }

    @GetMapping("/getById/{companyId}")
    public DataResult<GetCompanyResponse> getById(@PathVariable int companyId) {
        return this.companyService.getById(companyId);
    }

    @DeleteMapping("/delete/{companyId}")
    public DataResult<DeleteCompanyResponse> delete(@PathVariable int companyId) {
        return this.companyService.delete(companyId);
    }

    @PutMapping("/update")
    public DataResult<UpdateCompanyResponse> update(@RequestBody UpdateCompanyRequest updateCompanyRequest) {
        return this.companyService.update(updateCompanyRequest);
    }


}