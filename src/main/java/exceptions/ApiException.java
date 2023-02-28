package exceptions;

import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Data
public class ApiException {
  private final String message;
  private final HttpStatus httpStatus;
  private final ZonedDateTime zonedDateTime;
}
