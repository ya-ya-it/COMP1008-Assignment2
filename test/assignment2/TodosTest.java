/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import assignment2.Todos.LevelOfImportance;
import java.time.LocalDate;
import java.time.Month;
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
public class TodosTest {
    
    Todos validTodo;
    
    public TodosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        validTodo = new Todos("Finish this assignment", "Finish this assignment in time",
                LocalDate.of(2017, Month.APRIL, 25), LevelOfImportance.IMPORTANT);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Todos.
     */
    @Test
    public void testToString() {
        String expResult = "Finish this assignment: "
                + "Finish this assignment in time till 2017-04-25. It is IMPORTANT";
        String result = validTodo.toString();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of setDueDate method, of class Todos.
     */
    @Test
    public void testSetDueDate() {
        LocalDate dueDate = LocalDate.of(2018, Month.MARCH, 13);
        validTodo.setDueDate(dueDate);
        assertEquals(dueDate, validTodo.getDueDate());
    }
    
    /**
     * Test of setDueDate method, of class Todos.
     */
    @Test
    public void testSetDueDateInvalid() {
        LocalDate dueDate = LocalDate.of(2010, Month.MARCH, 13);
        
        try
        {
            validTodo.setDueDate(dueDate);
            fail("The due date is in the past and should have triggered an exception");
        }
        catch (IllegalArgumentException e)
        {
            System.out.printf("Due date in the past, exception = \"%s\"%n", e.getMessage());
        }
    }

    /**
     * Test of getDescription method, of class Todos.
     */
    @Test
    public void testGetDescription() {
        String expResult = "Finish this assignment in time";
        String result = validTodo.getDescription();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setDescription method, of class Todos.
     */
    @Test
    public void testSetDescription() {
        String description = "Push to GitHub";
        validTodo.setDescription(description);
        String expResult = "Push to GitHub";
        String result = validTodo.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDueDate method, of class Todos.
     */
    @Test
    public void testGetDueDate() {
        LocalDate expResult = LocalDate.of(2017, Month.APRIL, 25);
        LocalDate result = validTodo.getDueDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getImportance method, of class Todos.
     */
    @Test
    public void testGetImportance() {
        Todos.LevelOfImportance expResult = LevelOfImportance.IMPORTANT;
        Todos.LevelOfImportance result = validTodo.getImportance();
        assertEquals(expResult, result);
    }

    /**
     * Test of setImportance method, of class Todos.
     */
    @Test
    public void testSetImportance() {
        Todos.LevelOfImportance importance = LevelOfImportance.NOT_IMPORTANT;
        validTodo.setImportance(importance);
        Todos.LevelOfImportance expResult = LevelOfImportance.NOT_IMPORTANT;
        Todos.LevelOfImportance result = validTodo.getImportance();
        assertEquals(expResult, result);
    }
    
}
