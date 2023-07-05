package digital.inforce.userprofile.exception.handler;

import java.util.List;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import digital.inforce.userprofile.dto.RegistrationRequestDTO;
import digital.inforce.userprofile.exception.EntityNotExistsException;
import digital.inforce.userprofile.exception.InvalidEmailException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(EntityNotExistsException.class)
    protected ResponseEntity<Object> handleEntityNotExists(
        EntityNotExistsException ex) {
        ApiError apiError = new ApiError(NOT_FOUND);
        apiError.setMessage(ex.getMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(InvalidEmailException.class)
    protected ResponseEntity<Object> handleInvalidEmail(
        InvalidEmailException ex) {

        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
        apiError.setDebugMessage(ex.toString());

        RegistrationRequestDTO request = ex.getRequest();
        ApiValidationError apiValidationError = new ApiValidationError(List.of(request), ex.getMessage());
        apiValidationError.setField("email");
        apiValidationError.setRejectedValue(request.getEmail());

        return buildResponseEntity(apiError);
    }

}
