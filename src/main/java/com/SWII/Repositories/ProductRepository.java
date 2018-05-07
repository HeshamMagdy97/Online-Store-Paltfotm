package com.SWII.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.SWII.Entity.ProductEntity;

public interface ProductRepository extends CrudRepository<ProductEntity,Integer>{
ProductEntity findByName(String name);
    
}
