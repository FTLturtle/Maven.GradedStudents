package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void setFirstNameTest() {
        // Given
        String firstName = "";
        String lastName = "";
        Double[] testScores = {};
        Student testStudent = new Student(firstName, lastName, testScores);

        String expectedFirstName = "Shmee";

        // When
        testStudent.setFirstName(expectedFirstName);
        String actualFirstName = testStudent.getFirstName();

        // Then
        Assert.assertEquals(expectedFirstName, actualFirstName);
    }

    @Test
    public void setLastNameTest() {
        // Given
        String firstName = "";
        String lastName = "";
        Double[] testScores = {};
        Student testStudent = new Student(firstName, lastName, testScores);

        String expectedLastName = "Shplat";

        // When
        testStudent.setLastName(expectedLastName);
        String actualLastName = testStudent.getLastName();

        // Then
        Assert.assertEquals(expectedLastName, actualLastName);
    }

    @Test
    public void getTestScoresTest() {
        // Given
        String firstName = "";
        String lastName = "";
        Double[] testScores = {100.0, 89.5, 43.8};
        Student testStudent = new Student(firstName, lastName, testScores);

        // When
        Double[] actualScores = testStudent.getTestScores();

        // Then
        Assert.assertArrayEquals(testScores, actualScores);
    }

    @Test
    public void getNumberOfTestsTakenTest() {
        // Given
        String firstName = "";
        String lastName = "";
        Double[] testScores = {100.0, 89.5, 43.8};
        Student testStudent = new Student(firstName, lastName, testScores);

        int expectedNumberOfTests = testScores.length;

        // When
        int actualNumberOfTests = testStudent.getNumberOfTestsTaken();

        // Then
        Assert.assertEquals(expectedNumberOfTests, actualNumberOfTests);
    }

    @Test
    public void addTestTest() {
        // Given
        String firstName = "";
        String lastName = "";
        Double[] testScores = {};
        Student testStudent = new Student(firstName, lastName, testScores);

        Double scoreToAdd = 89.5;
        Double[] expectedScores = {scoreToAdd};

        // When
        testStudent.addTest(scoreToAdd);
        Double[] actualScores = testStudent.getTestScores();

        // Then
        Assert.assertArrayEquals(expectedScores, actualScores);
    }

    @Test
    public void getAverageTestScoreTest() {
        // Given
        String firstName = "";
        String lastName = "";
        Double[] testScores = {100.0, 50.0, 75.0};
        Student testStudent = new Student(firstName, lastName, testScores);
        Double threshold = .0001;

        Double expectedAverage = 75.0;

        // When
        Double actualAverage = testStudent.getAverageTestScore();

        // Then
        Assert.assertEquals(expectedAverage, actualAverage, threshold);
    }

    @Test
    public void setIndividualTestScoreTest() {
        // Given
        String firstName = "";
        String lastName = "";
        Double[] testScores = {100.0, 89.5, 43.8};
        Student testStudent = new Student(firstName, lastName, testScores);

        Double[] expectedScores = {100.0, 100.0, 43.8};

        // When
        testStudent.setIndividualTestScore(1, 100.0);
        Double[] actualScores = testStudent.getTestScores();

        // Then
        Assert.assertArrayEquals(expectedScores, actualScores);
    }

    @Test
    public void getTestScoresAsStringTest() {
        // Given
        String firstName = "";
        String lastName = "";
        Double[] testScores = {100.0, 89.5, 43.8};
        Student testStudent = new Student(firstName, lastName, testScores);

        String expectedScores = String.format("Test scores:\n\tTest 1 -> %.2f\n\tTest 2 -> %.2f\n\tTest 3 -> %.2f\n", testScores[0], testScores[1], testScores[2]);

        // When
        String actualScores = testStudent.getTestScoresAsString();

        // Then
        Assert.assertEquals(expectedScores, actualScores);
    }

    @Test
    public void toStringTest() {
        // Given
        String firstName = "Jerry";
        String lastName = "Seinfeld";
        Double[] testScores = {100.0, 75.0, 50.0};
        Student testStudent = new Student(firstName, lastName, testScores);

        String expectedToString = String.format("Student Name: %s %s\n> Average Score: %s\n> Test scores:\n\tTest 1 -> %.2f\n\tTest 2 -> %.2f\n\tTest 3 -> %.2f\n", firstName, lastName, "75.00", testScores[0], testScores[1], testScores[2]);

        // When
        String actualToString = testStudent.toString();

        // Then
        Assert.assertEquals(expectedToString, actualToString);
    }

    @Test
    public void compareToTest1() {
        // Given
        String firstName1 = "A";
        String lastName1 = "A";
        Double[] testScores1 = {100.0, 89.5, 43.8};
        Student testStudent1 = new Student(firstName1, lastName1, testScores1);

        String firstName2 = "B";
        String lastName2 = "B";
        Double[] testScores2 = {100.0, 120.5, 140.8};
        Student testStudent2 = new Student(firstName2, lastName2, testScores2);

        int expectedCompare = -1;

        // When
        int actualCompare = testStudent1.compareTo(testStudent2);

        // Then
        Assert.assertEquals(expectedCompare, actualCompare);
    }

    @Test
    public void compareToTest2() {
        // Given
        String firstName1 = "B";
        String lastName1 = "B";
        Double[] testScores1 = {100.0, 89.5, 43.8};
        Student testStudent1 = new Student(firstName1, lastName1, testScores1);

        String firstName2 = "A";
        String lastName2 = "A";
        Double[] testScores2 = {100.0, 120.5, 140.8};
        Student testStudent2 = new Student(firstName2, lastName2, testScores2);

        int expectedCompare = 1;

        // When
        int actualCompare = testStudent1.compareTo(testStudent2);

        // Then
        Assert.assertEquals(expectedCompare, actualCompare);
    }

    @Test
    public void compareToTest3() {
        // Given
        String firstName1 = "B";
        String lastName1 = "B";
        Double[] testScores1 = {100.0, 89.5, 43.8};
        Student testStudent1 = new Student(firstName1, lastName1, testScores1);

        String firstName2 = "A";
        String lastName2 = "B";
        Double[] testScores2 = {100.0, 120.5, 140.8};
        Student testStudent2 = new Student(firstName2, lastName2, testScores2);

        int expectedCompare = 1;

        // When
        int actualCompare = testStudent1.compareTo(testStudent2);

        // Then
        Assert.assertEquals(expectedCompare, actualCompare);
    }

    @Test
    public void compareToTest4() {
        // Given
        String firstName1 = "A";
        String lastName1 = "B";
        Double[] testScores1 = {100.0, 89.5, 43.8};
        Student testStudent1 = new Student(firstName1, lastName1, testScores1);

        String firstName2 = "B";
        String lastName2 = "B";
        Double[] testScores2 = {100.0, 120.5, 140.8};
        Student testStudent2 = new Student(firstName2, lastName2, testScores2);

        int expectedCompare = -1;

        // When
        int actualCompare = testStudent1.compareTo(testStudent2);

        // Then
        Assert.assertEquals(expectedCompare, actualCompare);
    }
}