package main;
import dao.ProductDAO;
import entity.Product;
import entity.Employee;
import entity.Department;
import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Arrays;

public class MainApp {

    public static void main(String[] args) {

    	ProductDAO dao = new ProductDAO();
    	dao.getAllProductsCriteria();

    	System.out.println("Sorted by price:");
    	dao.getProductsSortedByPrice();

    	System.out.println("Products above 10000:");
    	dao.getProductsAbovePrice(10000);

    	// Insert multiple products
    	dao.saveProduct(new Product("Laptop","Electronics",80000,5));
    	dao.saveProduct(new Product("Phone","Electronics",30000,10));
    	dao.saveProduct(new Product("Keyboard","Accessories",2000,20));
    	dao.saveProduct(new Product("Mouse","Accessories",1500,25));
    	dao.saveProduct(new Product("Monitor","Electronics",15000,8));
    	dao.saveProduct(new Product("Printer","Office",12000,4));
    	dao.updateProduct(1,  90000);
    	dao.deleteProduct(2);

    	System.out.println("Products inserted");

    	// Call HQL methods
    	dao.getProductsPriceAsc();
    	dao.getProductsPriceDesc();
    	dao.sortByQuantity();
    	dao.getFirstThreeProducts();
    	dao.getNextThreeProducts();
    	dao.countProducts();
    	dao.minMaxPrice();
    	dao.filterPriceRange();
    	
    	Employee e1 = new Employee("Rahul", "Developer");
    	Employee e2 = new Employee("Kiran", "Tester");

    	Department dept = new Department("IT", Arrays.asList(e1, e2));

    	Session session = HibernateUtil.getSessionFactory().openSession();
    	Transaction tx = session.beginTransaction();

    	session.save(dept);

    	tx.commit();
    	session.close();

    	System.out.println("Department and Employees saved successfully");

    }

}
