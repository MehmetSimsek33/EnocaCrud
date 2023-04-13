package EnocaCrud.EnocaCrud.business.concrete;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import EnocaCrud.EnocaCrud.business.abstracts.CompanyService;
import EnocaCrud.EnocaCrud.business.requests.companyRequests.CreateCompanyRequest;
import EnocaCrud.EnocaCrud.business.requests.companyRequests.UpdateCompanyRequest;
import EnocaCrud.EnocaCrud.business.responses.companyResponses.CreateCompanyResponse;
import EnocaCrud.EnocaCrud.business.responses.companyResponses.DeleteCompanyResponse;
import EnocaCrud.EnocaCrud.business.responses.companyResponses.GetAllCompanyResponse;
import EnocaCrud.EnocaCrud.business.responses.companyResponses.GetCompanyResponse;
import EnocaCrud.EnocaCrud.business.responses.companyResponses.UpdateCompanyResponse;
import EnocaCrud.EnocaCrud.core.excaptions.BusinessExcaption;
import EnocaCrud.EnocaCrud.core.mapping.ModelMapperService;
import EnocaCrud.EnocaCrud.core.results.DataResult;
import EnocaCrud.EnocaCrud.core.results.SuccessDataResult;
import EnocaCrud.EnocaCrud.dataAccess.CompanyRepository;
import EnocaCrud.EnocaCrud.entities.Company;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyManager implements CompanyService {
	
	private final CompanyRepository companyRepository;
	private final ModelMapperService modelMapperService;

	@Override
	public DataResult<CreateCompanyResponse> add(CreateCompanyRequest createCompanyRequest) {
		Company company = this.modelMapperService.forRequest().map(createCompanyRequest, Company.class);
		this.companyRepository.save(company);
		CreateCompanyResponse createCompanyResponse = this.modelMapperService.forResponse().map(company,
				CreateCompanyResponse.class);

		return new SuccessDataResult<>(createCompanyResponse, "Company Added");
	}

	@Override
	public DataResult<List<GetAllCompanyResponse>> getAll() {

		List<Company> companies = this.companyRepository.findAll();
		List<GetAllCompanyResponse> getAllCompanyResponses = companies.stream()
				.map(company -> this.modelMapperService.forResponse().map(company, GetAllCompanyResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<>(getAllCompanyResponses, "Company Listed");
	}

	@Override
	public DataResult<GetCompanyResponse> getById(int companyId) {
		checkIfExistsById(companyId);
		Company company = this.companyRepository.findById(companyId);
		GetCompanyResponse getCompanyResponse = this.modelMapperService.forResponse().map(company,
				GetCompanyResponse.class);
		return new SuccessDataResult<>(getCompanyResponse, "Company Listed");
	}

	@Override
	public DataResult<DeleteCompanyResponse> delete(int companyId) {
		checkIfExistsById(companyId);
		Company company = this.companyRepository.findById(companyId);
		DeleteCompanyResponse deleteCompanyResponse = this.modelMapperService.forResponse().map(company,
				DeleteCompanyResponse.class);
		this.companyRepository.delete(company);
		return new SuccessDataResult<>(deleteCompanyResponse, "Company Deleted");

	}

	@Override
	public DataResult<UpdateCompanyResponse> update(UpdateCompanyRequest updateCompanyRequest) {
		checkIfExistsById(updateCompanyRequest.getId());
		Company company = this.modelMapperService.forRequest().map(updateCompanyRequest, Company.class);
		UpdateCompanyResponse updateCompanyResponse = this.modelMapperService.forResponse().map(company,
				UpdateCompanyResponse.class);
		this.companyRepository.save(company);
		return new SuccessDataResult<>(updateCompanyResponse, "Company updated");
	}

	private void checkIfExistsById(int companyId) {
		if (!this.companyRepository.existsById(companyId)) {
			throw new BusinessExcaption("Company Id Not Found");
		}
	}
}