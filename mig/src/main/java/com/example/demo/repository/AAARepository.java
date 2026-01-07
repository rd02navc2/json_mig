package com.example.demo.repository;

import com.example.demo.entity.AAA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AAARepository extends JpaRepository<AAA, String> {
    
    List<AAA> findByName(String name);
    
    List<AAA> findByNameContaining(String name);
    
    List<AAA> findByCar(String car);
    
    List<AAA> findByBoro(String boro);

    List<AAA> findByChn(String chn);
    
    List<AAA> findByChnContaining(String chn);
    
    List<AAA> findByCarGreaterThan(String car);
    
    List<AAA> findByBoroLessThan(String boro);

    List<AAA> findByNameAndCar(String name, String car);
}