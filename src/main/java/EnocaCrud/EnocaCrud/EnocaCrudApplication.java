package EnocaCrud.EnocaCrud;

import java.util.HashMap;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import EnocaCrud.EnocaCrud.core.excaptions.BusinessExcaption;
import EnocaCrud.EnocaCrud.core.results.ErrorDataResult;


@SpringBootApplication
@RestControllerAdvice
public class EnocaCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnocaCrudApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationExceptions(
			MethodArgumentNotValidException methodArgumentNotValidException) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errorDataResult = new ErrorDataResult<Object>(validationErrors, "VALIDATION EXCAPTION");

		return errorDataResult;
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleBussinesExcaption(BusinessExcaption businessExcaption) {
		ErrorDataResult<Object> erroDataResult = new ErrorDataResult<Object>(businessExcaption.getMessage(),
				"BUSSINESS EXCEPTION");
		return erroDataResult;
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ErrorDataResult<Object> handleGeneralhException(InvalidFormatException ex) {
		ErrorDataResult<Object> erroDataResult = new ErrorDataResult<Object>(ex.getMessage(), "TYPE EXCEPTION");
		return erroDataResult;

	}

	@ExceptionHandler(Exception.class)
	public ErrorDataResult<Object> handleGeneralhException(Exception ex) {
		ErrorDataResult<Object> erroDataResult = new ErrorDataResult<Object>(ex.getMessage(), "EXCEPTION");
		return erroDataResult;

	}

}
