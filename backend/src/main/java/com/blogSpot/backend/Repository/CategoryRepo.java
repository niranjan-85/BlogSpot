package com.blogSpot.backend.Repository;

import com.blogSpot.backend.Beans.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Integer> {

}
