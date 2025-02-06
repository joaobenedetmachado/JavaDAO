package model.dao.impl;

import db.DbException;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SellerDAOJDBC implements SellerDAO {

    private Connection conn;

    public SellerDAOJDBC (Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Seller obj) {

    }

    @Override
    public void update(Seller obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Seller findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = conn.prepareStatement("SELECT seller.*, department.Name as DepName " +
                    " FROM seller INNER JOIN department " +
                    " ON seller.departmentId = department.Id " +
                    " WHERE seller.Id = ?");

            st.setInt(1, id);

            rs = st.executeQuery();

            if (rs.next()){
                Seller obj = new Seller();
                Department dep = new Department();

                dep.setID(rs.getInt("DepartmentId"));
                dep.setName(rs.getString("DepName"));

                obj.setID(rs.getInt("Id"));
                obj.setName(rs.getString("Name"));
                obj.setEmail(rs.getString("Email"));
                obj.setBirthDate(rs.getDate("BirthDate"));
                obj.setBaseSalary(rs.getDouble("BaseSalary"));
                obj.setDepartment(dep);

                return obj;
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }

    @Override
    public List<Seller> findAll() {
        return List.of();
    }
}
