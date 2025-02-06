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
            st = conn.prepareStatement("SELECT seller.*, department.Name as DepName " + // do the SQL query
                    " FROM seller INNER JOIN department " +
                    " ON seller.departmentId = department.Id " +
                    " WHERE seller.Id = ?");

            st.setInt(1, id); // put the id

            rs = st.executeQuery(); // grab the result

            if (rs.next()){ // if has result:
                Department dep = instantiateDepartment(rs); //instantiate a new Departament with the result as atribute
                return instantiateSeller(rs, dep); // the same thing as a new dep, but use the new dep and the result as a atribute for return the found seller
            }
            return null;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }

    }

    private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
        Seller obj = new Seller();

        obj.setID(rs.getInt("Id"));
        obj.setName(rs.getString("Name"));
        obj.setEmail(rs.getString("Email"));
        obj.setBirthDate(rs.getDate("BirthDate"));
        obj.setBaseSalary(rs.getDouble("BaseSalary"));
        obj.setDepartment(dep);

        return obj;
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();

        dep.setID(rs.getInt("DepartmentId"));
        dep.setName(rs.getString("DepName"));

        return dep;
    }

    @Override
    public List<Seller> findAll() {
        return List.of();
    }


}
