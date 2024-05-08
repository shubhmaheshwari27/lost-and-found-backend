package com.college.lostandfound.repository;


import com.college.lostandfound.model.FoundItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoundItemRepository extends JpaRepository<FoundItem, Long> {
    // Additional custom query methods can be defined here if needed
}
