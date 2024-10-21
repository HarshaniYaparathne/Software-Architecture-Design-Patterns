public class ChainOfResponsibilityPattern {

    // Abstract handler class
    abstract static class Dispenser {
        protected Dispenser nextDispenser;

        // Set the next dispenser in the chain
        public void setNextDispenser(Dispenser nextDispenser) {
            this.nextDispenser = nextDispenser;
        }

        // Handle the request
        public void dispense(int amount) {
            if (nextDispenser != null) {
                nextDispenser.dispense(amount);
            }
        }
    }

    // Concrete handler for dispensing $50 notes
    static class Dispenser50 extends Dispenser {
        @Override
        public void dispense(int amount) {
            if (amount >= 50) {
                int num = amount / 50;
                int remainder = amount % 50;
                System.out.println("Dispensing " + num + " $50 note" + (num > 1 ? "s" : ""));
                if (remainder != 0) {
                    super.dispense(remainder);
                }
            } else {
                super.dispense(amount);
            }
        }
    }

    // Concrete handler for dispensing $20 notes
    static class Dispenser20 extends Dispenser {
        @Override
        public void dispense(int amount) {
            if (amount >= 20) {
                int num = amount / 20;
                int remainder = amount % 20;
                System.out.println("Dispensing " + num + " $20 note" + (num > 1 ? "s" : ""));
                if (remainder != 0) {
                    super.dispense(remainder);
                }
            } else {
                super.dispense(amount);
            }
        }
    }

    // Concrete handler for dispensing $10 notes
    static class Dispenser10 extends Dispenser {
        @Override
        public void dispense(int amount) {
            if (amount >= 10) {
                int num = amount / 10;
                int remainder = amount % 10;
                System.out.println("Dispensing " + num + " $10 note" + (num > 1 ? "s" : ""));
                if (remainder != 0) {
                    super.dispense(remainder);
                }
            } else {
                super.dispense(amount);
            }
        }
    }

    // Concrete handler for dispensing $5 notes
    static class Dispenser5 extends Dispenser {
        @Override
        public void dispense(int amount) {
            if (amount >= 5) {
                int num = amount / 5;
                int remainder = amount % 5;
                System.out.println("Dispensing " + num + " $5 note" + (num > 1 ? "s" : ""));
                if (remainder != 0) {
                    super.dispense(remainder);
                }
            } else {
                super.dispense(amount);
            }
        }
    }

    // Main method to demonstrate the Chain of Responsibility pattern for ATM
    public static void main(String[] args) {
        // Create handlers
        Dispenser dispenser50 = new Dispenser50();
        Dispenser dispenser20 = new Dispenser20();
        Dispenser dispenser10 = new Dispenser10();
        Dispenser dispenser5 = new Dispenser5();

        // Set the chain of responsibility
        dispenser50.setNextDispenser(dispenser20);
        dispenser20.setNextDispenser(dispenser10);
        dispenser10.setNextDispenser(dispenser5);

        // Amount to be dispensed
        int amount = 135;
        System.out.println("Requested amount: $" + amount);
        System.out.println("Dispensing:");
        dispenser50.dispense(amount);  // Start the chain with the highest denomination
    }
}