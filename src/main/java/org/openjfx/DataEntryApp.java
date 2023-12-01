package org.openjfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class DataEntryApp {

    public void showDataEntry(Stage stage) {
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
        Text scenetitle = new Text("Dependent Addition Form");
    	scenetitle.setFont(Font.font("Verdana", FontWeight.BOLD, 36));
    	GridPane.setConstraints(scenetitle, 0, 5);
    	grid.getChildren().add(scenetitle);
    	
    	Text dependentText = new Text("Dependent's Information Section");
    	dependentText.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
    	//dependentText.setFill(Color.RED);
    	GridPane.setConstraints(dependentText,0, 10);
    	grid.getChildren().add(dependentText);
    	
    	Button back = new Button("Back");
    	GridPane.setConstraints(back, 0,61);
    	grid.getChildren().add(back);
    	
    	
        //
    	grid = dependentName(grid);
    	grid = dependentDOB(grid);
    	grid = dependentAddress(grid);
    	grid = dependentAlien(grid);
    	//

    	
    	Text appText = new Text("Applicant's Information Section");
    	appText.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
    	//appText.setFill(Color.RED);
    	GridPane.setConstraints(appText,0, 34);
    	grid.getChildren().add(appText);
    	//
    	grid = appName(grid);
    	grid = appAlien(grid);
    	grid = appEmail(grid);
    	//
    	
    	submission(grid);
    	
    
    	
    	back.setOnAction((ActionEvent e) -> {
    		
        	App app = new App();
			app.start(stage);
    		
    	
    	});
    	
    	
    	
    	
    }
    
   
    public GridPane dependentName(GridPane grid) {
    	Text nameText = new Text("Name:");
    	nameText.setFont(Font.font("Verdana", FontWeight.NORMAL, 13));
    	GridPane.setConstraints(nameText, 0, 14);
    	grid.getChildren().add(nameText);
        
    	final TextField name = new TextField();
    	name.setPromptText("First Name, Last Name");
    	GridPane.setConstraints(name, 0, 15);
    	grid.getChildren().add(name);
    	
    	return grid;
    }
  
    public GridPane dependentDOB(GridPane grid) {
    	Text dobText = new Text("Date of Birth:");
    	dobText.setFont(Font.font("Verdana", FontWeight.NORMAL, 13));
    	GridPane.setConstraints(dobText, 0, 19);
    	grid.getChildren().add(dobText);
    	
    	final TextField dob = new TextField();
    	dob.setPromptText("MM/DD/YYYY");
    	GridPane.setConstraints(dob, 0, 20);
    	grid.getChildren().add(dob);
    	
    	return grid;
    }

    public GridPane dependentAddress(GridPane grid) {
    	Text addrText = new Text("Address:");
    	addrText.setFont(Font.font("Verdana", FontWeight.NORMAL, 13));
    	GridPane.setConstraints(addrText, 0, 24);
    	grid.getChildren().add(addrText);
    	
    	final TextField addr = new TextField();
    	addr.setPromptText("Street Address, City, State, ZIP Code");
    	GridPane.setConstraints(addr, 0, 25);
    	grid.getChildren().add(addr);
    	
    	return grid;
    }
    
    public GridPane dependentAlien(GridPane grid) {
    	Text alienText = new Text("Alien Number:");
    	alienText.setFont(Font.font("Verdana", FontWeight.NORMAL, 13));
    	GridPane.setConstraints(alienText, 0, 29);
    	grid.getChildren().add(alienText);
    	
    	final TextField alienNum = new TextField();
    	GridPane.setConstraints(alienNum, 0, 30);
    	grid.getChildren().add(alienNum);
    	
    	return grid;
    }
    
    public GridPane appName(GridPane grid) {
    	Text appNameText = new Text("Name:");
    	appNameText.setFont(Font.font("Verdana", FontWeight.NORMAL, 13));
    	GridPane.setConstraints(appNameText, 0, 38);
    	grid.getChildren().add(appNameText);
        
    	final TextField appName = new TextField();
    	appName.setPromptText("First Name, Last Name");
    	GridPane.setConstraints(appName, 0, 39);
    	grid.getChildren().add(appName);
    	
    	return grid;
    }
    
    public GridPane appAlien(GridPane grid) {
    	Text appAlienText = new Text("Alien Number:");
    	appAlienText.setFont(Font.font("Verdana", FontWeight.NORMAL, 13));
    	GridPane.setConstraints(appAlienText, 0, 43);
    	grid.getChildren().add(appAlienText);
    	
    	final TextField appAlienNum = new TextField();
    	GridPane.setConstraints(appAlienNum, 0, 44);
    	grid.getChildren().add(appAlienNum);
    	
    	return grid;
    	
    }
    
    public GridPane appEmail(GridPane grid) {
    	Text appEmailText = new Text("Email Address:");
    	appEmailText.setFont(Font.font("Verdana", FontWeight.NORMAL, 13));
    	GridPane.setConstraints(appEmailText, 0, 48);
    	grid.getChildren().add(appEmailText);
    	
    	final TextField appEmail = new TextField();
    	GridPane.setConstraints(appEmail, 0, 49);
    	grid.getChildren().add(appEmail);
    	
    	return grid;
    }
    
    public void submission(GridPane grid) {
    	//Defining the Submit button
    	Button submit = new Button("Submit Form");
    	GridPane.setConstraints(submit, 0,57);
    	grid.getChildren().add(submit);
    	
    	
    	final Label label = new Label();
    	GridPane.setConstraints(label, 0, 58);
    	GridPane.setColumnSpan(label, 2);
    	label.setTextFill(Color.RED);
    	label.setFont(Font.font("Verdana", FontWeight.MEDIUM, 13));
    	grid.getChildren().add(label);
    	
    	submit.setOnAction((ActionEvent e) -> {
        	boolean missing = false;
        	boolean invalid = false;
    	    for(int i = 0; i < grid.getChildren().size(); i++) {
    	    	if(grid.getChildren().get(i).getClass() == TextField.class) {
    	    		TextField value = (TextField)grid.getChildren().get(i);
    	    		if(value.getText() == null || (value.getText().isEmpty() == true)){
    	    			//label.setText("One or more fields are empty");
    	    			missing = true;
    	    		}
    	    	}
    	    }
    	    
    	    
    	    try {
    	    	String dob = ((TextField)grid.getChildren().get(6)).getText();
    	    	String depAlienNum = ((TextField)grid.getChildren().get(10)).getText();
    	    	String appAlienNum = ((TextField)grid.getChildren().get(15)).getText();
    	    	String appEmail = ((TextField)grid.getChildren().get(17)).getText();
    	    	int alien_num;
        	    if(dob.length() != 10 || (dob.contains("/") == false))
        	    	invalid = true;
        	    alien_num = Integer.parseInt(appAlienNum);
        	    alien_num = Integer.parseInt(depAlienNum);
        	    if(appEmail.contains("@") == false)
        	    	invalid = true;
        	    
    	    }
    	    catch(Exception a) {
    	    	invalid = true;
    	    }
    	    if(invalid && missing)
    	    	label.setText("Invalid format option for one of the fields, and one of the fields is empty.");
    	    else if(invalid)
    	    	label.setText("Invalid format option for one of the fields");
    	    else if(missing)
    	    	label.setText("One of more fields are empty");
    	    else if (!missing && !invalid) {
    	    	label.setText("Thank you for submitting the form!\nAn email will be sent to the applicant upon approval.");
    	    	createDep(grid);
    	    }
    	    	
    	    //if(!missing) {
    	    //	label.setText("Thank you for submitting the form!\nAn email will be sent to the applicant upon approval.");
    	    //	createDep(grid);
    	    //}
    	    	
    	});
    	
    }
    
    

    
    
    
    
    public void createDep(GridPane grid) {
    	String name, dob, address, alienNum, appName, appAlienNum, appEmail;
    	/*
    	 * DepName = 4
    	 * DepDOB = 6
    	 * DepAddress = 8
    	 * DepAlienNum = 10
    	 * Appname = 13
    	 * AppAlienNum = 15
    	 * appEmail = 17
    	 * 
    	 */
    	/// CAN GET RID OF THE LOOP OR JUST COMMENT IT OUT BECAUSE IT HELPS FIND THE INDICES
    	//String texts = "";
    	final Label label2 = new Label();
    	GridPane.setConstraints(label2, 0, 60);
    	GridPane.setColumnSpan(label2, 2);
    	label2.setTextFill(Color.RED);
    	label2.setFont(Font.font("Verdana", FontWeight.MEDIUM, 13));
    	grid.getChildren().add(label2);
    	for(int i = 0; i < grid.getChildren().size(); i++) {
	    	if(grid.getChildren().get(i).getClass() == TextField.class) {
	    		TextField value = (TextField)grid.getChildren().get(i);
	    		//texts += "\n" + value.getText() + i;
	    		
	    	}
	    }
    	//label2.setText(texts);
    	name = ((TextField)grid.getChildren().get(4)).getText();
    	dob = ((TextField)grid.getChildren().get(6)).getText();
    	address = ((TextField)grid.getChildren().get(8)).getText();
    	alienNum = ((TextField)grid.getChildren().get(10)).getText();
    	appName = ((TextField)grid.getChildren().get(13)).getText();
    	appAlienNum = ((TextField)grid.getChildren().get(15)).getText();
    	appEmail = ((TextField)grid.getChildren().get(17)).getText();
    	
    		DependentAddition dependent = DependentAddition.dependentCreation(name,dob,
    			address,alienNum,appName,appAlienNum,appEmail);
    	}
    	//label2.setText(DependentAddition.database.toString());
    	//System.out.println("Database\n "+ DependentAddition.database.toString());
    	
    	
    	
    
    
   
}