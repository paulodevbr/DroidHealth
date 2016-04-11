package app.com.bugdroidbuilder.paulo.droidhealth.model;

/**
 * Created by paulo on 02/04/16.
 */
public class Pessoa {
    private float peso;
    private float altura;
    private int idade;
    private char sexo;

    private double qntAgua;
    private float IMC;
    private double IMB;
    private float qntExecicios;

    public float getQntExecicios() {
        return qntExecicios;
    }

    public void setQntExecicios(float qntExecicios) {
        this.qntExecicios = qntExecicios;
    }

    public double getQntAgua() {
        return qntAgua;
    }

    public void setQntAgua(double qntAgua) {
        this.qntAgua = qntAgua;
    }

    public float getIMC() {
        return IMC;
    }

    public void setIMC(float IMC) {
        this.IMC = IMC;
    }

    public double getIMB() {
        return IMB;
    }

    public void setIMB(double IMB) {
        this.IMB = IMB;
    }



    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
}
