package com.amir.repository;


import com.amir.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Amir on 2016-11-27.
 * spring-weblog
 */
@Repository
public interface MySayUserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);
    
    @EntityGraph(value = "User.detail", type = EntityGraph.EntityGraphType.LOAD)
    User getUserByEmail(String email);
}
