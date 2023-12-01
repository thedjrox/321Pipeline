package org.openjfx;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class workFlowTest {
	

	/**
	 * tests if the obj can be created and is null or not
	 */
	@Test
	public void CreateWFObjTest1() {
        workFlow testobj = new workFlow();
        assertNotNull(testobj);
    }
	
	/*
	 * tests if the obj is created from the workFlow class
	 */
	@Test
	public void CreateWFObjTest2() {
        workFlow testobj = new workFlow();
        assertTrue(testobj instanceof workFlow);
    }
	
	
	/*
	 *  tests if the dependentaddition form is added to the workflow by testing if the reviewStack and approveStack is null or not
	 */
	@Test
	public void addToWFTest1() {
		
		DependentAddition da = DependentAddition.dependentCreation("Tom","09/03/2002","1234 Road",
                "1234", "Mary","5678","mary@gmail.com");
		
        workFlow testobj = new workFlow();
		testobj.addToWF(da.getFormNumber(), "Reviwer");
	
		assertNotNull(testobj.getReviewStack());
		assertNotNull(testobj.getApproveStack());
	}
	
	
	/*
	 * tests if the dependentaddition form is added to the workflow by testing if the review stack has a depedendentAddition form
	 */
	@Test
	public void addToWFTest2() {
		
		DependentAddition da = DependentAddition.dependentCreation("Tom","09/03/2002","1234 Road",
                "1234", "Mary","5678","mary@gmail.com");
		
        workFlow testobj = new workFlow();
		testobj.addToWF(da.getFormNumber(), "Reviewer");
		
		assertEquals(1, testobj.getReviewStack().size());
		assertEquals(0, testobj.getApproveStack().size());

	}
	
	/*
	 * tests if the dependentaddition form is added to the next step (approve stack) in workflow if multiple dependentAddition forms need to be approved
	 */
	@Test
	public void addToWFTest3() {
		
		DependentAddition da1 = DependentAddition.dependentCreation("Tom","09/03/2002","1234 Road",
                "1234", "Mary","5678","mary@gmail.com");
		DependentAddition da2 = DependentAddition.dependentCreation("Will","08/03/2002","4578 Sweet Leaf",
                "9876", "Sarah","2345","sarah@gmail.com");
		
        workFlow obj = new workFlow();
        obj.addToWF(da1.getFormNumber(), "Approval");
		obj.addToWF(da2.getFormNumber(), "Approval");

		
		assertEquals(2, obj.getApproveStack().size());
	}
	
	
	/*
	 *  Test adding a form to the review stack
	 */
	@Test
	public void addToWFTest4() {    
	    DependentAddition da = DependentAddition.dependentCreation("John", "01/01/2000", "456 Main St",
	            "5678", "Alice", "9876", "alice@gmail.com");

	    workFlow testobj = new workFlow();
	    testobj.addToWF(da.getFormNumber(), "Reviewer");

	    assertEquals(1, testobj.getReviewStack().size());
	    assertEquals(0, testobj.getApproveStack().size());
	}
	
	/*
	 * Test adding a form to the approval stack
	 */
	@Test
	public void addToWFTest5() {   
	    DependentAddition da = DependentAddition.dependentCreation("John", "01/01/2000", "456 Main St",
	            "5678", "Alice", "9876", "alice@gmail.com");

	    workFlow testobj = new workFlow();
	    testobj.addToWF(da.getFormNumber(), "Approval");

	    assertEquals(0, testobj.getReviewStack().size());
	    assertEquals(1, testobj.getApproveStack().size());
	}
	
	/*
	 * tests if getNextItem() returns the next dependentaddtion obj's id in the review stack
	 */
	@Test
	public void getNextItemTest1() {
		
		DependentAddition da1 = DependentAddition.dependentCreation("Tom","09/03/2002","1234 Road",
                "1234", "Mary","5678","mary@gmail.com");
        workFlow testobj = new workFlow();
		testobj.addToWF(da1.getFormNumber(), "Reviewer");
		
		//testobj.addToWF(486502193);
		assertEquals(da1.getFormNumber(), testobj.getNextItem("Reviewer"));
		
	}
	
	/*
	 * tests if getNextItem() returns no id since there is nothing in the review and approve stack
	 */
	@Test
	public void getNextItemTest2() {
		
        workFlow testobj = new workFlow();
        
    	assertTrue(testobj.getNextItem("Reviewer")== 0);
		assertTrue(testobj.getNextItem("Approval")== 0);
		
	}
	
	/*
	 * Test getting the next item from an empty review stack
	 */
	@Test
	public void getNextItemTest3() {
	    
	    workFlow testobj = new workFlow();
	    assertEquals(0, testobj.getNextItem("Reviewer"));
	}
	
	/*
	 * Test getting the next item from an empty approval stack
	 */
	@Test
	public void getNextItemTest4() {
	    
	    workFlow testobj = new workFlow();
	    assertEquals(0, testobj.getNextItem("Approval"));
	}
	/*
	 * Test getting the next item from the approval stack
	 */
	@Test
	public void getNextItemTest5() {
	    
	    workFlow testobj = new workFlow();

	    DependentAddition da = DependentAddition.dependentCreation("John", "01/01/2000", "456 Main St",
	            "5678", "Alice", "9876", "alice@gmail.com");

	    testobj.addToWF(da.getFormNumber(), "Approval");

	    assertEquals(da.getFormNumber(), testobj.getNextItem("Approval"));
	    assertTrue(testobj.getApproveStack().isEmpty());
	}
	
	/*
	 * Test setting the review stack and then checking if it is properly set
	 */
	@Test
	public void setReviewStackTest() {
	    
	    workFlow testobj = new workFlow();
	    
	    ArrayList<Integer> reviewStack = new ArrayList<>();
	    reviewStack.add(123);
	    reviewStack.add(456);

	    testobj.setReviewStack(reviewStack);

	    assertEquals(reviewStack, testobj.getReviewStack());
	}

	/*
	 * Test setting the approve stack and then checking if it is properly set
	 */
	@Test
	public void setApproveStackTest() {
	    
	    workFlow testobj = new workFlow();
	    
	    ArrayList<Integer> approveStack = new ArrayList<>();
	    approveStack.add(789);
	    approveStack.add(101);

	    testobj.setApproveStack(approveStack);

	    assertEquals(approveStack, testobj.getApproveStack());
	}
	
	
	
	
}