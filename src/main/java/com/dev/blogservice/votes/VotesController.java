package com.dev.blogservice.votes;

import com.dev.blogservice.beans.ResponseDTO;
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

    @GetMapping(value = "/vote/get/{postId}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> getVote(@PathVariable("postId") String postId) throws Throwable{
        return ResponseEntity.ok(new ResponseDTO().success(service.getVoteById(postId)));
    }

    @PostMapping(value = "/vote", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDTO> saveVote(@RequestBody @Valid Votes vote) throws Throwable{
        service.save(vote);
        return ResponseEntity.ok(new ResponseDTO().success(vote));
    }
}
