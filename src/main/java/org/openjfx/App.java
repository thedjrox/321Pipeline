package org.openjfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class App extends Application{
	
	
	protected static Stage homeStage;
	
	 public void start(Stage stage) {
	    	/*
	        var javaVersion = SystemInfo.javaVersion();
	        var javafxVersion = SystemInfo.javafxVersion();

	        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
	        var scene = new Scene(new StackPane(label), 640, 480);
	        stage.setScene(scene);
	        stage.show();
	        */
	        
	        
	        // Creates the page to pop up empty
	    	GridPane grid = new GridPane();
	        grid.setAlignment(Pos.BASELINE_CENTER);
	        grid.setHgap(5);
	        grid.setVgap(5);
	        grid.setPadding(new Insets(25, 25, 25, 25));

	        Scene scene1 = new Scene(grid, 600, 720);
	        
	        stage.setScene(scene1);
	        stage.show();
	        
	        
	        // Title text
	        Text scenetitle = new Text("Dependent Addition Home Page");
	    	scenetitle.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
	    	GridPane.setConstraints(scenetitle, 0, 5);
	    	grid.getChildren().add(scenetitle);
	    	
	    	
	    	
	        //
	    	Button entry = DataEntryButton(grid);
	    	Button r  = ReviewButton(grid);
	    	Button a = ApprovalButton(grid);
	    	
	    	homeStage = stage;
	    	

	    	
	    	entry.setOnAction((ActionEvent e) -> {
	    		DataEntryApp obj  = new DataEntryApp();
	    		obj.showDataEntry(stage);
	    		    		
	    	});
	    	
	    	r.setOnAction((ActionEvent e) -> {
	    		ReviewApp obj  = new ReviewApp();
	    		obj.showReview(stage);
	    		    		
	    	});
	    	
	    	a.setOnAction((ActionEvent e) -> {
	    		ApprovalApp obj  = new ApprovalApp();
	    		obj.showApproval(stage);
	    		    		
	    	});
	    	
	    	
	  
	 }
	 
	 public  Button DataEntryButton(GridPane grid) {
	    	//Defining the Edit button
	    	Button dataEntry = new Button();
	    	dataEntry.setText("Data Entry");
	    	
	    	//dataEntry.setAlignment(Pos.CENTER);
	    	GridPane.setConstraints(dataEntry, 0,20);

	    	grid.getChildren().add(dataEntry);
	    	
	    	DropShadow shadow = new DropShadow();
	    	//Adding the shadow when the mouse cursor is on
	    	dataEntry.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
	    		dataEntry.setEffect(shadow);
	    	});
	    	 
	    	//Removing the shadow when the mouse cursor is off
	    	dataEntry.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
	    		dataEntry.setEffect(null);
	    	}); 
	    	
	    	dataEntry.setTextFill(Color.BLACK);

	    	
	    	return dataEntry;
	    		
	    	
	    }
	 
	 
	 public  Button ReviewButton(GridPane grid) {
	    	//Defining the Edit button
	    	Button review = new Button();
	    	review.setText("Reviewer");

	    	GridPane.setConstraints(review, 0,35);
	    	grid.getChildren().add(review);
	    	
	    	DropShadow shadow = new DropShadow();
	    	//Adding the shadow when the mouse cursor is on
	    	review.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
	    	    review.setEffect(shadow);
	    	});
	    	 
	    	//Removing the shadow when the mouse cursor is off
	    	review.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
	    	    review.setEffect(null);
	    	}); 
	    	
	    	review.setTextFill(Color.BLACK);

	    	
	    	return review;
	    		
	    	
	    }
	 
	 
	public  Button ApprovalButton(GridPane grid) {
	    	//Defining the Edit button
	    	Button approval = new Button();
	    	approval.setText("Approval");

	    	GridPane.setConstraints(approval, 0, 50);
	    	grid.getChildren().add(approval);
	    	
	    	DropShadow shadow = new DropShadow();
	    	//Adding the shadow when the mouse cursor is on
	    	approval.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
	    		approval.setEffect(shadow);
	    	});
	    	 
	    	//Removing the shadow when the mouse cursor is off
	    	approval.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
	    		approval.setEffect(null);
	    	}); 
	    	
	    	approval.setTextFill(Color.BLACK);

	    	
	    	return approval;
	    		
	}
	 
	 
	 
	 public static void main(String[] args) {
	        launch();
	    }

	 
	 
	 
	 
	 
	 
	 
	

}
	 
	 
	 

	 
