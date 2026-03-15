package dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import entity.Product;
import util.HibernateUtil;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


public class ProductDAO {

    public void saveProduct(Product product) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(product);

        tx.commit();
        session.close();
    }
    public void getProductsSortedByPrice() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);

        Root<Product> root = cq.from(Product.class);

        cq.select(root).orderBy(cb.asc(root.get("price")));

        List<Product> products = session.createQuery(cq).getResultList();

        for(Product p : products) {
            System.out.println(p.getName() + " " + p.getPrice());
        }

        session.close();
    }
    public void getProductsAbovePrice(int price) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);

        Root<Product> root = cq.from(Product.class);

        cq.select(root).where(cb.gt(root.get("price"), price));

        List<Product> products = session.createQuery(cq).getResultList();

        for(Product p : products) {
            System.out.println(p.getName() + " " + p.getPrice());
        }

        session.close();
    }
    public void getAllProductsCriteria() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);

        Root<Product> root = cq.from(Product.class);

        cq.select(root);

        List<Product> products = session.createQuery(cq).getResultList();

        for(Product p : products) {
            System.out.println(p.getName() + " " + p.getPrice());
        }

        session.close();
    }
    public void updateProduct(int id, int newPrice) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p = session.get(Product.class, id);

        if(p != null) {
            p.setPrice(newPrice);
            session.update(p);
            System.out.println("Product updated successfully");
        }

        tx.commit();
        session.close();
    }
    public void getProductsPriceAsc() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Product> list = session.createQuery(
                "FROM Product ORDER BY price ASC", Product.class).list();

        list.forEach(p -> System.out.println(p.getName() + " " + p.getPrice()));

        session.close();
    }
    public void getProductsPriceDesc() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Product> list = session.createQuery(
                "FROM Product ORDER BY price DESC", Product.class).list();

        list.forEach(p -> System.out.println(p.getName() + " " + p.getPrice()));

        session.close();
    }
    public void sortByQuantity() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Product> list = session.createQuery(
                "FROM Product ORDER BY quantity DESC", Product.class).list();

        list.forEach(p -> System.out.println(p.getName() + " " + p.getQuantity()));

        session.close();
    }
    public void getFirstThreeProducts() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Product> query = session.createQuery("FROM Product", Product.class);

        query.setFirstResult(0);
        query.setMaxResults(3);

        List<Product> list = query.list();

        list.forEach(p -> System.out.println(p.getName()));

        session.close();
    }
    public void getNextThreeProducts() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query<Product> query = session.createQuery("FROM Product", Product.class);

        query.setFirstResult(3);
        query.setMaxResults(3);

        List<Product> list = query.list();

        list.forEach(p -> System.out.println(p.getName()));

        session.close();
    }
    public void countProducts() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Long count = session.createQuery(
                "SELECT COUNT(*) FROM Product", Long.class).uniqueResult();

        System.out.println("Total Products: " + count);

        session.close();
    }
    public void minMaxPrice() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Object[] result = (Object[]) session.createQuery(
                "SELECT MIN(price), MAX(price) FROM Product")
                .uniqueResult();

        System.out.println("Minimum Price: " + result[0]);
        System.out.println("Maximum Price: " + result[1]);

        session.close();
    }
    public void filterPriceRange() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        List<Product> list = session.createQuery(
                "FROM Product WHERE price BETWEEN 2000 AND 20000",
                Product.class).list();

        list.forEach(p -> System.out.println(p.getName() + " " + p.getPrice()));

        session.close();
    }
    public void deleteProduct(int id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Product p = session.get(Product.class, id);

        if(p != null) {
            session.delete(p);
            System.out.println("Product deleted successfully");
        }

        tx.commit();
        session.close();
    }
}
