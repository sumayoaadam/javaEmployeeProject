package employeeWeb;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {

        this.service = service;
    }
//mapping home
    @GetMapping ("/")
    public String getHomePage() {

        return"home";
    }
    //mapping register page
    @GetMapping("/Register")
    public String getRegister(){
        return "Register"; //view name
    }

    // inserting data and saving
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee emp){
        service.insertEmployee(emp);
        return "redirect:/All";
    }
    // retreive all data
    @GetMapping("/All")
    public String getAll(Model model, @Param("keyword") Long keyword){
        List<Employee> list = service.getAllEmployee(keyword);
        model.addAttribute("employees" , list);
        model.addAttribute("keyword" , keyword);
        return "viewAll";
    }
    //delete coloum
    @RequestMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        service.deleteEmployee(id);
        return "redirect:/All";
    }
    //update or edit data
    @RequestMapping("/Edit/{id}")
    public String UpdateEmployee(@PathVariable Long id, Model model){
        Employee emp = service.getEmployeeById(id);
        model.addAttribute("employee" , emp);
        return "EditEmployee";  //view name
    }



}