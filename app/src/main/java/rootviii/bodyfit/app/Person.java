package rootviii.bodyfit.app;

/**
 * Created by voronsky on 4/4/2015.
 */
public class Person {
    String id;
    double height, weight, dWeight;
    int age, gender;
    double neckCF, waistLine, loinsCF, fatPers, musclesPers, waterPers;

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
}
