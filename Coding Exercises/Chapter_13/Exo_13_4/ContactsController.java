// Fig. 13.14: CoverViewerController.java
// Controller for Cover Viewer application
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import javafx.scene.control.ListCell;

public class ContactsController {
   // instance variables for interacting with GUI
   @FXML private ListView<Contact> contactsListView;
   @FXML private TextField emailTextField;
   @FXML private TextField firstNameTextField;
   @FXML private TextField lastNameTextField;
   @FXML private TextField phoneNumberTextField;

   // stores the list of Book Objects
   private final ObservableList<Contact> contacts = 
      FXCollections.observableArrayList();

   // initialize controller
   public void initialize() {
      contacts.add(new Contact("Bob", "Foreman", "8002548984", "bforeman@relx.com", "/images/androidhtp.jpg"));
      contacts.add(new Contact("Alice", "Riedmon", "49859665", "aliried@gmail.com", "/images/chtp.jpg"));
      contacts.add(new Contact("Vannel", "Zeufi", "455668849", "vz@gmail.com", "/images/cpphtp.jpg"));
      contacts.add(new Contact("Yannick", "Yan", "2379958569", "yannick@gmail.com", "/images/iw3htp.jpg"));
      contacts.add(new Contact("Merlin", "Jaures", "2378954425", "merlin@gmail.com", "/images/jhtp.jpg"));
      contactsListView.setItems(contacts); // bind booksListView to books

      // when ListView selection changes, show large cover in ImageView
      contactsListView.getSelectionModel().selectedItemProperty().
         addListener(
            new ChangeListener<Contact>() {                                   
               @Override                                                     
               public void changed(ObservableValue<? extends Contact> ov,
                  Contact oldValue, Contact newValue) {                        
                  firstNameTextField.setText(newValue.getFirstName());
                  lastNameTextField.setText(newValue.getLastName());
                  phoneNumberTextField.setText(newValue.getPhoneNumber());
                  emailTextField.setText(newValue.getEmail());
               }
            }
         );
      
      // set custom ListView cell factory
      contactsListView.setCellFactory(
         new Callback<ListView<Contact>, ListCell<Contact>>() {
            @Override
            public ListCell<Contact> call(ListView<Contact> listView) {
               return new ImageTextCell();
            }
         }
      );                                                                 
   }     
}

/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
