package lintcode;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals==null||newInterval==null) {
            return intervals;
        }

        if(intervals.size()==0) {
            intervals.add(newInterval);
            return intervals;
        }

        ListIterator<Interval> it = intervals.listIterator();
        while(it.hasNext()) {
            Interval tmpInterval = it.next();
            if(newInterval.end<tmpInterval.start) {
                it.previous();
                it.add(newInterval);
                return intervals;
            } else {
                if(tmpInterval.end<newInterval.start) {
                    continue;
                } else {
                    newInterval.start = Math.min(tmpInterval.start, newInterval.start);
                    newInterval.end   = Math.max(tmpInterval.end, newInterval.end);
                    it.remove();
                }
            }
        }
        intervals.add(newInterval);
        return intervals;
    }
}
class Interval{
    int start,end;
    Interval(int start,int end){
        this.start=start;
        this.end=end;
    }
}
