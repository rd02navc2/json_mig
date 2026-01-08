package com.example.demo.repository;

import com.example.demo.entity.Twcls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TwclsRepository extends JpaRepository<Twcls, String> {
    
    /**
     * 根據 Object Class 查詢
     */
    Optional<Twcls> findByObjectClass(String objectClass);
    
    /**
     * 根據 Class Name 查詢
     */
    Optional<Twcls> findByClassName(String className);
    
    /**
     * 根據 Class ID 查詢
     */
    Optional<Twcls> findByClassId(String classId);
    
    /**
     * 根據多個 Object Class 查詢
     */
    @Query("SELECT t FROM Twcls t WHERE t.objectClass IN :objectClasses")
    List<Twcls> findByObjectClassIn(@Param("objectClasses") List<String> objectClasses);
    
    /**
     * 模糊搜尋 Class Name
     */
    @Query("SELECT t FROM Twcls t WHERE t.className LIKE %:keyword%")
    List<Twcls> searchByClassNameKeyword(@Param("keyword") String keyword);
}