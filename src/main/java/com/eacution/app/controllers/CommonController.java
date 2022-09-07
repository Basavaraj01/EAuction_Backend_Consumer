package com.eacution.app.controllers;

import com.eacution.app.entity.Buyer;
import com.eacution.app.entity.Product;
import com.eacution.app.repositories.BuyerRepository;
import com.eacution.app.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.eacution.app.exceptions.NotFoundException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins="http://react-eauction.s3-website-us-east-1.amazonaws.com")
public class CommonController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BuyerRepository buyerRepository;


    @GetMapping("/product")
    public List<Product> getUsers(){
        return productRepository.findAll();
    }

    @PostMapping("/product")
    public void saveUsers(@RequestBody Product product){
        productRepository.save(product);
    }

    @GetMapping("/buyer")
    public List<Buyer> getBuyers(){
        return buyerRepository.findAll();
    }

    @PostMapping("/buyer")
    public void saveBuyers(@RequestBody Buyer buyer){
        buyerRepository.save(buyer);
    }

    @GetMapping("/seller/show-bids/{productId}")
    public List<Buyer> retrieveProductsById(@PathVariable int productId) {
        List<Buyer> buyers=buyerRepository.findByProductId(productId);
        if(buyers.isEmpty()){
            throw new NotFoundException("productId "+productId+" is not found");
        }
        return buyers;
    }
}
