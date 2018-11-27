package com.tw.apistackbase.controller;

import java.util.List;

import com.tw.apistackbase.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {


    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(produces = {"application/json"})
    public ResponseEntity<List<Employee>> getEmployee() {
        List<Employee> employees = employeeService.getAll();
        return ResponseEntity.ok(employees);
    }

    @PostMapping(produces = "application/json")
    public int addEmployee(@RequestBody Employee employee){
        int id = employeeService.add(employee);
        return id;
    }

    @RequestMapping(value = "/:id", method = RequestMethod.PUT)
    public @ResponseBody String updateEmployee(@RequestBody Employee employee){
        employeeService.getAll().filter()
        return "ok";
    }
}