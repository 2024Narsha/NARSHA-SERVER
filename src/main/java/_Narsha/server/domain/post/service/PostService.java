package _Narsha.server.domain.post.service;

import _Narsha.server.domain.post.dto.PostDto;
import _Narsha.server.domain.post.entity.PostEntity;

import java.util.List;

public interface PostService {

    PostEntity createPost(PostDto postDto);

    PostEntity getPost(Long id);

    PostEntity updatePost(Long id,PostDto postDto);

    void deletePost(Long id);

    List<PostEntity> getAllPost();
}
