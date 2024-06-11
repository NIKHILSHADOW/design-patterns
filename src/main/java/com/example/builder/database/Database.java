package com.example.builder.database;

import lombok.Getter;

@Getter
public class Database {
    private String host;
    private Integer port;
    private String name;
    private String password;
    private DatabaseType databaseType;

    // 1. hide constructor
    protected Database() {
    }

    // 5 create static intialiser for getting builder class instance
    public static DatabaseBuilder builder() {
        return new DatabaseBuilder();
    }

    // 2. create static inner class
    public static class DatabaseBuilder {

        private Database database;

        private DatabaseBuilder() {
            database = new Database();
        }

        // 3 setters or fluent interfaces
        public DatabaseBuilder host(String host) {
            database.host = host;
            return this;
        }

        public DatabaseBuilder port(Integer port) {
            database.port = port;
            return this;
        }

        public DatabaseBuilder name(String name) {
            database.name = name;
            return this;
        }

        public DatabaseBuilder password(String password) {
            database.password = password;
            return this;
        }

        public DatabaseBuilder mySql() {
            database.databaseType = DatabaseType.MYSQL;
            return this;
        }

        public DatabaseBuilder mongo() {
            database.databaseType = DatabaseType.MONGO;
            return this;
        }

        // 4 build method for actual instance
        public Database build() {
            if (!validate()) {
                throw new RuntimeException("wrong input fields");
            }
            Database actualDatabase = new Database();
            actualDatabase.host = database.host;
            actualDatabase.databaseType = database.databaseType;
            actualDatabase.name = database.name;
            actualDatabase.password = database.password;
            actualDatabase.port = database.port;

            return actualDatabase;
        }

        private boolean validate() {
            if (database.name == null || database.port == null)
                return false;
            return true;
        }

    }

}
