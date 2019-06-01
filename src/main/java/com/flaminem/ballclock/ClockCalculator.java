package main.java.com.flaminem.ballclock;

public class ClockCalculator {

    public String computeTimeBeforeRepetition(int ballsNumber) throws Exception {

        checkBallsNumber(ballsNumber);
        BallClock ballClock = new BallClock(ballsNumber);
        while (true) {
            ballClock.compute();
            if(ballClock.getQueue().equals(ballClock.getQueueReference())){
                return  ballsNumber + " balls cycle after " + ballClock.getDays() + " days.";
            }
        }
    }

    public String computeTimeBeforeRepetition(Integer ballsNumber, Integer minutesNumber) throws Exception {

        checkBallsNumber(ballsNumber);
        BallClock ballClock = new BallClock(ballsNumber);
        int cp = 0;
        while (cp < minutesNumber) {
            cp++;
            ballClock.compute();
        }
        return "{\"Min\":" + ballClock.getMin() + ",\"FiveMin\":" + ballClock.getFiveMin() + ",\"Hour\":" + ballClock.getHours() + ",\"Main\"\n"+
                "  " + ballClock.getQueue() + "}";
    }

    private void checkBallsNumber(Integer ballsNumber) throws Exception {
        if (ballsNumber < 27 || ballsNumber > 127 ){
            throw new InvalidInitialBallsNumberException("Bas balls number : Valid numbers are in the range 27 to 127.");
        }
    }
}
