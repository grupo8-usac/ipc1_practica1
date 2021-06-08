package com.company;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.*;
//C:\Users\EPA\Desktop\PruebaTxt
public class Main {
    static Scanner lec = new Scanner(System.in);
    double MatrizA[][];
    double MatrizB[][];
    double MatrizC[][];
    double MatrizD[][];
    double MatrizE[][];
    double MatrizF[][];
    double MatrizG[][];
    double MatrizH[][];
    double MatrizI[][];
    double MatrizJ[][];
    double MatrizK[][];
    double MatrizL[][];
    double MatrizM[][];
    double MatrizN[][];
    double MatrizO[][];
    double MatrizP[][];
    double MatrizQ[][];
    double MatrizS[][];
    double MatrizT[][];
    double MatrizU[][];
    double MatrizV[][];
    double MatrizW[][];
    double MatrizX[][];
    double MatrizY[][];
    double MatrizZ[][];
    double R[][];
    static double determinante_orden2, determinante_orden3;
    ;
    static double PrimeraMatriz_suma[][], SegundaMatriz_suma[][], Resultante_suma[][];
    static double PrimeraMatriz_resta[][], SegundaMatriz_resta[][], Resultante_resta[][];
    static double PrimeraMatriz_mult1[][], Resultante_mult1[][];
    static double numero;
    static double PrimeraMatriz_mult[][], SegundaMatriz_mult[][], Resultante_mult[][];
    static double PrimeraMatriz_divi[][], SegundaMatriz_divi[][], Resultante_divi[][];
    static double PrimeraMatriz_trans[][], Resultante_trans[][];
    static double PrimeraMatriz_inversa[][], Resultante_inversa[][];
    static double PrimeraMatriz_dete[][], Resultante_dete[][];
    static double PrimeraMatriz_pote[][], Resultante_pote[][];
    static double numero1;
    static public boolean suma_reporte = false, resta_reporte = false, division_reporte = false, mult_reporte = false,
            potencia_reporte = false, multnumero_reporte = false, determinante_reporte = false, inversa_reporte = false, det2 = false, det3 = false, tras_reporte = false;
    double SegundaMatriz[][];
    double PrimeraMatriz[][];
    double RR[][];
    public static double MatrizAux[][];
    Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        Main menu = new Main();
        menu.Menu();
    }

    public void Menu() {
        boolean entrar_menu = true;
        while (entrar_menu == true) {
            System.out.println("===Seleccione lo que desea cargar===");
            System.out.println(" 1. Cargar Matrices");
            System.out.println(" 2. Sumar Matrices ");
            System.out.println(" 3. Restar Matrices");
            System.out.println(" 4. Multiplicar Matirices ");
            //   System.out.println(" 5. Por un numero");
            // System.out.println(" 6. Por otra Matriz");
            System.out.println(" 5. Dividir Matrices");
            System.out.println(" 6. Transpuesta de Matriz");
            System.out.println(" 7. Matriz Inversa");
            System.out.println(" 8. Potencia de una Matriz");
            System.out.println(" 9. Determinante de una Matriz");
            System.out.println("10. Reportes");
            System.out.println("11. Salir");
            System.out.println("====================================");
            System.out.print(">>>Escribir el número de opción: >");

            Scanner lec = new Scanner(System.in);
            int opccion = lec.nextInt();
            while (opccion < 1 || 11 < opccion) {
                System.out.println(">>>Error, Escribir una opción del 1 al 11>>>");
                opccion = lec.nextInt();
            }
            switch (opccion) {
                case 1:
                    lectura_archivo();
                    break;
                case 2:
                    SumaMatriz();
                    break;
                case 3:
                    RestaMatriz();
                    break;
                case 4:
                    Menu_Mult();
                    // MultMatriz();
                    break;
                case 5:
                    DivMatriz();

                    //Mult1Matriz();
                    break;
                case 6:
                    TransMatriz();
                    break;
                case 7:
                    Inversa();
                    break;
                case 8:
                    Potencia();
                    break;
                case 9:
                    Determinante();
                    break;
                case 10:
                    Reportes();
                    //();
                    break;
                case 11:
                    System.out.println("Gracias por usar el Menú bye :v ");
                    entrar_menu = false;
                    break;

            }
        }
    }

    public void Menu_Mult() {
        boolean entrar_menu1 = true;
        while (entrar_menu1 == true) {
            System.out.println("===Menú_Multiplicación===");
            System.out.println(" 1. Multiplicar por un número");
            System.out.println(" 2. Multiplicar por otra matriz");
            System.out.println(" 3. Salir");
            System.out.println("====================================");
            System.out.print(">>>Escribir el número de opción: ");
            Scanner lec = new Scanner(System.in);
            int opccion = lec.nextInt();
            while (opccion < 1 || 3 < opccion) {
                System.out.println(">>>Error, Escribir una opción del 1 al 3>>>");
                opccion = lec.nextInt();
            }
            switch (opccion) {
                case 1:
                    MultMatriz_por_numero();
                    break;
                case 2:
                    MultMatriz_Matriz();
                    break;
                case 3:
                    System.out.println("Gracias por usar el Menú_Multiplicación bye :v ");
                    entrar_menu1 = false;
                    break;
            }
        }

    }

    public void lectura_archivo() {
        try {
            System.out.println("Ingrese la ruta de las matrices");
            System.out.print(">");
            String R1 = leer.nextLine();
            R1 = R1.replaceAll("\"", "");
            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;
            try {
                archivo = new File(R1);
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                String linea;
                while ((linea = br.readLine()) != null) {
                    String conte[] = linea.split(":");
                    char nombre = conte[0].charAt(0);

                    String Filas1[] = conte[1].split(";");
                    boolean Filas = true;
                    String temp[] = Filas1[0].split(",");

                    int cantidad = temp.length; // 3

                    for (int i = 1; i < Filas1.length; i++) {
                        String columna[] = Filas1[i].split(",");
                        int aux = columna.length;
                        if (cantidad != aux) {
                            Filas = false;
                        }
                    }
                    if (Filas) {
                        asignando_matriz(nombre, Filas1.length, cantidad, Filas1);
                    } else {
                        System.out.println("Ocurrio un error");
                    }
                }
            } catch (IOException e) {
                leer.nextLine();
                System.out.println("Error no se encontró la matriz");
            } finally {
                try {
                    if (null != fr) {
                        fr.close();
                    }
                } catch (IOException e2) {
                    leer.nextLine();
                    System.out.println("Error");
                }
            }
        } catch (Exception e) {
            leer.nextLine();
            System.out.println("Ocurrio un error.//" + "--");
        }
    }

    public void asignando_matriz(char Nombre, int fila, int colu, String[] contenido) {
        System.out.println(Nombre);
        switch (Nombre) {
            case 'A':
                MatrizA = Matriz_llenado(fila, colu, contenido);
                Imprimir(MatrizA, 'A');
                break;
            case 'B':
                MatrizB = Matriz_llenado(fila, colu, contenido);
                Imprimir(MatrizB, 'B');
                break;
            case 'C':
                MatrizC = Matriz_llenado(fila, colu, contenido);
                Imprimir(MatrizC, 'C');
                break;
            case 'D':
                MatrizD = Matriz_llenado(fila, colu, contenido);
                Imprimir(MatrizD, 'D');
                break;
            case 'E':
                MatrizE = Matriz_llenado(fila, colu, contenido);
                Imprimir(MatrizE, 'E');
                break;
            case 'F':
                MatrizF = Matriz_llenado(fila, colu, contenido);
                Imprimir(MatrizF, 'F');
                break;
            case 'G':
                MatrizG = Matriz_llenado(fila, colu, contenido);
                Imprimir(MatrizG, 'G');
                break;
            case 'H':
                MatrizH = Matriz_llenado(fila, colu, contenido);
                Imprimir(MatrizH, 'H');
                break;
            case 'I':
                MatrizI = Matriz_llenado(fila, colu, contenido);
                Imprimir(MatrizI, 'I');
                break;
            case 'J':
                MatrizJ = Matriz_llenado(fila, colu, contenido);
                Imprimir(MatrizJ, 'J');
                break;
            case 'K':
                MatrizK = Matriz_llenado(fila, colu, contenido);
                Imprimir(MatrizK, 'K');
                break;
            case 'L':
                MatrizL = Matriz_llenado(fila, colu, contenido);
                Imprimir(MatrizL, 'L');
                break;
            case 'M':
                MatrizM = Matriz_llenado(fila, colu, contenido);
                Imprimir(MatrizM, 'M');
                break;
            case 'N':
                MatrizN = Matriz_llenado(fila, colu, contenido);
                Imprimir(MatrizN, 'N');
                break;
            case 'O':
                MatrizO = Matriz_llenado(fila, colu, contenido);
                Imprimir(MatrizO, 'O');
                break;
            case 'P':
                MatrizP = Matriz_llenado(fila, colu, contenido);
                Imprimir(MatrizP, 'P');
                break;
            case 'Q':
                MatrizQ = Matriz_llenado(fila, colu, contenido);
                Imprimir(MatrizQ, 'Q');
                break;
            case 'R':
                R = Matriz_llenado(fila, colu, contenido);
                Imprimir(R, 'R');
                break;
            case 'S':
                MatrizS = Matriz_llenado(fila, colu, contenido);
                Imprimir(MatrizS, 'S');
                break;
            case 'T':
                MatrizT = Matriz_llenado(fila, colu, contenido);
                Imprimir(MatrizT, 'T');
                break;
            case 'U':
                MatrizU = Matriz_llenado(fila, colu, contenido);
                Imprimir(MatrizU, 'U');
                break;
            case 'V':
                MatrizV = Matriz_llenado(fila, colu, contenido);
                Imprimir(MatrizV, 'V');
                break;
            case 'W':
                MatrizW = Matriz_llenado(fila, colu, contenido);
                Imprimir(MatrizW, 'W');
                break;
            case 'X':
                MatrizX = Matriz_llenado(fila, colu, contenido);
                Imprimir(MatrizX, 'X');
                break;
            case 'Y':
                MatrizY = Matriz_llenado(fila, colu, contenido);
                Imprimir(MatrizY, 'Y');
                break;
            case 'Z':
                MatrizZ = Matriz_llenado(fila, colu, contenido);
                Imprimir(MatrizZ, 'Z');
                break;
            default:
                System.out.println("Error en el  archivo");
                break;
        }
    }

    public double[][] Matriz_llenado(int Filas, int Columnas, String[] contenido) {
        int aux = 0;
        double[][] numeros = new double[Filas][Columnas];
        double[] primera = new double[Columnas];

        for (int i = 0; i < Filas; i++) {
            String datosFilas[] = contenido[i].split(",");
            for (int j = 0; j < Columnas; j++) {
                primera[j] = Double.parseDouble(datosFilas[j]);
            }
            if (aux < Filas) {
                double temp[] = new double[primera.length];
                for (int j = 0; j < temp.length; j++) {
                    temp[j] = primera[j];
                }
                numeros[aux] = temp;
                aux++;
            }
        }
        return numeros;
    }

    public void Imprimir(double[][] Matriz, char Nombre) {
        System.out.println("Matriz: " + Nombre);
        for (double[] Nombre1 : Matriz) {
            for (int j = 0; j < Matriz[0].length; j++) {
                System.out.print(((double) (Math.round(Nombre1[j] * 100000d) / 100000d)) + "\t");//truncar numeros
            }
            System.out.println("");
        }
        System.out.println("");
    }

    void SumaMatriz() {
        try {
            suma_reporte = true;
            if (suma_reporte == true) {
                System.out.println("Ingrese el nombre de la Matriz 1: ");
                String A = leer.nextLine();
                A = A.toUpperCase();// conviertiendo el mensaje a MAYUSCULA
                if (A != null) {
                    if (A.equals("A")) {
                        PrimeraMatriz_suma = MatrizA;
                    }
                    if (A.equals("B")) {
                        PrimeraMatriz_suma = MatrizB;
                    }
                    if (A.equals("C")) {
                        PrimeraMatriz_suma = MatrizC;
                    }
                    if (A.equals("D")) {
                        PrimeraMatriz_suma = MatrizD;
                    }
                    if (A.equals("E")) {
                        PrimeraMatriz_suma = MatrizE;
                    }
                    if (A.equals("F")) {
                        PrimeraMatriz_suma = MatrizF;
                    }
                    if (A.equals("G")) {
                        PrimeraMatriz_suma = MatrizG;
                    }
                    if (A.equals("H")) {
                        PrimeraMatriz_suma = MatrizH;
                    }
                    if (A.equals("I")) {
                        PrimeraMatriz_suma = MatrizI;
                    }
                    if (A.equals("J")) {
                        PrimeraMatriz_suma = MatrizJ;
                    }
                    if (A.equals("K")) {
                        PrimeraMatriz_suma = MatrizK;
                    }
                    if (A.equals("L")) {
                        PrimeraMatriz_suma = MatrizL;
                    }
                    if (A.equals("M")) {
                        PrimeraMatriz_suma = MatrizM;
                    }
                    if (A.equals("N")) {
                        PrimeraMatriz_suma = MatrizN;
                    }
                    if (A.equals("O")) {
                        PrimeraMatriz_suma = MatrizO;
                    }
                    if (A.equals("P")) {
                        PrimeraMatriz_suma = MatrizP;
                    }
                    if (A.equals("Q")) {
                        PrimeraMatriz_suma = MatrizQ;
                    }
                    if (A.equals("R")) {
                        PrimeraMatriz_suma = R;
                    }
                    if (A.equals("S")) {
                        PrimeraMatriz_suma = MatrizS;
                    }
                    if (A.equals("T")) {
                        PrimeraMatriz_suma = MatrizT;
                    }
                    if (A.equals("U")) {
                        PrimeraMatriz_suma = MatrizU;
                    }
                    if (A.equals("V")) {
                        PrimeraMatriz_suma = MatrizV;
                    }
                    if (A.equals("W")) {
                        PrimeraMatriz_suma = MatrizW;
                    }
                    if (A.equals("X")) {
                        PrimeraMatriz_suma = MatrizX;
                    }
                    if (A.equals("Y")) {
                        PrimeraMatriz_suma = MatrizY;
                    }
                    if (A.equals("Z")) {
                        PrimeraMatriz_suma = MatrizZ;
                    }
                } else {
                    System.out.printf("La matriz " + A + " Esta vacia o tiene mal sus datos ");
                }
                Mostrarmatriz(PrimeraMatriz_suma);
                System.out.println("La matriz es: " + A);
                System.out.println("Ingrese el nombre de la Matriz 2: ");
                String B = leer.nextLine();
                B = B.toUpperCase();// conviertiendo el mensaje a MAYUSCULA

                if (B != null) {
                    if (B.equals("A")) {
                        SegundaMatriz_suma = MatrizA;
                    }
                    if (B.equals("B")) {
                        SegundaMatriz_suma = MatrizB;
                    }
                    if (B.equals("C")) {
                        SegundaMatriz_suma = MatrizC;
                    }
                    if (B.equals("D")) {
                        SegundaMatriz_suma = MatrizD;
                    }
                    if (B.equals("E")) {
                        SegundaMatriz_suma = MatrizE;
                    }
                    if (B.equals("F")) {
                        SegundaMatriz_suma = MatrizF;
                    }
                    if (B.equals("G")) {
                        SegundaMatriz_suma = MatrizG;
                    }
                    if (B.equals("H")) {
                        SegundaMatriz_suma = MatrizH;
                    }
                    if (B.equals("I")) {
                        SegundaMatriz_suma = MatrizI;
                    }
                    if (B.equals("J")) {
                        SegundaMatriz_suma = MatrizJ;
                    }
                    if (B.equals("K")) {
                        SegundaMatriz_suma = MatrizK;
                    }
                    if (B.equals("L")) {
                        SegundaMatriz_suma = MatrizL;
                    }
                    if (B.equals("M")) {
                        SegundaMatriz_suma = MatrizM;
                    }
                    if (B.equals("N")) {
                        SegundaMatriz_suma = MatrizN;
                    }
                    if (B.equals("O")) {
                        SegundaMatriz_suma = MatrizO;
                    }
                    if (B.equals("P")) {
                        SegundaMatriz_suma = MatrizP;
                    }
                    if (B.equals("Q")) {
                        SegundaMatriz_suma = MatrizQ;
                    }
                    if (B.equals("R")) {
                        SegundaMatriz_suma = R;
                    }
                    if (B.equals("S")) {
                        SegundaMatriz_suma = MatrizS;
                    }
                    if (B.equals("T")) {
                        SegundaMatriz_suma = MatrizT;
                    }
                    if (B.equals("U")) {
                        SegundaMatriz_suma = MatrizU;
                    }
                    if (B.equals("V")) {
                        SegundaMatriz_suma = MatrizV;
                    }
                    if (B.equals("W")) {
                        SegundaMatriz_suma = MatrizW;
                    }
                    if (B.equals("X")) {
                        SegundaMatriz_suma = MatrizX;
                    }
                    if (B.equals("Y")) {
                        SegundaMatriz_suma = MatrizY;
                    }
                    if (B.equals("Z")) {
                        SegundaMatriz_suma = MatrizZ;
                    }
                } else {
                    System.out.printf("La matriz " + B + " Esta vacia o tienen mal sus datos ");
                }

                Mostrarmatriz(SegundaMatriz_suma);
                System.out.println("La matriz es: " + B);
                R = new double[PrimeraMatriz_suma.length][SegundaMatriz_suma[0].length];//instanciando matriz final


                if (PrimeraMatriz_suma.length == SegundaMatriz_suma.length && PrimeraMatriz_suma[0].length == SegundaMatriz_suma[0].length) {
                    for (int i = 0; i < PrimeraMatriz_suma.length; i++) {
                        for (int j = 0; j < PrimeraMatriz_suma[i].length; j++) {
                            R[i][j] = PrimeraMatriz_suma[i][j] + SegundaMatriz_suma[i][j];
                        }
                    }
                    Resultante_suma = new double[PrimeraMatriz_suma.length][SegundaMatriz_suma[0].length];//instanciando matriz final
                    for (int i = 0; i < PrimeraMatriz_suma.length; i++) {
                        for (int j = 0; j < PrimeraMatriz_suma[i].length; j++) {
                            Resultante_suma[i][j] = PrimeraMatriz_suma[i][j] + SegundaMatriz_suma[i][j];
                        }
                    }
                    System.out.println("------------------");
                    System.out.println("La Suma es:");
                    System.out.println("-|La Matriz Resultante es|-");
                    Mostrarmatriz(R);
                    System.out.println("------------------");
                }
            } else {
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Las Matrices no tienen las mismas dimensiones para realizar la operacion");
                System.out.println("------------------------------------------------------------------------");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void RestaMatriz() {
        try {
            resta_reporte = true;
            if (resta_reporte == true) {
                System.out.println("Ingrese el nombre de la Matriz 1: ");
                String A = leer.nextLine();
                A = A.toUpperCase();// conviertiendo el mensaje a MAYUSCULA
                if (A != null) {
                    if (A.equals("A")) {
                        PrimeraMatriz_resta = MatrizA;
                    }
                    if (A.equals("B")) {
                        PrimeraMatriz_resta = MatrizB;
                    }
                    if (A.equals("C")) {
                        PrimeraMatriz_resta = MatrizC;
                    }
                    if (A.equals("D")) {
                        PrimeraMatriz_resta = MatrizD;
                    }
                    if (A.equals("E")) {
                        PrimeraMatriz_resta = MatrizE;
                    }
                    if (A.equals("F")) {
                        PrimeraMatriz_resta = MatrizF;
                    }
                    if (A.equals("G")) {
                        PrimeraMatriz_resta = MatrizG;
                    }
                    if (A.equals("H")) {
                        PrimeraMatriz_resta = MatrizH;
                    }
                    if (A.equals("I")) {
                        PrimeraMatriz_resta = MatrizI;
                    }
                    if (A.equals("J")) {
                        PrimeraMatriz_resta = MatrizJ;
                    }
                    if (A.equals("K")) {
                        PrimeraMatriz_resta = MatrizK;
                    }
                    if (A.equals("L")) {
                        PrimeraMatriz_resta = MatrizL;
                    }
                    if (A.equals("M")) {
                        PrimeraMatriz_resta = MatrizM;
                    }
                    if (A.equals("N")) {
                        PrimeraMatriz_resta = MatrizN;
                    }
                    if (A.equals("O")) {
                        PrimeraMatriz_resta = MatrizO;
                    }
                    if (A.equals("P")) {
                        PrimeraMatriz_resta = MatrizP;
                    }
                    if (A.equals("Q")) {
                        PrimeraMatriz_resta = MatrizQ;
                    }
                    if (A.equals("R")) {
                        PrimeraMatriz_resta = R;
                    }
                    if (A.equals("S")) {
                        PrimeraMatriz_resta = MatrizS;
                    }
                    if (A.equals("T")) {
                        PrimeraMatriz_resta = MatrizT;
                    }
                    if (A.equals("U")) {
                        PrimeraMatriz_resta = MatrizU;
                    }
                    if (A.equals("V")) {
                        PrimeraMatriz_resta = MatrizV;
                    }
                    if (A.equals("W")) {
                        PrimeraMatriz_resta = MatrizW;
                    }
                    if (A.equals("X")) {
                        PrimeraMatriz_resta = MatrizX;
                    }
                    if (A.equals("Y")) {
                        PrimeraMatriz_resta = MatrizY;
                    }
                    if (A.equals("Z")) {
                        PrimeraMatriz_resta = MatrizZ;
                    }
                } else {
                    System.out.printf("La matriz " + A + " Esta vacia o tienen mal sus datos ");
                }
                Mostrarmatriz(PrimeraMatriz_resta);
                System.out.println("La matriz es: " + A);
                System.out.println("Ingrese el nombre de la Matriz 2: ");
                String B = leer.nextLine();
                B = B.toUpperCase();// conviertiendo el mensaje a MAYUSCULA
                if (A != null) {
                    if (B.equals("A")) {
                        SegundaMatriz_resta = MatrizA;
                    }
                    if (B.equals("B")) {
                        SegundaMatriz_resta = MatrizB;
                    }
                    if (B.equals("C")) {
                        SegundaMatriz_resta = MatrizC;
                    }
                    if (B.equals("D")) {
                        SegundaMatriz_resta = MatrizD;
                    }
                    if (B.equals("E")) {
                        SegundaMatriz_resta = MatrizE;
                    }
                    if (B.equals("F")) {
                        SegundaMatriz_resta = MatrizF;
                    }
                    if (B.equals("G")) {
                        SegundaMatriz_resta = MatrizG;
                    }
                    if (B.equals("H")) {
                        SegundaMatriz_resta = MatrizH;
                    }
                    if (B.equals("I")) {
                        SegundaMatriz_resta = MatrizI;
                    }
                    if (B.equals("J")) {
                        SegundaMatriz_resta = MatrizJ;
                    }
                    if (B.equals("K")) {
                        SegundaMatriz_resta = MatrizK;
                    }
                    if (B.equals("L")) {
                        SegundaMatriz_resta = MatrizL;
                    }
                    if (B.equals("M")) {
                        SegundaMatriz_resta = MatrizM;
                    }
                    if (B.equals("N")) {
                        SegundaMatriz_resta = MatrizN;
                    }
                    if (B.equals("O")) {
                        SegundaMatriz_resta = MatrizO;
                    }
                    if (B.equals("P")) {
                        SegundaMatriz_resta = MatrizP;
                    }
                    if (B.equals("Q")) {
                        SegundaMatriz_resta = MatrizQ;
                    }
                    if (B.equals("R")) {
                        SegundaMatriz_resta = R;
                    }
                    if (B.equals("S")) {
                        SegundaMatriz_resta = MatrizS;
                    }
                    if (B.equals("T")) {
                        SegundaMatriz_resta = MatrizT;
                    }
                    if (B.equals("U")) {
                        SegundaMatriz_resta = MatrizU;
                    }
                    if (B.equals("V")) {
                        SegundaMatriz_resta = MatrizV;
                    }
                    if (B.equals("W")) {
                        SegundaMatriz_resta = MatrizW;
                    }
                    if (B.equals("X")) {
                        SegundaMatriz_resta = MatrizX;
                    }
                    if (B.equals("Y")) {
                        SegundaMatriz_resta = MatrizY;
                    }
                    if (B.equals("Z")) {
                        SegundaMatriz_resta = MatrizZ;
                    }
                } else {
                    System.out.printf("La matriz " + B + " Esta vacia o tiene mal sus datos ");

                }
                Mostrarmatriz(SegundaMatriz_resta);
                System.out.println("La matriz es: " + B);
                R = new double[PrimeraMatriz_resta.length][SegundaMatriz_resta[0].length];//instanciando matriz final
                if (PrimeraMatriz_resta.length == SegundaMatriz_resta.length && SegundaMatriz_resta[0].length == SegundaMatriz_resta[0].length) {
                    for (int i = 0; i < PrimeraMatriz_resta.length; i++) {
                        for (int j = 0; j < PrimeraMatriz_resta[i].length; j++) {
                            R[i][j] = PrimeraMatriz_resta[i][j] - SegundaMatriz_resta[i][j];
                        }
                    }
                    Resultante_resta = new double[PrimeraMatriz_resta.length][SegundaMatriz_resta[0].length];//instanciando matriz final
                    for (int i = 0; i < PrimeraMatriz_resta.length; i++) {
                        for (int j = 0; j < PrimeraMatriz_resta[i].length; j++) {
                            Resultante_resta[i][j] = PrimeraMatriz_resta[i][j] - SegundaMatriz_resta[i][j];
                        }
                    }
                    System.out.println("------------------");
                    System.out.println("La Resta es:");
                    System.out.println("-|La Matriz Resultante es|-");
                    Mostrarmatriz(R);
                    System.out.println("------------------");
                }
            } else {
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Las Matrices no tienen las mismas dimensiones para realizar la operacion");
                System.out.println("------------------------------------------------------------------------");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void MultMatriz_por_numero() {
        try {
            multnumero_reporte = true;
            if (multnumero_reporte == true) {
                System.out.println("Ingrese el nombre de la Matriz: ");
                String A = leer.nextLine();
                A = A.toUpperCase();// conviertiendo el mensaje a MAYUSCULA
                if (A != null) {

                    if (A.equals("A")) {
                        PrimeraMatriz_mult1 = MatrizA;
                    }
                    if (A.equals("B")) {
                        PrimeraMatriz_mult1 = MatrizB;
                    }
                    if (A.equals("C")) {
                        PrimeraMatriz_mult1 = MatrizC;
                    }
                    if (A.equals("D")) {
                        PrimeraMatriz_mult1 = MatrizD;
                    }
                    if (A.equals("E")) {
                        PrimeraMatriz_mult1 = MatrizE;
                    }
                    if (A.equals("F")) {
                        PrimeraMatriz_mult1 = MatrizF;
                    }
                    if (A.equals("G")) {
                        PrimeraMatriz_mult1 = MatrizG;
                    }
                    if (A.equals("H")) {
                        PrimeraMatriz_mult1 = MatrizH;
                    }
                    if (A.equals("I")) {
                        PrimeraMatriz_mult1 = MatrizI;
                    }
                    if (A.equals("J")) {
                        PrimeraMatriz_mult1 = MatrizJ;
                    }
                    if (A.equals("K")) {
                        PrimeraMatriz_mult1 = MatrizK;
                    }
                    if (A.equals("L")) {
                        PrimeraMatriz_mult1 = MatrizL;
                    }
                    if (A.equals("M")) {
                        PrimeraMatriz_mult1 = MatrizM;
                    }
                    if (A.equals("N")) {
                        PrimeraMatriz_mult1 = MatrizN;
                    }
                    if (A.equals("O")) {
                        PrimeraMatriz_mult1 = MatrizO;
                    }
                    if (A.equals("P")) {
                        PrimeraMatriz_mult1 = MatrizP;
                    }
                    if (A.equals("Q")) {
                        PrimeraMatriz_mult1 = MatrizQ;
                    }
                    if (A.equals("R")) {
                        PrimeraMatriz_mult1 = R;
                    }
                    if (A.equals("S")) {
                        PrimeraMatriz_mult1 = MatrizS;
                    }
                    if (A.equals("T")) {
                        PrimeraMatriz_mult1 = MatrizT;
                    }
                    if (A.equals("U")) {
                        PrimeraMatriz_mult1 = MatrizU;
                    }
                    if (A.equals("V")) {
                        PrimeraMatriz_mult1 = MatrizV;
                    }
                    if (A.equals("W")) {
                        PrimeraMatriz_mult1 = MatrizW;
                    }
                    if (A.equals("X")) {
                        PrimeraMatriz_mult1 = MatrizX;
                    }
                    if (A.equals("Y")) {
                        PrimeraMatriz_mult1 = MatrizY;
                    }
                    if (A.equals("Z")) {
                        PrimeraMatriz_mult1 = MatrizZ;
                    }
                } else {
                    System.out.printf("La matriz " + A + " Esta vacia o tiene mal sus datos ");
                }
                Mostrarmatriz(PrimeraMatriz_mult1);
                System.out.println("La Matriz es: " + A);
                //   Imprimir(PrimeraMatriz_mult1, 'R');
                System.out.println("Ingrese el numero para la multiplicación: ");
                String num;
                int n1;
                num = leer.nextLine();
                n1 = Integer.parseInt(num);
                numero = n1;

                R = new double[PrimeraMatriz_mult1.length][PrimeraMatriz_mult1[0].length];
                for (int i = 0; i < PrimeraMatriz_mult1.length; i++) {
                    for (int j = 0; j < PrimeraMatriz_mult1[i].length; j++) {
                        R[i][j] = n1 * (PrimeraMatriz_mult1[i][j]);
                    }
                }
                Resultante_mult1 = new double[PrimeraMatriz_mult1.length][PrimeraMatriz_mult1[0].length];
                for (int i = 0; i < PrimeraMatriz_mult1.length; i++) {
                    for (int j = 0; j < PrimeraMatriz_mult1[i].length; j++) {
                        Resultante_mult1[i][j] = n1 * (PrimeraMatriz_mult1[i][j]);
                    }
                }


                System.out.println("------------------");
                System.out.println("La Multiplicación es:");
                System.out.println("La Matriz Resultante  ");
                Mostrarmatriz(R);

                //  I_double(R, 'R');
                System.out.println("------------------");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void MultMatriz_Matriz() {
        try {
            System.out.println("Ingrese el nombre de la Matriz: ");
            String A = leer.nextLine();
            A = A.toUpperCase();// conviertiendo el mensaje a MAYUSCULA
            mult_reporte = true;
            if (mult_reporte == true) {
                if (A != null) {
                    if (A.equals("A")) {
                        PrimeraMatriz_mult = MatrizA;
                    }
                    if (A.equals("B")) {
                        PrimeraMatriz_mult = MatrizB;
                    }
                    if (A.equals("C")) {
                        PrimeraMatriz_mult = MatrizC;
                    }
                    if (A.equals("D")) {
                        PrimeraMatriz_mult = MatrizD;
                    }
                    if (A.equals("E")) {
                        PrimeraMatriz_mult = MatrizE;
                    }
                    if (A.equals("F")) {
                        PrimeraMatriz_mult = MatrizF;
                    }
                    if (A.equals("G")) {
                        PrimeraMatriz_mult = MatrizG;
                    }
                    if (A.equals("H")) {
                        PrimeraMatriz_mult = MatrizH;
                    }
                    if (A.equals("I")) {
                        PrimeraMatriz_mult = MatrizI;
                    }
                    if (A.equals("J")) {
                        PrimeraMatriz_mult = MatrizJ;
                    }
                    if (A.equals("K")) {
                        PrimeraMatriz_mult = MatrizK;
                    }
                    if (A.equals("L")) {
                        PrimeraMatriz_mult = MatrizL;
                    }
                    if (A.equals("M")) {
                        PrimeraMatriz_mult = MatrizM;
                    }
                    if (A.equals("N")) {
                        PrimeraMatriz_mult = MatrizN;
                    }
                    if (A.equals("O")) {
                        PrimeraMatriz_mult = MatrizO;
                    }
                    if (A.equals("P")) {
                        PrimeraMatriz_mult = MatrizP;
                    }
                    if (A.equals("Q")) {
                        PrimeraMatriz_mult = MatrizQ;
                    }
                    if (A.equals("R")) {
                        PrimeraMatriz_mult = R;
                    }
                    if (A.equals("S")) {
                        PrimeraMatriz_mult = MatrizS;
                    }
                    if (A.equals("T")) {
                        PrimeraMatriz_mult = MatrizT;
                    }
                    if (A.equals("U")) {
                        PrimeraMatriz_mult = MatrizU;
                    }
                    if (A.equals("V")) {
                        PrimeraMatriz_mult = MatrizV;
                    }
                    if (A.equals("W")) {
                        PrimeraMatriz_mult = MatrizW;
                    }
                    if (A.equals("X")) {
                        PrimeraMatriz_mult = MatrizX;
                    }
                    if (A.equals("Y")) {
                        PrimeraMatriz_mult = MatrizY;
                    }
                    if (A.equals("Z")) {
                        PrimeraMatriz_mult = MatrizZ;
                    }
                } else {
                    System.out.printf("La matriz " + A + " Esta vacia o tiene mal sus datos ");
                }
                Mostrarmatriz(PrimeraMatriz_mult);
                System.out.println("La Matriz es: " + A);
                System.out.println("Ingrese el nombre de la Matriz 2: ");
                String B = leer.nextLine();
                B = B.toUpperCase();// conviertiendo el mensaje a MAYUSCULA
                if (B != null) {
                    if (B.equals("A")) {
                        SegundaMatriz_mult = MatrizA;
                    }
                    if (B.equals("B")) {
                        SegundaMatriz_mult = MatrizB;
                    }
                    if (B.equals("C")) {
                        SegundaMatriz_mult = MatrizC;
                    }
                    if (B.equals("D")) {
                        SegundaMatriz_mult = MatrizD;
                    }
                    if (B.equals("E")) {
                        SegundaMatriz_mult = MatrizE;
                    }
                    if (B.equals("F")) {
                        SegundaMatriz_mult = MatrizF;
                    }
                    if (B.equals("G")) {
                        SegundaMatriz_mult = MatrizG;
                    }
                    if (B.equals("H")) {
                        SegundaMatriz_mult = MatrizH;
                    }
                    if (B.equals("I")) {
                        SegundaMatriz_mult = MatrizI;
                    }
                    if (B.equals("J")) {
                        SegundaMatriz_mult = MatrizJ;
                    }
                    if (B.equals("K")) {
                        SegundaMatriz_mult = MatrizK;
                    }
                    if (B.equals("L")) {
                        SegundaMatriz_mult = MatrizL;
                    }
                    if (B.equals("M")) {
                        SegundaMatriz_mult = MatrizM;
                    }
                    if (B.equals("N")) {
                        SegundaMatriz_mult = MatrizN;
                    }
                    if (B.equals("O")) {
                        SegundaMatriz_mult = MatrizO;
                    }
                    if (B.equals("P")) {
                        SegundaMatriz_mult = MatrizP;
                    }
                    if (B.equals("Q")) {
                        SegundaMatriz_mult = MatrizQ;
                    }
                    if (B.equals("R")) {
                        SegundaMatriz_mult = R;
                    }
                    if (B.equals("S")) {
                        SegundaMatriz_mult = MatrizS;
                    }
                    if (B.equals("T")) {
                        SegundaMatriz_mult = MatrizT;
                    }
                    if (B.equals("U")) {
                        SegundaMatriz_mult = MatrizU;
                    }
                    if (B.equals("V")) {
                        SegundaMatriz_mult = MatrizV;
                    }
                    if (B.equals("W")) {
                        SegundaMatriz_mult = MatrizW;
                    }
                    if (B.equals("X")) {
                        SegundaMatriz_mult = MatrizX;
                    }
                    if (B.equals("Y")) {
                        SegundaMatriz_mult = MatrizY;
                    }
                    if (B.equals("Z")) {
                        SegundaMatriz_mult = MatrizZ;
                    }
                } else {
                    System.out.printf("La matriz " + B + " Esta vacia o tiene mal sus datos ");
                }
                Mostrarmatriz(SegundaMatriz_mult);
                System.out.println("La Matriz es: " + B);
                R = multiplicar(PrimeraMatriz_mult, SegundaMatriz_mult);
                Resultante_mult = multiplicar(PrimeraMatriz_mult, SegundaMatriz_mult);


                System.out.println("------------------");
                System.out.println("La Multiplicación es:");
                Mostrarmatriz(R);
                // I_double(R, 'R');
                System.out.println("------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static double[][] multiplicar(double[][] a, double[][] b) {
        double[][] producto = new double[a.length][b[0].length];//instanciando matriz final
        // se comprueba si las matrices se pueden multiplicar
        if (a[0].length == b.length) {
            for (int i = 0; i < a.length; i++) {//recorre filas
                for (int j = 0; j < b[0].length; j++) {//recorre columnas
                    for (int k = 0; k < a[0].length; k++) {
                        // aquí se multiplica la matriz
                        producto[i][j] += a[i][k] * b[k][j]; //son operadores de asignación combinados,
                        //o sea, que en vez de reemplazar el valor de una variable,
                        //utilizando el igual (=), suma ese valor a dicha variable (+=), ejemplo:
//x = 3
//x = 10
//x += 5 }
                    }
                }
                // MostrarmatrizC(producto);
            }
        }
        return producto;

    }

    public static double[][] inversa_orden3(double B[][]) {
        //Declaramos variables
        double determinante, x00, x01, x02, x10, x11, x12, x20, x21, x22;
        // Declaramos nuestra matriz principal

        // Matriz inversa
        double C[][] = new double[B.length][B[0].length];

        //Hallamos determinante de nuestra matriz principal
        determinante = (B[0][0] * ((B[1][1] * B[2][2]) - (B[1][2] * B[2][1]))) - (B[0][1] * ((B[1][0] * B[2][2]) - (B[2][0] * B[1][2]))) + (B[0][2] * ((B[1][0] * B[2][1]) - (B[2][0] * B[1][1])));
        System.out.println();
        // System.out.println("Determinante:" + determinante);
        System.out.println();
        // Calculamos los valores de la matriz inversa ya dividido entre la determinante
        if (determinante != 0) {
            x00 = ((B[1][1] * B[2][2] - B[2][1] * B[1][2])) / determinante;
            x01 = (-(B[1][0] * B[2][2] - B[2][0] * B[1][2])) / determinante;
            x02 = ((B[1][0] * B[2][1] - B[2][0] * B[1][1])) / determinante;
            x10 = (-(B[0][1] * B[2][2] - B[2][1] * B[0][2])) / determinante;
            x11 = ((B[0][0] * B[2][2] - B[2][0] * B[0][2])) / determinante;
            x12 = (-(B[0][0] * B[2][1] - B[2][0] * B[0][1])) / determinante;
            x20 = ((B[0][1] * B[1][2] - B[1][1] * B[0][2])) / determinante;
            x21 = (-(B[0][0] * B[1][2] - B[1][0] * B[0][2])) / determinante;
            x22 = ((B[0][0] * B[1][1] - B[1][0] * B[0][1])) / determinante;
            // Hacemos el intercambio de que las filas pasen como columnas
            C[0][0] = x00;
            C[0][1] = x10;
            C[0][2] = x20;
            C[1][0] = x01;
            C[1][1] = x11;
            C[1][2] = x21;
            C[2][0] = x02;
            C[2][1] = x12;
            C[2][2] = x22;
            // Mostramos la matriz inversa
            System.out.println("--------------------------------------------------");
            System.out.println(">> Matriz inversa  es <<");
            System.out.println("--------------------------------------------------");
            /*for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    System.out.print("|"+ C[i][j] +"|");
                }
                System.out.println();
            } */
        } else {
            //  System.out.print("Error la matriz no tiene inversa");
        }
        return C;

    }

    public static double[][] inversa_orden2(double B[][]) {
        //Declaramos variables
        double determinante, x00, x01, x10, x11;
        // Declaramos nuestra matriz principal

        // Matriz inversa
        double C[][] = new double[B.length][B[0].length];

        //Hallamos determinante de nuestra matriz principal
        determinante = ((B[0][0] * (B[1][1])) - (B[0][1] * ((B[1][0]))));
        System.out.println();
        // System.out.println("Determinante:" + determinante);
        System.out.println();
        // Calculamos los valores de la matriz inversa ya dividido entre la determinante
        if (determinante != 0) {
            x00 = ((B[1][1])) / determinante;
            x01 = (-(B[1][0])) / determinante;
            x10 = (-(B[0][1])) / determinante;
            x11 = ((B[0][0])) / determinante;
            // Hacemos el intercambio de que las filas pasen como columnas
            C[0][0] = x00;
            C[0][1] = x10;
            C[1][0] = x01;
            C[1][1] = x11;
            // Mostramos la matriz inversa
            System.out.println("--------------------------------------------------");
            System.out.println(">> Matriz inversa  es <<");
            System.out.println("--------------------------------------------------");
            /*for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    System.out.print("|"+ C[i][j] +"|");
                }
                System.out.println();
            } */
        } else {
            // System.out.print("Error la matriz no tiene inversa");
        }
        return C;

    }

    public static double[][] Det_orden2(double B[][]) {
        //Declaramos variables
        det2 = true;
        double x00, x01, x10, x11;
        // Declaramos nuestra matriz principal
        // Matriz inversa
        double C[][] = new double[B.length][B[0].length];
        //Hallamos determinante de nuestra matriz principal
        determinante_orden2 = ((B[0][0] * (B[1][1])) - (B[0][1] * ((B[1][0]))));
        System.out.println("------------------------------------------");
        System.out.println("Determinante es:" + determinante_orden2);

        System.out.println("------------------------------------------");
        // Calculamos los valores de la matriz inversa ya dividido entre la determinante
        if (determinante_orden2 != 0) {
            x00 = ((B[1][1])) / determinante_orden2;
            x01 = (-(B[1][0])) / determinante_orden2;
            x10 = (-(B[0][1])) / determinante_orden2;
            x11 = ((B[0][0])) / determinante_orden2;
            // Hacemos el intercambio de que las filas pasen como columnas
            C[0][0] = x00;
            C[0][1] = x10;
            C[1][0] = x01;
            C[1][1] = x11;
            // Mostramos la matriz inversa

        } else {
            // System.out.print("Error la matriz no tiene inversa");
        }
        return C;
    }

    public static double [][] Det_orden3(double B[][]){
        det3=true;
        //Declaramos variables
        double x00,x01,x02,x10,x11,x12,x20,x21,x22;
        // Declaramos nuestra matriz principal

        // Matriz inversa
        double C[][] = new double[B.length][B[0].length];

        //Hallamos determinante de nuestra matriz principal
        determinante_orden3=(B[0][0]*((B[1][1]*B[2][2])-(B[1][2]*B[2][1])))-(B[0][1]*((B[1][0]*B[2][2])-(B[2][0]*B[1][2])))+(B[0][2]*((B[1][0]*B[2][1])-(B[2][0]*B[1][1])));
        System.out.println("---------------------------------");
        System.out.println("Determinante es :" + determinante_orden3);
        System.out.println("---------------------------------");
        // Calculamos los valores de la matriz inversa ya dividido entre la determinante
        if(determinante_orden3!=0){
            x00=((B[1][1]* B[2][2] - B[2][1]*B[1][2]))/determinante_orden3;
            x01=(-(B[1][0]* B[2][2] - B[2][0]* B[1][2]))/determinante_orden3;
            x02=((B[1][0]* B[2][1] - B[2][0]* B[1][1]))/determinante_orden3;
            x10=(-(B[0][1]* B[2][2] - B[2][1]* B[0][2]))/determinante_orden3;
            x11=((B[0][0]* B[2][2] - B[2][0]* B[0][2]))/determinante_orden3;
            x12=(-(B[0][0]* B[2][1] - B[2][0]* B[0][1]))/determinante_orden3;
            x20=((B[0][1]* B[1][2] - B[1][1]* B[0][2]))/determinante_orden3;
            x21=(-(B[0][0]* B[1][2] - B[1][0]* B[0][2]))/determinante_orden3;
            x22=((B[0][0]* B[1][1] - B[1][0]* B[0][1] ))/determinante_orden3;
            // Hacemos el intercambio de que las filas pasen como columnas
            C[0][0]=x00;
            C[0][1]=x10;
            C[0][2]=x20;
            C[1][0]=x01;
            C[1][1]=x11;
            C[1][2]=x21;
            C[2][0]=x02;
            C[2][1]=x12;
            C[2][2]=x22;
            // Mostramos la matriz inversa

        }
        else{
            //  System.out.print("Error la matriz no tiene inversa");
        }return C;


    }

    void DivMatriz() {
        try {
            division_reporte = true;
            if (division_reporte = true) {
                System.out.println("Ingrese el nombre de la Matriz 1: ");
                String A = leer.nextLine();
                A = A.toUpperCase();// conviertiendo el mensaje a MAYUSCULA
                if (A != null) {
                    if (A.equals("A")) {
                        PrimeraMatriz_divi = MatrizA;
                    }
                    if (A.equals("B")) {
                        PrimeraMatriz_divi = MatrizB;
                    }
                    if (A.equals("C")) {
                        PrimeraMatriz_divi = MatrizC;
                    }
                    if (A.equals("D")) {
                        PrimeraMatriz_divi = MatrizD;
                    }
                    if (A.equals("E")) {
                        PrimeraMatriz_divi = MatrizE;
                    }
                    if (A.equals("F")) {
                        PrimeraMatriz_divi = MatrizF;
                    }
                    if (A.equals("G")) {
                        PrimeraMatriz_divi = MatrizG;
                    }
                    if (A.equals("H")) {
                        PrimeraMatriz_divi = MatrizH;
                    }
                    if (A.equals("I")) {
                        PrimeraMatriz_divi = MatrizI;
                    }
                    if (A.equals("J")) {
                        PrimeraMatriz_divi = MatrizJ;
                    }
                    if (A.equals("K")) {
                        PrimeraMatriz_divi = MatrizK;
                    }
                    if (A.equals("L")) {
                        PrimeraMatriz_divi = MatrizL;
                    }
                    if (A.equals("M")) {
                        PrimeraMatriz_divi = MatrizM;
                    }
                    if (A.equals("N")) {
                        PrimeraMatriz_divi = MatrizN;
                    }
                    if (A.equals("O")) {
                        PrimeraMatriz_divi = MatrizO;
                    }
                    if (A.equals("P")) {
                        PrimeraMatriz_divi = MatrizP;
                    }
                    if (A.equals("Q")) {
                        PrimeraMatriz_divi = MatrizQ;
                    }
                    if (A.equals("R")) {
                        PrimeraMatriz_divi = R;
                    }
                    if (A.equals("S")) {
                        PrimeraMatriz_divi = MatrizS;
                    }
                    if (A.equals("T")) {
                        PrimeraMatriz_divi = MatrizT;
                    }
                    if (A.equals("U")) {
                        PrimeraMatriz_divi = MatrizU;
                    }
                    if (A.equals("V")) {
                        PrimeraMatriz_divi = MatrizV;
                    }
                    if (A.equals("W")) {
                        PrimeraMatriz_divi = MatrizW;
                    }
                    if (A.equals("X")) {
                        PrimeraMatriz_divi = MatrizX;
                    }
                    if (A.equals("Y")) {
                        PrimeraMatriz_divi = MatrizY;
                    }
                    if (A.equals("Z")) {
                        PrimeraMatriz_divi = MatrizZ;
                    }
                } else {
                    System.out.printf("La matriz " + A + " Esta vacia o tiene mal sus datos ");
                }
                System.out.println("La Matriz es: " + A);
                Mostrarmatriz(PrimeraMatriz_divi);

                System.out.println("Ingrese el nombre de la Matriz 2 (A-Z): ");
                String B = leer.nextLine();
                B = B.toUpperCase();// conviertiendo el mensaje a MAYUSCULA

                if (B != null) {
                    if (B.equals("A")) {
                        SegundaMatriz_divi = MatrizA;
                    }
                    if (B.equals("B")) {
                        SegundaMatriz_divi = MatrizB;
                    }
                    if (B.equals("C")) {
                        SegundaMatriz_divi = MatrizC;
                    }
                    if (B.equals("D")) {
                        SegundaMatriz_divi = MatrizD;
                    }
                    if (B.equals("E")) {
                        SegundaMatriz_divi = MatrizE;
                    }
                    if (B.equals("F")) {
                        SegundaMatriz_divi = MatrizF;
                    }
                    if (B.equals("G")) {
                        SegundaMatriz_divi = MatrizG;
                    }
                    if (B.equals("H")) {
                        SegundaMatriz_divi = MatrizH;
                    }
                    if (B.equals("I")) {
                        SegundaMatriz_divi = MatrizI;
                    }
                    if (B.equals("J")) {
                        SegundaMatriz_divi = MatrizJ;
                    }
                    if (B.equals("K")) {
                        SegundaMatriz_divi = MatrizK;
                    }
                    if (B.equals("L")) {
                        SegundaMatriz_divi = MatrizL;
                    }
                    if (B.equals("M")) {
                        SegundaMatriz_divi = MatrizM;
                    }
                    if (B.equals("N")) {
                        SegundaMatriz_divi = MatrizN;
                    }
                    if (B.equals("O")) {
                        SegundaMatriz_divi = MatrizO;
                    }
                    if (B.equals("P")) {
                        SegundaMatriz_divi = MatrizP;
                    }
                    if (B.equals("Q")) {
                        SegundaMatriz_divi = MatrizQ;
                    }
                    if (B.equals("R")) {
                        SegundaMatriz_divi = R;
                    }
                    if (B.equals("S")) {
                        SegundaMatriz_divi = MatrizS;
                    }
                    if (B.equals("T")) {
                        SegundaMatriz_divi = MatrizT;
                    }
                    if (B.equals("U")) {
                        SegundaMatriz_divi = MatrizU;
                    }
                    if (B.equals("V")) {
                        SegundaMatriz_divi = MatrizV;
                    }
                    if (B.equals("W")) {
                        SegundaMatriz_divi = MatrizW;
                    }
                    if (B.equals("X")) {
                        SegundaMatriz_divi = MatrizX;
                    }
                    if (B.equals("Y")) {
                        SegundaMatriz_divi = MatrizY;
                    }
                    if (B.equals("Z")) {
                        SegundaMatriz_divi = MatrizZ;
                    }
                } else {
                    System.out.printf("La matriz " + B + " Esta vacia o tienen mal sus datos ");
                }
                System.out.println("la Matriz ingresada es: " + B);
                Mostrarmatriz(SegundaMatriz_divi);


                // I_double(SegundaMatriz, 'B');

                if (SegundaMatriz_divi.length == SegundaMatriz_divi[0].length) {//si son cuadradas entra para hacer la inversa
                    //de lo contrario nel
                    int aux = 0;//SE UTILIZA el aux para saber la dimension de la matriz
                    for (int i = 0; i < SegundaMatriz_divi.length; i++) {
                        for (int j = 0; j < SegundaMatriz_divi[i].length; j++) {
                            //System.out.print("|" + matriz[i][j] + "|" + "\t");

                        }
                        aux++;//se usa el contador para saber que dimension es
                    }
                    //System.out.println("el aux tiene valor de "+aux);
                    if (aux == 2) {
                        RR = inversa_orden2(SegundaMatriz_divi);//llamando metodo de inversa orden 2
                        Mostrarmeinversa(RR);//imprimiendo matriz
                        R = multiplicar(RR, PrimeraMatriz_divi);
                        System.out.println("------------------");
                        System.out.println("La División es:");
                        System.out.println("-|Matriz Resultante|-");
                        Mostrarmatriz(R);
                        System.out.println("------------------");
                        Resultante_divi = R;

                    }if (aux == 3) {
                        RR = inversa_orden3(SegundaMatriz_divi);//llamando metodo de inversa orden 3
                        System.out.println("la inversa de "+B+" es:");
                        Mostrarmeinversa(RR);//imprimiendo matriz
                        R = multiplicar( PrimeraMatriz_divi,RR);
                        System.out.println("------------------");
                        System.out.println("La División es:");
                        System.out.println("-|Matriz Resultante|-");
                        Mostrarmatriz(R);
                        System.out.println("------------------");
                        Resultante_divi = R;
                    } else {
                        System.out.println("No es posible resolver la inversa de la matriz");
                        System.out.println("Solo se puede resolver hasta grado 3 revisar la matriz entrante.");
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void Inversa() {
        try {
            inversa_reporte = true;

            if (inversa_reporte == true) {
                System.out.println("Ingrese el nombre de la Matriz (A-Z): ");
                String A = leer.nextLine();
                A = A.toUpperCase();// conviertiendo el mensaje a MAYUSCULA
                if (A != null) {
                    if (A.equals("A")) {
                        PrimeraMatriz_inversa = MatrizA;
                    }
                    if (A.equals("B")) {
                        PrimeraMatriz_inversa = MatrizB;
                    }
                    if (A.equals("C")) {
                        PrimeraMatriz_inversa = MatrizC;
                    }
                    if (A.equals("D")) {
                        PrimeraMatriz_inversa = MatrizD;
                    }
                    if (A.equals("E")) {
                        PrimeraMatriz_inversa = MatrizE;
                    }
                    if (A.equals("F")) {
                        PrimeraMatriz_inversa = MatrizF;
                    }
                    if (A.equals("G")) {
                        PrimeraMatriz_inversa = MatrizG;
                    }
                    if (A.equals("H")) {
                        PrimeraMatriz_inversa = MatrizH;
                    }
                    if (A.equals("I")) {
                        PrimeraMatriz_inversa = MatrizI;
                    }
                    if (A.equals("J")) {
                        PrimeraMatriz_inversa = MatrizJ;
                    }
                    if (A.equals("K")) {
                        PrimeraMatriz_inversa = MatrizK;
                    }
                    if (A.equals("L")) {
                        PrimeraMatriz_inversa = MatrizL;
                    }
                    if (A.equals("M")) {
                        PrimeraMatriz_inversa = MatrizM;
                    }
                    if (A.equals("N")) {
                        PrimeraMatriz_inversa = MatrizN;
                    }
                    if (A.equals("O")) {
                        PrimeraMatriz_inversa = MatrizO;
                    }
                    if (A.equals("P")) {
                        PrimeraMatriz_inversa = MatrizP;
                    }
                    if (A.equals("Q")) {
                        PrimeraMatriz_inversa = MatrizQ;
                    }
                    if (A.equals("R")) {
                        PrimeraMatriz_inversa = R;
                    }
                    if (A.equals("S")) {
                        PrimeraMatriz_inversa = MatrizS;
                    }
                    if (A.equals("T")) {
                        PrimeraMatriz_inversa = MatrizT;
                    }
                    if (A.equals("U")) {
                        PrimeraMatriz_inversa = MatrizU;
                    }
                    if (A.equals("V")) {
                        PrimeraMatriz_inversa = MatrizV;
                    }
                    if (A.equals("W")) {
                        PrimeraMatriz_inversa = MatrizW;
                    }
                    if (A.equals("X")) {
                        PrimeraMatriz_inversa = MatrizX;
                    }
                    if (A.equals("Y")) {
                        PrimeraMatriz_inversa = MatrizY;
                    }
                    if (A.equals("Z")) {
                        PrimeraMatriz_inversa = MatrizZ;
                    }
                } else {
                    System.out.printf("La matriz " + A + " Esta vacia o tiene mal sus datos ");
                }
                Mostrarmatriz(PrimeraMatriz_inversa);
                int aux = 0;//SE UTILIZA el aux para saber la dimension de la matriz
                for (int i = 0; i < PrimeraMatriz_inversa.length; i++) {
                    for (int j = 0; j < PrimeraMatriz_inversa[i].length; j++) {
                        //System.out.print("|" + matriz[i][j] + "|" + "\t");

                    }
                    aux++;//se usa el contador para saber que dimension es
                }
                //System.out.println("el aux tiene valor de "+aux);

                if (PrimeraMatriz_inversa.length == PrimeraMatriz_inversa[0].length) {//si son cuadradas entra para hacer la inversa
                    //de lo contrario nel
                    if (aux == 2) {
                        R = inversa_orden2(PrimeraMatriz_inversa);//llamando metodo de inversa orden 2
                        Mostrarmeinversa(R);//imprimiendo matriz
                    }
                    if (aux == 3) {
                        R = inversa_orden3(PrimeraMatriz_inversa);//llamando metodo de inversa orden 3
                        Mostrarmeinversa(R);//imprimiendo matriz
                    } else {
                        System.out.println("No es posible resolver la inversa de la matriz");
                        System.out.println("Solo se puede resolver hasta grado 3 revisar la matriz entrante.");
                    }
                }
                Resultante_inversa = R;


                //R=inversa_funcion(PrimeraMatriz);
                // R=inversa_orden2(PrimeraMatriz);
                // Mostrarmeinversa(R);
                //  I_double(PrimeraMatriz, 'A');
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void TransMatriz() {
        try {
            tras_reporte = true;
            if (tras_reporte == true) {

                System.out.println("Ingrese el nombre de la Matriz: ");
                String A = leer.nextLine();
                A = A.toUpperCase();

                if (A.equals("A")) {
                    PrimeraMatriz_trans = MatrizA;
                }
                if (A.equals("B")) {
                    PrimeraMatriz_trans = MatrizB;
                }
                if (A.equals("C")) {
                    PrimeraMatriz_trans = MatrizC;
                }
                if (A.equals("D")) {
                    PrimeraMatriz_trans = MatrizD;
                }
                if (A.equals("E")) {
                    PrimeraMatriz_trans = MatrizE;
                }
                if (A.equals("F")) {
                    PrimeraMatriz_trans = MatrizF;
                }
                if (A.equals("G")) {
                    PrimeraMatriz_trans = MatrizG;
                }
                if (A.equals("H")) {
                    PrimeraMatriz_trans = MatrizH;
                }
                if (A.equals("I")) {
                    PrimeraMatriz_trans = MatrizI;
                }
                if (A.equals("J")) {
                    PrimeraMatriz_trans = MatrizJ;
                }
                if (A.equals("K")) {
                    PrimeraMatriz_trans = MatrizK;
                }
                if (A.equals("L")) {
                    PrimeraMatriz_trans = MatrizL;
                }
                if (A.equals("M")) {
                    PrimeraMatriz_trans = MatrizM;
                }
                if (A.equals("N")) {
                    PrimeraMatriz_trans = MatrizN;
                }
                if (A.equals("O")) {
                    PrimeraMatriz_trans = MatrizO;
                }
                if (A.equals("P")) {
                    PrimeraMatriz_trans = MatrizP;
                }
                if (A.equals("Q")) {
                    PrimeraMatriz_trans = MatrizQ;
                }
                if (A.equals("R")) {
                    PrimeraMatriz_trans = R;
                }
                if (A.equals("S")) {
                    PrimeraMatriz_trans = MatrizS;
                }
                if (A.equals("T")) {
                    PrimeraMatriz_trans = MatrizT;
                }
                if (A.equals("U")) {
                    PrimeraMatriz_trans = MatrizU;
                }
                if (A.equals("V")) {
                    PrimeraMatriz_trans = MatrizV;
                }
                if (A.equals("W")) {
                    PrimeraMatriz_trans = MatrizW;
                }
                if (A.equals("X")) {
                    PrimeraMatriz_trans = MatrizX;
                }
                if (A.equals("Y")) {
                    PrimeraMatriz_trans = MatrizY;
                }
                if (A.equals("Z")) {
                    PrimeraMatriz_trans = MatrizZ;
                }
                //Imprimir(PrimeraMatriz_trans, 'A');
                Mostrarmatriz(PrimeraMatriz_trans);

                R = new double[PrimeraMatriz_trans[0].length][PrimeraMatriz_trans.length];
                for (int i = 0; i < PrimeraMatriz_trans.length; i++) {
                    for (int j = 0; j < PrimeraMatriz_trans[i].length; j++) {
                        R[j][i] = PrimeraMatriz_trans[i][j];
                    }

                }
                Resultante_trans = new double[PrimeraMatriz_trans[0].length][PrimeraMatriz_trans.length];
                for (int i = 0; i < PrimeraMatriz_trans.length; i++) {
                    for (int j = 0; j < PrimeraMatriz_trans[i].length; j++) {
                        Resultante_trans[j][i] = PrimeraMatriz_trans[i][j];
                    }

                }
                System.out.println("------------------");
                System.out.println("La Transpuesta es:");
                Mostrarmatriz(Resultante_trans);
                //Imprimir(R, 'R');
                System.out.println("------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void Determinante() {
        try {
            determinante_reporte = true;
            if (determinante_reporte == true) {
                System.out.println("Ingrese el nombre de la Matriz (A-Z): ");
                String A = leer.nextLine();
                A = A.toUpperCase();// conviertiendo el mensaje a MAYUSCULA
                if (A != null) {
                    if (A.equals("A")) {
                        PrimeraMatriz_dete = MatrizA;
                    }
                    if (A.equals("B")) {
                        PrimeraMatriz_dete = MatrizB;
                    }
                    if (A.equals("C")) {
                        PrimeraMatriz_dete = MatrizC;
                    }
                    if (A.equals("D")) {
                        PrimeraMatriz_dete = MatrizD;
                    }
                    if (A.equals("E")) {
                        PrimeraMatriz_dete = MatrizE;
                    }
                    if (A.equals("F")) {
                        PrimeraMatriz_dete = MatrizF;
                    }
                    if (A.equals("G")) {
                        PrimeraMatriz_dete = MatrizG;
                    }
                    if (A.equals("H")) {
                        PrimeraMatriz_dete = MatrizH;
                    }
                    if (A.equals("I")) {
                        PrimeraMatriz_dete = MatrizI;
                    }
                    if (A.equals("J")) {
                        PrimeraMatriz_dete = MatrizJ;
                    }
                    if (A.equals("K")) {
                        PrimeraMatriz_dete = MatrizK;
                    }
                    if (A.equals("L")) {
                        PrimeraMatriz_dete = MatrizL;
                    }
                    if (A.equals("M")) {
                        PrimeraMatriz_dete = MatrizM;
                    }
                    if (A.equals("N")) {
                        PrimeraMatriz_dete = MatrizN;
                    }
                    if (A.equals("O")) {
                        PrimeraMatriz_dete = MatrizO;
                    }
                    if (A.equals("P")) {
                        PrimeraMatriz_dete = MatrizP;
                    }
                    if (A.equals("Q")) {
                        PrimeraMatriz_dete = MatrizQ;
                    }
                    if (A.equals("R")) {
                        PrimeraMatriz_dete = R;
                    }
                    if (A.equals("S")) {
                        PrimeraMatriz_dete = MatrizS;
                    }
                    if (A.equals("T")) {
                        PrimeraMatriz_dete = MatrizT;
                    }
                    if (A.equals("U")) {
                        PrimeraMatriz_dete = MatrizU;
                    }
                    if (A.equals("V")) {
                        PrimeraMatriz_dete = MatrizV;
                    }
                    if (A.equals("W")) {
                        PrimeraMatriz_dete = MatrizW;
                    }
                    if (A.equals("X")) {
                        PrimeraMatriz_dete = MatrizX;
                    }
                    if (A.equals("Y")) {
                        PrimeraMatriz_dete = MatrizY;
                    }
                    if (A.equals("Z")) {
                        PrimeraMatriz_dete = MatrizZ;
                    }
                } else {
                    System.out.printf("La matriz " + A + " Esta vacia o tiene mal sus datos ");
                }
                Mostrarmatriz(PrimeraMatriz_dete);
                int aux = 0;//SE UTILIZA el aux para saber la dimension de la matriz
                for (int i = 0; i < PrimeraMatriz_dete.length; i++) {
                    for (int j = 0; j < PrimeraMatriz_dete[i].length; j++) {
                        //System.out.print("|" + matriz[i][j] + "|" + "\t");

                    }
                    aux++;//se usa el contador para saber que dimension es
                }
                //System.out.println("el aux tiene valor de "+aux);

                if (PrimeraMatriz_dete.length == PrimeraMatriz_dete[0].length) {//si son cuadradas entra para hacer la inversa
                    //de lo contrario nel
                    if (aux == 2) {
                        Det_orden2(PrimeraMatriz_dete);//llamando metodo de inversa orden 2
                        Resultante_dete = Det_orden2(PrimeraMatriz_dete);


                    }
                    if (aux == 3) {
                        Det_orden3(PrimeraMatriz_dete);//llamando metodo de inversa orden 3
                        Resultante_dete = Det_orden3(PrimeraMatriz_dete);

                    } else {
                        System.out.println("No es posible resolver la Determinante de la matriz");
                        System.out.println("Solo se puede resolver hasta grado 3 revisar la matriz entrante.");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Mostrarmatriz(double matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(" | " + matriz[i][j] + "  | ");

            }
            System.out.println("\t");
        }
    }

    public static void Mostrarmeinversa(double matriz[][]) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("|" + matriz[i][j] + "|" + "\t");
            }
            System.out.println("\t");
        }
    }

    public void Potencia() {
        try {
            potencia_reporte = true;
            if (potencia_reporte == true) {
                System.out.println("Ingrese el nombre de la Matriz: ");
                String A = leer.nextLine();
                A = A.toUpperCase();// conviertiendo el mensaje a MAYUSCULA
                if (A != null) {

                    if (A.equals("A")) {
                        PrimeraMatriz_pote = MatrizA;
                    }
                    if (A.equals("B")) {
                        PrimeraMatriz_pote = MatrizB;
                    }
                    if (A.equals("C")) {
                        PrimeraMatriz_pote = MatrizC;
                    }
                    if (A.equals("D")) {
                        PrimeraMatriz_pote = MatrizD;
                    }
                    if (A.equals("E")) {
                        PrimeraMatriz_pote = MatrizE;
                    }
                    if (A.equals("F")) {
                        PrimeraMatriz_pote = MatrizF;
                    }
                    if (A.equals("G")) {
                        PrimeraMatriz_pote = MatrizG;
                    }
                    if (A.equals("H")) {
                        PrimeraMatriz_pote = MatrizH;
                    }
                    if (A.equals("I")) {
                        PrimeraMatriz_pote = MatrizI;
                    }
                    if (A.equals("J")) {
                        PrimeraMatriz_pote = MatrizJ;
                    }
                    if (A.equals("K")) {
                        PrimeraMatriz_pote = MatrizK;
                    }
                    if (A.equals("L")) {
                        PrimeraMatriz_pote = MatrizL;
                    }
                    if (A.equals("M")) {
                        PrimeraMatriz_pote = MatrizM;
                    }
                    if (A.equals("N")) {
                        PrimeraMatriz_pote = MatrizN;
                    }
                    if (A.equals("O")) {
                        PrimeraMatriz_pote = MatrizO;
                    }
                    if (A.equals("P")) {
                        PrimeraMatriz_pote = MatrizP;
                    }
                    if (A.equals("Q")) {
                        PrimeraMatriz_pote = MatrizQ;
                    }
                    if (A.equals("R")) {
                        PrimeraMatriz_pote = RR;
                    }
                    if (A.equals("S")) {
                        PrimeraMatriz_pote = MatrizS;
                    }
                    if (A.equals("T")) {
                        PrimeraMatriz_pote = MatrizT;
                    }
                    if (A.equals("U")) {
                        PrimeraMatriz_pote = MatrizU;
                    }
                    if (A.equals("V")) {
                        PrimeraMatriz_pote = MatrizV;
                    }
                    if (A.equals("W")) {
                        PrimeraMatriz_pote = MatrizW;
                    }
                    if (A.equals("X")) {
                        PrimeraMatriz_pote = MatrizX;
                    }
                    if (A.equals("Y")) {
                        PrimeraMatriz_pote = MatrizY;
                    }
                    if (A.equals("Z")) {
                        PrimeraMatriz_pote = MatrizZ;
                    }
                } else {
                    System.out.printf("La matriz " + A + " Esta vacia o tiene mal sus datos ");
                }
                Imprimir(PrimeraMatriz_pote, 'R');

                System.out.println("Ingrese el exponente: ");
                int expo = leer.nextInt();
                numero1 = expo;

                RR = potencia(PrimeraMatriz_pote, expo);


                System.out.println("------------------");
                System.out.println("La Potencia es:");
                System.out.println("La Matriz Resultante  ");
                Mostrarmatriz(RR);
                //I_double(R, 'R');
                System.out.println("------------------");
                leer.nextLine();
                R = RR;
                Resultante_pote = RR;
            }
            } catch(Exception e){
                e.printStackTrace();
            }

        }


    public static double[][] potencia(double[][] a, int expo) {
        double[][] producto = a;
        if (producto != null) {
            if (expo > 0) {
                for (int i = 1; i < expo; i++) {
                    producto = multiplicar(producto, a);

                }
            }

        }
        return producto;
    }

    public static void Reportes() {
        //Creando archivo
        FileWriter fichero = null;
        PrintWriter pw = null;
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        try {
            fichero = new FileWriter("Practica_1.html");//crear archivo
            pw = new PrintWriter(fichero);//este es nuestro lapiz
            pw.println(">HTML<");
            pw.println("<center> Practica_1 (hora y fecha: " + hourdateFormat.format(date) + ")" + " </center>");
            //<center> </center>
            pw.println("<center>Reporte :v ---Grupo_8--- </center>");
            pw.println("<head>");
            pw.println("<title>Reporte HTML</title>");
            pw.println("</head>");
            pw.println("<body>");//INICIANDO CONTENIDO style=\"background-color: #3349FF ;\"
            pw.println("<h1><center><b><strong> <font color= #2874A6> °°Operaciones de Matrices°° :V </font></strong></b></center></h1>");
            pw.println("<body background=FondoPractica4.jpg>");
            pw.println("<hr align=left>");

            pw.println("<h2><center><font size=4> *Suma*  </font></center></h2>");
            if (suma_reporte == true) {

                pw.println("<center> La Matriz 1 ingresada es </center>");
                pw.println("<div style=\"text-align:left;\">");
                pw.println("<table border=\"1\" style=\"margin:0 auto;\">");
                for (int i = 0; i < PrimeraMatriz_suma.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < PrimeraMatriz_suma[i].length; j++) {
                        pw.println("<div align=left>");
                        pw.println("<td>" + PrimeraMatriz_suma[i][j] + "</td>");
                        pw.println(" </left>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table >");//cierre primer tabla
                pw.println("</div >");
                ////////////////////////////////
                pw.println("<h2><center><font size=4> +  </font></center></h2>");
                pw.println("<center> La Matriz 2 ingresada es</center>");
                pw.println("<div style=\"text-align:right;\">");
                pw.println("<div style=\"text-align:right;\">");
                pw.println("<table border=\"1\" style=\"margin:0 auto;\">");
                for (int i = 0; i < SegundaMatriz_suma.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < SegundaMatriz_suma[i].length; j++) {
                        pw.println(" <center>");
                        pw.println("<td>" + SegundaMatriz_suma[i][j] + "</td>");
                        pw.println(" </center>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table >");//cierre primer tabla
                pw.println("</div >");
                ///////////////////////////Resultado de la suma/////////////////////////
                pw.println("<h2><center><font size=4> =  </font></center></h2>");
                pw.println("<center> La Suma de Matrices es: </center>");
                pw.println("<div style=\"text-align:center;\">");
                pw.println("<table border=\"1\" style=\"margin:0 auto;\">");
                for (int i = 0; i < Resultante_suma.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < Resultante_suma[i].length; j++) {
                        pw.println(" <center>");
                        pw.println("<td>" + Resultante_suma[i][j] + "</td>");
                        pw.println(" </center>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table >");//cierre primer tabla
                pw.println("</div >");
            } else {
                pw.println("<center> **No hay datos para realizar operación Suma**: </center>");
            }

            //////////////////////////////////
            //operacion Resta//////////////////////
            pw.println("<hr align=center>");///linea divisora
            //////////////////////////
            pw.println("<h2><center><font size=4> *Resta*  </font></center></h2>");
            if (resta_reporte == true) {
                pw.println("<center> La Matriz 1 ingresada es </center>");

                pw.println("<div style=\"text-align:left;\">");
                pw.println("<table border=\"1\" style=\"margin:0 auto;\">");
                for (int i = 0; i < PrimeraMatriz_resta.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < PrimeraMatriz_resta[i].length; j++) {
                        pw.println(" <center>");
                        pw.println("<td>" + PrimeraMatriz_resta[i][j] + "</td>");
                        pw.println(" </center>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table >");//cierre primer tabla
                pw.println("</div >");
                ////////////////////////////////
                pw.println("<h2><center><font size=4> -  </font></center></h2>");
                pw.println("<center> La Matriz 2 ingresada es</center>");
                pw.println("<div style=\"text-align:right;\">");
                pw.println("<table border=\"1\" style=\"margin:0 auto;\">");
                for (int i = 0; i < SegundaMatriz_resta.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < SegundaMatriz_resta[i].length; j++) {
                        pw.println(" <center>");
                        pw.println("<td>" + SegundaMatriz_resta[i][j] + "</td>");
                        pw.println(" </center>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table >");//cierre primer tabla
                pw.println("</div >");
                ///////////////////////////Resultado de la Resta/////////////////////////
                pw.println("<h2><center><font size=4> =  </font></center></h2>");
                pw.println("<center> La Resta de matrices es: </center>");
                pw.println("<div style=\"text-align:center;\">");
                pw.println("<table border=\"1\" style=\"margin:0 auto;\">");
                for (int i = 0; i < Resultante_resta.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < Resultante_resta[i].length; j++) {
                        pw.println(" <center>");
                        pw.println("<td>" + Resultante_resta[i][j] + "</td>");
                        pw.println(" </center>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table >");//cierre primer tabla
                pw.println("</div >");
            } else {
                pw.println("<center> **No hay datos para realizar operación Resta**: </center>");
            }
            //////////////////////////////////
            //operacion Mult por numero
            //////////////////////
            pw.println("<hr align=center>");///linea divisora
            //////////////////////////
            pw.println("<h2><center><font size=4> *Multiplicación por un múmero*  </font></center></h2>");
            if (multnumero_reporte == true) {
                pw.println("<center> La Matriz 1 ingresada es </center>");

                pw.println("<div style=\"text-align:left;\">");
                pw.println("<table border=\"1\" style=\"margin:0 auto;\">");
                for (int i = 0; i < PrimeraMatriz_mult1.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < PrimeraMatriz_mult1[i].length; j++) {
                        pw.println(" <center>");
                        pw.println("<td>" + PrimeraMatriz_mult1[i][j] + "</td>");
                        pw.println(" </center>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table >");//cierre primer tabla
                pw.println("</div >");
                ///////////////////////////////
                pw.println("<h2><center><font size=4> *  </font></center></h2>");
                pw.println("<center> El número ingresado es: </center>");
                pw.println("<div style=\"text-align:center;\">");
                pw.println("<table border=\"1\" style=\"margin:0 auto;\">");
                pw.println("<center>" + numero + "</center>");
                pw.println("</table >");//cierre primer tabla
                pw.println("</div >");


                ///////////////////////////Resultado de la Multiplicacio por numero/////////////////////////
                pw.println("<h2><center><font size=4> =  </font></center></h2>");
                pw.println("<center> La Matriz multiplicaca es: </center>");
                pw.println("<div style=\"text-align:center;\">");
                pw.println("<table border=\"1\" style=\"margin:0 auto;\">");
                for (int i = 0; i < Resultante_mult1.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < Resultante_mult1[i].length; j++) {
                        pw.println(" <center>");
                        pw.println("<td>" + Resultante_mult1[i][j] + "</td>");
                        pw.println(" </center>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table >");//cierre primer tabla
                pw.println("</div >");
            } else {
                pw.println("<center> **No hay datos para realizar operación Multiplicación por un Número**: </center>");
            }
            //////////////////////////////////
            //operacion Mult//////////////////////
            pw.println("<hr align=center>");///linea divisora//////////////////////////

            pw.println("<h2><center><font size=4> *Multiplicación entre Matrices*  </font></center></h2>");
            if (mult_reporte == true) {
                pw.println("<center> La Matriz 1 ingresada es </center>");

                pw.println("<div style=\"text-align:left;\">");
                pw.println("<table border=\"1\" style=\"margin:0 auto;\">");
                for (int i = 0; i < PrimeraMatriz_mult.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < PrimeraMatriz_mult[i].length; j++) {
                        pw.println(" <center>");
                        pw.println("<td>" + PrimeraMatriz_mult[i][j] + "</td>");
                        pw.println(" </center>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table >");//cierre primer tabla
                pw.println("</div >");
                ////////////////////////////////
                pw.println("<h2><center><font size=4> *  </font></center></h2>");
                pw.println("<center> La Matriz 2 ingresada es</center>");
                pw.println("<div style=\"text-align:right;\">");
                pw.println("<table border=\"1\" style=\"margin:0 auto;\">");
                for (int i = 0; i < SegundaMatriz_mult.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < SegundaMatriz_mult[i].length; j++) {
                        pw.println(" <center>");
                        pw.println("<td>" + SegundaMatriz_mult[i][j] + "</td>");
                        pw.println(" </center>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table >");//cierre primer tabla
                pw.println("</div >");
                ///////////////////////////Resultado de la Multi/////////////////////////
                pw.println("<h2><center><font size=4> =  </font></center></h2>");
                pw.println("<center> La Multiplicación entre Matrices es: </center>");
                pw.println("<div style=\"text-align:center;\">");
                pw.println("<table border=\"1\" style=\"margin:0 auto;\">");
                for (int i = 0; i < Resultante_mult.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < Resultante_mult[i].length; j++) {
                        pw.println(" <center>");
                        pw.println("<td>" + Resultante_mult[i][j] + "</td>");
                        pw.println(" </center>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table >");//cierre primer tabla
                pw.println("</div >");
            } else {
                pw.println("<center> **No hay datos para realizar operación Multiplicación **: </center>");
            }
            //////////////////////////////////
            //////////////////////////////////
            //////////////////////////////////
            //operacion División//////////////////////
            pw.println("<hr align=center>");///linea divisora
            //////////////////////////
            pw.println("<h2><center><font size=4> *División*  </font></center></h2>");
            if (division_reporte == true) {
                pw.println("<center> La Matriz 1 ingresada es </center>");

                pw.println("<div style=\"text-align:left;\">");
                pw.println("<table border=\"1\" style=\"margin:0 auto;\">");
                for (int i = 0; i < PrimeraMatriz_divi.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < PrimeraMatriz_divi[i].length; j++) {
                        pw.println(" <center>");
                        pw.println("<td>" + PrimeraMatriz_divi[i][j] + "</td>");
                        pw.println(" </center>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table >");//cierre primer tabla
                pw.println("</div >");
                ////////////////////////////////
                pw.println("<h2><center><font size=4> ÷  </font></center></h2>");
                pw.println("<center> La Matriz 2 ingresada es</center>");
                pw.println("<div style=\"text-align:right;\">");
                pw.println("<table border=\"1\" style=\"margin:0 auto;\">");
                for (int i = 0; i < SegundaMatriz_divi.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < SegundaMatriz_divi[i].length; j++) {
                        pw.println(" <center>");
                        pw.println("<td>" + SegundaMatriz_divi[i][j] + "</td>");
                        pw.println(" </center>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table >");//cierre primer tabla
                pw.println("</div >");
                ///////////////////////////Resultado de la Resta/////////////////////////
                pw.println("<h2><center><font size=4> =  </font></center></h2>");
                pw.println("<center> La División entre Matrices es: </center>");
                pw.println("<div style=\"text-align:center;\">");
                pw.println("<table border=\"1\" style=\"margin:0 auto;\">");
                for (int i = 0; i < Resultante_divi.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < Resultante_divi[i].length; j++) {
                        pw.println(" <center>");
                        pw.println("<td>" + Resultante_divi[i][j] + "</td>");
                        pw.println(" </center>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table >");//cierre primer tabla
                pw.println("</div >");
            } else {
                pw.println("<center> **No hay datos para realizar operación División**: </center>");
            }
            //////////////////////////////////

            //operacion Transpuesta
            //////////////////////
            pw.println("<hr align=center>");///linea divisora
            //////////////////////////
            pw.println("<h2><center><font size=4> *Transpuesta de una matriz*  </font></center></h2>");
            if (tras_reporte == true) {
                pw.println("<center> La Matriz ingresada es </center>");

                pw.println("<div style=\"text-align:left;\">");
                pw.println("<table border=\"1\" style=\"margin:0 auto;\">");
                for (int i = 0; i < PrimeraMatriz_trans.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < PrimeraMatriz_trans[i].length; j++) {
                        pw.println(" <center>");
                        pw.println("<td>" + PrimeraMatriz_trans[i][j] + "</td>");
                        pw.println(" </center>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table >");//cierre primer tabla
                pw.println("</div >");
                ///////////////////////////Resultado de la Transpuesta/////////////////////////
                pw.println("<h2><center><font size=4> =  </font></center></h2>");
                pw.println("<center> La Matriz Transpuesta: </center>");
                pw.println("<div style=\"text-align:center;\">");
                pw.println("<table border=\"1\" style=\"margin:0 auto;\">");
                for (int i = 0; i < Resultante_trans.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < Resultante_trans[i].length; j++) {
                        pw.println(" <center>");
                        pw.println("<td>" + Resultante_trans[i][j] + "</td>");
                        pw.println(" </center>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table >");//cierre primer tabla
                pw.println("</div >");
            } else {
                pw.println("<center> **No hay datos para realizar operación Traspuesta **: </center>");
            }
            //////////////////////////
            //operacion Inversa
            //////////////////////
            pw.println("<hr align=center>");///linea divisora
            //////////////////////////
            pw.println("<h2><center><font size=4> *Inversa de una matriz*  </font></center></h2>");
            if (inversa_reporte == true) {
                pw.println("<center> La Matriz ingresada es </center>");

                pw.println("<div style=\"text-align:left;\">");
                pw.println("<table border=\"1\" style=\"margin:0 auto;\">");
                for (int i = 0; i < PrimeraMatriz_inversa.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < PrimeraMatriz_inversa[i].length; j++) {
                        pw.println(" <center>");
                        pw.println("<td>" + PrimeraMatriz_inversa[i][j] + "</td>");
                        pw.println(" </center>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table >");//cierre primer tabla
                pw.println("</div >");
                ///////////////////////////Resultado de la Inversa/////////////////////////
                pw.println("<h2><center><font size=4> =  </font></center></h2>");
                pw.println("<center> La Matriz Inversa es: </center>");
                pw.println("<div style=\"text-align:center;\">");
                pw.println("<table border=\"1\" style=\"margin:0 auto;\">");
                for (int i = 0; i < Resultante_inversa.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < Resultante_inversa[i].length; j++) {
                        pw.println(" <center>");
                        pw.println("<td>" + Resultante_inversa[i][j] + "</td>");
                        pw.println(" </center>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table >");//cierre primer tabla
                pw.println("</div >");
            } else {
                pw.println("<center> **No hay datos para realizar operación Inversa **: </center>");
            }
            //////////////////////////
            //////////////////////////////////
            //operacion Potencia
            //////////////////////
            pw.println("<hr align=center>");///linea divisora
            //////////////////////////
            pw.println("<h2><center><font size=4> *Potencia de una Matriz*  </font></center></h2>");
            if (potencia_reporte == true) {
                pw.println("<center> La Matriz 1 ingresada es </center>");

                pw.println("<div style=\"text-align:left;\">");
                pw.println("<table border=\"1\" style=\"margin:0 auto;\">");
                for (int i = 0; i < PrimeraMatriz_pote.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < PrimeraMatriz_pote[i].length; j++) {
                        pw.println(" <center>");
                        pw.println("<td>" + PrimeraMatriz_pote[i][j] + "</td>");
                        pw.println(" </center>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table >");//cierre primer tabla
                pw.println("</div >");
                ///////////////////////////////
                pw.println("<center> El número ingresado es: </center>");
                pw.println("<div style=\"text-align:center;\">");
                pw.println("<table border=\"1\" style=\"margin:0 auto;\">");
                pw.println("<h2><center><font size=2>" + numero1 + "</font></center></h2>");
                pw.println("</table >");//cierre primer tabla
                pw.println("</div >");


                ///////////////////////////Resultado de la Potencia/////////////////////////
                pw.println("<h2><center><font size=4> =  </font></center></h2>");
                pw.println("<center> La Potencia de la matriz es: </center>");
                pw.println("<div style=\"text-align:center;\">");
                pw.println("<table border=\"1\" style=\"margin:0 auto;\">");
                for (int i = 0; i < Resultante_pote.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < Resultante_pote[i].length; j++) {
                        pw.println(" <center>");
                        pw.println("<td>" + Resultante_pote[i][j] + "</td>");
                        pw.println(" </center>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table >");//cierre primer tabla
                pw.println("</div >");
            } else {
                pw.println("<center> **No hay datos para realizar operación Potencia**: </center>");
            }
            //////////////////////////////////
            //operacion Determinante
            //////////////////////
            pw.println("<hr align=center>");///linea divisora
            //////////////////////////
            pw.println("<h2><center><font size=4> *Determinante de una matriz*  </font></center></h2>");
            pw.println("<center> La Matriz ingresada es </center>");

            pw.println("<div style=\"text-align:left;\">");
            pw.println("<table border=\"1\" style=\"margin:0 auto;\">");
            if (determinante_reporte == true) {
                for (int i = 0; i < PrimeraMatriz_dete.length; i++) {
                    pw.println("<tr>");
                    for (int j = 0; j < PrimeraMatriz_dete[i].length; j++) {
                        pw.println(" <center>");
                        pw.println("<td>" + PrimeraMatriz_dete[i][j] + "</td>");
                        pw.println(" </center>");
                    }
                    pw.println("</tr>");
                }
                pw.println("</table >");//cierre primer tabla
                pw.println("</div >");
                ///////////////////////////Resultado de la Determinante/////////////////////////
                pw.println("<h2><center><font size=4> =  </font></center></h2>");
                pw.println("<center> Resultado de la Determinante es: </center>");
                pw.println("<div style=\"text-align:center;\">");
                pw.println("<table border=\"1\" style=\"margin:0 auto;\">");
                if (det2 == true) {
                    pw.println("<center>" + determinante_orden2 + "</center>");
                }
                if (det3 == true) {
                    pw.println("<center>" + determinante_orden3 + "</center>");
                }
            } else {
                pw.println("<center> **No hay datos para realizar operación Traspuesta **: </center>");
            }


            pw.println("</body>");
            pw.println("</HTML>");
            // for (int i = 0; i < 10; i++)
            //pw.println("Linea " + i);


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }


}