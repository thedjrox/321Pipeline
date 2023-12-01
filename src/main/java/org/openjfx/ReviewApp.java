package org.openjfx;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * JavaFX Review App
 */
public class ReviewApp {

	
	public DependentAddition BO;
	public GridPane grid;
	public static DependentAddition b1;
	//boolean valid;
	//boolean check;
	private TextField dobField;
	private TextField nameField;
	private TextField addrField;
	private TextField alienNumField;
	private TextField appNameField;
	private TextField appAlienField;
	private TextField appEmailField;
	
	
	/**
	 * CODE IS SIMILAR TO THAT OF DATA ENTRY APP, AND WAS USED FROM DATA ENTRY BUT NOT COPY AND PASTED
	 * The start method will display the page that can be exited
	 * will call all the textfield and button methods 
	 */
    public void showReview(Stage stage) {
    	
        
    // DependentAddition b1 = DependentAddition.dependentCreation("Emil y", "11/1/2000", "wiedweid" , "45309687", 
             //    "Will", "123456789", "rjkfnerjf@email.com");
 	//System.out.println("Before Edit:" + b1.getName());

 	   
 	 
    	
    	//System.out.println(b1.getFormNumber());
       //b1 = createDep();
        // System.out.println("Before Edit:" + b1.getDateOfBirth());
        //page is created
    	grid = new GridPane();
    	
        grid.setHgap(2);
        grid.setVgap(2);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene reviewScreen = new Scene(grid, 600, 720);
        stage.setScene(reviewScreen);
        stage.show();
        
        
        //create title of form
       /* Text heading = new Text();
        heading.setText("Dependent Addition Form:");
        GridPane.setConstraints(heading, 20 , 0);
    	heading.setFont(Font.font("Arial", FontWeight.BOLD, 30));
    	
    	grid.getChildren().add(heading);
    	
    	//create dependent information section
    	Text dependentSection = new Text();
    	dependentSection.setText("Dependent's Information Section:");
    	GridPane.setConstraints(dependentSection,20, 8);
    	dependentSection.setFont(Font.font("Arial", FontWeight.BOLD, 15));

    
    	grid.getChildren().add(dependentSection);
    	
       //create applicant information section
    	Text appSection = new Text();
    	appSection.setText("Applicant's Information Section:");
    	GridPane.setConstraints(appSection, 20, 24);
    	appSection.setFont(Font.font("Arial", FontWeight.BOLD, 15));
    

    	grid.getChildren().add(appSection);*/
    	
    	//back button
    	Button back = new Button("Back");
    	GridPane.setConstraints(back, 0,62);
    	grid.getChildren().add(back);

    	if(!(DependentAddition.wf.getReviewStack().isEmpty())) {
    		
    		//create title of form
            Text heading = new Text();
            heading.setText("Dependent Addition Form:");
            GridPane.setConstraints(heading, 20 , 0);
        	heading.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        	
        	grid.getChildren().add(heading);
        	
        	//create dependent information section
        	Text dependentSection = new Text();
        	dependentSection.setText("Dependent's Information Section:");
        	GridPane.setConstraints(dependentSection,20, 8);
        	dependentSection.setFont(Font.font("Arial", FontWeight.BOLD, 15));

        
        	grid.getChildren().add(dependentSection);
        	
           //create applicant information section
        	Text appSection = new Text();
        	appSection.setText("Applicant's Information Section:");
        	GridPane.setConstraints(appSection, 20, 24);
        	appSection.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        

        	grid.getChildren().add(appSection);
    		
    		int formNum = DependentAddition.wf.getNextItem("Reviewer");
    		//System.out.println("Form num:" + formNum);
 	   		b1 = DependentAddition.getDependentFromDB_FormNumber(formNum);
 	   		//b1 = createDep();
 	   		
 	   	
 	   		//methods are called to create textboxs to fill out personal info
 	   		grid = NameofDependent(grid);
 	   		grid = dependentDOB(grid);
 	   		grid = dependentAddress(grid);
 	   		grid = dependentAlien(grid);
 	   		grid = applicantName(grid);
 	   		grid = applicantAlien(grid);
 	   		grid = applicantEmail(grid);
    	
    	
    	
    	
    	
 	   		//editButton(grid);
 	   		
 	   		//Defining the Edit button
 	   		// creates option to edit the form if there is any formatting issues
 	   		Button edit = new Button();
 	   		edit.setText("Edit Form");
 	   		edit.setTextFill(Color.BLACK);
 	   		GridPane.setConstraints(edit, 20,36);
 	   		grid.getChildren().add(edit);
 	   		
 	   		edit.setOnAction((ActionEvent e) -> {
 	   			for(int i = 0; i < grid.getChildren().size(); i++) {
    		
 	   				if(grid.getChildren().get(i).getClass() == TextField.class) {
    				
 	   					TextField value = (TextField) grid.getChildren().get(i);
 	   					value.setEditable(true);
 	   				}
 	   			}
    		    		
 	   		});
    	
 	   		//storing the checkbox value wether it was checked or not
 	   		CheckBox value = reviewComplete(grid);
 	   		//submitButton(grid, value);
    	
    	
    	
 	   		Button submit = new Button();
 	   		submit.setText("Save & Submit Form");
    	
 	   		GridPane.setConstraints(submit, 21, 40);
 	   		grid.getChildren().add(submit);
    	
 	   		Label label = new Label();
 	   		GridPane.setConstraints(label, 21, 42);
 	   		GridPane.setColumnSpan(label, 2);
 	   		label.setTextFill(Color.RED);
 	   		label.setFont(Font.font("Verdana", FontWeight.MEDIUM, 13));
 	   		grid.getChildren().add(label);
		
 	   		Label label2 = new Label();
 	   		GridPane.setConstraints(label2, 21, 38);
 	   		GridPane.setColumnSpan(label2, 2);
 	   		label2.setTextFill(Color.RED);
 	   		label2.setFont(Font.font("Verdana", FontWeight.MEDIUM, 13));
 	   		grid.getChildren().add(label2);
 	   		
 	   		Label label3 = new Label();
 	   		GridPane.setConstraints(label3, 21, 42);
			GridPane.setColumnSpan(label3, 2);
			label3.setTextFill(Color.RED);
			label3.setFont(Font.font("Verdana", FontWeight.MEDIUM, 13));
			grid.getChildren().add(label3);
		
 	   		submit.setOnAction((ActionEvent e) -> {

			
 	   			if(value.isSelected() == false) {
    	    	
 	   				label2.setVisible(true);
 	   				label2.setText("Error: check box must be checked!");
 	   				label.setVisible(false);

 	   			}
			
 	   			if(value.isSelected() == true) {
    			  
 	   				b1.setAddress(addrField.getText());
 	   				b1.setDateOfBirth(dobField.getText());
 	   				b1.setAlienNum(alienNumField.getText());
 	   				b1.setName(nameField.getText());
 	   				b1.setApplicantName(appNameField.getText());
 	   				b1.setApplicantEmail(appEmailField.getText());
 	   				b1.setApplicantAlienNum(appAlienField.getText());
 	   				
 	   				if(b1.validateDependent(b1)== false) {
 	   					
 	   					label.setVisible(false);
 	   					
 	   					label3.setVisible(true);
 	   					
 	   					label3.setText("Error: updated information is invalid, please review again");
 	   					
 	   					
 	   				}
 	   				
 	   				else {
 	   					label3.setVisible(false);
 	   					label.setVisible(true);
 	   					label2.setVisible(false);
 	   					label.setText("Form has been sent for Approval");
 	   					DependentAddition.wf.addToWF(b1.getFormNumber(), "Approval");
 	   					//System.out.println("After Edit inside submit on action :" + b1.getDateOfBirth());
 	   				}

 	   			}
 	   		});		
		
 	   		back.setOnAction((ActionEvent e) -> {
    		
 	   			App app = new App();
 	   			app.start(stage);
    		
    	
 	   		});
    	
		
    	}  
    	
    	else if(DependentAddition.wf.getReviewStack().isEmpty()) {
    		
    		Label empty = new Label();
 	   		GridPane.setConstraints(empty, 0, 50);
 	   		empty.setTextFill(Color.RED);
 	   		empty.setFont(Font.font("Verdana", FontWeight.MEDIUM, 15));
 	   		grid.getChildren().add(empty);
 	   		empty.setText("Review stack is empty, there are no forms to be reviewed!");
 	   		
 	   		back.setOnAction((ActionEvent e) -> {
    		
	   			App app = new App();
	   			app.start(stage);
		
	
	   		});

 	   		
 	   		
    	}
    	
    }
    
    
    /**
	 * CODE IS SIMILAR TO THAT OF DATA ENTRY APP, AND WAS USED FROM DATA ENTRY BUT NOT COPY AND PASTED
	 * creates the field where the dependent's name can be inputed
	*/
    public GridPane NameofDependent(GridPane grid) {
    	Text nameInput = new Text();
    	nameInput.setText("Name:");
    	GridPane.setConstraints(nameInput, 20, 10);
    	grid.getChildren().add(nameInput);
        
    	nameField = new TextField();
    	GridPane.setConstraints(nameField, 20, 11);
    	
    	grid.getChildren().add(nameField);
    	
    	nameField.setText(b1.getName());
    	nameField.setEditable(false);
    	
    	return grid;
    }
    
    /**
	 * CODE IS SIMILAR TO THAT OF DATA ENTRY APP, AND WAS USED FROM DATA ENTRY BUT NOT COPY AND PASTED
	 * creates the field where the dependent's DOB can be inputed
	*/
   
    public GridPane dependentDOB(GridPane grid) {
    	Text inputDOB = new Text();
    	inputDOB.setText("Date of Birth:");
    	GridPane.setConstraints(inputDOB, 20, 12);
    	grid.getChildren().add(inputDOB);
    	
    	dobField = new TextField();
    	
    	GridPane.setConstraints(dobField, 20, 13);
    	dobField.setText(b1.getDateOfBirth());

    	grid.getChildren().add(dobField);
    	dobField.setEditable(false);

    	return grid;
    }
    
    
    
    /**
	 * CODE IS SIMILAR TO THAT OF DATA ENTRY APP, AND WAS USED FROM DATA ENTRY BUT NOT COPY AND PASTED
	 * creates the field where the dependent's address can be inputed
	*/
    public GridPane dependentAddress(GridPane grid) {
    	Text addrInput = new Text("Adress:");
    	GridPane.setConstraints(addrInput, 20, 14);
    	grid.getChildren().add(addrInput);
    	
    	addrField = new TextField();
    	GridPane.setConstraints(addrField, 20, 15);
    	addrField.setText(b1.getAddress());

    	grid.getChildren().add(addrField);
    	addrField.setEditable(false);
    	

    	return grid;
    }
    
    /**
	 * CODE IS SIMILAR TO THAT OF DATA ENTRY APP, AND WAS USED FROM DATA ENTRY BUT NOT COPY AND PASTED
	 * creates the field where the dependent's alien number can be inputed
	*/
    public GridPane dependentAlien(GridPane grid) {
    	Text alienInput = new Text();
    	alienInput.setText("Alien Number:");
    	GridPane.setConstraints(alienInput, 20, 16);
    	grid.getChildren().add(alienInput);
    	
    	alienNumField = new TextField();
    	GridPane.setConstraints(alienNumField, 20, 17);
    	alienNumField.setText(b1.getAlienNum());

    	grid.getChildren().add(alienNumField);
    	alienNumField.setEditable(false);
    	

    	return grid;
    }
    
    
    /**
	 * CODE IS SIMILAR TO THAT OF DATA ENTRY APP, AND WAS USED FROM DATA ENTRY BUT NOT COPY AND PASTED
	 * creates the field where the applicant's name can be inputed
	*/
    public GridPane applicantName(GridPane grid) {
    	Text appNameInput = new Text();
    	appNameInput.setText("Name:");
    	GridPane.setConstraints(appNameInput, 20, 26);
    	grid.getChildren().add(appNameInput);
        
    	appNameField = new TextField();
    	
    	GridPane.setConstraints(appNameField, 20, 27);
    	appNameField.setText(b1.getApplicantName());

    	
    	grid.getChildren().add(appNameField);
    	appNameField.setEditable(false);
    	

    	return grid;
    }
    

    /**
	 * CODE IS SIMILAR TO THAT OF DATA ENTRY APP, AND WAS USED FROM DATA ENTRY BUT NOT COPY AND PASTED
	 * creates the field where the applicant's Alien number can be inputed
	*/
    public GridPane applicantAlien(GridPane grid) {
    	Text appAlienInput = new Text();
    	appAlienInput.setText("Alien Number:");
    	GridPane.setConstraints(appAlienInput, 20, 28);
    	grid.getChildren().add(appAlienInput);
    	
    	appAlienField = new TextField();
    	GridPane.setConstraints(appAlienField, 20, 29);
    	appAlienField.setText(b1.getApplicantAlienNum());

    	
    	grid.getChildren().add(appAlienField);
    	

    	
    	appAlienField.setEditable(false);

 	
    	return grid;
    	
    }
    
   
    /**
	 * CODE IS SIMILAR TO THAT OF DATA ENTRY APP, AND WAS USED FROM DATA ENTRY BUT NOT COPY AND PASTED
	 * creates the field where the applicant's email can be inputed
	*/
    public GridPane applicantEmail(GridPane grid) {
    	Text appEmailInput = new Text("Email Address:");
    	GridPane.setConstraints(appEmailInput, 20, 30);
    	grid.getChildren().add(appEmailInput);
    	
    	appEmailField = new TextField();
    	GridPane.setConstraints(appEmailField, 20, 31);
    	appEmailField.setText(b1.getApplicantEmail());

    	
    	grid.getChildren().add(appEmailField);
    	appEmailField.setEditable(false);
    	
    	return grid;
    }
    
   
    
    /**
     * method creates option to edit the form if there is any formatting issue
     * @param grid
     */
   /* public void editButton(GridPane grid) {
    	//Defining the Edit button
    	Button edit = new Button();
    	edit.setText("Edit Form");

    	GridPane.setConstraints(edit, 20,36);
    	grid.getChildren().add(edit);
    	
    	DropShadow shadow = new DropShadow();
    	//Adding the shadow when the mouse cursor is on
    	edit.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
    	    edit.setEffect(shadow);
    	});
    	 
    	//Removing the shadow when the mouse cursor is off
    	edit.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
    	    edit.setEffect(null);
    	}); 
    	
    	edit.setTextFill(Color.BLACK);

    	
    	//makes the fields editable
    	edit.setOnAction((ActionEvent e) -> {
    		for(int i = 0; i < grid.getChildren().size(); i++) {
    		
    			if(grid.getChildren().get(i).getClass() == TextField.class) {
    				
    				TextField value = (TextField) grid.getChildren().get(i);
    				 value.setEditable(true);
    			}
    		}
    		    		
    	});
    	
    }*/
    
    /**
     * method creates a check box to confirm reviewing process if finished (acts like a signature by the reviewer)
     * @param grid
     * @return
     */
    public CheckBox reviewComplete(GridPane grid) {
    	
    	//defining the check box
    	CheckBox suppCheck = new CheckBox("Form has been reviewed");
    	GridPane.setConstraints(suppCheck, 21,36);
    	//suppCheck.
    	suppCheck.setTextFill(Color.BLACK);
		suppCheck.setFont(Font.font("Calibri", FontWeight.MEDIUM, 14));
    	grid.getChildren().add(suppCheck);
    	
    	return suppCheck;
    	
    }
    
   /**
    * creates the option to submit the form and updating the existing form in the database and passing it to the next step in the workflow
    * @param grid
    * @param suppcheck
    */
  /* public void submitButton(GridPane grid, CheckBox suppcheck) {
    	
	   
    	//Defining the submit button
    	Button submit = new Button();
    	submit.setText("Save & Submit Form");

    	GridPane.setConstraints(submit, 21, 40);
    	grid.getChildren().add(submit);
    	
		//System.out.println(b1.getName());

    	
    	DropShadow shadow = new DropShadow();
    	//Adding the shadow when the mouse cursor is on
    	submit.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
    	    submit.setEffect(shadow);
    	});
    	 
    	//Removing the shadow when the mouse cursor is off
    	submit.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
    	    submit.setEffect(null);
    	});    
    	
    	
    	submit.setTextFill(Color.BLACK);

    	
    	Label label = new Label();
		GridPane.setConstraints(label, 21, 42);
		GridPane.setColumnSpan(label, 2);
		label.setTextFill(Color.RED);
		label.setFont(Font.font("Verdana", FontWeight.MEDIUM, 13));
		grid.getChildren().add(label);
		
		Label label2 = new Label();
		GridPane.setConstraints(label2, 21, 38);
		GridPane.setColumnSpan(label2, 2);
		label2.setTextFill(Color.RED);
		label2.setFont(Font.font("Verdana", FontWeight.MEDIUM, 13));
		grid.getChildren().add(label2);
		
		
		submit.setOnAction((ActionEvent e) -> {

			
			if(suppcheck.isSelected() == false) {
    	    	
    			label2.setVisible(true);
				label2.setText("Error: check box must be checked!");
				label.setVisible(false);

			}
			
    		if(suppcheck.isSelected() == true) {
    			
    			b1.setAddress(addrField.getText());
    		   	b1.setDateOfBirth(dobField.getText());
    	   		b1.setAlienNum(alienNumField.getText());
    	   		b1.setName(nameField.getText());
    	   		b1.setApplicantName(appNameField.getText());
    	   		b1.setApplicantEmail(appEmailField.getText());
    	   		b1.setApplicantAlienNum(appAlienField.getText());
    			
    		
    			label.setVisible(true);
    			label.setText("Form has been sent for Approval");
    			label2.setVisible(false);
    		}
    	});		
		
		//System.out.println(b1.getName());
		
		
    }*/
    
    /*public boolean isValidDate(String dateStr) {
        DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    public boolean isValidAlienNum(String AlienStr) {
       
        try {
            Integer.parseInt(AlienStr);
        } catch (Exception e) {
            return false;
        }
        return true;
    }*/
    
   /*public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }*/
    
 
   /**
    * creates a dependentAddition object
    * @return
    */
 public DependentAddition createDep() {
	   
	   
	   DependentAddition BO = DependentAddition.dependentCreation();
	   
	   BO.setAddress("Address wiedweid");
	   BO.setAlienNum("45309687");
	   BO.setApplicantAlienNum("123456789");
	   BO.setApplicantEmail("rjkfnerjf@email.com");
	   BO.setApplicantName("Will");
	   BO.setDateOfBirth("11/1/2000");
	   BO.setName("Emil y");
	   
	   return BO;
	   
   }
  
  
	
	

}