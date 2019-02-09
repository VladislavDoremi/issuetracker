package com.axmor.util;

import lombok.*;

public class Path {
    public static class Web {
        @Getter public static final String INDEX = "/index/";
        @Getter public static final String LOGIN = "/login/";
        @Getter public static final String LOGOUT = "/logout/";
        @Getter public static final String DASHBOARD = "/dashboard/";

        @Getter public static final String ISSUE = "/issue/";
        @Getter public static final String ISSUE_FORM = "/issue/form/";
        @Getter public static final String ALL_ISSUES = "/issues/";

        @Getter public static final String COMMENT = "/issue/:uuid/comments";
        @Getter public static final String ALL_COMMENTS = "/issue/:uuid/comments";
    }

    public static class Template {
        public final static String NOT_FOUND = "/pages/not_found.ftl";
        public final static String INDEX = "/pages/index.ftl";
        public final static String LOGIN = "/pages/login.ftl";
        public final static String DASHBOARD = "/pages/dashboard.ftl";
        public final static String ABOUT_ME = "/pages/about_me.ftl";
        public final static String CREATE_ISSUE = "/pages/issue/create_issue.ftl";
        public final static String ISSUE = "/pages/issue/issue.ftl";

    }
}
