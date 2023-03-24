package com.example.calculadora;

public class Calculadora {
    String numero,aux;

    public Calculadora (String numero,String aux) {
        this.numero=numero;
        this.aux=aux;
    }

    public String suma(String n,String aux) {



        return String.valueOf((Integer.parseInt(n)+Integer.parseInt(aux)));
    }





}
