package app.com.bugdroidbuilder.paulo.droidhealth.model;

/**
 * Created by paulo on 02/04/16.
 */
public class Pessoa {
    private static float peso;
    private static float altura;
    private static int idade;
    private static String sexo;
    private static String qntExFisico;
    private static String qntAgua;
    private static String IMC;
    private static String IMB;
    private static int pesoIdeal;
    private static int difPesoIdeal;


    public static float getPeso() {
        return peso;
    }

    public static void setPeso(float peso) {
        Pessoa.peso = peso;
    }

    public static float getAltura() {
        return altura;
    }

    public static void setAltura(float altura) {
        Pessoa.altura = altura;
    }

    public static int getIdade() {
        return idade;
    }

    public static void setIdade(int idade) {
        Pessoa.idade = idade;
    }

    public static String getSexo() {
        return sexo;
    }

    public static void setSexo(String sexo) {
        Pessoa.sexo = sexo;
    }

    public static String getQntExFisico() {
        return qntExFisico;
    }

    public static void setQntExFisico(String qntExFisico) {
        Pessoa.qntExFisico = qntExFisico;
    }

    public static String getQntAgua() {
        return qntAgua;
    }

    public static void setQntAgua(String qntAgua) {
        Pessoa.qntAgua = qntAgua;
    }

    public static String getIMC() {
        return IMC;
    }

    public static void setIMC(String IMC) {
        Pessoa.IMC = IMC;
    }

    public static String getIMB() {
        return IMB;
    }

    public static void setIMB(String IMB) {
        Pessoa.IMB = IMB;
    }

    public static int getPesoIdeal() {
        return pesoIdeal;
    }

    public static void setPesoIdeal(int pesoIdeal) {
        Pessoa.pesoIdeal = pesoIdeal;
    }

    public static void setDifPesoIdeal(int dif) {
        Pessoa.difPesoIdeal = dif;
    }

    public static int getDifPesoIdeal() {
        return difPesoIdeal;
    }
}
