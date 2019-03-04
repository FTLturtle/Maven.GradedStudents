package io.zipcoder;

import java.util.Arrays;
import java.util.TreeMap;

public class Classroom {
    private Student[] students;

    public Classroom() {
        this(30);
    }

    public Classroom(int numOfStudents) {
        this(new Student[numOfStudents]);
    }

    public Classroom(Student[] arrayOfStudents) {
        students = Arrays.copyOf(arrayOfStudents, arrayOfStudents.length);
    }

    public Student[] getStudents() {
        return Arrays.copyOf(students, students.length);
    }

    public double getAverageExamScore() {
        double sum = 0.0;
        for (Student s : students) {
            sum += s.getAverageTestScore();
        }
        return sum / students.length;
    }

    public void addStudent(Student studentToAdd) {
        Student[] addedStudentArray = Arrays.copyOf(students, students.length + 1);
        addedStudentArray[addedStudentArray.length - 1] = studentToAdd;
        students = addedStudentArray;
    }

    public void removeStudent(String firstName, String lastName) throws NullPointerException {
        Student[] removedStudentArray = new Student[students.length];
        int removedStudentArrayCounter = 0;
        for (Student student : students) {
            if (!(firstName.equals(student.getFirstName()) && lastName.equals(student.getLastName()))) {
                removedStudentArray[removedStudentArrayCounter] = student;
                removedStudentArrayCounter++;
            }
        }
        students = removedStudentArray;
    }

    public Student[] getStudentsByScore() {
        Student[] sortedByScoreArray = Arrays.copyOf(students, students.length);
        Arrays.sort(sortedByScoreArray, GradeComparator.getGradeComparator());
        return sortedByScoreArray;
    }

    public TreeMap<Student, Character> getGradeBook() {
        TreeMap<Student, Character> gradeBook = new TreeMap<>();
        for (int i = 0; i < students.length; i++) {
            gradeBook.put(students[i], getStudentGrade(i, students.length));
        }
        return gradeBook;
    }

    private char getStudentGrade(int studentIndexPosition, int classSize) {
        double percentile = (double) studentIndexPosition / (double) (classSize - 1);
        char grade;
        if (percentile < 0.101) {
            grade = 'A';
        } else if (percentile < 0.291) {
            grade = 'B';
        } else if (percentile < 0.501) {
            grade = 'C';
        } else if (percentile < 0.891) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        return grade;
    }
}