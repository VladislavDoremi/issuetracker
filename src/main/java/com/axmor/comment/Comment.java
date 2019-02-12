package com.axmor.comment;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class Comment {

    private UUID commentUuid;
    private UUID issueUuid;
    private UUID userUuid;
    private String description;
    private Date createAt;
    private Date editAt;
    private boolean deleted;

    public Comment() {}

    public UUID getCommentUuid() {
        return commentUuid;
    }

    public void setCommentUuid(UUID commentUuid) {
        this.commentUuid = commentUuid;
    }

    public UUID getIssueUuid() {
        return issueUuid;
    }

    public void setIssueUuid(UUID issueUuid) {
        this.issueUuid = issueUuid;
    }

    public UUID getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(UUID userUuid) {
        this.userUuid = userUuid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getEditAt() {
        return editAt;
    }

    public void setEditAt(Date editAt) {
        this.editAt = editAt;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
