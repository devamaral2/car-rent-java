package com.fiap.amaralrentcar.controller.exception;

import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.stream.Collectors;

@AllArgsConstructor
public class ValidationTrigger {
    BindingResult bindingResult;

    public void verify() {
        if (bindingResult.hasErrors()) {
            var message = bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining());
            throw new BadRequestException(message);
        }
    }
}
