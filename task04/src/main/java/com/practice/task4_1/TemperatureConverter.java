package com.practice.task4_1;

/**
 * {@link TemperatureConverter} is a temperature converter utility class, that converts
 * temperature between main temperature scales: Fahrenheit, Celsius and Kelvin scale.
 */
public class TemperatureConverter {

    /**
     * This method converts temperature, provided as argument from Fahrenheit scale
     * to Celsius scale.
     *
     * @param degreesFahrenheit temperature to be converted
     * @return a temperature in Celsius scale
     */
    public double convertFtoC(double degreesFahrenheit) {
        return (degreesFahrenheit - 32.0) / 9.0 * 5.0;
    }

    /**
     * This method converts temperature, provided as argument from Celsius scale
     * to Fahrenheit scale.
     *
     * @param degreesCelsius temperature to be converted
     * @return a temperature in Fahrenheit scale
     */
    public double convertCtoF(double degreesCelsius) {
        return degreesCelsius / 5.0 * 9.0 + 32.0;
    }

    /**
     * This method converts temperature, provided as argument from Celsius scale
     * to Kelvin scale.
     *
     * @param degreesCelsius temperature to be converted
     * @return a temperature in Kelvin scale
     */
    public double convertCtoK(double degreesCelsius) {
        return degreesCelsius + 273.2;
    }

    /**
     * This method converts temperature, provided as argument from Kelvin scale
     * to Celsius scale.
     *
     * @param kelvin temperature to be converted
     * @return a temperature in Celsius scale
     */
    public double convertKtoC(double kelvin) {
        return kelvin - 273.2;
    }

    /**
     * This method converts temperature, provided as argument from Fahrenheit scale
     * to Kelvin scale.
     *
     * @param degreesFahrenheit temperature to be converted
     * @return a temperature in Kelvin scale
     */
    public double convertFtoK(double degreesFahrenheit) {
        return (degreesFahrenheit + 459.7) / 9.0 * 5.0;
    }

    /**
     * This method converts temperature, provided as argument from Kelvin scale
     * to Fahrenheit scale.
     *
     * @param kelvin temperature to be converted
     * @return a temperature in Fahrenheit scale
     */
    public double convertKtoF(double kelvin) {
        return kelvin / 5.0 * 9.0 - 459.7;
    }
}