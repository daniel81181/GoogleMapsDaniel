package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class NavigationBar2 extends HBox{
	String dir1;
	String dir2;
	
	public NavigationBar2(WebView webView,String homePageUrl,boolean goToHomePage ){
		this.setSpacing(4);
		
		this.setStyle("-fx-padding: 10"+
		            "-fx-borde-style: solid inside;"+
				"-fx-border-width:2;"+
		            "-fx-border-insets: 5;"+
		            "-fx-border-radius: 5;"+
			        "-fx-border-color:turquoise;");
		
	Label label=new Label("From:");
	Label label1=new Label("To:");
	
	WebEngine webEngine= webView.getEngine();
	
	TextField fromPlace=new TextField();
	TextField toPlace=new TextField();
	
	Button searchBtn=new Button("Search");
	Button goBackBtn=new Button("Go Back");
	
	HBox.setHgrow(fromPlace, Priority.ALWAYS);
	HBox.setHgrow(toPlace,Priority.ALWAYS);

	goBackBtn.setOnAction(new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent event)
        {
            webEngine.load(homePageUrl);
        }
    });
	
	searchBtn.setOnAction(new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent event)
        
        {
            dir1=fromPlace.getText();
            dir2=toPlace.getText();
            webEngine.load("https://google.com/maps/dir/"+dir1+"/"+dir2);
        }
    });
    // Add the Children to the Navigation Bar
    this.getChildren().addAll(label, fromPlace,label1,toPlace,searchBtn,goBackBtn);
     
    if (goToHomePage) 
    {
        // Load the URL
        webEngine.load(homePageUrl);
    }
	}
	
	
}
