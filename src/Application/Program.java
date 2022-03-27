package Application;


import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.Entities.Department;
import model.Entities.Seller;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("------------Find by id---------------------");

		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n------------Find by department-------------------");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);

		for (Seller s : list) {
			System.out.println(s);
		}

		System.out.println("\n------------Find All-------------------");

		list = sellerDao.findAll();

		for (Seller s : list) {
			System.out.println(s);
		}

		System.out.println("\n------------Insert-------------------");

		Seller newSeller = new Seller(null, "Greg", "Greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted, new id = " + newSeller.getId());

		System.out.println("\n------------Update------------------");
		
		seller = sellerDao.findById(1);
		seller.setName("Martha Wayne");
		sellerDao.update(seller);
		System.out.println("Update Complete");
		
		System.out.println("\n------------Delete------------------");
		System.out.print("Enter id to delete:");
		int id = sc.nextInt();
		sellerDao.deletebyid(id);
		System.out.println("Delete Complete");
		sc.close();
	}

}
