package rootviii.bodyfit.app.pojo;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.Date;

/**
 * Created by Daryna on 04.04.2015.
 */
@ParseClassName("BTask")
public class BTask extends ParseObject {

    public int getType() {
        return getInt("type");
    }

    public void setType(int type) {
        put("type", type);
    }

    public Date getStartTime() {
        return getDate("startTime");
    }

    public void setStartTime(Date startTime) {
        put("startTime", startTime);
    }

    public Date getFinishTime() {
        return getDate("finishTime");
    }

    public void setFinishTime(Date finishTime) {
        put("finishTime", finishTime);
    }

    public double getAmount() {
        return getDouble("amount");
    }

    public void setAmount(double amount) {
        put("amount", amount);
    }

    public boolean isComplete() {
        return getBoolean("isComplete");
    }

    public void setComplete(boolean isComplete) {
        put("isComplete", isComplete);
    }
}
