package com.example.demo.repository;

import com.example.demo.entity.Twids;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TwidsRepository extends JpaRepository<Twids, String> {
    
    /**
     * 根據 TWID 查詢
     */
    Optional<Twids> findByTwid(String twid);
    
    /**
     * 根據英文名稱查詢
     */
    Optional<Twids> findByEnName(String enName);
    
    /**
     * 根據 SRC 查詢所有相關記錄
     */
    List<Twids> findBySrc(String src);
    
    /**
     * 模糊搜尋英文名稱
     */
    @Query("SELECT t FROM Twids t WHERE t.enName LIKE %:keyword%")
    List<Twids> searchByEnNameKeyword(@Param("keyword") String keyword);
}