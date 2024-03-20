package com.marketingApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingApp.entity.BlogPost;
import com.marketingApp.repository.BlogPostRepository;

@Service
public class BlogPostService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    public void saveBlogPost(BlogPost blogPost) {
        blogPostRepository.save(blogPost);
    }

    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    public void deleteBlogPost(Long id) {
        blogPostRepository.deleteById(id);
    }

    public BlogPost getBlogPostById(Long id) {
        return blogPostRepository.findById(id).orElse(null);
    }

    public void saveUpdatedBlogPost(BlogPost blogPost) {
        blogPostRepository.save(blogPost);
    }
}
