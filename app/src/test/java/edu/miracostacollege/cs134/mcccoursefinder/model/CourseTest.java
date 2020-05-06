package edu.miracostacollege.cs134.mcccoursefinder.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CourseTest {

    private Course testCourse;

    // executes before every single test
    @Before
    public void setUp() throws Exception {
        // initialize with test data
        testCourse = new Course("CS", "999", "Recursive Recursion");
    }

    // tearDown() executes after every test finishes
    // typically used for cleanup code e.g. delete db, close db
    // not used here
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getId() {
        // alpha = "CS", number = 999, title = "Recursive Recursion"
        // id = -1 so db reassigns id
        // All tests begin with assertXXXX (where XXXX is something)
        // Assert that the id of the testCourse is -1
        assertEquals("Testing the getter for id", -1, testCourse.getId());
        // test fails: assertEquals("Testing the getter for id", 0, testCourse.getId());
        testCourse = new Course(101, "CS", "999", "Recursive Recursion");
        assertEquals("Testing the getter for id", 101, testCourse.getId());
    }

    @Test
    public void setId() {

        // Happy Path (normal input)
        assertEquals("Testing the setter for id", -1, testCourse.getId());
        // use the setter
        testCourse.setId(101);
        assertEquals("Testing the setter for id", 101, testCourse.getId());

        // Edge case test: test the boundaries
        try{
            testCourse.setId(Integer.MIN_VALUE);
            // Expecting an exception to occur, so if it doesn't, we fail the test
            fail("Expected setter of MIN_VALUE to generate exception");
        } catch (IllegalArgumentException e) {
            // worked as expected
        }

        testCourse.setId(Integer.MAX_VALUE);
        assertEquals("Testing the setter for id", Integer.MAX_VALUE, testCourse.getId());

        // Sad Path (abnormal input)
        // testCourse.setId(-2);
        // failed b/c exception is thrown: assertEquals("Testing the setter for id", -2, testCourse.getId());
        try{
            testCourse.setId(-2);
            // Expecting an exception to occur, so if it doesn't, we fail the test
            fail("Expected setter of -2 to generate exception");
        } catch (IllegalArgumentException e) {
            // worked as expected
        }
    }

    // TODO: complete the rest of the getters and setters tests
    @Test
    public void getAlpha() {
    }

    @Test
    public void getNumber() {
    }

    @Test
    public void getTitle() {
    }

    @Test
    public void setTitle() {
    }

    @Test
    public void getFullName() {
    }

    @Test
    public void testToString() {
    }
}