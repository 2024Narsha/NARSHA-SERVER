package _Narsha.server.domain.post.service.impl;

import _Narsha.server.domain.post.dto.PostDto;
import _Narsha.server.domain.post.entity.PostEntity;
import _Narsha.server.domain.post.repository.PostRepository;
import _Narsha.server.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public PostEntity createPost(PostDto postDto) {
        PostEntity postEntity = PostEntity.builder()
                .title(postDto.getTitle())
                .details(postDto.getDetails())
                .deadLine(postDto.getDetails())
                .build();

        return postRepository.save(postEntity);
    }

    @Override
    public PostEntity getPost(Long id) {
        return postRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("게시글을 찾을 수 없습니다."));
    }

    @Override
    public PostEntity updatePost(Long id, PostDto postDto) {
        PostEntity postEntity = postRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("게시글을 찾을 수 없습니다."));
        updatePost(postEntity,postDto);
        return postRepository.save(postEntity);
    }

    private void updatePost(PostEntity postEntity, PostDto postDto){
        if(postDto.getDetails() != null) postEntity.setDetails(postDto.getDetails());
        if(postDto.getTitle() != null) postEntity.setTitle(postDto.getTitle());
        if(postDto.getDeadLine() != null) postEntity.setDeadLine(postDto.getDeadLine());
    }

    @Override
    public void deletePost(Long id) {
        PostEntity postEntity = postRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("게시글을 찾을 수 없습니다."));

        postRepository.delete(postEntity);
    }

    @Override
    public List<PostEntity> getAllPost() {
        return postRepository.findAll();
    }
}
