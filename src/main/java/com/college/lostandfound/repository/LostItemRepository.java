package com.college.lostandfound.repository;


import com.college.lostandfound.model.LostItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LostItemRepository extends JpaRepository<LostItem, Long> {
    // Additional custom query methods can be defined here if needed
}
