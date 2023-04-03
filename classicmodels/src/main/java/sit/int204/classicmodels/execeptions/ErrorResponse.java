//package sit.int204.classicmodels.execeptions;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//import lombok.Setter;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.context.request.WebRequest;
//
//import java.io.FileNotFoundException;
//import java.security.Timestamp;
//import java.time.DateTimeException;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Objects;
//
//@Getter
//@Setter
//@RequiredArgsConstructor
//@JsonInclude(JsonInclude.Include.NON_NULL)
//public class ErrorResponse {
//    private  DateTimeException timestamp  ;
//    private final int status;
//    private final String message;
//    private final String instance;
//    private String stackTrace;
//    private List<ValidationError> errors;
//    @Getter
//    @Setter
//    @RequiredArgsConstructor
//    private static class ValidationError {
//        private final String field;
//        private final String message;
//    }
//    public void addValidationError(String field, String message){
//        if(Objects.isNull(errors)){
//            errors = new ArrayList<>();
//        }
//        errors.add(new ValidationError(field, message));
//    }
//
//
//}
