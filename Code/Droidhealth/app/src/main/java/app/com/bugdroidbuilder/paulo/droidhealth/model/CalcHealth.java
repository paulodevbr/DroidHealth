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

    public String calcIMC(){
        //calcula IMC, divide altura por 100 porque na formula do IMC altura deve estar em metros
        float peso = Pessoa.getPeso();
        float altura = Pessoa.getAltura();
        double imc = peso/(Math.pow((altura/100), 2));
        // já calcula o peso ideal e o armazena na classe Pessoa
        Pessoa.setDifPesoIdeal(calcKgParaPesoIdeal(imc));
        Pessoa.setIMC((float)imc);
        Pessoa.setImcString(retornaResultIMC(imc));
        return Float.toString(Pessoa.getIMC());
    }


    public int calcKgParaPesoIdeal(double imc){
        //calcula peso ideal do usuario de acordo com o resultado do IMC
        // e retorna quantos kg faltam para atingir este peso
        Pessoa.setPesoIdeal((int)(Math.pow((Pessoa.getAltura()/100), 2) * 27));

        return (int)(Pessoa.getPesoIdeal() - Pessoa.getPeso());
    }

    // Verifica resultado do IMC e já concatena com uma string de feedback do resultado
    public String retornaResultIMC(double imc){

        String resultado = Double.toString(imc);
        if(imc < 17){
            return MUITO_ABAIXO_DO_PESO;
        }else if(17 <= imc && imc <= 18.49){
            return ABAIXO_DO_PESO;
        }else if(18.5 <= imc && imc <= 24.99){
            return NO_PESO;
        }else if(25 <= imc && imc <= 29.99){
            return ACIMA_DO_PESO;
        }else if(30 <= imc && imc <= 34.99){
            return  OBESIDADE;
        }
        else if(35 <= imc && imc >= 39.99){
            return OBESIDADE_SEVERA;
        }else{
            return OBESIDADE_MORBIDA;
        }

    }
    public String calcIMB(){
        float peso = Pessoa.getPeso();
        float altura = Pessoa.getAltura();
        float idade = Pessoa.getIdade();
        String sexo = Pessoa.getSexo();
        String imb;
        double qntExercicios = verificaQntExercicios();

        switch(sexo){

            case"Masculino":
                //Calcula IMB do sexo masculino
                imb = formataTamanhoResultado(Double.toString((66 + (13.8 * peso) + (5 * altura) - (6.8 * idade)) * qntExercicios)) + " calorias";
                Pessoa.setIMB(imb);
                return Pessoa.getIMB();

            case"Feminino":
                //Calcula IMB do sexo feminino
                imb = formataTamanhoResultado(Double.toString((655 + (9.6 * peso) + (1.8 * altura) - (4.7 * idade)) * qntExercicios))+ " calorias";
                Pessoa.setIMB(imb);
                return Pessoa.getIMB();
            default:
                return Double.toString(0.00);
        }

    }
    public double verificaQntExercicios() {
        String qntExercString = Pessoa.getQntExFisico();
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
    public String calcAgua(){
        float peso = Pessoa.getPeso();
        String resultAgua = Double.toString(peso * 0.035);
        Pessoa.setQntAgua(formataTamanhoResultado(resultAgua));
        return Pessoa.getQntAgua();

    }
    public String formataTamanhoResultado(String resultado){
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
                        break;
                }
                return resultado.substring(0,4);
            case 5:
                switch (resultado.indexOf(".")){
                    case 2:
                        return resultado.substring(0,4);

                    case 1:
                        return resultado.substring(0,3);
                    default:
                        break;
                }
                return resultado.substring(0,4);

            default: return resultado.substring(0,1);
        }

    }

}
