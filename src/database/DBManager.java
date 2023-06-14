package database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.exception.DBManagerException;

public class DBManager {
    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_USERNAME = "sa";
    private static final String DB_PASSWORD = "";

    // connection
    public static Connection connect() throws DBManagerException {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new DBManagerException("Error trying to load database driver");
        }
        try {
            String url = "jdbc:h2:tcp://localhost//{DIR}/surveydb";
            url = url.replace("{DIR}", getBaseDirectory());
            connection = DriverManager.getConnection(url, DB_USERNAME, DB_PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new DBManagerException("Error trying to connect to database");
        }
        return connection;
    }

    public static String getBaseDirectory() {
        File curr = new File("h2/database/");
        return curr.getAbsolutePath();
    }

    public static void closeConnection(Connection connection) throws DBManagerException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DBManagerException("Error trying to close database connection");
        }
    }

    // statement
    public static Statement createStatement(Connection connection) throws DBManagerException {
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            throw new DBManagerException("Error creating new database statement");
        }
    }

    public static void executeStatement(Connection connection, Statement statement, String sql)
            throws DBManagerException {
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            DBManager.rollback(connection);
            throw new DBManagerException("Error executing statement");
        }
    }
    
    public static void executeUpdate(Connection connection, Statement statement, String sql) throws DBManagerException {
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            DBManager.rollback(connection);
            throw new DBManagerException("Error executing update");
        }
    }

    public static ResultSet executeQuery(Connection connection, Statement statement, String sql) throws DBManagerException {
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(sql);
            return rs;
        } catch(SQLException e) {
            throw new DBManagerException("Error executing query");
        }
    }

    public static void rollback(Connection connection) throws DBManagerException {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new DBManagerException("Error rolling back in new database statement");
        }
    }

    public static void commit(Connection connection) throws DBManagerException {
        try {
            connection.commit();
        } catch (SQLException e) {
            DBManager.rollback(connection);
            throw new DBManagerException("Error doing commit");
        }
    }
    public static void generateStatementExUpdate(String sql) throws DBManagerException {
        Connection connection = DBManager.connect();
        Statement statement = DBManager.createStatement(connection);
        DBManager.executeUpdate(connection, statement, sql);
        DBManager.commit(connection);
        DBManager.closeConnection(connection);
    }

    public static void generateStatementEx(String sql) throws DBManagerException {
        Connection connection = DBManager.connect();
        Statement statement = DBManager.createStatement(connection);
        DBManager.executeStatement(connection, statement, sql);
        DBManager.commit(connection);
        DBManager.closeConnection(connection);
    }

    public static ResultSet generateQuery(String sql) throws DBManagerException {
        Connection connection = DBManager.connect();
        Statement statement = DBManager.createStatement(connection);
        ResultSet rs = DBManager.executeQuery(connection, statement, sql);
        return rs;  
    }
}