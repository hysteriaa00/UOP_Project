/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uop;

import java.awt.geom.Rectangle2D;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import uop.Repository.UserRepo;

/**
 *
 * @author caplj
 */
public class UOP extends Application {

    private static Stage pStage;

    public static Stage getPrimaryStage() {
        return pStage;
    }

    public static void callResize() {
        javafx.geometry.Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        pStage.sizeToScene();
        pStage.setX((screenBounds.getWidth() - pStage.getWidth()) / 2);
        pStage.setY((screenBounds.getHeight() - pStage.getHeight()) / 2);
    }

     public static Object switchScene(String resPath) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(UOP.class.getResource(resPath));

        Parent view = loader.load();

        // change scene
        pStage.getScene().setRoot(view);
        return loader.getController();
    }
    @Override
    public void start(Stage stage) throws Exception {
        pStage = stage;

        Parent root = FXMLLoader.load(getClass().getResource("FXML/FXMLDocument.fxml"));

        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
