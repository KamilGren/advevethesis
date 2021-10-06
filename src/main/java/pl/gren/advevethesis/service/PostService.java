package pl.gren.advevethesis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gren.advevethesis.dto.PostDto;
import pl.gren.advevethesis.exceptions.PostNotFoundException;
import pl.gren.advevethesis.model.Post;
import pl.gren.advevethesis.repository.PostRepository;


import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PostService {

//    @Autowired
//  private AuthService authService;
    @Autowired
    private PostRepository postRepository;

    @Transactional
    public List<PostDto> showAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(this::mapFromPostToDto).collect(toList());
    }

    @Transactional
    public void deletePost(int id)
    {
        postRepository.deleteById(id);
    }

    @Transactional
    public void createPost(PostDto postDto) {
        Post post = mapFromDtoToPost(postDto);
        postRepository.save(post);
    }

    public List <Post> getPostByUserUsername(String userName) { return postRepository.getPostByUser_Username(userName); }


    @Transactional
    public PostDto readSinglePost(int id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException("For id " + id));
        return mapFromPostToDto(post);
    }

    private PostDto mapFromPostToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setPhotoLink(post.getPhotoLink());
        postDto.setUser(post.getUser());
        return postDto;
    }

    private Post mapFromDtoToPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        //User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("User Not Found"));
        post.setCreatedOn(Instant.now());
        //post.setUsername(loggedInUser.getUsername());
        post.setUpdatedOn(Instant.now());
        post.setPhotoLink(postDto.getPhotoLink());
        post.setUser(postDto.getUser());
        return post;
    }
}
