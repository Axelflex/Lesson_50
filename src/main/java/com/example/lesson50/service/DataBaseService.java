package com.example.lesson50.service;

import com.example.lesson50.dao.CustomerDAO;
import com.example.lesson50.dao.UserDAO;
import com.example.lesson50.model.Customer;
import com.example.lesson50.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DataBaseService {
    private final DataBaseConnectivityService dbService;
    private final CustomerDAO customerDAO;
    private final UserDAO userDAO;

    private int executeUpdate(String query) throws SQLException{
        Statement statement = dbService.getConnection().createStatement();
        return statement.executeUpdate(query);
    }

    private void createTables() throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS users( " +
                "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY, " +
                "nickname VARCHAR(100) NOT NULL, " +
                "name VARCHAR(100) NOT NULL, " +
                "email VARCHAR(100) NOT NULL, " +
                "password VARCHAR(100) NOT NULL, " +
                "publicationsCount INTEGER, " +
                "follower INTEGER, " +
                "subscriptions INTEGER); " +

                "CREATE TABLE IF NOT EXISTS publications( " +
                "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY, " +
                "user_id INTEGER NOT NULL, " +
                "photo VARCHAR(100) NOT NULL, " +
                "description VARCHAR(100), " +
                "datetimeOfPublication VARCHAR(100) NOT NULL, " +
                "CONSTRAINT fk_user_id " +
                "FOREIGN KEY(user_id) " +
                "REFERENCES users(id))";
        String insertQuery = "INSERT INTO publications(user_id, photo, datetimeOfPublication) " +
                "VALUES(1, '/photo.jpeg', '13.02.2021'); " +
                "INSERT INTO users(nickname, name, email, password) " +
                "VALUES('BrianZ', 'Brian', 'BZran@gamil.com', '12345qwerty'); " +
                "INSERT INTO users(nickname, name, email, password) " +
                "VALUES('Axel', 'Max', 'MaxFlex@gamil.com', 'qwerty'); " +
                "INSERT INTO users(nickname, name, email, password) " +
                "VALUES('Lizzer', 'John', 'JoLiz@gamil.com', 'qwertyJo'); " +
                "INSERT INTO users(nickname, name, email, password) " +
                "VALUES('BGm', 'Mishel', 'Mishel@gamil.com', 'qwerty13'); ";
        executeUpdate(createTableQuery);
        executeUpdate(insertQuery);
    }

    public String shouldCreateTable(){
        try {
            createTables();
            dbService.getConnection().createStatement().execute("select * from users");
            return "All is OK";
        }catch (SQLException e){
            return e.getMessage();
        }
    }
    public String shouldSelectData(){
        try {
            String query = "select * from customers " +
                    "where name = ?";
            PreparedStatement statement = dbService.getConnection().prepareStatement(query);
            statement.setString(1, "Brian");
            if(statement.execute()){
                ResultSet resultSet = statement.getResultSet();
                resultSet.next();
                int age = resultSet.getInt("age");
                String name = resultSet.getString("name");
                return String.format("Age: %s \n Name: %s", age, name);
            }else {
                throw new SQLException();
            }
        }catch (SQLException e){
            return e.getMessage();
        }
    }

    public void shouldResultSet(){
        try {
            Statement statement = dbService.getConnection().createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE
            );
            ResultSet resultSet = statement.executeQuery("select * from customers");
            resultSet.moveToInsertRow();
            resultSet.updateLong("id", 3L);
            resultSet.updateString("name", "John");
            resultSet.updateInt("age", 18);
            resultSet.insertRow();
            resultSet.moveToCurrentRow();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public String getDataSourceConnection(){
        try (Connection connection = dbService.getConnection()){
            if(connection.isValid(1)){
                return "All is OK";
            }else {
                throw new SQLException("SQLException: Something went wrong");
            }
        }catch (SQLException e){
            return e.getMessage();
        }
    }

    public List<Customer> getCustomers(){
         return customerDAO.getAllCustomers();
    }
    public List<User> getUserByName(String name){
        return userDAO.getUserByName(name);
    }
    public List<User> getUserByNickname(String nickname){
        return userDAO.getUserByNickname(nickname);
    }
    public List<User> getUserByEmail(String email){
        return userDAO.getUserByEmail(email);
    }
    public Boolean isExist(String email){
        return userDAO.isUserExist(email);
    }
}
