//package sit.int204.classicmodels.execeptions;
//
//
//import org.apache.tomcat.websocket.AuthenticationException;
//import org.aspectj.apache.bcel.Repository;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//
//import java.io.FileNotFoundException;
//import java.time.DateTimeException;
//
////advice ของทุกตัว
//@RestControllerAdvice
//public class GlobalExceptionHandler {
////    @ExceptionHandler(FileNotFoundException.class)
////    @ResponseStatus(code = HttpStatus.NOT_FOUND)
////    public ResponseEntity<ErrorResponse> handleFileNotFound(FileNotFoundException ex, WebRequest request) {
////        ErrorResponse er = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(),
////                request.getDescription(false));
////        // getDescription : endpoint ที่ส่งมา
////        // Error validate ตาม ที่ check จาก Entity not null lenght
////        //Spring boot มีตัว validation ให้ ตัวช่วยแต่เราก็ต้องเขียนเอง
////        //add ทำไม ?
////        er.addValidationError("field 1","error 1");
////        er.addValidationError("field 2","error 2");
////        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
////    }
//
//
//
//
//
//   /* @ExceptionHandler(FileNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    // เกิด exception ชื่อ file not found จะตกลงที่นี่แน่ๆ
//    public ResourceNotFoundException handleFileNotFound(Exception e){
//        ResourceNotFoundException rnf = new ResourceNotFoundException(e.getMessage());
//        //สร้าง obj เก็บ response ที่เราจะส่งกลับ
//        //ได้ผลลัพธ์ที่จะส่งกลับ ยาวมาก
//        //service ไม่ได้ดักจะขึ้นไป controller เพื่อเชคว่าได้ ดัก exception มั้ย
//        return  rnf ;
//    }*/
//
////    @ExceptionHandler(java.lang.NumberFormatException.class)
////    @ResponseStatus(HttpStatus.BAD_REQUEST)
////    public RuntimeException handleNumberFormat(RuntimeException e){
////
////        return  e;
////    }
//
//    @ExceptionHandler(NullPointerException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<ErrorResponse> handleNullPointer (RuntimeException e,WebRequest request){
//        ErrorResponse er = new ErrorResponse(HttpStatus.NOT_FOUND.value(),e.getMessage(),request.getDescription(false)) ;
////    er.setTimestamp(new RuntimeException());
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
//    }
////ดักทุกอันที่ไม่ใช่อันที่เราดักตรงๆ
//    //ไม่ตรงกับอันไหนเลยมาเข้าอันนี้
//    @ExceptionHandler(RuntimeException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<ErrorResponse> handlerRuntimeException (RuntimeException e,WebRequest request){
//        ErrorResponse er = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),e.getMessage(),request.getDescription(false).substring(4)) ;
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
//    }
////จะเขียนบน controller class หรือ advice ก็ได้
//
//    @ExceptionHandler(AuthenticationException.class)
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    public ResponseEntity<ErrorResponse>  handlerAuthentication(RuntimeException e,WebRequest request){
//        ErrorResponse er = new ErrorResponse(HttpStatus.UNAUTHORIZED.value(),e.getMessage(),request.getDescription(false).substring(4));
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(er) ;
//    }
//}
