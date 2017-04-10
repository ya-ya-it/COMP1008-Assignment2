package assignment2;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dasha
 */
public class DetailsTodoController implements Initializable {

    @FXML
    private TextField nameField;
    @FXML
    private TextArea descriptionArea;
    @FXML
    private DatePicker dueDateDatePicker;
    @FXML
    private ComboBox importanceComboBox;

    @FXML
    private Button backButton;
    @FXML
    private Button addButton;

    @FXML
    private Label errorLabel;

    public void backButtonPushed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("TodosList.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    public boolean validateInputs() {

        if (nameField.getText().isEmpty() && descriptionArea.getText().isEmpty()
                && dueDateDatePicker.getValue() != null && importanceComboBox.getValue() != null) {
            errorLabel.setText("All fields must be filled");
            return false;
        } else {
            errorLabel.setText("");
            return true;
        }

    }

    public void addButtonPushed(ActionEvent event) throws IOException {
        if (validateInputs()) {
            try {
                String name = nameField.getText();
                String description = descriptionArea.getText();
                LocalDate dueDate = dueDateDatePicker.getValue();
                String importanceToString = importanceComboBox.getSelectionModel().toString();
                Todos.LevelOfImportance importance;
                if ("REALLY_IMPORTANT".equals(importanceToString)) {
                    importance = Todos.LevelOfImportance.REALLY_IMPORTANT;
                } else if ("IMPORTANT".equals(importanceToString)) {
                    importance = Todos.LevelOfImportance.IMPORTANT;
                } else {
                    importance = Todos.LevelOfImportance.NOT_IMPORTANT;
                }
                
                Todos newTodo = new Todos(name, description, dueDate, importance);
            } catch (NullPointerException ex) {
                errorLabel.setText("All fields must be filled");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        importanceComboBox.getItems().setAll(Todos.LevelOfImportance.values());
        errorLabel.setText("");
    }

}
