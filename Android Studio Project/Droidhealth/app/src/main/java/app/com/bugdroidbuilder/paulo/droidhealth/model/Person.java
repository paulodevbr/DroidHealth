package app.com.bugdroidbuilder.paulo.droidhealth.model;

import app.com.bugdroidbuilder.paulo.droidhealth.controller.HealthController;

/** static class that CRUD user information among all activities
 *
 */
public class Person {
    private static int weight;
    private static int height;
    private static int age;


    private static float BMI;//Body Mass Index
    private static float BMR;//Basal Metabolic Rate
    private static float HDR;//hydration per day
    private static int idealWeight;


    private static StringBuilder gender, qntPhysicalActivies, stringHDR, stringWeight, stringIdealWeight,
            stringHeight, stringBMI, stringBMR, stringAdviceWeight;

    public static int getWeight() {
        return weight;
    }

    public static void setAdviceWeight(int calories) {
        if (HealthController.isLowerWeight()) {
            Person.stringAdviceWeight = new StringBuilder().append("Para ganhar peso: ")
                    .append(calories).append(" kcal/dia");

        } else if (HealthController.isHigherWeight()) {
            Person.stringAdviceWeight = new StringBuilder().append("Para perder peso: ")
                    .append(calories).append(" kcal/dia");
        } else if ( !HealthController.isLowerWeight()&&!HealthController.isHigherWeight()){
            Person.stringAdviceWeight = new StringBuilder().append("Parabéns, continue assim!");
        }

    }

    public static String getStringAdviceWeight() {

        try{
            return Person.stringAdviceWeight.toString();
        }catch (NullPointerException e){
            return "Parabens, continue assim !";
        }
    }

    public static String getStringWeight() {
        return stringWeight.toString();
    }

    public static void setIdealWeight(int idealWeight) {
        Person.idealWeight = idealWeight;
        Person.stringIdealWeight = new StringBuilder().append("Ideal: ").append(idealWeight).append(" Kg");
    }

    public static String getStringIdealWeight() {
        return Person.stringIdealWeight.toString();
    }



    public static String getStringHeight() {
        return stringHeight.toString();
    }

    public static int getHeight() {
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
        return gender.toString();
    }

    public static void setGender(String gender) {
        Person.gender = new StringBuilder().append(gender);
    }

    public static String getQntPhysicalActivies() {
        return qntPhysicalActivies.toString();
    }

    public static void setQntPhysicalActivies(String qntPhysicalActivies) {
        Person.qntPhysicalActivies = new StringBuilder().append(qntPhysicalActivies);
    }


    public static void setHDR(float HDR) {
        Person.HDR = HDR;
        Person.stringHDR = new StringBuilder().append("Hidratação: ").append(Float.toString(HDR)).append(" litros/dia");
    }

    public static String getStringHDR() {
        return Person.stringHDR.toString();
    }


    public static void setBMI(float BMI) {
        Person.BMI = BMI;
    }

    public static float getBMR() {
        return BMR;
    }

    public static void setBMR(float BMR) {
        Person.BMR = BMR;
        Person.stringBMR = new StringBuilder().append("Gasto de calorias: ").append((int) BMR).append(" kcal/dia");
    }

    public static String getStringBMR() {
        return stringBMR.toString();
    }

    public static String getStringBMI() {
        return stringBMI.toString();
    }

    public static void setHealthCondition(String stringBMI) {
        Person.stringBMI = new StringBuilder().append(stringBMI);
    }


    public static void setWeight(float gainWeightCalories) {
        Person.weight = (int) gainWeightCalories;
        Person.stringWeight = new StringBuilder().append("Peso: ").append(Person.weight).append(" Kg");
    }


}
