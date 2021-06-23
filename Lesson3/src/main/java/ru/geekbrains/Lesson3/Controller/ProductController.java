package ru.geekbrains.Lesson3.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.Lesson3.*;
import ru.geekbrains.Lesson3.Service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public void StudentController(ProductService productOperationService){
        this.productService = productOperationService;
    }

    @GetMapping
    public String StringShowAllProducts(Model model){
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);

        return "/WEB-INF/all_products.html";
    }

    @GetMapping("/add")
    public String ShowAddForm(){
        return "/WEB-INF/add_product.html";
    }
    @PostMapping("/add")
    public String saveNewProduct(@ModelAttribute Product newProduct){
        productService.addProduct(newProduct);
        return "redirect:/products";
    }

    @GetMapping("/edit{id}")
    public String showEditForm(@PathVariable long id, Model model){
        model.addAttribute("product", productService.readProduct(id));
        return "/WEB-INF/edit_product_form.html";
    }
}
