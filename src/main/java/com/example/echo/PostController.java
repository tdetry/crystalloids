/*
 * Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.echo;

import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.UnauthorizedException;

import java.util.List;

/**
 * The PostController API which Endpoints will be exposing.
 */
@Api(
    name = "post",
    version = "v1",
        audiences = {"236591439146-opp6mqq3da0ukb14mifv0i8i4p7n6ppn.apps.googleusercontent.com"}, // TODO: in configuration
        clientIds = {"236591439146-opp6mqq3da0ukb14mifv0i8i4p7n6ppn.apps.googleusercontent.com"},
    namespace =
    @ApiNamespace(
        ownerDomain = "echo.example.com",
        ownerName = "echo.example.com",
        packagePath = ""
    ))
public class PostController {

  /**
   * Controller for CRUD on Posts
   */

  // TODO: I would do IC and autowired with spring, here i do not know yet.
  private PostService postService = new PostService();

  @ApiMethod(name = "savePost",
          httpMethod = ApiMethod.HttpMethod.POST)
  public Post save(User user, Post post)  throws UnauthorizedException {

      // TODO: auth not working atm..
      // if (user == null) {
      //    throw new UnauthorizedException("Invalid credentials");
      // }

      post.setAuthor("testUser"); //  TODO: from User

    Post savedPost = postService.save(post);

    return savedPost;

  }

    @ApiMethod(name = "getPosts",
            httpMethod = ApiMethod.HttpMethod.GET)
    public List<Post> getAll(User user) throws UnauthorizedException {

        // if (user == null) {
        //    throw new UnauthorizedException("Invalid credentials");
        // }

        List<Post> savedPosts = postService.getAll();

        return savedPosts;

    }


    @ApiMethod(name = "editPost",
            httpMethod = ApiMethod.HttpMethod.PUT)
    public Post edit(User user, Post post) throws UnauthorizedException  {
        // if (user == null) {
        //    throw new UnauthorizedException("Invalid credentials");
        // }

        // TODO: logic to update only his post

        post.setAuthor("testUser"); //  TODO: from User

        Post editedPost = postService.update(post);

        return editedPost;

    }



}
