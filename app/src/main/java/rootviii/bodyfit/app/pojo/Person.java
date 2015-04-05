package rootviii.bodyfit.app.pojo;

import com.parse.ParseClassName;
import com.parse.ParseObject;

/**
 * Created by voronsky on 4/4/2015.
 */
@ParseClassName("Person")
public class Person extends ParseObject {

    public double getHeight() {
        return getDouble("height");
    }

    public void setHeight(double height) {
        put("height", height);
    }

    public double getWeight() {
        return getDouble("weight");
    }

    public void setWeight(double weight) {
        put("weight", weight);
    }

    public double getdWeight() {
        return getDouble("dweight");
    }

    public void setdWeight(double dWeight) {
        put("dweight", dWeight);
    }

    public int getAge() {
        return getInt("age");
    }

    public void setAge(int age) {
        put("age", age);
    }

    public int getGender() {
        return getInt("gender");
    }

    public void setGender(int gender) {
        put("gender", gender);
    }

    public double getNeckCF() {
        return getDouble("neckCF");
    }

    public void setNeckCF(double neckCF) {
        put("neckCF", neckCF);
    }

    public double getWaistLine() {
        return getDouble("waistline");
    }

    public void setWaistLine(double waistLine) {
        put("waistline", waistLine);
    }

    public double getLoinsCF() {
        return getDouble("loinsCF");
    }

    public void setLoinsCF(double loinsCF) {
        put("loinsCF", loinsCF);
    }

    public double getFatPercent() {
        return getDouble("fatPercent");
    }

    public void setFatPercent(double fatPercent) {
        this.put("fatPercent", fatPercent);
    }

    public double getMusclePercent() {
        return getDouble("musclePercent");
    }

    public void setMusclePercent(double musclePercent) {
        put("musclePercent", musclePercent);
    }

    public double getWaterPercent() {
        return getDouble("waterPercent");
    }

    public void setWaterPercent(double waterPercent) {
        put("waterPercent", waterPercent);
    }
}
