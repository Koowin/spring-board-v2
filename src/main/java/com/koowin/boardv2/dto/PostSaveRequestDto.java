package com.koowin.boardv2.dto;


import com.koowin.boardv2.model.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class PostSaveRequestDto {
    @Size
    private String title;
    private String author;
    private String content;

    @Builder
    public PostSaveRequestDto(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .author(author)
                .content(content)
                .build();

    }
}
