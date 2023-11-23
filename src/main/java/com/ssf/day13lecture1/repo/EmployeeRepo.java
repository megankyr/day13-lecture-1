package com.ssf.day13lecture1.repo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ssf.day13lecture1.model.Employee;


public class EmployeeRepo {
    final String dirPath = "c://data";
    final String fileName = "employee.txt";
    private List<Employee> employees;
    public EmployeeRepo() throws ParseException {
        if (employees == null){
            employees = new ArrayList<Employee>();
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date dt = df.parse("1995-10-13");
        Employee emp = new Employee("Jimin", "Park", "jiminpark@gmail.com", "81234567", 10000, dt, 212345);
        employees.add(emp);
        Employee emp1 = new Employee("Jungkook", "Jeon", "jungkookjeon@gmail.com", "81234568", 9000, dt, 212346);
        employees.add(emp1);
    }

    public List<Employee> findAll(){
        return employees;
    }

    public Boolean delete(Employee employee){
        Boolean result = false;
        int employeeIndex = employees.indexOf(employee);

        if (employeeIndex >= 0){
            employees.remove(employeeIndex);
            result = true;
        }
        return result;
    }
    public Employee findByEmail(String email){
        return employees.stream().filter(emp -> emp.getEmail().equals(email)).findFirst().get();
    }

    public Boolean updateEmployee(Employee employee){
        Boolean result = false;
        Employee empObj = employees.stream().filter(emp -> emp.getEmail().equals(employee.getEmail())).findFirst().get();
        int employeeIndex = employees.indexOf(empObj);

        if (employeeIndex >= 0){
            employees.get(employeeIndex).setBirthDay(employee.getBirthDay());
            employees.get(employeeIndex).setEmail(employee.getEmail());
            employees.get(employeeIndex).setFirstName(employee.getFirstName());
            employees.get(employeeIndex).setLastName(employee.getLastName());
            employees.get(employeeIndex).setPhoneNo(employee.getPhoneNo());
            employees.get(employeeIndex).setPostalCode(employee.getPostalCode());
            employees.get(employeeIndex).setSalary(employee.getSalary());
            result = true;
        }
        return result;
    }
}
