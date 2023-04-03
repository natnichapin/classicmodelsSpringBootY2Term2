package sit.int204.classicmodels.Repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import sit.int204.classicmodels.Models.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,String> {
List<Product> findProductByProductNameStartingWithOrProductDescriptionContaining(String name ,String description);
Page<Product> findProductByProductNameStartingWithOrProductDescriptionContaining(String name , String description, Pageable pageable) ;
List<Product> findProductByProductNameStartingWithOrProductDescriptionContaining(String name , String description, Sort sort) ;
List<Product> findProductByPriceBetween(Double low,Double high) ;
    List<Product> findProductByPriceBetweenOrderByPriceDesc(Double low,Double high) ;
    Page<Product> findProductByPriceBetweenOrderByPriceDesc(Double low,Double high,Pageable pageable) ;
    Product findProductByProductCode(String ProductCode ) ;


    //อยากให้มันทำอะไรได้ ก็ Over load มา แล้วส่ง obj ที่ต้องการไป
}
