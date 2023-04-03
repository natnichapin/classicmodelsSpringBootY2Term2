package sit.int204.classicmodels.controller;

import org.apache.catalina.users.SparseUserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import sit.int204.classicmodels.Models.Product;
import sit.int204.classicmodels.services.ProductService;

import java.util.List;
@CrossOrigin
// ถ้า Project รันได้อย่างน้อย Entity ที่เขียนไปนั้นไม่ผิด

// @ for spring boot ta know this is controller
//if only 'controller' is mean 'MVC'
@RestController
@RequestMapping("/api/products")
public class ProductContoller {
    @Autowired //Spring framework for injection operation
    private ProductService productService ;

    //filed Name not match it   used default
    //we can change convey between fronted

    @GetMapping("")
    public Page<Product> getAllProduct (@RequestParam (defaultValue = "0") Integer page
            , @RequestParam (defaultValue = "15") Integer pageSize,@RequestParam(defaultValue = "productCode") String sortBy){
        return  productService.getProducts(page, pageSize , sortBy) ;
    }

    @GetMapping("/pages")
    public Page<Product> getProductPage (@RequestParam (defaultValue = "0") Integer page
            , @RequestParam (defaultValue = "15") Integer pageSize,@RequestParam(defaultValue = "productCode") String sortBy){
        return  productService.getProducts(page, pageSize , sortBy) ;
    }

    @GetMapping("/contexts")
    public List<Product> getProductByContext(@RequestParam String name,@RequestParam String description){
        return  productService.getProductByContext(name,description);
    }

    @GetMapping("/PriceBetween/{low}/{high}")
    public List<Product> getProductByPriceBetween(@PathVariable Double low,@PathVariable Double high){
        return  productService.getProductsPriceBetween(low,high);
    }


    @GetMapping("/getSizeAll")
    public Integer getSizeAll(@RequestParam (defaultValue = "1") Integer page,@RequestParam (defaultValue = "10") Integer RowPerPage){
        return  productService.getSizeAll(page,RowPerPage) ;
    }

    @GetMapping("/{sort}")
    public List<Product> getProductBySort(@RequestParam (defaultValue = "1") Integer page ,@RequestParam (defaultValue = "10") Integer size ,@PathVariable  String sort) {
        return productService.getProductBySort(page,size,sort);
    }

    @PutMapping("/UpdateProduct/{productCode}")
    public Product UpdateProductById(@PathVariable String productCode,@RequestBody Product product){
        return productService.updateProduct(productCode,product);
    }

    @PostMapping("/AddNewProduct")
    public Product AddNewProduct(@RequestBody Product product){
        return productService.addNewProduct(product);
    }
}
