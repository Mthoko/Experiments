package exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

  @ExceptionHandler(value = {ApiRequestException.class})
  public ResponseEntity<Object> handleApiRequestException(ApiRequestException apiRequestException){

    HttpStatus badRequest = HttpStatus.BAD_REQUEST;
    new ApiException(apiRequestException.getMessage(),
        badRequest, ZonedDateTime.now(ZoneId.of("Z")));

    return new ResponseEntity<>(apiRequestException, badRequest);
  }

}
