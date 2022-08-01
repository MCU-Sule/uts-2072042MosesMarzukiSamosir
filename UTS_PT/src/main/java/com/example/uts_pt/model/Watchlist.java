package com.example.uts_pt.model;

public class Watchlist {
    private int idWatchlist;
    private int LastWatch;
    private boolean fav;
    private Movie movie;
    private User user;

    @Override
    public String toString() {
        return idWatchlist + " " + LastWatch + fav + movie + user;
    }

    public Watchlist(int lastWatch,boolean fav, Movie movie, User user) {
        LastWatch = lastWatch;
        this.fav = fav;
        this.movie = movie;
        this.user = user;
    }

    public int getIdWatchlist() {
        return idWatchlist;
    }

    public void setIdWatchlist(int idWatchlist) {
        this.idWatchlist = idWatchlist;
    }

    public int getLastWatch() {
        return LastWatch;
    }

    public void setLastWatch(int lastWatch) {
        LastWatch = lastWatch;
    }

    public boolean isFav() {
        return fav;
    }

    public void setFav(boolean fav) {
        this.fav = fav;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
