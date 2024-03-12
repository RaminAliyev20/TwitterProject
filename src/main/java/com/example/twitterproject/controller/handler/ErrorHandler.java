//package com.example.twitterproject.controller.handler;
//
//import com.example.twitterproject.model.exception.NotFoundException;
//import jakarta.validation.ConstraintViolationException;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.data.crossstore.ChangeSetPersister;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import com.example.twitterproject.model.exception.ExceptionDTO;
//
//import java.util.ArrayList;
//
//@RestControllerAdvice
//@Slf4j
//public class ErrorHandler {
//    @ExceptionHandler(NotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    ExceptionDTO handle(NotFoundException e) {
//        log.error("ActionLog.handle.error NotFoundException handled");
//        return new ExceptionDTO(e.getMessage());
//    }
//
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    ExceptionDTO handle(Exception exception) {
//        log.error("ActionLog.handle.error Exception handled");
//        return new ExceptionDTO("UNEXPECTED_ERROR");
//    }
//}
