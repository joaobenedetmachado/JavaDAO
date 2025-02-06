package model.dao.impl;

import model.dao.DepartamentDAO;
import model.entities.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DepartmentDAOJDBC implements DepartamentDAO {

    private Connection conn;

        public DepartmentDAOJDBC(Connection conn) {
            this.conn = conn;
        }

    @Override
    public void insert(Department obj) {

    }

    @Override
    public void update(Department obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement("SELECT * from department " +
                    " WHERE Id = ?");
            ps.setInt(1, id);

            rs = ps.executeQuery();

            while (rs.next()) {
                Department dep = instantiateDepartment(rs);
                return dep;

            } return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setID(rs.getInt("Id"));
        dep.setName(rs.getString("Name"));
        return dep;
    }

    @Override
    public List<Department> findAll() {
        return List.of();
    }
}
