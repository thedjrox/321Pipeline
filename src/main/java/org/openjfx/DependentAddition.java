package org.openjfx;

import java.util.ArrayList;

public class DependentAddition{

	public static ArrayList<DependentAddition> database = new ArrayList<DependentAddition>();
	public static ArrayList<Integer> usedFormNumbers = new ArrayList<Integer>();
    private int formNumber;
    private String name;
    private String dateOfBirth;
    private String address;
    private String alienNum;
    private String applicantName; 
    private String applicantAlienNum;
    private String applicantEmail;
    public static workFlow wf =  new workFlow();

  

    public DependentAddition(String name, String dateOfBirth, String address, String alienNum, 
                                String applicantName, String applicantAlienNum, String applicantEmail)
    {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.alienNum = alienNum;
        this.applicantName = applicantName;
        this.applicantAlienNum = applicantAlienNum; 
        this.applicantEmail = applicantEmail;
        this.formNumber = calcFormNumber();
        wf.addToWF(formNumber, "Reviewer");
        
    }

    private DependentAddition(){}

    public static DependentAddition dependentCreation( String name, String dateOfBirth, String address, String alienNum, 
                                    String applicantName, String applicantAlienNum, String applicantEmail)
    {
    	DependentAddition dep = new DependentAddition(name, dateOfBirth, address, alienNum,applicantName,applicantAlienNum,applicantEmail);                          
    	saveToDB(dep);
    	return dep;                                
    }

    /*
     * Allows the values to be set later by using the setters
     */
    public static DependentAddition dependentCreation(){
        return new DependentAddition();
    }

    /*
     * helper function to generate the form number
     */
    public int calcFormNumber() {
    	int rand = 0;
    	
    	do {
    		rand = (int)(Math.random() * 200) + 0;
    	}while(usedFormNumbers.contains(rand));
    	
    	usedFormNumbers.add(rand);
    	return rand;
    }
    
    /*
     * check to make sure that date of birth is in proper format, alien
     * number is an int,applicantAlienNum is an int, and email address is in proper format
     */
    public boolean validateDependent(DependentAddition da){
    	// alien num and applicant alien num must be convertable to an int
    	// date of birth should follow the format xx/xx/xxxx
    	// email must have an @ and a .
    	String string_num, birthdate;
    	int alien_num;
    	try {
    		// checking that the alien nums can be converted to ints. If an exception occurs, return false
    		string_num = this.getAlienNum();
    		alien_num = Integer.parseInt(string_num);
    		string_num = this.getApplicantAlienNum();
    		alien_num = Integer.parseInt(string_num);
    		
    		// date of birth
    		birthdate = this.getDateOfBirth();
    		if((birthdate.length() != 10) || (birthdate.contains("/") == false)) {
    			return false;
    		}
    		if(this.getApplicantEmail().contains("@") == false) {
    			return false;
    		}
    		
    	}
    	catch (Exception e) {
    		return false;
    		
    	}
        return true;
    }

    public static void saveToDB(DependentAddition dependent){
    	database.add(dependent);
    }

    public static DependentAddition getDependentFromDB_AlienNum(int alienNumber){
        int num = 0;
        for( int i = 0; i < database.size(); i++) {
        	num = Integer.parseInt(database.get(i).alienNum);
        	if(num == alienNumber)
        		return database.get(i);
        }
        // not found in database
        return null;
    }
    public static DependentAddition getDependentFromDB_FormNumber(int formNum){
        for( int i = 0; i < database.size(); i++) {
        	if(database.get(i).formNumber == formNum)
        		return database.get(i);
        }
        // not found in database
        return null;
    }
    

    /*
    * Should call validate dependent before updating
    */
    public Boolean updateDependent(DependentAddition dependent){
    	// ensure that the dependent we are updating with also passes validations
    	Boolean validate = validateDependent(dependent);
    	if(!validate)
    		return false;
    	
        this.name = dependent.name;
        this.dateOfBirth = dependent.dateOfBirth;
        this.address = dependent.address;
        this.alienNum = dependent.alienNum;
        this.applicantName = dependent.applicantName;
        this.applicantAlienNum = dependent.applicantAlienNum;
        this.applicantEmail = dependent.applicantEmail;
        this.formNumber = dependent.formNumber;
    	
        return true;
        
    }

    // Setters

    public void setName(String name){
    	this.name = name;
    }

    public void setDateOfBirth(String birthdate){
    	this.dateOfBirth = birthdate;
    }

    public void setAddress(String address){
    	this.address = address;
    }

    public void setAlienNum(String alienNum){
    	this.alienNum = alienNum;
    }

    public void setApplicantName(String applicantName){
    	this.applicantName = applicantName;
    }

    public void setApplicantAlienNum(String applicantAlienNum){
    	this.applicantAlienNum = applicantAlienNum;
    }

    public void setApplicantEmail(String applicantEmail){
    	this.applicantEmail = applicantEmail;
    }

    // Getters

    public String getName(){
        return this.name;
    }

    public String getDateOfBirth(){
        return this.dateOfBirth;
    }

    public String getAddress(){
        return this.address;
    }

    public String getAlienNum(){
        return this.alienNum;
    }

    public String getApplicantName(){
        return this.applicantName;
    }

    public String getApplicantAlienNum(){
        return this.applicantAlienNum;
    }

    public String getApplicantEmail(){
        return this.applicantEmail;
    }

    public int getFormNumber() {
    	return this.formNumber;
    }
    /*
    public DependentAddition getDependent(){
        return null;
    }
    */
    
    public String toString() {
    	return "Form #" + formNumber + " Dependent Name: " + name + 
    			" Dependent DOB: " + dateOfBirth +
    			" Dependent Address: " + address + 
    			" Dependent Alien Number: " + alienNum + 
    			" Applicant Name: " + applicantName + 
    			" Applicant Alien Number: " + applicantAlienNum + 
    			" Applicant Email " + applicantEmail;
    }
}