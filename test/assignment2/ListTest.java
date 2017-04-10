/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dasha
 */
public class ListTest {
    
    List validList;
    
    public ListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        validList = new List("Finish this assignment");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addToList method, of class List.
     */
    @Test
    public void testAddToList() {
        String item = "Test addToList Method";
        validList.addToList(item);
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("Test addToList Method");
        assertEquals(validList.getList(), expResult);
    }

    /**
     * Test of showList method, of class List.
     */
    @Test
    public void testShowList() {
        String expResult = "Finis the assignment, Send file to Jaret";
        validList.addToList("Finis the assignment");
        validList.addToList("Send file to Jaret");
        String result = validList.showList();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class List.
     */
    @Test
    public void testToString() {
        String expResult = "Finish this assignment";
        String result = validList.toString();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of getIsDone method, of class List.
     */
    @Test
    public void testGetIsDone() {
        boolean expResult = false;
        boolean result = validList.getIsDone();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIsDone method, of class List.
     */
    @Test
    public void testSetIsDone() {
        Boolean isDone = false;
        validList.setIsDone();
        boolean expResult = true;
        boolean result = validList.getIsDone();;
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class List.
     */
    @Test
    public void testGetName() {
        String expResult = "Finish this assignment";
        String result = validList.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class List.
     */
    @Test
    public void testSetName() {
        String name = "Add name to the list";
        validList.setName(name);
        assertEquals(name, validList.getName());
    }

    /**
     * Test of getList method, of class List.
     */
    @Test
    public void testGetList() {
        validList.addToList("Change the name");
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("Change the name");
        ArrayList<String> result = validList.getList();
        assertEquals(expResult, result);
    }
}
