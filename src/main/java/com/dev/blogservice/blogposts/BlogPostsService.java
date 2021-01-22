package com.dev.blogservice.blogposts;

import com.dev.blogservice.votes.VotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogPostsService {

    @Autowired
    private BlogPostsRepository repository;

    @Autowired
    private VotesService voteService;

    public List<BlogPosts> getBlogPostsList() {
        List<BlogPosts> posts =  repository.findAllByOrder();
        posts.forEach(post-> {
            post.setVotes(voteService.getVoteById(post.getId()));
        });
        return posts;
    }

    public BlogPosts getBlogPostById(String id) {
        return repository.findById(id).get();
    }

    public void save(BlogPosts post) {
        repository.saveAndFlush(post);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
