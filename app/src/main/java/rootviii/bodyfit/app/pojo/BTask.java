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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }
}
