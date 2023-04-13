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

import EnocaCrud.EnocaCrud.business.abstracts.EmployeeService;
import EnocaCrud.EnocaCrud.business.requests.employeeRequests.CreateEmployeeRequest;
import EnocaCrud.EnocaCrud.business.requests.employeeRequests.UpdateEmployeeRequest;
import EnocaCrud.EnocaCrud.business.responses.employeeResponses.CreateEmployeeResponse;
import EnocaCrud.EnocaCrud.business.responses.employeeResponses.DeleteEmployeeResponse;
import EnocaCrud.EnocaCrud.business.responses.employeeResponses.GetAllEmployeeResponse;
import EnocaCrud.EnocaCrud.business.responses.employeeResponses.GetEmployeeResponse;
import EnocaCrud.EnocaCrud.business.responses.employeeResponses.UpdateEmployeeResponse;
import EnocaCrud.EnocaCrud.core.results.DataResult;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeControllers {
	private final EmployeeService employeeService;

	@PostMapping("/add")
	public DataResult<CreateEmployeeResponse> add(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
		return this.employeeService.add(createEmployeeRequest);
	}

	@GetMapping("/getById/{employeeId}")
	public DataResult<GetEmployeeResponse> getById(@PathVariable int employeeId) {
		return this.employeeService.getById(employeeId);
	}

	@GetMapping("/getAll")
	public DataResult<List<GetAllEmployeeResponse>> getAll() {
		return this.employeeService.getAll();
	}

	@DeleteMapping("/delete/{employeId}")
	public DataResult<DeleteEmployeeResponse> delete(@PathVariable int employeId) {
		return this.employeeService.delete(employeId);
	}

	@PutMapping("/update")
	public DataResult<UpdateEmployeeResponse> update(@RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
		return this.employeeService.update(updateEmployeeRequest);
	}
}