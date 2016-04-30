package app.com.bugdroidbuilder.paulo.droidhealth.model;

/**
 *
 */
public final class CalcHealth {

    private final String MUITO_ABAIXO_DO_PESO = "Muito abaixo do peso";
    private final String ABAIXO_DO_PESO = "Abaixo do peso";
    private final String NO_PESO = "Saudável";
    private final String ACIMA_DO_PESO = "Acima do peso";
    private final String OBESIDADE = "Obesidade";
    private final String OBESIDADE_SEVERA = "Obesidade severa";
    private final String OBESIDADE_MORBIDA = "Obesidade mórbida";

    public String calcBMI(){
        //calcula IMC, divide altura por 100 porque na formula do IMC altura deve estar em metros
        float weight = Person.getWeight();
        float height = Person.getHeight();
        double bmi = weight/(Math.pow((height/100), 2));
        // já calcula o peso ideal e o armazena na classe Person
        Person.setDifIdealWeight(calcKgToIdealWeight());
        Person.setBMI((float)bmi);
        Person.setStringBMI(retornResultBMI(bmi));
        return Float.toString(Person.getBMI());
    }


    public int calcKgToIdealWeight(){
        //calcula peso ideal do usuario de acordo com o resultado do IMC
        // e retorna quantos kg falta perder ou ganhar para atingir este peso
        Person.setPesoIdeal((int)(Math.pow((Person.getHeight()/100), 2) * 27));

        return (int)(Person.getPesoIdeal() - Person.getWeight());
    }

    // Verifica resultado do IMC e já concatena com uma string de feedback do resultado
    public String retornResultBMI(double bmi){

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
    public String calcBMR(){
        float weight = Person.getWeight();
        float height = Person.getHeight();
        float age = Person.getAge();
        String gender = Person.getGender();
        double bmr;
        double qntPhysicalAct = checkQntPhysicalAct();

        switch(gender){

            case"Masculino":
                //Calcula IMB do sexo masculino
                bmr = (66 + (13.8 * weight) + (5 * height) - (6.8 * age)) * qntPhysicalAct;
                Person.setBMR((float)bmr);
                return Person.getStringBMR();

            case"Feminino":
                //Calcula IMB do sexo feminino
                bmr = (655 + (9.6 * weight) + (1.8 * height) - (4.7 * age)) * qntPhysicalAct;
                Person.setBMR((float)bmr);
                return Person.getStringBMR();
            default:
                return Double.toString(0.00);
        }

    }
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
    public String calcWaterQnt(){
        float peso = Person.getWeight();
        String resultWater = Double.toString(peso * 0.035);
        Person.setStringHDR(convertResult(resultWater));
        return Person.getStringHDR();

    }
    public String convertResult(String result){
        if(result.length()>5){
            result = result.substring(0,5);
        }
        switch(result.length()){
            case 1: return result.substring(0,1);
            case 2: return result.substring(0,2);
            case 3: return result.substring(0,3);
            case 4:
                switch (result.indexOf(".")){
                    case 2:
                        return result.substring(0,4);

                    case 1:
                        return result.substring(0,3);
                    default:
                        break;
                }
                return result.substring(0,4);
            case 5:
                switch (result.indexOf(".")){
                    case 2:
                        return result.substring(0,4);

                    case 1:
                        return result.substring(0,3);
                    default:
                        break;
                }
                return result.substring(0,4);

            default: return result.substring(0,1);
        }

    }

}
