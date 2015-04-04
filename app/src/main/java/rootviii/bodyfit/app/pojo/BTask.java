package rootviii.bodyfit.app.pojo;

import java.util.Date;

/**
 * Created by Daryna on 04.04.2015.
 */
public class BTask {
    public int type;
    public Date startTime;
    public Date finishTime;
    public double amount;
    public boolean isComplete;
    public BTask(int type, Date startTime, Date finishTime, double amount, boolean isComplete) {
        this.type = type;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.amount = amount;
        this.isComplete = isComplete;

    }

}
