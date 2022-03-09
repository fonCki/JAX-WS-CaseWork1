package dataAccess;

import java.sql.*;

    public class DataConnection {

        static final String DB_URL = "jdbc:postgresql://rogue.db.elephantsql.com:5432/awnxdfjy";
        static final String USER = "awnxdfjy";
        static final String PASSWORD = "ePBs6uwpO5J-MeSGaeKkw5VvN6Ab9fnM";
        static final String SCHEMA = "orders";

        private static DataConnection instance = new DataConnection();

        public synchronized static DataConnection getInstance()
        {
            return instance;
        }

        public synchronized Connection getConnection()
        {
            try
            {
                DriverManager.registerDriver(new org.postgresql.Driver());
                return DriverManager.getConnection(DB_URL,USER,PASSWORD);
            }
            catch (SQLException e)
            {
                throw new RuntimeException("DATABASE CONNECTION FAILED!");
            }
        }

    }

