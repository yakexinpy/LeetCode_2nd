/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ret = new ArrayList<Interval>();

        for(Interval tmp : intervals){
            if(tmp.end < newInterval.start)
                ret.add(tmp);
            else if(tmp.start > newInterval.end){
                ret.add(newInterval);
                newInterval = tmp;
            }
            else if(tmp.end >= newInterval.start || tmp.start <= newInterval.end)
                newInterval = new Interval(Math.min(tmp.start, newInterval.start), Math.max(tmp.end, newInterval.end));
        }
        ret.add(newInterval);
        return ret;
    }
}
