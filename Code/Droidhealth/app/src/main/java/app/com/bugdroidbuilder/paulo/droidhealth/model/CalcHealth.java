package app.com.bugdroidbuilder.paulo.droidhealth.model;

/**
 * Created by paulo on 02/04/16.
 */
public final class CalcHealth {

    private final String MUITO_ABAIXO_DO_PESO = "Muito abaixo do peso";
    private final String ABAIXO_DO_PESO = "Abaixo do peso";
    private final String NO_PESO = "Saudável";
    private final String ACIMA_DO_PESO = "Acima do peso";
    private final String OBESIDADE = "Obesidade";
    private final String OBESIDADE_SEVERA = "Obesidade severa";
    private final String OBESIDADE_MORBIDA = "Obesidade mórbida";


    public String calcIMC(float peso, float altura){
        return verificaIMC(peso/Math.pow(altura, 2));
    }
    public String verificaIMC(Double imc){
        String resultado;
        if(imc < 17){
            return Double.toString(imc).substring(0,5) + "\n" +  MUITO_ABAIXO_DO_PESO;
        }else if(17 <= imc && imc <= 18.49){
            return Double.toString(imc).substring(0,5) + "\n" + ABAIXO_DO_PESO;
        }else if(18.5 <= imc && imc <= 24.99){
            return Double.toString(imc).substring(0,5) + "\n" + NO_PESO;
        }else if(25 <= imc && imc <= 29.99){
            return Double.toString(imc).substring(0,5) + "\n" + ACIMA_DO_PESO;
        }else if(30 <= imc && imc <= 34.99){
            return Double.toString(imc).substring(0,5) + "\n" +  OBESIDADE;
        }
        else if(35 <= imc && imc >= 39.99){
            return Double.toString(imc) + OBESIDADE_SEVERA;
        }else{
            return Double.toString(imc) + OBESIDADE_MORBIDA;
        }

    }
    public Double calcIMB(float peso, float altura, int idade, float qntExercicios, char sexo){

        switch(sexo){

            case'M':
                //Calcula IMB do sexo masculino
                return 66 + (13.8 * peso) + (5 * altura) - (6.8 * idade) * qntExercicios;

            case'F':
                //Calcula IMB do sexo feminino
                return 655 + (9.6 * peso) + (1.8 * altura) - (4.7 * idade) * qntExercicios;
            default:
                return 0.0000;
        }

    }
    public String calcAgua(float peso){
        try{
            return Double.toString(peso * 0.035).substring(0,4) + " litros";
        }catch(IndexOutOfBoundsException e){
            return Double.toString(peso * 0.035).substring(0,3) + " litros";
        }

    }
}
