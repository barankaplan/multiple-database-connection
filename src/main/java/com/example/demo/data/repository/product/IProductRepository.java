package com.example.demo.data.repository.product;


import com.example.demo.data.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> //, CrudRepository<Product,Integer>
{



}

