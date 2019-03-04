package io.zipcoder;

import java.util.Comparator;

public class GradeComparator implements Comparator<Student> {
    private static GradeComparator gradeComparator;

    private GradeComparator() {
    }

    static GradeComparator getGradeComparator() {
        if (gradeComparator == null) {
            gradeComparator = new GradeComparator();
        }
        return gradeComparator;
    }

    public int compare(Student student1, Student student2) {
        double gradeDifference = student2.getAverageTestScore() - student1.getAverageTestScore();
        int result;
        if (Math.abs(gradeDifference) < .01) {
            result = student1.compareTo(student2);
        } else if (gradeDifference < 0.0) {
            result = -1;
        } else {
            result = 1;
        }
        return result;
    }
}
