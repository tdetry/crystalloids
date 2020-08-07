package com.example.echo;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import lombok.*;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity {
    @Id
    Long id; // Can be Long, long, or String

    String body;

    String author;

    String subject;

}
