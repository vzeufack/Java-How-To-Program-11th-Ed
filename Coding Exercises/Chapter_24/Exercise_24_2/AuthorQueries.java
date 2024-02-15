// Fig. 24.31: PersonQueries.java
// PreparedStatements used by the Address Book application.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class AuthorQueries {
    private static final String URL = "jdbc:derby:books";
    private static final String USERNAME = "deitel";
    private static final String PASSWORD = "deitel";

    private Connection connection;
    private PreparedStatement selectAllAuthors;
    private PreparedStatement insertNewAuthor;
    private PreparedStatement deleteAuthor;
    private PreparedStatement editAuthor;

    // constructor
    public AuthorQueries() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            selectAllAuthors = connection.prepareStatement("SELECT * FROM authors");

            insertNewAuthor = connection.prepareStatement(
                    "INSERT INTO authors (FirstName, LastName) VALUES (?, ?)");
            deleteAuthor = connection.prepareStatement("DELETE FROM authors where AuthorID = ?");
            editAuthor = connection.prepareStatement("UPDATE authors SET FirstName = ?, LastName = ? WHERE AuthorID = ?");
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        }
    }

    public List<Author> getAllAuthors() {
        // executeQuery returns ResultSet containing matching entries
        try (ResultSet resultSet = selectAllAuthors.executeQuery()) {
            List<Author> results = new ArrayList<Author>();

            while (resultSet.next()) {
                results.add(new Author(
                        resultSet.getInt("AuthorID"),
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName")));
            }

            return results;
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return null;
    }

    // add an entry
    public int addAuthor(String firstName, String lastName) {
        try {
            insertNewAuthor.setString(1, firstName);
            insertNewAuthor.setString(2, lastName);

            return insertNewAuthor.executeUpdate();
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return 0;
        }
    }

    public int editAuthor(int authorId, String firstName, String lastName) {
        try {
            editAuthor.setString(1, firstName);
            editAuthor.setString(2, lastName);
            editAuthor.setInt(3, authorId);

            return editAuthor.executeUpdate();
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return 0;
        }
    }

    public int deleteAuthor(int authorID){
        try {
            deleteAuthor.setInt(1, authorID);

            return deleteAuthor.executeUpdate();
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return 0;
        }
    }

    // close the database connection
    public void close() {
        try {
            connection.close();
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}

