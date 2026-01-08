package com.example.demo.repository;

import com.example.demo.entity.Twdens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TwdensRepository extends JpaRepository<Twdens, String> {
    
    /**
     * 根據 DEN 查詢
     */
    Optional<Twdens> findByDen(String den);
    
    /**
     * 根據 XML Tag Name 查詢
     */
    Optional<Twdens> findByXmlTagName(String xmlTagName);
    
    /**
     * 根據 Object Class 查詢所有相關記錄
     */
    List<Twdens> findByObjectClass(String objectClass);
    
    /**
     * 模糊搜尋 DEN
     */
    @Query("SELECT t FROM Twdens t WHERE t.den LIKE %:keyword%")
    List<Twdens> searchByDenKeyword(@Param("keyword") String keyword);
    
    /**
     * 根據多個 Object Class 查詢
     */
    @Query("SELECT t FROM Twdens t WHERE t.objectClass IN :objectClasses")
    List<Twdens> findByObjectClassIn(@Param("objectClasses") List<String> objectClasses);
}