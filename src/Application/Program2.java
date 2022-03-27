package Application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.Entities.Department;
import model.Entities.Seller;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("------------Find by id---------------------");
		
		Department dep = departmentDao.findById(7);
		System.out.println(dep);		

		System.out.println("\n------------Find All-------------------");
		List<Department> list = departmentDao.findAll();
		for(Department d: list) {
			System.out.println(d);
		}

		System.out.println("\n------------Insert-------------------");
		
		Department newDepartment = new Department(null, "Vendas");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted, new id = " + newDepartment.getId());

		System.out.println("\n------------Update------------------");
		
		dep = departmentDao.findById(6);
		dep.setName("departamento teste");
		departmentDao.update(dep);		
		System.out.println("Update Complete");

		System.out.println("\n------------Delete------------------");
		System.out.print("Enter id to delete:");
		int id = sc.nextInt();
		departmentDao.deletebyid(id);
		System.out.println("Delete Complete");

		sc.close();
	}

}
