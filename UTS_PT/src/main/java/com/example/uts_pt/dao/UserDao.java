package com.example.uts_pt.dao;

import com.example.uts_pt.model.User;
import com.example.uts_pt.util.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao implements DaoInterface<User> {

    @Override
    public ObservableList<User> getData() {
        ObservableList<User> users;
        users = FXCollections.observableArrayList();

        Connection conn = MyConnection.getConnection();
        String query = "Select * FROM User";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ResultSet result = ps.executeQuery();
            while (result.next()){
                String username = result.getString("UserName");
                String pw = result.getString("UserPassword");
                User user = new User(username,pw);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public void addData(User data) {
        Connection conn = MyConnection.getConnection();
        String query = "INSERT INTO user (UserName, UserPassword) VALUES (?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,data.getUsername());
            ps.setString(2,data.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean delData(User data) {
        Connection conn = MyConnection.getConnection();
        String query = "DELETE FROM user WHERE idUser = ?";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1,data.getIdUser());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    @Override
    public int updateData(User data) {
        return 0;
    }


}
