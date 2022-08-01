package com.example.uts_pt.controller;

import com.example.uts_pt.dao.UserDao;
import com.example.uts_pt.model.User;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class SecondController {
    public TextField txtUserName;
    public PasswordField txtPassword;
    public Button btnSubmit;

    ObservableList<User>userObservableList;

    public void clear (){
        txtUserName.clear();
        txtPassword.clear();
    }
    public void submit(ActionEvent event) {
        UserDao userDao = new UserDao();
        userObservableList = userDao.getData();
        if (txtUserName.getText().isEmpty()|| txtPassword.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR, "please fill in all the field", ButtonType.OK);
            alert.showAndWait();
        }else {
            userDao.addData(new User(txtUserName.getText(),txtPassword.getText()));
            userObservableList = userDao.getData();
            clear();
            btnSubmit.getScene().getWindow().hide();
        }
    }
}
