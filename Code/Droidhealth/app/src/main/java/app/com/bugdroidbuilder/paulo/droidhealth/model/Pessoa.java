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

    private static float IMC;
    private static float IMB;
    private static int pesoIdeal;
    private static int difPesoIdeal;

    private static StringBuilder qntAgua = new StringBuilder();
    private static StringBuilder pesoString = new StringBuilder();
    private static StringBuilder alturaString = new StringBuilder();
    private static StringBuilder imcString = new StringBuilder();
    private static StringBuilder imbString = new StringBuilder();

    public static float getPeso() {
        return peso;
    }

    public static void setPeso(float peso) {
        Pessoa.peso = (int)peso;
        Pessoa.pesoString = new StringBuilder().append("Peso: ").append(Pessoa.peso).append(" Kg");
    }

    public static float getAltura() {
        return altura;
    }

    public static void setAltura(float altura) {
        Pessoa.altura = (int)altura;
        Pessoa.alturaString = new StringBuilder().append("Altura: ").append((int)altura).append(" cm");
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
        return qntAgua.toString();
    }

    public static void setQntAgua(String qntAgua) {
        Pessoa.qntAgua = new StringBuilder().append("Consumo de água recomendado: ").append(qntAgua).append(" litros/dia");
    }

    public static float getIMC() {
        return IMC;
    }

    public static void setIMC(float IMC) {
        Pessoa.IMC = IMC;
    }

    public static float getIMB() {
        return IMB;
    }

    public static void setIMB(float IMB) {
        Pessoa.IMB = IMB;
        Pessoa.imbString = new StringBuilder().append("Gasto de kcal: ").append((int)IMB).append("/dia");
    }

    public static String getImbString() {
        return imbString.toString();
    }

    public static int getPesoIdeal() {
        return pesoIdeal;
    }

    public static void setPesoIdeal(int pesoIdeal) {
        Pessoa.pesoIdeal = pesoIdeal;
    }

    public static String getImcString() {
        return imcString.toString();
    }

    public static void setImcString(String imcString) {
        Pessoa.imcString = new StringBuilder().append(imcString);
    }

    public static void setDifPesoIdeal(int dif) {
        Pessoa.difPesoIdeal = dif;
    }

    public static int getDifPesoIdeal() {
        return difPesoIdeal;
    }

    public static String getPesoString() {
        return pesoString.toString();
    }

    public static String getAlturaString() {
        return alturaString.toString();
    }
}
