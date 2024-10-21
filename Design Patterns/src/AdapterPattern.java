public class AdapterPattern {

    // Target interface
    interface TemperatureTarget {
        void displayTemperatureInFahrenheit();
    }

    // Adaptee class with specific methods for temperature in Celsius
    static class TemperatureAdaptee {
        private final double temperatureInCelsius;

        public TemperatureAdaptee(double temperatureInCelsius) {
            this.temperatureInCelsius = temperatureInCelsius;
        }

        public double getTemperatureInCelsius() {
            return temperatureInCelsius;
        }

        // Convert Celsius to Fahrenheit
        public double getTemperatureInFahrenheit() {
            return (temperatureInCelsius * 9 / 5) + 32;
        }
    }

    // Adapter class implementing Target and using TemperatureAdaptee
    static class TemperatureAdapter implements TemperatureTarget {
        private final TemperatureAdaptee adaptee;

        public TemperatureAdapter(TemperatureAdaptee adaptee) {
            this.adaptee = adaptee;
        }

        @Override
        public void displayTemperatureInFahrenheit() {
            double temperature = adaptee.getTemperatureInFahrenheit();
            System.out.println("Temperature in Fahrenheit: " + temperature);
        }
    }

    // Main method to demonstrate the Adapter pattern with temperature
    public static void main(String[] args) {
        TemperatureAdaptee adaptee = new TemperatureAdaptee(25);

        // Display temperature in Celsius before adaptation
        System.out.println("Temperature before adaptation:");
        System.out.println("Temperature in Celsius: " + adaptee.getTemperatureInCelsius());
        System.out.println("----------------------------------");

        // Adapt and display temperature in Fahrenheit
        System.out.println("Temperature after adaptation:");
        TemperatureTarget target = new TemperatureAdapter(adaptee);
        target.displayTemperatureInFahrenheit();  // Should print the temperature in Fahrenheit
    }
}