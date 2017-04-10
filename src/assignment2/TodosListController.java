/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dasha
 */
public class TodosListController implements Initializable {

    @FXML
    private TableView<Todos> tableView;
    @FXML
    private TableColumn<Todos, String> todoColumn;
    @FXML
    private TableColumn<Todos, String> descriptionColumn;
    @FXML
    private TableColumn<Todos, LocalDate> dueDateColumn;
    @FXML
    private TableColumn<Todos, Todos.LevelOfImportance> importanceColumn;

    @FXML
    private Button doneButton;
    @FXML
    private Button addButton;

    public void changeNameCellEvent(CellEditEvent edittedCell) {
        Todos todoSelected = tableView.getSelectionModel().getSelectedItem();
        todoSelected.setName(edittedCell.getNewValue().toString());
    }

    public void userClickedOnTable() {
        this.doneButton.setDisable(false);
    }

    public void changeDescriptionCellEvent(CellEditEvent edittedCell) {
        Todos todoSelected = tableView.getSelectionModel().getSelectedItem();
        todoSelected.setDescription(edittedCell.getNewValue().toString());
    }

    public void addButtonPushed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DetailsTodo.fxml"));
        Parent tableViewParent = loader.load();

        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    public void doneButtonPushed() {
        ObservableList<Todos> selectedRows, allTodos;
        allTodos = tableView.getItems();

        selectedRows = tableView.getSelectionModel().getSelectedItems();

        for (Todos todo : selectedRows) {
            allTodos.remove(todo);
            todo.setIsDone();
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        todoColumn.setCellValueFactory(new PropertyValueFactory<Todos, String>("name"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Todos, String>("description"));
        dueDateColumn.setCellValueFactory(new PropertyValueFactory<Todos, LocalDate>("dueDate"));
        importanceColumn.setCellValueFactory(new PropertyValueFactory<Todos, Todos.LevelOfImportance>("importance"));

        tableView.setItems(getTodos());

        tableView.setEditable(true);
        todoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        descriptionColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        this.doneButton.setDisable(true);
    }

    public ObservableList<Todos> getTodos() {
        ObservableList<Todos> todos = FXCollections.observableArrayList();
        todos.add(new Todos("Assignment", "Finish this assignment in time",
                LocalDate.of(2017, Month.APRIL, 25), Todos.LevelOfImportance.REALLY_IMPORTANT));
        todos.add(new Todos("GitHub", "Finish this assignment in time",
                LocalDate.of(2017, Month.APRIL, 25), Todos.LevelOfImportance.IMPORTANT));
        return todos;
    }

}
