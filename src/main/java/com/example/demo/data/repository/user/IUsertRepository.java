package com.example.demo.data.repository.user;


import com.example.demo.data.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsertRepository extends JpaRepository<User,Integer> {



}

