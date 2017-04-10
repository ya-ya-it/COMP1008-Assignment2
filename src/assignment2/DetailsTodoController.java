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
 * @author Daria Davydenko
 * Student number: 200335788
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

    /**
     * This method changes scene to Todo List when Back button is pushed.
     *
     * @param event
     * @throws IOException
     */
    public void backButtonPushed(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("TodosList.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    /**
     * This method validate is the fields is empty. If it is empty, error label
     * will be set.
     *
     * @return
     */
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

    /**
     * This method save new todo, set it to the table and return to Todo list
     * page.
     *
     * @param event
     * @throws IOException
     */
    public void addButtonPushed(ActionEvent event) throws IOException {
        if (validateInputs()) {
            try {
                String name = nameField.getText();
                String description = descriptionArea.getText();
                try {
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

                    Todos todo = new Todos(name, description, dueDate, importance);

                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("TodosList.fxml"));
                    Parent tableViewParent = loader.load();

                    Scene tableViewScene = new Scene(tableViewParent);

                    TodosListController controller = loader.getController();
                    controller.addToTable(todo);

                    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                    window.setScene(tableViewScene);
                    window.show();
                } catch (IllegalArgumentException ex) {
                    errorLabel.setText("You can't change anything in your past. Sorry :c");
                }

            } catch (NullPointerException ex) {
                errorLabel.setText("All fields must be filled");
            }
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        importanceComboBox.getItems().setAll(Todos.LevelOfImportance.values());
        errorLabel.setText("");
    }

}
