package com.david.blog.api.controller;

import com.david.blog.api.entity.Blog;
import com.david.blog.api.respository.BlogRepository;
import com.david.blog.api.util.RespCode;
import com.david.blog.api.util.RespEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @RequestMapping(value = "createblog",method = RequestMethod.POST)
    @ResponseBody
    public RespEntity createblog(@RequestBody Blog reqBlog) {

        Blog blog = new Blog();
        if(blog != null) {
            //blog.setBlogId(reqBlog.getBlogId());
            blog.setTitle(reqBlog.getTitle());
            blog.setDescription(reqBlog.getDescription());
            blog.setContent(reqBlog.getContent());
            blog.setCreateTime(reqBlog.getCreateTime());
            blog = blogRepository.save(blog);
        }
        return new RespEntity(RespCode.SUCCESS, blog);
    }

    @GetMapping(value = "getBlogById")
    public Optional<Blog> getBlogById(int blogId){
        Optional<Blog> blog = blogRepository.findById(blogId);
        return blog;
    }


    @GetMapping(value = "deleteBlogById")
    public RespEntity deleteBlogById(int blogId){
        blogRepository.deleteById(blogId);
        return new RespEntity(RespCode.SUCCESS, null);
    }

    @GetMapping(value = "getblogs")
    public List<Blog> getBlogs(){
        List<Blog> blogs = blogRepository.findAll();
        return blogs;
    }


}
