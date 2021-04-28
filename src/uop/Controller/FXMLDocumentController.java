/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uop.Controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import uop.Model.Role;
import uop.Model.User;
import uop.Repository.UserRepo;
import uop.UOP;
import uop.Util.LoggedUser;

/**
 *
 * @author caplj
 */
public class FXMLDocumentController {
    
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField pwField;
    @FXML
    private Label warningLoginLabel;

    public void tryToLoginAction() throws Exception {
        final Optional<User> user = UserRepo.findByUsernameAndPassword(usernameField.getText().trim(), pwField.getText().trim());
        if (user.isPresent()) {
            final User userGot = user.get();
            LoggedUser.setCurrentUser(userGot);

            UOP.getPrimaryStage().hide();
            String path = null;
            if (null!=userGot.getRole()) switch (userGot.getRole()) {
                case CONSUMER:
                    path = "FXML/ConsumerFXML.fxml";
                    break;
                case DRIVER:
                    path = "FXML/DriverFXML.fxml";
                    break;
                case DISPATCHER:
                    path = "FXML/DispatcherFXML.fxml";
                    break;
                default:
                    break;
            }
            String finalPath = path;
            UOP.switchScene(finalPath);
            Platform.runLater(() -> {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ignored) {
                }
                UOP.callResize();
            });
            UOP.getPrimaryStage().show();

        } else {
            warningLoginLabel.setTextFill(Color.RED);
            warningLoginLabel.setText("Neispravno korisničko ime ili lozinka!");
        }
    }


    public void MouseClickResetWarning() {
        warningLoginLabel.setText("");
    }
}
