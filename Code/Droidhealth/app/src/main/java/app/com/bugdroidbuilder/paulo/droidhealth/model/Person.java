package app.com.bugdroidbuilder.paulo.droidhealth.model;

/** static class that CRUD user information among all activities
 *
 */
public class Person {
    private static float weight;
    private static float height;
    private static int age;
    private static String gender;
    private static String qntPhysicalActivies;

    private static float BMI;//Body Mass Index
    private static float BMR;//Basal Metabolic Rate
    private static float HDR;//hydration per day
    private static int idealWeight;
    private static int difIdealWeight;

    private static StringBuilder stringHDR;
    private static StringBuilder stringWeight;
    private static StringBuilder stringHeight;
    private static StringBuilder stringBMI;
    private static StringBuilder stringBMR;

    public static float getWeight() {
        return weight;
    }

    public static void setWeight(float weight) {
        Person.weight = (int) weight;
        Person.stringWeight = new StringBuilder().append("Peso: ").append(Person.weight).append(" Kg");
    }
    public static void setStringWeight(String _pesoString) {
        Person.stringWeight = new StringBuilder().append(_pesoString);
    }
    public static String getStringWeight() {
        return stringWeight.toString();
    }
    public static void setDifIdealWeight(int dif) {
        Person.difIdealWeight = dif;
    }

    public static int getDifIdealWeight() {
        return difIdealWeight;
    }



    public static String getStringHeight() {
        return stringHeight.toString();
    }


    public static float getHeight() {
        return height;
    }

    public static void setHeight(float height) {
        Person.height = (int) height;
        Person.stringHeight = new StringBuilder().append("Altura: ").append((int) height).append(" cm");
    }

    public static int getAge() {
        return age;
    }

    public static void setAge(int age) {
        Person.age = age;
    }

    public static String getGender() {
        return gender;
    }

    public static void setGender(String gender) {
        Person.gender = gender;
    }

    public static String getQntPhysicalActivies() {
        return qntPhysicalActivies;
    }

    public static void setQntPhysicalActivies(String qntPhysicalActivies) {
        Person.qntPhysicalActivies = qntPhysicalActivies;
    }

    public static float getHDR() {
        return HDR;
    }

    public static void setHDR(float HDR) {
        Person.HDR = HDR;
        Person.stringHDR = new StringBuilder().append("Consumo de água recomendado: ").append(HDR).append(" litros/dia");
    }

    public static String getStringHDR() {
        return stringHDR.toString();
    }

    public static void setStringHDR(String qntWater) {
        Person.stringHDR = new StringBuilder().append(qntWater);
    }

    public static float getBMI() {
        return BMI;
    }

    public static void setBMI(float BMI) {
        Person.BMI = BMI;
    }

    public static float getBMR() {
        return BMR;
    }

    public static void setBMR(float BMR) {
        Person.BMR = BMR;
        Person.stringBMR = new StringBuilder().append("Gasto de kcal: ").append((int) BMR).append("/dia");
    }

    public static String getStringBMR() {
        return stringBMR.toString();
    }

    public static int getPesoIdeal() {
        return idealWeight;
    }

    public static void setPesoIdeal(int pesoIdeal) {
        Person.idealWeight = pesoIdeal;
    }

    public static String getStringBMI() {
        return stringBMI.toString();
    }

    public static void setStringBMI(String stringBMI) {
        Person.stringBMI = new StringBuilder().append(stringBMI);
    }
    public static void setStringBMR(String stringBMR) {
        Person.stringBMR = new StringBuilder().append(stringBMR);
    }


}
