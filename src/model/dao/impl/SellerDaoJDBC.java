package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import db.DB;
import db.DbException;
import model.Entities.Department;
import model.Entities.Seller;
import model.dao.SellerDao;

public class SellerDaoJDBC implements SellerDao{

	private Connection conn;
	
	public SellerDaoJDBC(Connection conn){
		this.conn = conn;
	}
	
	@Override
	public void insert(Seller obj) {
		
		
	}

	@Override
	public void update(Seller obj) {
	
	}

	@Override
	public void deletebyid(Integer id) {		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("SELECT seller .*, department.name as DepName"
					+" from seller INNER JOIN department"
					+" on seller.DepartmentID = department.Id"
					+ " WHERE seller.id = ?");			
			st.setInt(1, id);
			
			rs = st.executeQuery();
			if (rs.next()) {
				Department dep = new Department(); 
				dep.setId(rs.getInt("DepartmentId"));
				dep.setName(rs.getString("DepName"));
				Seller obj = new Seller();
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("Name"));
				obj.setEmail(rs.getString("Email"));
				obj.setBaseSalary(rs.getDouble("BaseSalary"));
				obj.setBirthDate(rs.getDate("BirthDate"));
				obj.setDepartment(dep);				
				return obj;
				}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());		
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Seller> findAll() {	
		return null;
	}

}