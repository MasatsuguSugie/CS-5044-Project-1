package edu.vt.cs5044;

/**
 * Basic test suite for the FuelMonitor class. You will need to develop additional tests to ensure
 * correctness of your system. This file is ignored by Web-CAT, but it will be graded by a human to
 * ensure you've added reasonable tests.
 */
// CHECKSTYLE:OFF
@SuppressWarnings("javadoc")
public class FuelMonitorTester
{

    public static void main(String[] args)
    {

        // create a new fuel monitor object
        System.out.println("-- Constructing new FuelMonitor object FM(14.5)");
        FuelMonitor monitor = new FuelMonitor(14.5);
        System.out.println("Trip miles (expected: 0) was: " + monitor.getTripMiles());
        System.out.println("Lifetime miles (expected: 0) was: " + monitor.getLifetimeMiles());
        System.out.println("Fuel remaining (expected: 14.5) was: " + monitor.getFuelRemaining());
        System.out.println();
        monitor.useInGreenMode(5, 0.123);
        System.out.println("-- After G(5, 0.123)");
        System.out.println("Trip miles (expected: 5) was: " + monitor.getTripMiles());
        System.out.println("Lifetime miles (expected: 5) was: " + monitor.getLifetimeMiles());

        // We've used 0.123 gallons, so 14.5 - 0.123 = 14.377 gallons remain
        System.out.println("Fuel remaining (expected: 14.377) was: " + monitor.getFuelRemaining());

        // Trip and Lifetime MPG are 5 / 0.123 = 40.6504... truncated to 40.6
        System.out.println("Trip MPG (expected: 40.6) was: " + monitor.getTripMPG());
        System.out.println("Lifetime MPG (expected: 40.6) was: " + monitor.getLifetimeMPG());

        // Green miles remaining is 40.6504... * 14.377 = 584.4309... truncated to 580
        System.out.println(
            "Green miles remaining (expected: 580) was: " + monitor.getGreenMilesRemaining());

        System.out.println();
        monitor.useInSportMode(23, 1.234);
        monitor.useInGreenMode(150, 3.14);
        System.out.println("-- After S(23, 1.234) then G(150, 3.14)");
        System.out.println("Trip miles (expected: 178) was: " + monitor.getTripMiles());
        System.out.println("Lifetime miles (expected: 178) was: " + monitor.getLifetimeMiles());

        // We've used an additional 4.374 gallons, so 14.377 - 4.374 = 10.003 gallons remain
        System.out.println("Fuel remaining (expected: 10.003) was: " + monitor.getFuelRemaining());

        // Trip and Lifetime MPG are 178 / 4.497 = 39.5819... truncated to 39.5
        System.out.println("Trip MPG (expected: 39.5) was: " + monitor.getTripMPG());
        System.out.println("Lifetime MPG (expected: 39.5) was: " + monitor.getLifetimeMPG());

        // Green MPG this trip is 155 / 3.263 = 47.5023...
        // Green miles remaining is 10.003 * 47.5023... = 475.1655 truncated to 470
        System.out.println(
            "Green miles remaining (expected: 470) was: " + monitor.getGreenMilesRemaining());

        // Sport MPG this trip is 23 / 1.234 = 18.6386...
        // Sport miles remaining is 10.003 * 18.6383... = 186.4417... truncated to 180
        System.out.println(
            "Sport miles remaining (expected: 180) was: " + monitor.getSportMilesRemaining());

        System.out.println();
        monitor.addFuel(5.55);
        monitor.useInSportMode(0, 0.5);
        monitor.useInSportMode(42, 2.4);
        monitor.useInGreenMode(5, 0.01);
        System.out.println("-- After F(5.55), S(0, 0.5), S(42, 2.4), then G(5, 0.01)");
        System.out.println("Trip miles (expected: 225) was: " + monitor.getTripMiles());
        System.out.println("Lifetime miles (expected: 225) was: " + monitor.getLifetimeMiles());

        // We've added a net 2.64 gallons, so 10.003 + 2.64 = 12.643 gallons remain
        System.out.println("Fuel remaining (expected: 12.643) was: " + monitor.getFuelRemaining());

        // Trip and Lifetime MPG are 225 / (2.91 + 4.497) = 30.3767... truncated to 30.3
        System.out.println("Trip MPG (expected: 30.3) was: " + monitor.getTripMPG());
        System.out.println("Lifetime MPG (expected: 30.3) was: " + monitor.getLifetimeMPG());

        // Green MPG this trip is 160 / 3.273 = 48.8848...
        // Green miles remaining is 12.643 * 48.8848... = 618.0507... truncated to 610
        System.out.println(
            "Green miles remaining (expected: 610) was: " + monitor.getGreenMilesRemaining());

        // Sport MPG this trip is 65 / 4.134 = 15.7233...
        // Sport miles remaining is 12.643 * 15.7233... = 198.7893... truncated to 190
        System.out.println(
            "Sport miles remaining (expected: 190) was: " + monitor.getSportMilesRemaining());

        System.out.println();
        monitor.resetTrip();
        monitor.useInSportMode(20, 1.111);
        monitor.useInGreenMode(345, 10);
        System.out.println("-- After R(), S(20, 1.111), then G(345, 10)");
        System.out.println("Trip miles (expected: 365) was: " + monitor.getTripMiles());
        System.out.println("Lifetime miles (expected: 590) was: " + monitor.getLifetimeMiles());

        // We've used 11.111 gallons, so 12.643 - 11.111 = 1.532 gallons remain
        System.out.println("Fuel remaining (expected: 1.532) was: " + monitor.getFuelRemaining());

        // Trip MPG is 365 / 11.111 = 32.8503... truncated to 32.8
        System.out.println("Trip MPG (expected: 32.8) was: " + monitor.getTripMPG());

        // Lifetime MPG is 590 / (7.407 + 11.111) = 31.8609... truncated to 31.8
        System.out.println("Lifetime MPG (expected: 31.8) was: " + monitor.getLifetimeMPG());

        // Green MPG this trip is 345 / 10 = 34.5
        // Green miles remaining is 1.532 * 34.5 = 52.854 truncated to 50
        System.out.println(
            "Green miles remaining (expected: 50) was: " + monitor.getGreenMilesRemaining());

        // Sport MPG this trip is 20 / 1.111 = 18.0018...
        // Sport miles remaining is 1.532 * 18.0018... = 27.5788... truncated to 20
        System.out.println(
            "Sport miles remaining (expected: 20) was: " + monitor.getSportMilesRemaining());
        
        /**
         * The following is my personal tester class.
         */
        
        System.out.println();
        System.out.println("-- Constructing new FuelMonitor object FM(20.0)");
        FuelMonitor funky = new FuelMonitor(20.0);
        System.out.println("Trip miles (expected: 0) was: " + funky.getTripMiles());
        System.out.println("Lifetime miles (expected: 0) was: " + funky.getLifetimeMiles());
        System.out.println("Fuel remaining (expected: 20.0) was: " + funky.getFuelRemaining());
        System.out.println();
        funky.useInGreenMode(25, 2.234);
        System.out.println("-- After G(25, 2.234)");
        System.out.println("Trip miles (expected: 25) was: " + funky.getTripMiles());
        System.out.println("Lifetime miles (expected: 25) was: " + funky.getLifetimeMiles());

        // We've used 2.234 gallons, so 20.0 - 2.234 = 17.766 gallons remain
        System.out.println("Fuel remaining (expected: 17.766) was: " + funky.getFuelRemaining());

        // Trip and Lifetime MPG are 25 / 2.234 = 11.1906... truncated to 11.1
        System.out.println("Trip MPG (expected: 11.1) was: " + funky.getTripMPG());
        System.out.println("Lifetime MPG (expected: 11.1) was: " + funky.getLifetimeMPG());

        // Green miles remaining is 11.1906... * 17.766 = 198.8137... truncated to 190
        System.out.println(
            "Green miles remaining (expected: 190) was: " + funky.getGreenMilesRemaining());
        
        System.out.println();
        System.out.println("-- Constructing new FuelMonitor object FM(50.0)");
        FuelMonitor funkyOne = new FuelMonitor(50.0);
        System.out.println();
        funkyOne.addFuel(15.5);
        funkyOne.useInSportMode(0, 2.5);
        funkyOne.useInSportMode(100, 25.0);
        funkyOne.useInGreenMode(55, 10.0);
        System.out.println("-- After F(15.5), S(0, 2.5), S(100, 25.0), then G(55, 10.0)");
        System.out.println("Trip miles (expected: 155) was: " + funkyOne.getTripMiles());
        System.out.println("Lifetime miles (expected: 155) was: " + funkyOne.getLifetimeMiles());

        // We created a new object with 50.0 gallons and added 15.5 gallons.
        // So 65.5 - 2.5 - 25.0 - 10.0 = 28.0 gallons remain
        System.out.println("Fuel remaining (expected: 28.0) was: " + funkyOne.getFuelRemaining());

        // Trip and Lifetime MPG are 155 / (10.0 + 27.5) = 4.1333... truncated to 4.1
        System.out.println("Trip MPG (expected: 4.1) was: " + funkyOne.getTripMPG());
        System.out.println("Lifetime MPG (expected: 4.1) was: " + funkyOne.getLifetimeMPG());

        // Green MPG this trip is 55 / 10.0 = 5.5...
        // Green miles remaining is 5.5 * 28.0... = 154... truncated to 150
        System.out.println(
            "Green miles remaining (expected: 150) was: " + funkyOne.getGreenMilesRemaining());

        // Sport MPG this trip is 100 / 27.5 = 3.6363...
        // Sport miles remaining is 3.6363 * 28.0... = 101.8181... truncated to 100
        System.out.println(
            "Sport miles remaining (expected: 100) was: " + funkyOne.getSportMilesRemaining());
        
        System.out.println();
        funkyOne.resetTrip();
        funkyOne.addFuel(15.5);
        funkyOne.useInSportMode(0, 2.5);
        funkyOne.useInSportMode(100, 25.0);
        funkyOne.useInGreenMode(55, 10.0);

        // Green MPG this trip is 55 / 10.0 = 5.5...
        // Green miles remaining is 5.5 * 6.0... = 33... truncated to 30
        System.out.println(
            "Green miles remaining (expected: 30) was: " + funkyOne.getGreenMilesRemaining());

        // Sport MPG this trip is 100 / 27.5 = 3.6363...
        // Sport miles remaining is 3.6363 * 6.0... = 21.8181... truncated to 20
        System.out.println(
            "Sport miles remaining (expected: 20) was: " + funkyOne.getSportMilesRemaining());
        System.out.println();
        funkyOne.resetTrip();
        System.out.println("Trip miles (expected: 0) was: " + funkyOne.getTripMiles());
        System.out.println("Lifetime miles (expected: 310) was: " + funkyOne.getLifetimeMiles());

        // We haven't added any fuel so it should remain the same at 6.0.
        System.out.println("Fuel remaining (expected: 6.0) was: " + funkyOne.getFuelRemaining());

        // Trip MPG is zero because we haven't used any fuel or miles..
        // Lifetime MPG are 310 / 75.0 = 4.1333... truncated to 4.1
        System.out.println("Trip MPG (expected: 0.0) was: " + funkyOne.getTripMPG());
        System.out.println("Lifetime MPG (expected: 4.1) was: " + funkyOne.getLifetimeMPG());

    }

}
