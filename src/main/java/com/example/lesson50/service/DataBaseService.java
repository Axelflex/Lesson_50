package com.example.lesson50.service;

import com.example.lesson50.dao.CustomerDAO;
import com.example.lesson50.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DataBaseService {
    private final DataBaseConnectivityService dbService;
    private final CustomerDAO customerDAO;

    private int executeUpdate(String query) throws SQLException{
        Statement statement = dbService.getConnection().createStatement();
        return statement.executeUpdate(query);
    }

    private void createCustomerTable() throws SQLException {
        String createTableQuery = "CREATE TABLE customers( " +
                "id INTEGER PRIMARY KEY, " +
                "name TEXT, " +
                "age INTEGER)";
        String insertQuery = "INSERT INTO customers " +
                "VALUES(73, 'Brian', 33)";

        executeUpdate(createTableQuery);
        executeUpdate(insertQuery);
    }

    public String shouldCreateTable(){
        try {
            createCustomerTable();
            dbService.getConnection().createStatement().execute("select * from customers");
            return "All it's OK";
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
}
