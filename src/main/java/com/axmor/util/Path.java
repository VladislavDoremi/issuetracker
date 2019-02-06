package com.axmor.util;

import lombok.*;

public class Path {
    public static class Web {
        @Getter public static final String INDEX = "/index/";
        @Getter public static final String LOGIN = "/login/";
        @Getter public static final String LOGOUT = "/logout/";
        @Getter public static final String DASHBOARD = "/dashboard/";
        @Getter public static final String ABOUT_ME = "/about/";

        @Getter public static final String ONE_ISSUE = "/issue/:isbn/";
        @Getter public static final String ALL_ISSUE = "/issues/";
        @Getter public static final String ISSUE_CREATE = "/issue/create/";
    }

    public static class Template {
        public final static String NOT_FOUND = "/pages/not_found.ftl";
        public final static String INDEX = "/pages/index.ftl";
        public final static String LOGIN = "/pages/login.ftl";
        public final static String DASHBOARD = "/pages/dashboard.ftl";
        public final static String ABOUT_ME = "/pages/about_me.ftl";

    }
}
