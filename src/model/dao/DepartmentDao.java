package model.dao;

import java.util.List;

import model.Entities.Department;

public interface DepartmentDao {
	
 void insert(Department obj);
 void update(Department obj);
 void deletebyid(Integer id);
 Department findById(Integer id); 
 List <Department> findAll(); 
 
}
