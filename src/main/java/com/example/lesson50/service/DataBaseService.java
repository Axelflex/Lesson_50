package com.example.lesson50.service;

import com.example.lesson50.dao.CustomerDAO;
import com.example.lesson50.dao.PublicationDAO;
import com.example.lesson50.dao.UserDAO;
import com.example.lesson50.model.Customer;
import com.example.lesson50.model.Publication;
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
    private final PublicationDAO publicationDAO;

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
                "REFERENCES users(id)); " +

                "CREATE TABLE IF NOT EXISTS likes( " +
                "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY, " +
                "user_id INTEGER NOT NULL, " +
                "publication_id INTEGER NOT NULL, " +
                "datetimeOfLike VARCHAR(100) NOT NULL, " +
                "CONSTRAINT fk_user_id " +
                "FOREIGN KEY(user_id) " +
                "REFERENCES users(id), " +
                "CONSTRAINT fk_publication_id " +
                "FOREIGN KEY(publication_id) " +
                "REFERENCES publications(id)); " +

                "CREATE TABLE IF NOT EXISTS followers( " +
                "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY, " +
                "subscriber_id INTEGER NOT NULL, " +
                "ownerOfProfile_id INTEGER NOT NULL, " +
                "datetimeOfFollow VARCHAR(100) NOT NULL, " +
                "CONSTRAINT fk_subscriber_id " +
                "FOREIGN KEY(subscriber_id) " +
                "REFERENCES users(id), " +
                "CONSTRAINT fk_ownerOfProfile_id " +
                "FOREIGN KEY(ownerOfProfile_id) " +
                "REFERENCES users(id)); " +

                "CREATE TABLE IF NOT EXISTS comments( " +
                "id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY PRIMARY KEY, " +
                "user_id INTEGER NOT NULL, " +
                "publication_id INTEGER NOT NULL, " +
                "commentText VARCHAR(250) NOT NULL, " +
                "datetimeOfComment VARCHAR(100) NOT NULL, " +
                "CONSTRAINT fk_user_id " +
                "FOREIGN KEY(user_id) " +
                "REFERENCES users(id), " +
                "CONSTRAINT fk_publication_id " +
                "FOREIGN KEY(publication_id) " +
                "REFERENCES publications(id)) ";

        String insertQuery = "INSERT INTO publications(user_id, photo, datetimeOfPublication) " +
                "VALUES(1, '/photo.jpeg', '13.02.2021'); " +
                "INSERT INTO publications(user_id, photo, datetimeOfPublication) " +
                "VALUES(1, '/photo1.jpeg', '13.02.2022'); " +
                "INSERT INTO publications(user_id, photo, datetimeOfPublication) " +
                "VALUES(1, '/photo2.jpeg', '01.09.2022'); " +
                "INSERT INTO publications(user_id, photo, datetimeOfPublication) " +
                "VALUES(3, '/photo3.jpeg', '23.11.2021'); " +
                "INSERT INTO publications(user_id, photo, datetimeOfPublication) " +
                "VALUES(2, '/photo3.jpeg', '24.03.2021'); " +
                "INSERT INTO publications(user_id, photo, datetimeOfPublication) " +
                "VALUES(2, '/photo3.jpeg', '12.05.2021'); " +

                "INSERT INTO comments(user_id, publication_id, commentText, datetimeOfComment) " +
                "VALUES(1, 2, 'Hello World', '11.02.2021'); " +
                "INSERT INTO Comments(user_id, publication_id, commentText,datetimeOfComment) " +
                "VALUES(2, 1, 'Hello World2', '11.02.2021'); " +
                "INSERT INTO Comments(user_id, publication_id, commentText,datetimeOfComment) " +
                "VALUES(2, 3, 'Hello', '11.02.2021'); " +
                "INSERT INTO Comments(user_id, publication_id, commentText,datetimeOfComment) " +
                "VALUES(4, 2, 'Hello World', '11.02.2021'); " +
                "INSERT INTO Comments(user_id, publication_id, commentText,datetimeOfComment) " +
                "VALUES(4, 2, 'World Hello', '11.02.2021'); " +

                "INSERT INTO followers(subscriber_id, ownerOfProfile_id, datetimeOfFollow) " +
                "VALUES(1, 2, '11.02.2021'); " +
                "INSERT INTO Followers(subscriber_id, ownerOfProfile_id, datetimeOfFollow) " +
                "VALUES(3, 2, '11.02.2021'); " +
                "INSERT INTO Followers(subscriber_id, ownerOfProfile_id, datetimeOfFollow) " +
                "VALUES(4, 2, '11.02.2021'); " +
                "INSERT INTO Followers(subscriber_id, ownerOfProfile_id, datetimeOfFollow) " +
                "VALUES(2, 3, '11.02.2021'); " +

                "INSERT INTO likes(user_id, publication_id, datetimeOfLike) " +
                "VALUES(1, 1, '13.02.2021'); " +
                "INSERT INTO likes(user_id, publication_id, datetimeOfLike) " +
                "VALUES(2, 2, '13.02.2021'); " +
                "INSERT INTO likes(user_id, publication_id, datetimeOfLike) " +
                "VALUES(2, 2, '13.02.2021'); " +
                "INSERT INTO likes(user_id, publication_id, datetimeOfLike) " +
                "VALUES(3, 4, '13.02.2021'); ";

//                "INSERT INTO users(nickname, name, email, password) " +
//                "VALUES('BrianZ', 'Brian', 'BZran@gamil.com', '12345qwerty'); " +
//                "INSERT INTO users(nickname, name, email, password) " +
//                "VALUES('Axel', 'Max', 'MaxFlex@gamil.com', 'qwerty'); " +
//                "INSERT INTO users(nickname, name, email, password) " +
//                "VALUES('Lizzer', 'John', 'JoLiz@gamil.com', 'qwertyJo'); " +
//                "INSERT INTO users(nickname, name, email, password) " +
//                "VALUES('BGm', 'Mishel', 'Mishel@gamil.com', 'qwerty13'); ";
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

    public List<Publication> getAllPubs(){
        return publicationDAO.getAllPub();
    }
}
