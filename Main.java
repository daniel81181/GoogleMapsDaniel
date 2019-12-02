package application;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
 
public class Main extends Application
{
    public static void main(String[] args) 
    {
        Application.launch(args);
    }
     
    @Override
    public void start(final Stage stage) 
    {
        WebView webView = new WebView();
     
        String homePageUrl = "http://www.google.com/maps";

        NavigationBar2 navigationBar = new NavigationBar2(webView, homePageUrl, true);

        VBox root = new VBox(navigationBar, webView);
         
 root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
         
Scene scene = new Scene(root);

stage.setScene(scene);

        stage.show();       
    }
}