package EnocaCrud.EnocaCrud.business.abstracts;

import java.util.List;

import EnocaCrud.EnocaCrud.business.requests.companyRequests.CreateCompanyRequest;
import EnocaCrud.EnocaCrud.business.requests.companyRequests.UpdateCompanyRequest;
import EnocaCrud.EnocaCrud.business.responses.companyResponses.CreateCompanyResponse;
import EnocaCrud.EnocaCrud.business.responses.companyResponses.DeleteCompanyResponse;
import EnocaCrud.EnocaCrud.business.responses.companyResponses.GetAllCompanyResponse;
import EnocaCrud.EnocaCrud.business.responses.companyResponses.GetCompanyResponse;
import EnocaCrud.EnocaCrud.business.responses.companyResponses.UpdateCompanyResponse;
import EnocaCrud.EnocaCrud.core.results.DataResult;

public interface CompanyService {

	DataResult<CreateCompanyResponse> add(CreateCompanyRequest createCompanyRequest);

	DataResult<List<GetAllCompanyResponse>> getAll();

	DataResult<GetCompanyResponse> getById(int companyId);

	DataResult<DeleteCompanyResponse> delete(int companyId);

	DataResult<UpdateCompanyResponse> update(UpdateCompanyRequest updateCompanyRequest);
}