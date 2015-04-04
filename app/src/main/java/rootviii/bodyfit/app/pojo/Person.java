package rootviii.bodyfit.app.pojo;

/**
 * Created by voronsky on 4/4/2015.
 */
public class Person {

    private String id;
    private double height;
    private double weight;
    private double dWeight;
    private int age;
    private int gender;
    private double neckCF;
    private double waistLine;
    private double loinsCF;
    private double fatPers;
    private double musclesPers;
    private double waterPers;

    public Person(String id, double height, double weight, double dWeight,
                  int age, int gender, double neckCF, double loinsCF, double waistLine,
                  double fatPers, double musclesPers, double waterPers) {
        this.id = id;
        this.height = height;
        this.weight = weight;
        this.dWeight = dWeight;
        this.age = age;
        this.gender = gender;
        this.neckCF = neckCF;
        this.loinsCF = loinsCF;
        this.waistLine = waistLine;
        this.fatPers = fatPers;
        this.musclesPers = musclesPers;
        this.waterPers = waterPers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getdWeight() {
        return dWeight;
    }

    public void setdWeight(double dWeight) {
        this.dWeight = dWeight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public double getNeckCF() {
        return neckCF;
    }

    public void setNeckCF(double neckCF) {
        this.neckCF = neckCF;
    }

    public double getWaistLine() {
        return waistLine;
    }

    public void setWaistLine(double waistLine) {
        this.waistLine = waistLine;
    }

    public double getLoinsCF() {
        return loinsCF;
    }

    public void setLoinsCF(double loinsCF) {
        this.loinsCF = loinsCF;
    }

    public double getFatPers() {
        return fatPers;
    }

    public void setFatPers(double fatPers) {
        this.fatPers = fatPers;
    }

    public double getMusclesPers() {
        return musclesPers;
    }

    public void setMusclesPers(double musclesPers) {
        this.musclesPers = musclesPers;
    }

    public double getWaterPers() {
        return waterPers;
    }

    public void setWaterPers(double waterPers) {
        this.waterPers = waterPers;
    }
}
