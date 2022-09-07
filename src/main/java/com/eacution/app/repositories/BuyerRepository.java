package com.eacution.app.repositories;

import com.eacution.app.entity.Buyer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyerRepository  extends MongoRepository<Buyer,Integer> {

    public List<Buyer> findByProductId(Integer productId);
}
