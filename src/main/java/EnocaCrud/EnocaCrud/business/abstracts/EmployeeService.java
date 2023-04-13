package EnocaCrud.EnocaCrud.business.abstracts;

import java.util.List;

import EnocaCrud.EnocaCrud.business.requests.employeeRequests.CreateEmployeeRequest;
import EnocaCrud.EnocaCrud.business.requests.employeeRequests.UpdateEmployeeRequest;
import EnocaCrud.EnocaCrud.business.responses.employeeResponses.CreateEmployeeResponse;
import EnocaCrud.EnocaCrud.business.responses.employeeResponses.DeleteEmployeeResponse;
import EnocaCrud.EnocaCrud.business.responses.employeeResponses.GetAllEmployeeResponse;
import EnocaCrud.EnocaCrud.business.responses.employeeResponses.GetEmployeeResponse;
import EnocaCrud.EnocaCrud.business.responses.employeeResponses.UpdateEmployeeResponse;
import EnocaCrud.EnocaCrud.core.results.DataResult;

public interface EmployeeService {

	DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest);

	DataResult<List<GetAllEmployeeResponse>> getAll();

	DataResult<GetEmployeeResponse> getById(int employeeId);

	DataResult<DeleteEmployeeResponse> delete(int employeId);

	DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest);
}