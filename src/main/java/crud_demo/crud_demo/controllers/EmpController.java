package crud_demo.crud_demo.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import crud_demo.crud_demo.entity.Employee;
import crud_demo.crud_demo.service.EmpService;

@Controller
public class EmpController {

    @Autowired
    private EmpService service;
    
    @GetMapping("/")
    public String home(Model m){
        List<Employee> emp=service.getAllEmployee();
        m.addAttribute("emp",emp);
        return "index";
    }

    @GetMapping("/addemp")
    public String addEmp(){
        return "add_emp";
    }

    @PostMapping("/register")
    public String empRegister(@ModelAttribute Employee emp,HttpSession session){
        System.out.println(emp);
        service.addEmp(emp);
        session.setAttribute("msg", "Employee Added successfully");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id,Model m){
        Employee e=service.getEmpById(id);
        m.addAttribute("emp",e);
        return "edit";
    }

    @PostMapping("/update")
    public String updateEmp(@ModelAttribute Employee e,HttpSession session){
        service.addEmp(e);
        session.setAttribute("msg", "Employee data updated successfully");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable int id,HttpSession session){
        service.deleteEmp(id);
        session.setAttribute("msg", "Employee data deleted successfully");
        return "redirect:/";
    }

}
