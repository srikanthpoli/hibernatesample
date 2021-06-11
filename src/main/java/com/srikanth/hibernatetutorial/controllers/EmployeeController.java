package com.srikanth.hibernatetutorial.controllers;

import com.srikanth.hibernatetutorial.controllers.dto.EmployeeErrorResponse;
import com.srikanth.hibernatetutorial.controllers.dto.EmployeeNotFoundException;
import com.srikanth.hibernatetutorial.entities.onetoone.EmployeeEntity;
import com.srikanth.hibernatetutorial.services.EmployeeService;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/employee")
@Transactional
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    
    @RequestMapping(value = "/Test", method = RequestMethod.GET)
    public String test() {

        return "Test";


    }

    @RequestMapping(value = "/getEmployeeByID/{id}", method = RequestMethod.GET)
    public EmployeeEntity getEmployeeByID(@PathVariable int id) {

        EmployeeEntity employeeEntities = null;

            employeeEntities = employeeService.getEmployeeByID(id);
           if(1==1) {
               throw new EmployeeNotFoundException("EMployee not found with ID " + id);
           }

        return employeeEntities;


    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException excep){
        EmployeeErrorResponse employeeErrorResponse= new EmployeeErrorResponse(excep.getMessage(),new Timestamp(System.currentTimeMillis()),404);

        return new ResponseEntity(employeeErrorResponse, HttpStatus.NOT_FOUND);
    }


    @RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity employeeEntity) throws ParseException {

        return employeeService.createEmployee(employeeEntity);

    }

    @RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.DELETE)
    public EmployeeEntity deleteEmployeebyID(@PathVariable int id) {

        return employeeService.deleteEmployeeByID(id);

    }

    @RequestMapping(value = "/getEmployeeByCompany/{company}", method = RequestMethod.POST)
    public List<EmployeeEntity> getEmployeesByCompany(@PathVariable String company) {

        return employeeService.getEmployeesByCompany(company);


    }
}
