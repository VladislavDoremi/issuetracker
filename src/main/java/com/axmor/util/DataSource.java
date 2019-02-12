package com.axmor.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {

    private static HikariConfig config;
    private static HikariDataSource dataSource;

    static {
        config = new HikariConfig();
        config.setJdbcUrl("jdbc:h2:tcp://localhost/~/test");
        config.setUsername( "sa" );
        config.setPassword( "" );

        dataSource = new HikariDataSource( config );
    }

    public static HikariDataSource getDataSource() {
        return dataSource;
    }
}
