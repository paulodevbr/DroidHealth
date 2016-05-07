package app.com.bugdroidbuilder.paulo.droidhealth.model;

import app.com.bugdroidbuilder.paulo.droidhealth.R;
import app.com.bugdroidbuilder.paulo.droidhealth.controller.HealthController;



/** Class able to calculate Body Mass Index, Basal Metabolic Rate, and the hidration according to user data
 *
 */
public final class CalcHealth {



    /** Calculate the hydration per day according to user weight
     *
     */
    public void calcHDR(){
        float peso = Person.getWeight();
        double resultWater = peso * 0.035;
        Person.setHDR((float)resultWater);

    }

    /** Calculate the Body Mass Index and return the health condition
     *
     */
    public void calcBMI(){
        //calculate BMI, and height is divided by 100 because is needed to be in meters
        float weight = Person.getWeight();
        float height = Person.getHeight();
        height = height/100;
        double bmi = weight/(Math.pow((height), 2));
        // calculate the ideal weight and store it in class Person
        Person.setDifIdealWeight(calcKgToIdealWeight());
        Person.setBMI((float)bmi);
        Person.setStringBMI(returnHealthCondition(bmi));
    }


    public int calcKgToIdealWeight(){
        //calculate the ideal weight based in BMI
        //return how many kg is needed to gain or lose, to achieve the ideal weight
        float height = Person.getHeight();
        height = height/100;
        Person.setIdealWeight((int)((Math.pow((height), 2) * 23)));

        return (int)(Person.getIdealWeight() - Person.getWeight());
    }

    /** Verify the Body Metabolic Index result and return the health condition
     *
     * @param bmi body mass index
     * @return health condition
     */
    public String returnHealthCondition(double bmi){
        final String MUITO_ABAIXO_DO_PESO = "Muito abaixo do peso";
        final String ABAIXO_DO_PESO = "Abaixo do peso";
        final String NO_PESO = "Saudável";
        final String ACIMA_DO_PESO = "Acima do peso";
        final String OBESIDADE = "Obesidade";
        final String OBESIDADE_SEVERA = "Obesidade severa";
        final String OBESIDADE_MORBIDA = "Obesidade mórbida";

        if(bmi < 17){
            HealthController.setLowerWeight(true);
            HealthController.setHigherWeight(false);
            HealthController.setColor(R.color.colorBad);
            return MUITO_ABAIXO_DO_PESO;
        }else if(17 <= bmi && bmi <= 18.49){
            HealthController.setLowerWeight(true);
            HealthController.setHigherWeight(false);
            HealthController.setColor(R.color.colorSoSo);
            return ABAIXO_DO_PESO;
        }else if(18.5 <= bmi && bmi <= 24.99){
            HealthController.setLowerWeight(false);
            HealthController.setHigherWeight(false);
            HealthController.setColor(R.color.colorHealthy);
            return NO_PESO;
        }else if(25 <= bmi && bmi <= 29.99){
            HealthController.setLowerWeight(false);
            HealthController.setHigherWeight(true);
            HealthController.setColor(R.color.colorSoSo);
            return ACIMA_DO_PESO;
        }else if(30 <= bmi && bmi <= 34.99){
            HealthController.setLowerWeight(false);
            HealthController.setHigherWeight(true);
            HealthController.setColor(R.color.colorBad);
            return  OBESIDADE;
        }
        else if(35 <= bmi && bmi <= 39.99){
            HealthController.setLowerWeight(false);
            HealthController.setHigherWeight(true);
            HealthController.setColor(R.color.colorSoBad);
            return OBESIDADE_SEVERA;
        }else{
            HealthController.setLowerWeight(false);
            HealthController.setHigherWeight(true);
            HealthController.setColor(R.color.colorTerrible);
            return OBESIDADE_MORBIDA;
        }

    }

    /** Calculate the Basal Metabolic Rate
     *
     * @return Basal Metabolic Rate ready to be shown
     */
    public String calcBMR(){
        float weight = Person.getWeight();
        float height = Person.getHeight();
        float age = Person.getAge();
        String gender = Person.getGender();
        double bmr;
        double qntPhysicalAct = checkQntPhysicalAct();

        switch(gender){

            case"Masculino":
                //Calculate male Basal Metabolic Rate
                bmr = (66 + (13.8 * weight) + (5 * height) - (6.8 * age)) * qntPhysicalAct;
                Person.setBMR((float)bmr);
                checkWeightState();
                return Person.getStringBMR();

            case"Feminino":
                //Calculate female Basal Metabolic Rate
                bmr = (655 + (9.6 * weight) + (1.8 * height) - (4.7 * age)) * qntPhysicalAct;
                Person.setBMR((float)bmr);
                checkWeightState();
                return Person.getStringBMR();
            default:
                return Double.toString(0.00);
        }

    }

    /** Check the frequency of physical activities
     *
     * @return a value to calculate BMR according to the frequency of physical activities
     */
    public double checkQntPhysicalAct() {
        String qntExercString = Person.getQntPhysicalActivies();
        double valQntExerc = 0;
        switch (qntExercString){
            case "Sedentário":
                valQntExerc = 1.2;
                break;
            case "Exercícios leves (1 a 3 dias por semana)":
                valQntExerc = 1.55;
                break;
            case "Exercícios intensos (6 a 7 dias por semana)":
                valQntExerc = 1.725;
                break;
            case "Exercícios intensos diariamente":
                valQntExerc =1.9;
                break;
            default:
                break;

        }
        return valQntExerc;
    }
    // Verify if the user needs to lose or gain weight
    public void checkWeightState(){
        if(HealthController.isLowerWeight()){
            calcCaloriesToGainWeight();
        }else if(HealthController.isHigherWeight()) {
            calcCaloriesToLoseWeight();
        }else Person.setAdviceWeight(0);
    }

    public void calcCaloriesToLoseWeight(){
        int calories = 0;
        float bmr = Person.getBMR();
        calories =(int) (bmr * 0.75);
        Person.setAdviceWeight(calories);
    }

    public void calcCaloriesToGainWeight(){
        int calories = 0;
        float bmr = Person.getBMR();
        calories =(int) (bmr * 1.15);
        Person.setAdviceWeight(calories);
    }





}
