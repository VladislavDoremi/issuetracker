package com.axmor.issue;

import com.google.common.collect.ImmutableList;

import java.util.List;

public class IssueDao {

    private final List<Issue> testIssues = ImmutableList.of(
            new Issue(1, 1, "Issie1", "dfgdffgfdgf", 0),
            new Issue(2, 2, "Issie2", "dfgfdfgdgff", 2),
            new Issue(3, 3, "Issie3", "dfgxzcgdfgf", 1),
            new Issue(4, 4, "Issie4", "dfgdfgxfczf", 0),
            new Issue(5, 1, "Issie5", "dfgdfffgdgf", 3),
            new Issue(6, 2, "Issie6", "dfgdffgfdgf", 0),
            new Issue(7, 1, "Issie7", "dfgdfgdfgff", 1),
            new Issue(8, 1, "Issie8", "dfgdfgdgfff", 1),
            new Issue(9, 1, "Issie9", "dfgdfgdgfff", 2),
            new Issue(10, 1, "Issie10", "dfgdfgdgf", 3),
            new Issue(11, 1, "Issie11", "dfgdfgdgf", 0),
            new Issue(12, 2, "Issie12", "dfgdfgdgf", 1),
            new Issue(13, 3, "Issie13", "dfgdfgdgf", 3),
            new Issue(14, 2, "Issie14", "dfgdfgdgf", 2),
            new Issue(15, 2, "Issie15", "dfgdfgdgf", 0),
            new Issue(16, 4, "Issie16", "dfgdfgdgf", 2),
            new Issue(17, 1, "Issie17", "dfgdfgdgf", 0),
            new Issue(18, 1, "Issie18", "dfgdfgdgf", 1),
            new Issue(19, 1, "Issie19", "dfgdfgdgf", 0),
            new Issue(20, 1, "Issie20", "dfgdfgdgf", 3)
    );

    public List<Issue> getAll() {
        return testIssues;
    }

    public Issue getById() {
        return new Issue(1, 2, "Issie1", "dfgdffgfdgf", 0);
    }


}
