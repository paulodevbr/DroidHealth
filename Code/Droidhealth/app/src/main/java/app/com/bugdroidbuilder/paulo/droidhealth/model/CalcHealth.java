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


    public String calcIMC(int peso, int altura){
        return verificaIMC(peso/Math.pow((altura/100), 2));
    }
    public String verificaIMC(Double imc){
        String resultado = Double.toString(imc);
        if(imc < 17){
            return verificaTamanhoResultado(resultado) + "\n" +  MUITO_ABAIXO_DO_PESO;
        }else if(17 <= imc && imc <= 18.49){
            return verificaTamanhoResultado(resultado) + "\n" + ABAIXO_DO_PESO;
        }else if(18.5 <= imc && imc <= 24.99){
            return verificaTamanhoResultado(resultado) + "\n" + NO_PESO;
        }else if(25 <= imc && imc <= 29.99){
            return verificaTamanhoResultado(resultado) + "\n" + ACIMA_DO_PESO;
        }else if(30 <= imc && imc <= 34.99){
            return verificaTamanhoResultado(resultado) + "\n" + OBESIDADE;
        }
        else if(35 <= imc && imc >= 39.99){
            return verificaTamanhoResultado(resultado) + "\n" + OBESIDADE_SEVERA;
        }else{
            return verificaTamanhoResultado(resultado) + "\n" + OBESIDADE_MORBIDA;
        }

    }
    public double calcIMB(float peso, int altura, int idade, float qntExercicios, String sexo){

        switch(sexo){

            case"Masculino":
                //Calcula IMB do sexo masculino
                return 66 + (13.8 * peso) + (5 * altura) - (6.8 * idade) * qntExercicios;

            case"Feminino":
                //Calcula IMB do sexo feminino
                return 655 + (9.6 * peso) + (1.8 * altura) - (4.7 * idade) * qntExercicios;
            default:
                return 0.0000;
        }

    }
    /*public double verificaQntExercicios(String qntExercicios){

        switch (qntExercicios){

        }
        return qntExercicios;
    }*/
    public String calcAgua(int peso){
        String resultAgua = Double.toString(peso * 0.035);
        return verificaTamanhoResultado(resultAgua) + " litros";

    }
    public String verificaTamanhoResultado(String resultado){
        if(resultado.length()>5){
            resultado = resultado.substring(0,5);
        }
        switch(resultado.length()){
            case 1: return resultado.substring(0,1);
            case 2: return resultado.substring(0,2);
            case 3: return resultado.substring(0,3);
            case 4:
                switch (resultado.indexOf(".")){
                    case 2:
                        return resultado.substring(0,4);

                    case 1:
                        return resultado.substring(0,3);
                    default:
                        return resultado.substring(0,3);
                }
            case 5:
                switch (resultado.indexOf(".")){
                    case 2:
                        return resultado.substring(0,4);

                    case 1:
                        return resultado.substring(0,3);
                    default:
                        return resultado.substring(0,3);
                }

            default: return resultado.substring(0,1);
        }

    }

}
