package com.example.uts_pt.dao;

import com.example.uts_pt.model.Movie;
import com.example.uts_pt.util.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieDao implements DaoInterface {


    @Override
    public ObservableList<Movie> getData() {
        ObservableList<Movie> movies;
        movies = FXCollections.observableArrayList();

        Connection conn = MyConnection.getConnection();
        String query = "SELECT * FROM Movie";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ResultSet result = ps.executeQuery();
            while (result.next()){
                int id = result.getInt("idMovie");
                String title = result.getString("Title");
                String genre = result.getString("Genre");
                int durasi = result.getInt("Durasi");
                Movie movie = new Movie(id,title,genre,durasi);
                movies.add(movie);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return movies;
    }

    @Override
    public void addData(Object data) {

    }

    @Override
    public boolean delData(Object data) {
        return false;
    }

    @Override
    public int updateData(Object data) {
        return 0;
    }
}
