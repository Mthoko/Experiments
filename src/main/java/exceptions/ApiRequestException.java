package exceptions;

public class ApiRequestException extends Exception {

  public ApiRequestException(String message) {
    super(message);
  }
}