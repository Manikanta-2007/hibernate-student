package main;
import dao.ProductDAO;
import entity.Product;

public class MainApp {

    public static void main(String[] args) {

    	ProductDAO dao = new ProductDAO();

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

    }

}
