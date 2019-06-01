package main.java.com.flaminem.ballclock;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.reverse;

public class BallClock {

    private double days;
    private LinkedList<Integer> queue;
    private LinkedList<Integer> queueReference;
    private LinkedList<Integer> min;
    private LinkedList<Integer> fiveMin;
    private LinkedList<Integer> hours;

    public BallClock(Integer ballsNumber) {

        this.days = 0;
        this.queue = IntStream.rangeClosed(1, ballsNumber).boxed().collect(Collectors.toCollection(LinkedList::new));
        this.queueReference = new LinkedList<>(queue);
        this.min = new LinkedList<>();
        this.fiveMin = new LinkedList<>();
        this.hours = new LinkedList<>();
    }

    public BallClock compute() {
        min.add(queue.remove(0));
        if(min.size() == 5){
            min = updateTracks(queue, min, fiveMin, 4);
        }
        if(fiveMin.size() == 12){
            fiveMin = updateTracks(queue, fiveMin, hours, 11);
        }
        if(hours.size() == 12){
            int lastQueueBall = hours.remove(11);
            hours = updateTracks(queue, hours, queue, 10);
            queue.add(lastQueueBall);
            days = days + .5;
        }
        return this;
    }

    public double getDays() {
        return days;
    }

    public LinkedList<Integer> getQueueReference() {
        return queueReference;
    }

    public LinkedList<Integer> getQueue() {
        return queue;
    }

    public LinkedList<Integer> getMin() {
        return min;
    }

    public LinkedList<Integer> getFiveMin() {
        return fiveMin;
    }

    public LinkedList<Integer> getHours() {
        return hours;
    }

    private LinkedList<Integer> updateTracks(LinkedList<Integer> queue, LinkedList<Integer> resettedTrack, LinkedList<Integer> updatedTrack, int i) {
        updatedTrack.add(resettedTrack.remove(i));
        reverse(resettedTrack);
        queue.addAll(resettedTrack);
        resettedTrack = new LinkedList<>();
        return resettedTrack;
    }
}
