package com.spring.dao;

import com.spring.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private String jdbcURL = "jdbc:mysql://localhost:3306/user_info";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Amarsql";

    private static final String INSERT_USERS_SQL = "INSERT INTO user" + "(name, email, password) VALUES " + "(?,?,?);";

    private static final String SELECT_USER_BY_ID = "SELECT id,name,email FROM user WHERE id =?";
    private static final String SELECT_ALL_USERS = "SELECT * FROM user";
    private static final String DELETE_USERS_SQL = "DELETE FROM user WHERE id = ?;";
    private static final String UPDATE_USERS_SQL = "UPDATE user SET name = ?,email= ? WHERE id = ?;";

    public UserDao(){
    }

    protected Connection getConnection(){
        Connection connection = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
            System.out.println("Connected to Database!");
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }

    public void insertUser(User user) throws SQLException{
        System.out.println(INSERT_USERS_SQL);

        //TRY-WITH-RESOURCE STATEMENT WILL AUTO CLOSE THE CONNECTION.
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getEmail());
            preparedStatement.setString(3,user.getPassword());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    public User selectUser(int id){
        User user = null;

        //STEP 1: ESTABLISH A CONNECTION
        try(Connection connection = getConnection();

            //STEP 2: CREATE A STATEMENT USING CONNECTION OBJECT
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);){
                preparedStatement.setInt(1,id);
                System.out.println(preparedStatement);

                //STEP 3: EXECUTE THE QUERY OR UPDATE QUERY
            ResultSet rs = preparedStatement.executeQuery();

        //STEP 4: PROCESS THE RESULTSET OBJECT.
        while(rs.next()){
            String name = rs.getString("name");
            String email = rs.getString("email");
            String password = rs.getString("password");
            user = new User(id, name, email, password);
        }
    } catch(SQLException e){
        printSQLException(e);
    }
    return user;
 }

 public List<User> selectAllUsers(){

        //USING TRY-WITH-RESOURCES TO AVOID CLOSING RESOURCES(BOILER PLATE CODE)
     List<User> users = new ArrayList<>();

     //STEP 1: ESTABLISHING A CONNECTION
     try(Connection connection = getConnection();

         //STEP 2: CREATE A STATEMENT USING CONNECTION OBJECT
         PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);){
             System.out.println(preparedStatement);

            // STEP 3: EXECUTE THE QUERY OR UPDATE QUERY
            ResultSet rs = preparedStatement.executeQuery();

            //STEP 4: PROCESS THE RESULTSET OBJECT.
         while (rs.next()){
             int id = rs.getInt("id");
             String name = rs.getString("name");
             String email = rs.getString("email");
             String password = rs.getString("password");
             users.add(new User(id, name, email, password));
         }
         }
         catch (SQLException e){
             printSQLException(e);
         }
         return users;

 }

    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex){
        for(Throwable e: ex){
            if(e instanceof SQLException){
                e.printStackTrace(System.err);
                System.err.println("SQLState: "+ ((SQLException) e).getSQLState());
                System.err.println("Error Code: "+ ((SQLException) e).getErrorCode());
                System.err.println("Message: "+ e.getMessage());
                Throwable t = ex.getCause();
                while(t != null){
                    System.out.println("Cause: " + t);
                    t= t.getCause();
                }
            }
        }
    }

}

