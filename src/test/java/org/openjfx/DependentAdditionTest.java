package org.openjfx;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;


import org.junit.*;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class DependentAdditionTest {

	/**
	 * Tests that a dependent object is created
	 */
    @Test
    public void dependentCreationTest1(){
        DependentAddition dependent = DependentAddition.dependentCreation("Tom","09/03/2002","1234 Road",
                                "1234", "Mary","5678","mary@gmail.com");
        assertNotNull(dependent);
    }

    /**
     * Tests that the dependents information has been set correctly
     */
    @Test
    public void dependentCreationTest2(){
        DependentAddition dependent = DependentAddition.dependentCreation("Tom","09/03/2002","1234 Road",
                                "1234", "Mary","5678","mary@gmail.com");
        
        
        assertEquals(dependent.getName(),"Tom");
        assertEquals(dependent.getDateOfBirth(),"09/03/2002");
        assertEquals(dependent.getAddress(),"1234 Road" );
        assertEquals(dependent.getAlienNum(), "1234");
        assertEquals(dependent.getApplicantName(),"Mary");
        assertEquals(dependent.getApplicantAlienNum(),"5678");
        assertEquals(dependent.getApplicantEmail(), "mary@gmail.com");
    }

    /**
     * Tests creating an empty dependent object and sets the values
     */
    @Test
    public void dependentCreationTest3(){

        DependentAddition dependent = DependentAddition.dependentCreation();

        dependent.setName("Tom");
        dependent.setDateOfBirth("09/03/2002");
        dependent.setAddress("1234 Road");
        dependent.setAlienNum("1234");
        dependent.setApplicantName("Mary");
        dependent.setApplicantAlienNum("5678");
        dependent.setApplicantEmail("mary@gmail.com");
        
        assertEquals(dependent.getName(),"Tom");
        assertEquals(dependent.getDateOfBirth(),"09/03/2002");
        assertEquals(dependent.getAddress(),"1234 Road" );
        assertEquals(dependent.getAlienNum(), "1234");
        assertEquals(dependent.getApplicantName(),"Mary");
        assertEquals(dependent.getApplicantAlienNum(),"5678");
        assertEquals(dependent.getApplicantEmail(), "mary@gmail.com");

    }
    
    /**
     * Test for a valid dependent
     */
    @Test
    public void validateDependentTest1(){
        DependentAddition dependent = DependentAddition.dependentCreation("Tom","09/03/2002","1234 Road",
                                "1234", "Mary","5678","mary@gmail.com");
        assertTrue(dependent.validateDependent(dependent));
    }
    
    /**
     * Test for an invalid dependent due to improper format of birthday
     */
    @Test
    public void validateDependentTest2(){
        DependentAddition dependent = DependentAddition.dependentCreation("Tom","0/0/0","1234 Road",
                                "1234", "Mary","5678","mary@gmail.com");
        assertFalse(dependent.validateDependent(dependent));
    }
    
    /**
     * Test for an invalid dependent due to improper format of email
     */
    @Test
    public void validateDependentTest3(){
        DependentAddition dependent = DependentAddition.dependentCreation("Tom","09/03/2002","1234 Road",
                                "1234", "Mary","5678","marygmail.com");
        assertFalse(dependent.validateDependent(dependent));
    }
    
    /**
     * Test for an invalid dependent due to improper format of alienNumber
     */
    @Test
    public void validateDependentTest4(){
        DependentAddition dependent = DependentAddition.dependentCreation("Tom","09/03/2002","1234 Road",
                                "skdjfh", "Mary","5678","marygmail.com");
        assertFalse(dependent.validateDependent(dependent));
    }
    
    
    
    /**
     * Test for if dependent's information was updated due to format issues
     */
    @Test
    public void updateDependentTest1(){
        DependentAddition da1 = DependentAddition.dependentCreation("T om","09/03/2002","1234 Road",
                                "1234", "Mary","5678","mary@gmail.com");
        DependentAddition da2 = DependentAddition.dependentCreation("Tom","09/03/2002","1234 Road",
                "1234", "Mary","5678","mary@gmail.com");
        
        da1.updateDependent(da2);
        
        assertTrue(da1.getName() == "Tom");
    }
    
    /**
     * Test for if dependent's updated information is wrong and was not updated
     */
    @Test
    public void updateDependentTest2(){
        DependentAddition da1 = DependentAddition.dependentCreation("Tom","09/03/2002","1234 Road",
                                "kjwnkbrh", "Mary","5678","mary@gmail.com");
        DependentAddition da2 = DependentAddition.dependentCreation("Tom","09/03/2002","1234 Road",
                "onetwothreefour", "Mary","5678","mary@gmail.com");
        
        da1.updateDependent(da2);
        
        assertFalse(da1.getAlienNum()== "onetwothreefour");
    }
    
    /**
     * Test if a dependent addition form was able to be found and retrieved from the database by its alien number
     */

    @Test
    public void getDependentFromDB_AlienNumTest1(){
    	
        DependentAddition da1 = DependentAddition.dependentCreation("Tom","09/03/2002","1234 Road",
                                "1234", "Mary","5678","mary@gmail.com");
        DependentAddition da2 = DependentAddition.dependentCreation("Will","08/03/2002","4578 Sweet Leaf",
                "9876", "Sarah","2345","sarah@gmail.com");
        DependentAddition.saveToDB(da1);
        DependentAddition.saveToDB(da2);
        
        int num = Integer.parseInt(da1.getAlienNum());
        //System.out.println(da1.getName());
       // System.out.println(DependentAddition.getDependentFromDB_AlienNum(num).getName());
        
        
        assertEquals(DependentAddition.getDependentFromDB_AlienNum(num).getName(), da1.getName());
    }
    
    
    /**
     *  Test if inputting a nonexisitng alien number to get a depedentaddition form will return null
     */
    @Test
    public void getDependentFromDB_AlienNumTest2(){
    	
        assertNull(DependentAddition.getDependentFromDB_AlienNum(56987));
    }
    
    
    /**
     * Test if a dependent addition form was able to be found and retrieved from the database by its form number
     */
    @Test
    public void getDependentFromDB_FormNumberTest1(){
    	
        DependentAddition da1 = DependentAddition.dependentCreation("Tom","09/03/2002","1234 Road",
                                "1234", "Mary","5678","mary@gmail.com");
        DependentAddition da2 = DependentAddition.dependentCreation("Will","08/03/2002","4578 Sweet Leaf",
                "9876", "Sarah","2345","sarah@gmail.com");
        DependentAddition.saveToDB(da1);
        DependentAddition.saveToDB(da2);
        int formnum = da1.getFormNumber();
        
        
        assertEquals(DependentAddition.getDependentFromDB_FormNumber(formnum), da1);
    }
    
    /**
     * Test if inputting a nonexisitng form number to get a depedentaddition form will return null
     */
    @Test
    public void getDependentFromDB_FormNumberTest2(){
    	
        assertNull(DependentAddition.getDependentFromDB_FormNumber(1790));
    }
    
    
    
    /*test if the toString method properly outputs the correct data in the right order*/
    @Test
    public void toStringTest() {
    	
    	DependentAddition da = DependentAddition.dependentCreation("Tom","09/03/2002","1234 Road",
                "1234", "Mary","5678","mary@gmail.com");
    	
    	String result = "Form #" + da.getFormNumber() + " Dependent Name: " + da.getName() +" Dependent DOB: " +da.getDateOfBirth() +" Dependent Address: " + da.getAddress() +" Dependent Alien Number: " + da.getAlienNum() +" Applicant Name: " + da.getApplicantName()+ " Applicant Alien Number: " + da.getApplicantAlienNum()+ " Applicant Email "+ da.getApplicantEmail();
    	
    	assertEquals(da.toString(), result);
    	
    	
    }
    /*test if a dependentAddition object was added to the database*/
    @Test
    public void saveToDBTest(){
        DependentAddition dependent = DependentAddition.dependentCreation("Tom","09/03/2002","1234 Road",
                                "1234", "Mary","5678","mary@gmail.com");
        int database_size = DependentAddition.database.size();
        DependentAddition.saveToDB(dependent);
        // assert that the previous size + 1 is equal to the new size since we added an object
        assertEquals(database_size + 1, DependentAddition.database.size());
    }
    

}