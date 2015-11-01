package com.interviewalgo.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Merge two arrays of intervals. Given a collection of intervals, merge all
 * overlapping intervals.
 * 
 * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
 * 
 * @author ksingh
 * 
 */
public class MergeIntervals {

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<MergeIntervals.Interval>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 8));
        intervals.add(new Interval(10, 12));
        intervals.add(new Interval(15, 20));

        System.out.println(intervals);
        System.out.println(MergeIntervals.merge(intervals));
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        
        List<Interval> result = new ArrayList<Interval>();
        Collections.sort(intervals, new IntervalComparator());
        Interval prev = intervals.get(0);
        for (int index = 1; index < intervals.size(); index++) {
            Interval curr = intervals.get(index);
            if (prev.end >= curr.start) {
                Interval merged = new Interval(prev.start, curr.end);
                // result.add(merged);
                prev = merged;
            } else {
                result.add(prev);
                prev = curr;
            }
        }
        result.add(prev);

        return result;
    }

    public static class Interval {
        int start;
        int end;

        public Interval() {
            this.start = 0;
            this.end = 0;
        }

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "[" + this.start + ", " + this.end + "] ";
        }
    }

    static class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }

    }

}
