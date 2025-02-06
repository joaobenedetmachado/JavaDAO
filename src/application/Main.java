package application;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.dao.impl.SellerDAOJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        SellerDAO sellerdao = DAOFactory.createSellerDAO();

        Seller seller = sellerdao.findById(4);

        System.out.println(seller);




    }
}
