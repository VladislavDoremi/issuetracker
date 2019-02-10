package com.axmor.comment;

import lombok.Data;

import java.util.UUID;

@Data
public class Comment {

    private UUID commentUuid;
    private UUID issueUuid;
    private UUID userUuid;
    private String description;

    public Comment() {}

    public UUID getCommentUuid() {
        return commentUuid;
    }

    public UUID getIssueUuid() {
        return issueUuid;
    }

    public UUID getUserUuid() {
        return userUuid;
    }

    public String getDescription() {
        return description;
    }
}
