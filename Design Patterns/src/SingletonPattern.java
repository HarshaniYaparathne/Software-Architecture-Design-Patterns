public class SingletonPattern {

    // Configuration class implementing Singleton pattern
    static class Configuration {
        // Private static instance of the singleton
        private static final Configuration instance = new Configuration();

        // Sample configuration settings
        private final String databaseUrl;
        private final String username;

        // Private constructor to prevent instantiation
        private Configuration() {
            // Initialize configuration settings
            this.databaseUrl = "jdbc:mysql://localhost:3306/mydatabase";
            this.username = "admin";
        }

        // Public method to provide access to the instance
        public static Configuration getInstance() {
            return instance;
        }

        // Getters for configuration settings
        public String getDatabaseUrl() {
            return databaseUrl;
        }

        public String getUsername() {
            return username;
        }
    }

    // Main method to demonstrate the Singleton pattern with Configuration
    public static void main(String[] args) {
        // Access the singleton instance and retrieve configuration settings
        Configuration config1 = Configuration.getInstance();
        System.out.println("Database URL: " + config1.getDatabaseUrl());
        System.out.println("Username: " + config1.getUsername());

        // Access the singleton instance again
        Configuration config2 = Configuration.getInstance();

        // Verify that both references point to the same instance
        System.out.println("Are both configuration instances the same? " + (config1 == config2));
    }
}