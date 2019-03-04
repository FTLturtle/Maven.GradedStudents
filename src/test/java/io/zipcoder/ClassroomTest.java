package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ClassroomTest {
    private Double[] grades1 = {100.0, 90.0, 80.0}; // B
    private Double[] grades2 = {100.0, 95.0, 90.0}; // A
    private Double[] grades3 = {90.0, 80.0, 70.0}; // C
    private Double[] grades4 = {10.0, 15.0, 20.0}; // F
    private Double[] grades5 = {25.0, 30.0, 35.0}; // D
    private Student student1 = new Student("Gandalf", "the Grey", grades1);
    private Student student2 = new Student("Bilbo", "Baggins", grades2);
    private Student student3 = new Student("Thorin", "Oakenshield", grades3);
    private Student student4 = new Student("Frodo", "Baggins", grades4);
    private Student student5 = new Student("Gimli", "son of Gloin", grades5);
    private Student[] studentArray = {student1, student2, student3, student4, student5};

    @Test
    public void constructorTest1() {
        // Given
        int expectedSize = 30;

        // When
        Classroom testClassroom = new Classroom();
        int actualSize = testClassroom.getStudents().length;

        // Then
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void constructorTest2() {
        // Given
        int expectedSize = 20;

        // When
        Classroom testClassroom = new Classroom(expectedSize);
        int actualSize = testClassroom.getStudents().length;

        // Then
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void constructorTest3() {
        // Given
        Student[] expectedStudentArray = new Student[10];

        // When
        Classroom testClassroom = new Classroom(expectedStudentArray);
        Student[] actualStudentArray = testClassroom.getStudents();

        // Then
        Assert.assertArrayEquals(expectedStudentArray, actualStudentArray);
    }

    @Test
    public void getAverageScoreTest1() {
        // Given
        double expectedAverage = 62.0;
        Student[] testStudentArray = Arrays.copyOf(studentArray, studentArray.length);

        // When
        Classroom testClassroom = new Classroom(testStudentArray);
        double actualAverage = testClassroom.getAverageExamScore();

        // Then
        Assert.assertEquals(expectedAverage, actualAverage, .000001);
    }

    @Test
    public void addStudentTest1() {
        // Given
        Classroom testClassroom = new Classroom(studentArray);
        Double[] grades = {100.0, 90.0, 70.0};
        Student expectedStudent = new Student("Nathan", "Fillion", grades);

        // When
        testClassroom.addStudent(expectedStudent);
        Student actualStudent = testClassroom.getStudents()[5];

        // Then
        Assert.assertEquals(expectedStudent, actualStudent);
    }

    @Test
    public void removeStudentTest1() {
        // Given
        Classroom testClassroom = new Classroom(studentArray);

        // When
        testClassroom.removeStudent(student3.getFirstName(), student3.getLastName());

        // Then
        Assert.assertNull(testClassroom.getStudents()[4]);
    }

    @Test
    public void removeStudentTest2() {
        // Given
        Classroom testClassroom = new Classroom(studentArray);

        // When
        testClassroom.removeStudent(student3.getFirstName(), student3.getLastName());

        // Then
        Assert.assertNull(testClassroom.getStudents()[4]);
    }

    @Test
    public void getStudentsByScoreTest1() {
        // Given
        Classroom testClassroom = new Classroom(studentArray);

        Student[] expectedArray = {student2, student1, student3, student5, student4};

        // When
        Student[] actualArray = testClassroom.getStudentsByScore();

        // Then
        Assert.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void getGradeBookTest1() {
        // Given
        Classroom testClassroom = new Classroom(studentArray);

        String expectedGradeBook = "[B, D, C, F, A]";

        // When
        String actualGradeBook = testClassroom.getGradeBook().values().toString();
        // the values() method of TreeMap creates a collections view of all the values, sorted in ascending order of the corresponding keys

        // Then
        Assert.assertEquals(expectedGradeBook, actualGradeBook);
    }

}
