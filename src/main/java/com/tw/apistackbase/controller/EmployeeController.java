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

    @PutMapping("/{id}")
    public @ResponseBody String updateEmployee(@PathVariable int id, @RequestBody Employee employeeUpdate){
        if(employeeService.findById(id) != null){
            Employee update = employeeService.findById(id);
            update.setAge(employeeUpdate.getAge());
            update.setGender(employeeUpdate.getGender());
            update.setName(employeeUpdate.getName());
            return "update success";
        }else{
            return "update failed";
        }
    }
}