package racing;

public class RacingOption {
    private int carCnt;
    private int reps;

    RacingOption(int carCnt, int reps){
        this.carCnt = carCnt;
        this.reps = reps;
    }

    public int getCarCnt() {
        return carCnt;
    }

    public int getReps() {
        return reps;
    }

}
