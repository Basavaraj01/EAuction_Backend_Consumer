package com.eacution.app.repositories;


import com.eacution.app.entity.Buyer;
import com.eacution.app.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BuyerRepository buyerRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "eauction_product_json", groupId = "myGroup")
    public void consume(Product product){
        productRepository.save(product);
        LOGGER.info(String.format("Product Json message recieved -> %s", product.toString()));
    }

    @KafkaListener(topics = "eauction_buyer_json", groupId = "myGroup")
    public void consume(Buyer buyer){
        buyerRepository.save(buyer);
        LOGGER.info(String.format("Buyer Json message recieved -> %s", buyer.toString()));
    }
}
