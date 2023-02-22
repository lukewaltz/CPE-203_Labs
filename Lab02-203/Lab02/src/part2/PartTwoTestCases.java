package part2;

import org.junit.jupiter.api.Test;
import part1.Util;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * NOTE THAT THIS FILE WILL NOT COMPILE UNTIL YOU HAVE COPIED OVER YOUR
 * EMISSION, COUNTRY, AND SECTOR CLASSES TO THE part2 DIRECTORY
 */
public class PartTwoTestCases {

    //Sector 00
    @Test
    public void testYearWithHighestEmissions00() {
        // Create the testable Sector object
        Map<Integer, Double> gEmissions = new HashMap<>();
        gEmissions.put(1970, 2278.8);
        gEmissions.put(1971, 2356.43);
        gEmissions.put(1972, 2243.3);
        Sector sector = new Sector("Transport", gEmissions);
        // Check that the method works as expected
        assertEquals(1971, sector.getYearWithHighestEmissions());
    }

    //Sector 01
    @Test
    public void testYearWithHighestEmissions01() {
        // Create the testable Sector object
        Map<Integer, Double> gEmissions = new HashMap<>();
        gEmissions.put(1980, 2278.8);
        gEmissions.put(1981, 2456.43);
        gEmissions.put(1982, 2243.3);
        Sector sector = new Sector("Agriculture", gEmissions);
        // Check that the method works as expected
        assertEquals(1981, sector.getYearWithHighestEmissions());
    }

    //Country 00
    @Test
    public void testYearWithHighestEmissions1() {
        // Create the testable Sector object
        Emission emission0 = new Emission(160.5, 230.25, 240.25);
        Emission emission1 = new Emission(360.5, 430.25, 440.25);
        Emission emission2 = new Emission(260.5, 330.25, 340.25);

        Map<Integer, Emission> emissionByYear = new HashMap<>();
        emissionByYear.put(1970, emission0);
        emissionByYear.put(1971, emission1);
        emissionByYear.put(1972, emission2);
        Country country = new Country("USA", emissionByYear);
        // Check that the method works as expected
        assertEquals(1971, country.getYearWithHighestEmissions());
    }

    //Country 01
    @Test
    public void testYearWithHighestEmissions2() {
        // Create the testable Sector object
        Emission emission0 = new Emission(160.5, 230.25, 240.25);
        Emission emission1 = new Emission(360.5, 430.25, 440.25);
        Emission emission2 = new Emission(260.5, 330.25, 340.25);

        Map<Integer, Emission> emissionByYear = new HashMap<>();
        emissionByYear.put(1980, emission0);
        emissionByYear.put(1981, emission1);
        emissionByYear.put(1982, emission2);
        Country country = new Country("Canada", emissionByYear);
        // Check that the method works as expected
        assertEquals(1981, country.getYearWithHighestEmissions());
    }

    /**
     * Tests the implementation of the Emission class.
     *
     * TO-DO: Examine this test case to know what you should name your public methods.
     *
     * @throws NoSuchMethodException
     */
    @Test
    public void testEmissionImplSpecifics() throws NoSuchMethodException {
        final List<String> expectedMethodNames = Arrays.asList("getCO2", "getN2O", "getCH4");

        final List<Class> expectedMethodReturns = Arrays.asList(double.class, double.class, double.class);

        final List<Class[]> expectedMethodParameters = Arrays.asList(new Class[0], new Class[0], new Class[0]);

        verifyImplSpecifics(Emission.class, expectedMethodNames, expectedMethodReturns,
                expectedMethodParameters);
    }

    /**
     * Tests the part2 implementation of the Country class.
     *
     * @throws NoSuchMethodException
     */
    @Test
    public void testCountryImplSpecifics() throws NoSuchMethodException {
        final List<String> expectedMethodNames = Arrays.asList("getName", "getEmissions", "getYearWithHighestEmissions");

        final List<Class> expectedMethodReturns = Arrays.asList(String.class, Map.class, int.class);

        final List<Class[]> expectedMethodParameters = Arrays.asList(new Class[0], new Class[0], new Class[0]);

        verifyImplSpecifics(Country.class, expectedMethodNames, expectedMethodReturns,
                expectedMethodParameters);
    }

    /**
     * Tests the part2 implementation of the Sector class.
     *
     * @throws NoSuchMethodException
     */
    @Test
    public void testSectorImplSpecifics() throws NoSuchMethodException {
        final List<String> expectedMethodNames = Arrays.asList("getName", "getEmissions", "getYearWithHighestEmissions");

        final List<Class> expectedMethodReturns = Arrays.asList(String.class, Map.class, int.class);

        final List<Class[]> expectedMethodParameters = Arrays.asList(new Class[0], new Class[0], new Class[0]);

        verifyImplSpecifics(Sector.class, expectedMethodNames, expectedMethodReturns,
                expectedMethodParameters);
    }

    private static void verifyImplSpecifics(final Class<?> clazz, final List<String> expectedMethodNames,
                                            final List<Class> expectedMethodReturns, final List<Class[]> expectedMethodParameters)
            throws NoSuchMethodException {
        assertEquals(0, clazz.getFields().length, "Unexpected number of public fields");

        final List<Method> publicMethods = Arrays.stream(clazz.getDeclaredMethods())
                .filter(m -> Modifier.isPublic(m.getModifiers())).collect(Collectors.toList());

        assertEquals(expectedMethodNames.size(), publicMethods.size(),
                "Unexpected number of public methods");

        assertTrue(expectedMethodNames.size() == expectedMethodReturns.size(),
                "Invalid test configuration");
        assertTrue(expectedMethodNames.size() == expectedMethodParameters.size(),
                "Invalid test configuration");

        for (int i = 0; i < expectedMethodNames.size(); i++) {
            Method method = clazz.getDeclaredMethod(expectedMethodNames.get(i), expectedMethodParameters.get(i));
            assertEquals(expectedMethodReturns.get(i), method.getReturnType());
        }
    }

}
