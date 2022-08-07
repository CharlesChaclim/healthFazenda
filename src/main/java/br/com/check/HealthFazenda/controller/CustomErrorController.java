package br.com.check.HealthFazenda.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.el.MethodNotFoundException;

@RestController
public class CustomErrorController implements ErrorController {

    @RequestMapping(value = "/error")
    public String error() {
        throw new MethodNotFoundException();
    }

}