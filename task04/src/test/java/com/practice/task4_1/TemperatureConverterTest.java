package com.practice.task4_1;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TemperatureConverterTest {
    private TemperatureConverter converter;

    @Parameterized.Parameter
    public double celsius;

    @Parameterized.Parameter(1)
    public double kelvin;

    @Parameterized.Parameter(2)
    public double fahrenheit;

    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {0.0, 273.2, 32.0},
                {-273.2, 0.0, -459.7},
                {3.0, 276.2, 37.4},
                {-5.0, 268.2, 23}
        });
    }

    @Before
    public void initialize() {
        converter = new TemperatureConverter();
    }

    @Test
    public void convertCtoK() {
        double temperature = converter.convertCtoK(celsius);
        assertEquals(kelvin, temperature, 0.1);
    }

    @Test
    public void convertKtoC() {
        assertEquals(celsius, converter.convertKtoC(kelvin), 0.1);
    }

    @Test
    public void convertCtoF() {
        assertEquals(fahrenheit, converter.convertCtoF(celsius), 0.1);
    }

    @Test
    public void convertFtoC() {
        assertEquals(celsius, converter.convertFtoC(fahrenheit), 0.1);
    }

    @Test
    public void convertFtoK() {
        assertEquals(kelvin, converter.convertFtoK(fahrenheit), 0.1);
    }

    @Test
    public void convertKtoF() {
        assertEquals(fahrenheit, converter.convertKtoF(kelvin), 0.1);
    }
}