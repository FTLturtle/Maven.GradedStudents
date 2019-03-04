package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

public class GradeComparatorTest {
    private Double[] grades1 = {100.0, 90.0, 80.0};
    private Double[] grades2 = {100.0, 95.0, 90.0};
    private Double[] grades3 = {90.0, 80.0, 70.0};
    private Double[] grades4 = {10.0, 15.0, 20.0};
    private Double[] grades5 = {10.0, 15.0, 20.0};
    private Student student1 = new Student("Gandalf", "the Grey", grades1);
    private Student student2 = new Student("Bilbo", "Baggins", grades2);
    private Student student3 = new Student("Thorin", "Oakenshield", grades3);
    private Student student4 = new Student("Frodo", "Baggins", grades4);
    private Student student5 = new Student("Gimli", "son of Gloin", grades5);
    private GradeComparator gradeComparator = GradeComparator.getGradeComparator();

    @Test
    public void differentGradesCompareTest1() {
        // Given
        int expectedInt = 1;

        // When
        int actualInt = gradeComparator.compare(student1, student2);

        // Then
        Assert.assertEquals(expectedInt, actualInt);
    }

    @Test
    public void differentGradesCompareTest2() {
        // Given
        int expectedInt = -1;

        // When
        int actualInt = gradeComparator.compare(student2, student1);

        // Then
        Assert.assertEquals(expectedInt, actualInt);
    }

    @Test
    public void equalGradesCompareTest1() {
        // When
        int actualInt = gradeComparator.compare(student4, student5);

        // Then
        Assert.assertTrue(actualInt < 0);
    }

    @Test
    public void equalGradesCompareTest2() {
        // When
        int actualInt = gradeComparator.compare(student5, student4);

        // Then
        Assert.assertTrue(actualInt > 0);
    }
}
