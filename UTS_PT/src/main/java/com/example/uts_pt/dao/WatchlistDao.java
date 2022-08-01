package com.example.uts_pt.dao;

import com.example.uts_pt.model.Movie;
import com.example.uts_pt.model.User;
import com.example.uts_pt.model.Watchlist;
import com.example.uts_pt.util.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WatchlistDao implements DaoInterface{

    @Override
    public ObservableList<Watchlist> getData() {
        ObservableList<Watchlist> watchlists;
        watchlists = FXCollections.observableArrayList();

        Connection conn = MyConnection.getConnection();
        String query = "select movie.Title,watchlist.LastWatch, watchlist.Favorite,watchlist.Movie_idMovie, watchlist.User_idUser,movie.Title, movie.Genre, movie.Durasi, user.UserName, user.UserPassword  FROM watchlist \n" +
                "Join user on watchlist.User_idUser  = user.idUser\n" +
                "join movie on watchlist.Movie_idMovie = movie.idMovie";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(query);
            ResultSet result = ps.executeQuery();
            while (result.next()){
                int lastwatch = result.getInt("LastWatch");
                boolean fav = result.getBoolean("Favorite");
                int idm = result.getInt("Movie_idMovie");
                String title = result.getString("Title");
                String genre = result.getString("Genre");
                int durasi = result.getInt("Durasi");
                String username = result.getString("UserName");
                String pass = result.getString("UserPassword");
                Movie idmov = new Movie(idm,title,genre,durasi);
                User iduser = new User(username,pass);
                Watchlist wl = new Watchlist(lastwatch,fav,idmov,iduser);
                watchlists.add(wl);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return watchlists;
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
