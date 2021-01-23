package com.dev.blogservice.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentsService {

    @Autowired
    private CommentsRepository repository;

    public List<Comments> getCommentByPostId(String id) {
        List<Comments> comments = repository.findCommentsByPostId(id);
        return repository.findCommentsByPostId(id);
    }

    public void save(Comments comment) {
        repository.saveAndFlush(comment);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
