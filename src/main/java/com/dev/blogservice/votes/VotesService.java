package com.dev.blogservice.votes;

import com.dev.blogservice.comments.Comments;
import com.dev.blogservice.comments.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VotesService {

    @Autowired
    private VotesRepository repository;

    public List<Votes> getVotesList() {
        List<Votes> votes = new ArrayList<Votes>();
        repository.findAll().forEach(vote -> votes.add(vote));
        return votes;
    }

    public List<Votes> getVoteById(String id) {
        return repository.findVotesByPostId(id);
    }

    public void save(Votes vote) {
        Votes v = repository.findVotesByPostIdAndCreatedBy(vote.getPostId(), vote.getCreatedBy());
        if(v != null){
            v.setUpVote(vote.getUpVote());
            v.setDownVote(vote.getDownVote());
            repository.save(v);
        }else{
            repository.saveAndFlush(vote);
        }
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
