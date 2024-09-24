package _Narsha.server.domain.post.controller;

import _Narsha.server.domain.post.dto.PostDto;
import _Narsha.server.domain.post.entity.PostEntity;
import _Narsha.server.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostEntity> createPost(@RequestBody PostDto postDto) {
        PostEntity createdPost = postService.createPost(postDto);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostEntity> getPost(@PathVariable Long id) {
        PostEntity post = postService.getPost(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PostEntity> updatePost(@PathVariable Long id, @RequestBody PostDto postDto) {
        PostEntity updatedPost = postService.updatePost(id, postDto);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<PostEntity>> getAllPost() {
        List<PostEntity> postList = postService.getAllPost();
        return ResponseEntity.ok(postList);
    }

}
