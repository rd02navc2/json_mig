package com.example.demo.service;

import com.example.demo.entity.AAA;
import com.example.demo.repository.AAARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AAAService {
    
    @Autowired
    private AAARepository aaaRepository;

    public List<AAA> findAll() {
        return aaaRepository.findAll();
    }

    public Optional<AAA> findById(String cls) {
        return aaaRepository.findById(cls);
    }

    @Transactional
    public AAA save(AAA aaa) {
        return aaaRepository.save(aaa);
    }

    @Transactional
    public void deleteById(String cls) {
        aaaRepository.deleteById(cls);
    }

    public boolean existsById(String cls) {
        return aaaRepository.existsById(cls);
    }

    public List<AAA> findByName(String name) {
        return aaaRepository.findByName(name);
    }

    public List<AAA> searchByName(String name) {
        return aaaRepository.findByNameContaining(name);
    }
    
    public List<AAA> searchByChn(String chn) {
        return aaaRepository.findByChnContaining(chn);
    }

    public List<AAA> findByCar(String car) {
        return aaaRepository.findByCar(car);
    }

    @Transactional
    public List<AAA> saveAll(List<AAA> aaaList) {
        return aaaRepository.saveAll(aaaList);
    }
}