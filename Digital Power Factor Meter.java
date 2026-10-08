import java.util.Scanner;

public class DigitalPowerFactorMeter {

    private double voltage;
    private double current;
    private double activePower;

    public DigitalPowerFactorMeter(double voltage, double current, double activePower) {
        this.voltage = voltage;
        this.current = current;
        this.activePower = activePower;
    }

    // Calculate apparent power
    public double calculateApparentPower() {
        return voltage * current;
    }

    // Calculate power factor
    public double calculatePowerFactor() {
        double apparentPower = calculateApparentPower();

        if (apparentPower == 0) {
            return 0;
        }

        return activePower / apparentPower;
    }

    // Display results
    public void displayResult() {
        double apparentPower = calculateApparentPower();
        double powerFactor = calculatePowerFactor();

        System.out.println("\n----- Digital Power Factor Meter -----");
        System.out.printf("Voltage          : %.2f V%n", voltage);
        System.out.printf("Current          : %.2f A%n", current);
        System.out.printf("Active Power     : %.2f W%n", activePower);
        System.out.printf("Apparent Power   : %.2f VA%n", apparentPower);
        System.out.printf("Power Factor     : %.3f%n", powerFactor);

        if (powerFactor >= 0.95) {
            System.out.println("Status           : GOOD");
        } else if (powerFactor >= 0.80) {
            System.out.println("Status           : MODERATE");
        } else {
            System.out.println("Status           : LOW - Power Factor Improvement Needed");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== DIGITAL POWER FACTOR METER =====");

        System.out.print("Enter Voltage (V): ");
        double voltage = scanner.nextDouble();

        System.out.print("Enter Current (A): ");
        double current = scanner.nextDouble();

        System.out.print("Enter Active Power (W): ");
        double activePower = scanner.nextDouble();

        DigitalPowerFactorMeter meter =
                new DigitalPowerFactorMeter(voltage, current, activePower);

        meter.displayResult();

        scanner.close();
    }
}
