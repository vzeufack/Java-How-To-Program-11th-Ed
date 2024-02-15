import javafx.collections.ObservableList;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.sql.SQLException;

public class LibraryController {
    @FXML private BorderPane borderPane;
    @FXML private TextArea queryTextArea;
    @FXML private GridPane addAuthorGridPane;
    @FXML private TextField firstNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private ComboBox<Author> authorComboBox;
    @FXML private Button authorSubmitBtn;
    private static final String DATABASE_URL = "jdbc:derby:books";
    private static final String USERNAME = "deitel";
    private static final String PASSWORD = "deitel";

    // default query retrieves all data from Authors table
    private static final String DEFAULT_QUERY = "SELECT * FROM authors";

    // used for configuring JTable to display and sort data
    private ResultSetTableModel tableModel;
    private TableRowSorter<TableModel> sorter;
    private final AuthorQueries authorQueries = new AuthorQueries();
    private javafx.collections.FXCollections FXCollections;
    private final ObservableList<Author> authorList = FXCollections.observableArrayList();

    private SwingNode swingNode;

    public void initialize() {
        queryTextArea.setText(DEFAULT_QUERY);

        try {
            tableModel = new ResultSetTableModel(DATABASE_URL, USERNAME, PASSWORD, DEFAULT_QUERY);
            JTable resultTable = new JTable(tableModel);
            sorter = new TableRowSorter<TableModel>(tableModel);
            resultTable.setRowSorter(sorter);

            swingNode = new SwingNode();
            swingNode.setContent(new JScrollPane(resultTable));
            borderPane.setCenter(swingNode);
        } catch (SQLException sqlException) {
            displayAlert(Alert.AlertType.ERROR, "Database Error",
                    sqlException.getMessage());
            tableModel.disconnectFromDatabase();
            System.exit(1);
        }

        authorComboBox.setItems(authorList);
        getAllAuthorEntries();
    }

    private void selectFirstAuthorEntry() {
        authorComboBox.getSelectionModel().selectFirst();
    }

    private void getAllAuthorEntries() {
        authorList.setAll(authorQueries.getAllAuthors());
        selectFirstAuthorEntry();
    }

    @FXML
    void displayAllAuthors(ActionEvent event){
        displayAllAuthors();
    }

    private void displayAllAuthors(){
        try {
            tableModel.setQuery("SELECT * FROM authors");
        }
        catch (SQLException sqlException) {
            displayAlert(Alert.AlertType.ERROR, "Database Error",
                    sqlException.getMessage());
            tableModel.disconnectFromDatabase(); // close connection
            System.exit(1); // terminate application
        }
    }

    @FXML
    void displayAllBooks(ActionEvent event){
        try {
            tableModel.setQuery("SELECT * FROM titles");
        }
        catch (SQLException sqlException) {
            displayAlert(Alert.AlertType.ERROR, "Database Error",
                    sqlException.getMessage());
            tableModel.disconnectFromDatabase(); // close connection
            System.exit(1); // terminate application
        }
    }
    @FXML
    void getBooks(ActionEvent event){
        int authorId = authorComboBox.getSelectionModel().getSelectedItem().getAuthorID();
        try {
            tableModel.setQuery("SELECT AuthorISBN.AuthorId, FirstName, LastName, AuthorISBN.ISBN, Title, editionNumber, copyright" +
                                " FROM Titles INNER JOIN AuthorISBN ON Titles.ISBN = AuthorISBN.ISBN AND AuthorISBN.authorId = " + authorId +
                                " INNER JOIN Authors ON Authors.AuthorId = AuthorISBN.AuthorId");
        }
        catch (SQLException sqlException) {
            displayAlert(Alert.AlertType.ERROR, "Database Error",
                    sqlException.getMessage());
            tableModel.disconnectFromDatabase(); // close connection
            System.exit(1); // terminate application
        }
    }

    // query the database and display results in JTable
    @FXML
    void submitQueryButtonPressed(ActionEvent event) {
        // perform a new query
        try {
            tableModel.setQuery(queryTextArea.getText());
        }
        catch (SQLException sqlException) {
            displayAlert(Alert.AlertType.ERROR, "Database Error",
                    sqlException.getMessage());

            // try to recover from invalid user query
            // by executing default query
            try {
                tableModel.setQuery(DEFAULT_QUERY);
                queryTextArea.setText(DEFAULT_QUERY);
            }
            catch (SQLException sqlException2) {
                displayAlert(Alert.AlertType.ERROR, "Database Error",
                        sqlException2.getMessage());
                tableModel.disconnectFromDatabase(); // close connection
                System.exit(1); // terminate application
            }
        }
    }

    @FXML
    void showAddAuthorGridPane(ActionEvent event){
        borderPane.setCenter(addAuthorGridPane);
        addAuthorGridPane.setVisible(true);
        authorSubmitBtn.setText("Add");
        firstNameTextField.setText("");
        lastNameTextField.setText("");
    }

    @FXML
    void addAuthor(ActionEvent event){
        int result;

        if(authorSubmitBtn.getText().equalsIgnoreCase("Add"))
            result = authorQueries.addAuthor(firstNameTextField.getText(), lastNameTextField.getText());
        else
            result = authorQueries.editAuthor(authorComboBox.getValue().getAuthorID(), firstNameTextField.getText(), lastNameTextField.getText());

        if (result != 1) {
            displayAlert(Alert.AlertType.ERROR, "Entry not processed","Unable to add/edit entry.");
        }

        borderPane.setCenter(swingNode);
        displayAllAuthors();
        getAllAuthorEntries();
    }

    @FXML
    void cancelAuthorCreation(ActionEvent event){
        borderPane.setCenter(swingNode);
        displayAllAuthors();
        getAllAuthorEntries();
    }

    @FXML
    void deleteAuthor(ActionEvent event) {
        int authorID = authorComboBox.getSelectionModel().getSelectedItem().getAuthorID();
        int result = authorQueries.deleteAuthor(authorID);

        if (result != 1) {
            displayAlert(Alert.AlertType.ERROR, "Entry Not Deleted","Unable to delete entry.");
        }

        borderPane.setCenter(swingNode);
        displayAllAuthors();
        getAllAuthorEntries();
    }

    @FXML
    void showEditAuthorGridPane(ActionEvent event){
        borderPane.setCenter(addAuthorGridPane);
        addAuthorGridPane.setVisible(true);
        authorSubmitBtn.setText("Edit");

        Author current = authorComboBox.getValue();
        firstNameTextField.setText(current.getFirstName());
        lastNameTextField.setText(current.getLastName());
    }

    private void displayAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
