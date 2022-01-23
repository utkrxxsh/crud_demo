package crud_demo.crud_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crud_demo.crud_demo.entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Integer>{
    
}
