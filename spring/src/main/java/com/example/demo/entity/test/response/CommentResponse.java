package com.example.demo.entity.test.response;

import lombok.Data;

//조회 기능을 하려면 Response가 필요함
@Data
public class CommentResponse {
    private String comment;

    public CommentResponse (String comment) {
        this.comment = comment;
    }
}
