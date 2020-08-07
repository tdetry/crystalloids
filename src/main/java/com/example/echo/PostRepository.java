package com.example.echo;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Result;

import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class PostRepository {

    static {
        ObjectifyService.init();
        ObjectifyService.register(PostEntity.class);
    }


    public PostEntity save(PostEntity postEntity) {
        ObjectifyService.run(() ->  ofy().save().entity(postEntity).now());
        return postEntity;
    }

    public List<PostEntity> findAll(){
        List<PostEntity> postEntities = ObjectifyService.run(() -> ofy().load().type(PostEntity.class).list());
        return postEntities;
    }

}
