package crud_demo.crud_demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud_demo.crud_demo.entity.Employee;
import crud_demo.crud_demo.repository.EmpRepo;

@Service
public class EmpService {
    
    @Autowired
    private EmpRepo repo;

    public void addEmp(Employee emp){
        repo.save(emp);
    }

    public List<Employee> getAllEmployee(){
        return repo.findAll();
    }

    public Employee getEmpById(int id){
        Optional<Employee> e=repo.findById(id);
        if(e.isPresent()){
            return e.get();
        }
        return null;
    }

    public void deleteEmp(int id){
        repo.deleteById(id);
    }

}
