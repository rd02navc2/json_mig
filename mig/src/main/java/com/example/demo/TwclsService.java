package com.example.demo;

import com.example.demo.entity.Twcls;
import com.example.demo.repository.TwclsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TwclsService {

    @Autowired
    private TwclsRepository repo;

    public List<Twcls> findAll() {
        return repo.findAll();
    }

    public Twcls save(Twcls twcls) {
        return repo.save(twcls);
    }

    public void deleteByObjectClass(String objectClass) {
        repo.deleteById(objectClass);
    }

    public boolean existsByObjectClass(String objectClass) {
        return repo.existsById(objectClass);
    }
}
