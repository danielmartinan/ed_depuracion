import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.min;

public class Main {

    // Atributo para el cálculo final del pago semanal
    static int pagoSemanal = 0;
    static int jornadaDiaria = 8;

    public static void main(String[] args) {
        int[] horasTrabajadas = {8, 9, 8, 10, 8};
        int tarifaPorHora = 12;
        int tarifaPorHoraExtra = 20;
        int diasTrabajados = horasTrabajadas.length;

        // Cálculo de horas extra (simulación con error de iteración)
        int[] horasExtra = calcularHorasExtra(horasTrabajadas);

        // Cálculo del pago semanal con horas y días trabajados
        calcularPagoSemanal(horasTrabajadas, horasExtra, tarifaPorHora, tarifaPorHoraExtra);

        // Imprimimos por pantalla el resultado
        System.out.println("Pago semanal calculado: $" + pagoSemanal);
    }

    // Método para calcular el pago considerando horas y días trabajados
    public static void calcularPagoSemanal(int[] horasTrabajadas, int[] horasExtra, int tarifaPorHora, int tarifaPorHoraExtra) {
        //Calculamos el pago de las horas normales
        for (int i = 0; i < horasTrabajadas.length; i++) {
            pagoSemanal += calcularPago(min(horasTrabajadas[i],8), tarifaPorHora);
        }

        //calculamos el pago de las horas extra
        for (int i = 0; i < horasTrabajadas.length; i++) {
            pagoSemanal += calcularPago(horasExtra[i], tarifaPorHoraExtra);
        }
    }

    // Método que calcula el pago en base a las horas trabajadas y la tarifa por hora
    public static int calcularPago(int horas, int tarifa) {
        return horas * tarifa; // Cálculo correcto aquí
    }

    // Método alternativo para calcular el pago sólo con horas y tarifa, sin días
    public static void calcularPagoPorHoras(int horas, int tarifa) {
        int pagoSimple = calcularPago(horas, tarifa);
        pagoSemanal += pagoSimple;
    }

    // Método que simula el cálculo de horas extra con un error en el bucle de iteración
    public static int[] calcularHorasExtra(int[] horasTrabajadas) {
        int[] horasExtra = new int[5];

        for (int i = 0; i < horasTrabajadas.length; i++) {  // Error: debería ser i < horasTotales para evitar desbordamiento
            horasExtra[i] = horasTrabajadas[i] - jornadaDiaria;
        }

        return horasExtra;
    }
}