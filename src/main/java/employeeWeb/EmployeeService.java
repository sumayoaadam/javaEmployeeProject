package employeeWeb;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {
    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {

        this.repo = repo;
    }

    //save wexe qawane lawo shaqo ah hdii xog cusub laso galiyo inee save gareso
    // marna xogta hore ujirty wax laga badalo ine save gareeso
    public void insertEmployee(Employee employee){
        repo.save(employee);
    }
    public void updateEmployee(Employee employee){
        repo.save(employee);
    }
    //delet data using by id
    public void deleteEmployee(Long id){
        repo.deleteById(id);
    }
    // retreive one data or one coloum  using by id
    public Employee getEmployeeById(Long id){
        return repo.findById(id).orElse(null);
    }
    //retrive all data
    public List<Employee> getAllEmployee(Long keyword){
        if(keyword != null)
            return repo.search(keyword);
        return repo.findAll();
    }
}
