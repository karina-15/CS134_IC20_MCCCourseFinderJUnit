package edu.miracostacollege.cs134.mcccoursefinder.model;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DBHelperTest {

    // initialize 1 db and 1 context
    private static DBHelper testDB;
    private static Context testContext;

    // initialize db tables
    private Course testCourse;
    private Instructor testInstructor;
    private Offering testOffering;

    @Before
    public void setUp() throws Exception {
        // create context for unit testing
        testContext = InstrumentationRegistry.getTargetContext();
        testDB = new DBHelper(testContext);

        // cleans db before every test
        // DATABASE_NAME = "MCC"
        testContext.deleteDatabase(DBHelper.DATABASE_NAME);

        // initialize test object
        testCourse = new Course("CS", "999", "Recursive Recursion");
        testInstructor = new Instructor("King", "Kailyn", "kking@miracosta.edu");
        testOffering = new Offering(12345, "Spring 2022", testCourse, testInstructor);
    }

    @After
    public void tearDown() throws Exception {
        testDB.deleteAllCourses();
    }

    @Test
    public void onCreate() {
    }

    @Test
    public void onUpgrade() {
    }

    @Test
    public void addCourse() {
        // Test adding a new course to database
        // Happy path:
        // a) test size of database == 1
        // b) test id == 1
        // c) retrieve (get) course from database, all fields should be same as testCourse

        // Put tests in a loop:
        // can stress test with 10_000 ~8min 19sec to complete
        for (int i = 1; i < 100; i++) {
            testDB.addCourse(testCourse);

            assertEquals("Testing size of database", i, testDB.getAllCourses().size());

            // err: update id from -1 to 1 when added to db
            // err: generate equals method
            assertEquals("Testing id of testCourse after add.", i, testCourse.getId());

            // asserts course object instead of individual fields
            assertEquals("Test all fields of course added to database", testCourse, testDB.getCourse(i));
        }
    }

    @Test
    public void getAllCourses() {
        assertEquals("Testing size of all courses", 0, testDB.getAllCourses().size());
        testDB.addCourse((testCourse));
        assertEquals("Testing size of all courses", 1, testDB.getAllCourses().size());
    }

    @Test
    public void deleteCourse() {
        // Sad path: abnormal behavior
        // try deleting a course that doesn't exist
        assertEquals("Testing size of all courses", 0, testDB.deleteCourse(testCourse));
        assertEquals("Testing size of all courses", 0, testDB.getAllCourses().size());

        // Happy path: normal behavior
        testDB.addCourse(testCourse);
        assertEquals("Testing size of all courses", 1, testDB.deleteCourse(testCourse));
        assertEquals("Testing size of all courses", 0, testDB.getAllCourses().size());

        // Edge case: Test of boundaries
        // try to delete null - fix err
        assertEquals("Testing size of all courses", 0, testDB.deleteCourse(null));
    }

    // TODO: tests for methods below
    @Test
    public void deleteAllCourses() {
    }

    @Test
    public void updateCourse() {
    }

    @Test
    public void getCourse() {
    }

    @Test
    public void addInstructor() {
    }

    @Test
    public void getAllInstructors() {
    }

    @Test
    public void deleteInstructor() {
    }

    @Test
    public void deleteAllInstructors() {
    }

    @Test
    public void updateInstructor() {
    }

    @Test
    public void getInstructor() {
    }

    @Test
    public void addOffering() {
    }

    @Test
    public void getAllOfferings() {
    }

    @Test
    public void deleteOffering() {
    }

    @Test
    public void deleteAllOfferings() {
    }

    @Test
    public void updateOffering() {
    }

    @Test
    public void getOffering() {
    }

    @Test
    public void importOfferingsFromCSV() {
    }

    @Test
    public void importCoursesFromCSV() {
    }

    @Test
    public void importInstructorsFromCSV() {
    }
}