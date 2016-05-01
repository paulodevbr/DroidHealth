package app.com.bugdroidbuilder.paulo.droidhealth.model;

/** Class that can calculate Body Mass Index, Basal Metabolic Rate, and the hidration according to user data
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
        double bmi = weight/(Math.pow((height/100), 2));
        // calculate the ideal weight and store it in class Person
        Person.setDifIdealWeight(calcKgToIdealWeight());
        Person.setBMI((float)bmi);
        Person.setStringBMI(returnHealthCondition(bmi));

    }


    public int calcKgToIdealWeight(){
        //calcula peso ideal do usuario de acordo com o resultado do IMC
        // e retorna quantos kg falta perder ou ganhar para atingir este peso
        Person.setPesoIdeal((int)(Math.pow((Person.getHeight()/100), 2) * 27));

        return (int)(Person.getPesoIdeal() - Person.getWeight());
    }

    /** Verify the Body Metabolic Index result and return the health condition
     *
     * @param bmi Body Mass Index
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
            return MUITO_ABAIXO_DO_PESO;
        }else if(17 <= bmi && bmi <= 18.49){
            return ABAIXO_DO_PESO;
        }else if(18.5 <= bmi && bmi <= 24.99){
            return NO_PESO;
        }else if(25 <= bmi && bmi <= 29.99){
            return ACIMA_DO_PESO;
        }else if(30 <= bmi && bmi <= 34.99){
            return  OBESIDADE;
        }
        else if(35 <= bmi && bmi >= 39.99){
            return OBESIDADE_SEVERA;
        }else{
            return OBESIDADE_MORBIDA;
        }

    }

    /** Calculate the Basal Metabolic Rate
     *
     */
    public void calcBMR(){
        float weight = Person.getWeight();
        float height = Person.getHeight();
        float age = Person.getAge();
        String gender = Person.getGender();
        double bmr;
        double qntPhysicalAct = checkQntPhysicalAct();

        switch(gender){

            case"Masculino":
                //Calculate Basal Metabolic Rate for men
                bmr = (66 + (13.8 * weight) + (5 * height) - (6.8 * age)) * qntPhysicalAct;
                Person.setBMR((float)bmr);

            case"Feminino":
                //Calculate Basal Metabolic Rate for women
                bmr = (655 + (9.6 * weight) + (1.8 * height) - (4.7 * age)) * qntPhysicalAct;
                Person.setBMR((float)bmr);
            default:

        }

    }

    /** Check the frequency of physical activities
     *
     * @return a value to calculate BMR according to the frequency of physical activities
     */
    public double checkQntPhysicalAct() {
        String qntExercString = Person.getQntPhysicalActivies();
        double valQntExerc;
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
                valQntExerc = 0.2;// valor 0.2 para teste
                break;

        }
        return valQntExerc;
    }



}
