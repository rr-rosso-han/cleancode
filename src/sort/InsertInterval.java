package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiahan on 2/20/15.
 */
public class InsertInterval {
    private class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals.size() == 0) {
            List<Interval> it = new ArrayList<Interval>();
            it.add(newInterval);
            return it;
        }
        List<Interval> result = new ArrayList<>();

        for(Interval current : intervals){
            if (current.end < newInterval.start) {
                result.add(current);
            } else if (current.start > newInterval.end) {
                result.add(newInterval);
                newInterval = current;
            } else if (current.end >= newInterval.start
                    || current.start <= newInterval.end) {
                newInterval = new Interval(Math.min(current.start, newInterval.start),
                        Math.max(newInterval.end, current.end));
            }
        }
        result.add(newInterval);
        return result;
    }
}
