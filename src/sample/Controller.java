package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    ObservableList<Contact> contacts = FXCollections.observableArrayList();

    @FXML
    TextField name, phone, email;

    @FXML
    ListView list;

    public void onAdd() {
        Contact person = new Contact(name.getText(), phone.getText(), email.getText());
        if (!name.getText().isEmpty() && !phone.getText().isEmpty() && !email.getText().isEmpty()) {
            contacts.add(person);
            name.clear();
            phone.clear();
            email.clear();
        }
    }

    public void onRemove() {
        SelectionModel model = list.getSelectionModel();
        Contact person = (Contact) model.getSelectedItem();
        contacts.remove(person);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(contacts);
    }
}
