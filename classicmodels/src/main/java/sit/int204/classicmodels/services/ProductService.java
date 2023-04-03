package sit.int204.classicmodels.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import sit.int204.classicmodels.Models.Employee;
import sit.int204.classicmodels.Models.Product;
import sit.int204.classicmodels.Repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // filed เดียว ไม่ได้เป็น array
    public Page<Product> getProducts(int page , int size,String sortBy){
        Sort sort = Sort.by(sortBy) ;
        //PageRequest is obj that created page.
       /* if(size>20) {  throw new RuntimeException("invalid value size"+size){} ;

        }*/
        Pageable pageable = PageRequest.of(page,size,sort) ;
        return productRepository.findAll(pageable);
    }

    public List<Product> getProductByContext(String name , String description){
        return productRepository.findProductByProductNameStartingWithOrProductDescriptionContaining(name,description);

    }

    public List<Product> getProductsPriceBetween(double low,double high) {
        //ทำให้ไม่เกิดข้อผิดพลาดแม้ User จะส่งมา สลับ
        if (low > high) {
            return productRepository.findProductByPriceBetweenOrderByPriceDesc(high, low);
        }
        else {
            return productRepository.findProductByPriceBetweenOrderByPriceDesc(low,high) ;
        }
    }

    public Integer getSizeAll(int page , int RowPerPage){
        return  page*RowPerPage ;
    }

    public List<Product> getProductBySort(int page ,int size ,String sort){
        Sort s = Sort.by(sort) ;
        Pageable pageable = PageRequest.of(page,size,s);
    return     productRepository.findAll(pageable).getContent() ;
    }

    public Product updateProduct(String ProductCode,Product product){
     Product  productExist =   productRepository.findProductByProductCode(ProductCode) ;
     productExist.setProductName(product.getProductName());
     productExist.setProductDescription(product.getProductDescription());
     productExist.setPrice(product.getPrice());
        productExist.setProductScale(product.getProductScale());
        productExist.setProductVendor(product.getProductVendor());
        productExist.setBuyPrice(product.getBuyPrice());
        productExist.setProductLine(product.getProductLine());
        productExist.setQuantityInStock(product.getQuantityInStock());
        return  productRepository.saveAndFlush(productExist) ;

    }

    public Product addNewProduct(Product product) {
        return  productRepository.saveAndFlush(product);
    }




}
