package application;

import model.entities.Department;
import model.entities.Seller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Department obj = new Department(12, "Games");

        Seller s1 = new Seller(1, "João", "jvbm2177@gmail.com", new Date(), 1999.8, obj);
        System.out.println(s1);




    }
}
