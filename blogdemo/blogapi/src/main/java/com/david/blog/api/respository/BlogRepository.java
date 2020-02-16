package com.david.blog.api.respository;

import com.david.blog.api.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog,Integer> {

}
