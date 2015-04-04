package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by jiahan on 2/20/15.
 */
public class MergeIntervals {
    private class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return new ArrayList<Interval>();
        }
        Collections.sort(intervals, new IntervalComparator());
        List<Interval> result = new ArrayList<>();

        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (current.end < prev.start) {
                result.add(current);
            } else if (current.start > prev.end) {
                result.add(prev);
                prev = current;
            } else if (current.end >= prev.start
                    || current.start <= prev.end) {
                prev = new Interval(Math.min(current.start, prev.start),
                        Math.max(prev.end, current.end));
            }
        }
        result.add(prev);
        return result;
    }

    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval it1, Interval it2) {
            return it1.start - it2.start;
        }
    }
}
