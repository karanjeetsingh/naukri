package com.interviewalgo.strings;

public class StaircaseProblem {
    public static void main(String[] args) {
        int totalSteps = 10;
        int maxSteps = 10;
        getStaircaseCombn(totalSteps, maxSteps, "");
    }

    public static void getStaircaseCombn(int totalSteps, int maxSteps, String steps) {
        if (totalSteps == 0) {
            System.out.println(steps);
        } else if (totalSteps < 0) {
        } else {
            for (int step = 1; step <= maxSteps; step++) {
                getStaircaseCombn(totalSteps - step, maxSteps, steps + " " + step);
            }
        }
    }
}
