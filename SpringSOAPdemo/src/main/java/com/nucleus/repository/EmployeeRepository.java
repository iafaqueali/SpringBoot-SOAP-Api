package com.nucleus.repository;




import com.nucleus.models.soap.emp.Employee;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;


@Component
public class EmployeeRepository {

    private static final Map<Integer, Employee> emps = new HashMap<>();

    @PostConstruct
    public void init(){
        Employee emp1 = new Employee();
        emp1.setId(1);
        emp1.setFirstname("Afaque");
        emp1.setLastname("Beats");
        emp1.setEmail("Afaque@nucleus.com");
        emp1.setJobtitle("Founder");
        emps.put(emp1.getId(), emp1);


        Employee emp2 = new Employee();
        emp2.setId(2);
        emp2.setFirstname("Ali");
        emp2.setLastname("Beats");
        emp2.setEmail("Ali@nucleus.com");
        emp2.setJobtitle("Co-Founder");
        emps.put(emp2.getId(), emp2);
    }

    public Employee findEmployee(int id){
        return emps.get(id);
    }
}
