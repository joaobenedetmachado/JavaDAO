package application;

import model.dao.DAOFactory;
import model.dao.DepartamentDAO;
import model.dao.SellerDAO;
import model.dao.impl.SellerDAOJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SellerDAO sellerdao = DAOFactory.createSellerDAO();

        System.out.println(" =*= TEST N1: seller findById  =*= ");
        Seller seller = sellerdao.findById(4);

        System.out.println(seller);

        DepartamentDAO depdao = DAOFactory.createDepartmentDAO();
        Department dep = depdao.findById(3);
        System.out.println(dep);

        System.out.println(" =*= TEST N2: seller findByDepartment  =*= ");
        Department depart = new Department(2, null);
        List<Seller> listSellers = sellerdao.findByDepartment(depart);
        for (Seller obj : listSellers) {
            System.out.println(obj);
        }
    }
}
