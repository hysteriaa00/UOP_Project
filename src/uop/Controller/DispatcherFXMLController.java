/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uop.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import uop.Model.Driver;
import uop.Repository.DriverRepo;

/**
 * FXML Controller class
 *
 * @author caplj
 */
public class DispatcherFXMLController implements Initializable {

    @FXML
    private TableView<Driver> driverTable;
    @FXML
    private TableColumn<Driver, Long> salaryColumn;
    @FXML
    private TableColumn<Driver, String> membershipCardColumn;
    @FXML
    private TableColumn<Driver, String> fullNameColumn;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
        membershipCardColumn.setCellValueFactory(new PropertyValueFactory<>("membershipCard"));
        fullNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        try {
            driverTable.setItems(FXCollections.observableArrayList(DriverRepo.findAll()));
            
        } catch (IOException ex) {
            Logger.getLogger(DispatcherFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
