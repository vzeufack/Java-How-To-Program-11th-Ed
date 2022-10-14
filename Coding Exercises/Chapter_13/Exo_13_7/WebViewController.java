import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;
import javafx.scene.web.WebEngine;

public class WebViewController {

    @FXML
    private TextField urlTextField;

    @FXML
    private WebView webView;
    
    private WebEngine engine;
    
    private String homePage;
    
    public void initialize() {
      engine = webView.getEngine();
      homePage = "www.google.com";
      urlTextField.setText(homePage);
      load();
    }

    @FXML
    public void load() {
      engine.load("http://" + urlTextField.getText());
    }
    
    @FXML
    public void refresh(){
      engine.reload();
    }

}