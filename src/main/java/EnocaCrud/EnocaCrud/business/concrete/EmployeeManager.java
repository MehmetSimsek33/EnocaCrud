package EnocaCrud.EnocaCrud.business.concrete;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import EnocaCrud.EnocaCrud.business.abstracts.EmployeeService;
import EnocaCrud.EnocaCrud.business.requests.employeeRequests.CreateEmployeeRequest;
import EnocaCrud.EnocaCrud.business.requests.employeeRequests.UpdateEmployeeRequest;
import EnocaCrud.EnocaCrud.business.responses.employeeResponses.CreateEmployeeResponse;
import EnocaCrud.EnocaCrud.business.responses.employeeResponses.DeleteEmployeeResponse;
import EnocaCrud.EnocaCrud.business.responses.employeeResponses.GetAllEmployeeResponse;
import EnocaCrud.EnocaCrud.business.responses.employeeResponses.GetEmployeeResponse;
import EnocaCrud.EnocaCrud.business.responses.employeeResponses.UpdateEmployeeResponse;
import EnocaCrud.EnocaCrud.core.excaptions.BusinessExcaption;
import EnocaCrud.EnocaCrud.core.mapping.ModelMapperService;
import EnocaCrud.EnocaCrud.core.results.DataResult;
import EnocaCrud.EnocaCrud.core.results.SuccessDataResult;
import EnocaCrud.EnocaCrud.dataAccess.EmployeeRepository;
import EnocaCrud.EnocaCrud.entities.Employee;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {
	private final EmployeeRepository employeeRepository;
	private final ModelMapperService modelMapperService;

	@Override
	public DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest) {
		Employee employee = this.modelMapperService.forRequest().map(createEmployeeRequest, Employee.class);
		this.employeeRepository.save(employee);
		CreateEmployeeResponse createEmployeeResponse = this.modelMapperService.forResponse().map(employee,
				CreateEmployeeResponse.class);
		return new SuccessDataResult<>(createEmployeeResponse, "Employee Added");
	}

	@Override
	public DataResult<List<GetAllEmployeeResponse>> getAll() {

		List<Employee> employees = this.employeeRepository.findAll();
		List<GetAllEmployeeResponse> getAllEmployeeResponses = employees.stream()
				.map(employee -> this.modelMapperService.forResponse().map(employee, GetAllEmployeeResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<>(getAllEmployeeResponses,
				"Employee Listed");
	}

	@Override
	public DataResult<GetEmployeeResponse> getById(int employeeId) {
		checkIfExistsById(employeeId);
		Employee employee = this.employeeRepository.findById(employeeId);
		GetEmployeeResponse getAllEmployeeResponse = this.modelMapperService.forResponse().map(employee,
				GetEmployeeResponse.class);
		return new SuccessDataResult<>(getAllEmployeeResponse, "Employee Get");
	}

	@Override
	public DataResult<DeleteEmployeeResponse> delete(int employeId) {
		checkIfExistsById(employeId);
		Employee employee = this.employeeRepository.findById(employeId);
		DeleteEmployeeResponse deleteEmployeeResponse = this.modelMapperService.forResponse().map(employee,
				DeleteEmployeeResponse.class);
		this.employeeRepository.delete(employee);
		return new SuccessDataResult<>(deleteEmployeeResponse,
				"Employee Deleted");
	}

	@Override
	public DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest) {
		checkIfExistsById(updateEmployeeRequest.getId());
		Employee employee = this.modelMapperService.forRequest().map(updateEmployeeRequest, Employee.class);
		this.employeeRepository.save(employee);
		UpdateEmployeeResponse updateEmployeeResponse = this.modelMapperService.forResponse().map(employee,
				UpdateEmployeeResponse.class);
		return new SuccessDataResult<>(updateEmployeeResponse, "Employe Updated");

	}

	private void checkIfExistsById(int employeeId) {
		if (!this.employeeRepository.existsById(employeeId)) {
			throw new BusinessExcaption("Employe Id Not Found");
		}
	}
}