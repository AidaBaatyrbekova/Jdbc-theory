package org.example.service;

import org.example.config.DataBaseConnection;
import org.example.model.User;

import java.sql.*;

public class UserService {

    public void createTable() {
        String query = """
                CREATE TABLE IF NOT EXISTS users(
                    id SERIAL PRIMARY KEY ,
                    name VARCHAR NOT NULL ,
                    last_name VARCHAR
                );
                """;

        try (Connection connection = DataBaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute(query);
            System.out.println("Users table successfully created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveUser(User user) {
        String query = """
                INSERT INTO users(name, last_name)
                VALUES (?, ?);
                """;

        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLast_name());
            preparedStatement.execute();
            System.out.println("User successfully saved!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void cleanUserTable() {
        try (Connection connection = DataBaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("""
                    TRUNCATE TABLE users;
                    """);

            System.out.println("Users table successfully cleaned!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public User findUserById(int id) {
        String query = "SELECT * FROM users WHERE id = ?";
        User user = new User();

        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setLast_name(resultSet.getString("last_name"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }


}
