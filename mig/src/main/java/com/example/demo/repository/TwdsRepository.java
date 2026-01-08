package com.example.demo.repository;

import com.example.demo.entity.Twds;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TwdsRepository extends JpaRepository<Twds, String> {
    
    /**
     * 根據中文名稱查詢
     */
    Optional<Twds> findByChName(String chName);
    
    /**
     * 根據英文名稱查詢
     */
    Optional<Twds> findByEnName(String enName);
    
    /**
     * 模糊搜尋中文名稱
     */
    @Query("SELECT t FROM Twds t WHERE t.chName LIKE %:keyword%")
    List<Twds> searchByChNameKeyword(@Param("keyword") String keyword);
    
    /**
     * 根據 SN 查詢
     */
    Optional<Twds> findBySn(String sn);
}