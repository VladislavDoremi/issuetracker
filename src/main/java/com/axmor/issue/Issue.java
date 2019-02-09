package com.axmor.issue;

import lombok.Data;

import java.util.UUID;

@Data
public class Issue {

    private UUID issueUuid;
    private String title;
    private String description;
    private int status;
    private UUID userUuid;

    public Issue() {}

}
