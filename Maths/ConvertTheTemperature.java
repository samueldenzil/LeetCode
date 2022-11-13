// https://leetcode.com/problems/convert-the-temperature/
package Maths;

import java.util.Arrays;

public class ConvertTheTemperature {

    public static void main(String[] args) {
        double celsius = 36.50;
        System.out.println(Arrays.toString(convertTemperature(celsius)));
    }

    public static double[] convertTemperature(double celsius) {
        double kelvin = celsius + 273.15;
        double fahrenheit = celsius * 1.80 + 32.00;
        return new double[]{kelvin, fahrenheit};
    }
}
