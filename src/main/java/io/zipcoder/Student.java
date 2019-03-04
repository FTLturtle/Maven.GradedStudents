package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;

public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private ArrayList<Double> testScores;

    public Student(String firstName, String lastName, Double[] testScores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.testScores = new ArrayList<>(Arrays.asList(testScores));
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double[] getTestScores() {
        return this.testScores.toArray(new Double[0]);
    }

    public int getNumberOfTestsTaken() {
        return this.testScores.size();
    }

    public void addTest(double score) {
        this.testScores.add(score);
    }

    public double getAverageTestScore() {
        double sum = 0.0;
        for (Double d : this.testScores) {
            sum += d;
        }
        return sum / this.testScores.size();
    }

    public void setIndividualTestScore(int index, double score) {
        this.testScores.set(index, score);
    }

    public String getTestScoresAsString() {
        StringBuilder testScoresStringBuilder = new StringBuilder("Test scores:\n");
        for (int i = 0; i < this.testScores.size(); i++) {
            testScoresStringBuilder.append(String.format("\tTest %d -> %.2f\n", i + 1, this.testScores.get(i)));
        }
        return testScoresStringBuilder.toString();
    }

    @Override
    public String toString() {
        return String.format("Student Name: %s %s\n> Average Score: %.2f\n> ", this.firstName, this.lastName, this.getAverageTestScore()) + getTestScoresAsString();
    }

    public int compareTo(Student otherStudent) {
        int result = compareLastNames(otherStudent);
        if (result == 0) {
            result = compareFirstNames(otherStudent);
        }
        return result;
    }

    private int compareFirstNames(Student otherStudent) {
        return getFirstName().compareTo(otherStudent.getFirstName());
    }

    private int compareLastNames(Student otherStudent) {
        return getLastName().compareTo(otherStudent.getLastName());
    }

}
