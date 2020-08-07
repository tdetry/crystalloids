package com.example.echo;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostService {

    // TODO: I would do IC and autowired with spring, here i do not know yet.
    private PostRepository postRepository = new PostRepository();


    public Post save(Post post) {
        PostEntity postEntitySaved = postRepository.save(map(post));
        return Post.builder().body(postEntitySaved.getBody()).id(postEntitySaved.getId().intValue()).build();
    }

    public List<Post> getAll(){
        List<PostEntity> postEntities = postRepository.findAll();

        List<Post> posts = new ArrayList<>();

        for(PostEntity postEntity : postEntities) {
            posts.add(this.map(postEntity));
        }

        return posts;
    }

    public Post update(Post post){
        PostEntity postEntity = postRepository.save(map(post));
        return map(postEntity);
    }

    // this could move outside of service
    private Post map(PostEntity postEntity){
        if (postEntity == null) {
            return null;
        }

        return Post.builder()
                .body(postEntity.getBody())
                .id(postEntity.getId().intValue())
                .author((postEntity.getAuthor()))
                .subject((postEntity.getSubject()))
                .build();
    }

    private PostEntity map(Post post){
        if (post == null) {
            return null;
        }

        if (post.getId() == null) {
            return PostEntity.builder()
                    .body(post.getBody())
                    .author(post.getAuthor())
                    .subject(post.getSubject())
                    .build();
        }

        return PostEntity.builder().id(new Long(post.getId())).body(post.getBody()).build();
    }


}
