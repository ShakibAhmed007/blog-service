package com.dev.blogservice.votes;

import com.dev.blogservice.beans.ResponseModel;
import com.dev.blogservice.comments.Comments;
import com.dev.blogservice.comments.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping(value = "/votes")
public class VotesController {

    @Autowired
    private VotesService service;

//    @GetMapping(value = "/vote/get", produces= MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<ResponseModel> getVotes() throws Throwable {
//        return ResponseEntity.ok(new ResponseModel().success(service.getVotesList()));
//    }

    @GetMapping(value = "/vote/get/{postId}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> getVote(@PathVariable("postId") String postId) throws Throwable{
        return ResponseEntity.ok(new ResponseModel().success(service.getVoteById(postId)));
    }

    @PostMapping(value = "/vote", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseModel> saveVote(@RequestBody @Valid Votes vote) throws Throwable{
        service.save(vote);
        return ResponseEntity.ok(new ResponseModel().success(vote));
    }

//    @DeleteMapping(value = "/vote/{voteId}", produces= MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<ResponseModel> deleteVote(@PathVariable("voteId") String voteId) throws Throwable{
//        service.delete(voteId);
//        return ResponseEntity.ok(new ResponseModel().success(voteId));
//    }
}
