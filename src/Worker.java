public class Worker extends Person {
    private double hourlyPayRate;

    public Worker(String IDNum, String firstName, String lastName, String title, int yob, double hourlyPayRate) {
        super(IDNum, firstName, lastName, title, yob);
        this.hourlyPayRate = hourlyPayRate;
    }

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public void setHourlyPayRate(double hourlyPayRate) {
        this.hourlyPayRate = hourlyPayRate;
    }

    public double calculateWeeklyPay(double hoursWorked) {
        if (hoursWorked <= 40) {
            return hoursWorked * hourlyPayRate;
        } else {
            // Regular pay for first 40 hours + overtime (1.5x) for hours over 40
            double regularPay = 40 * hourlyPayRate;
            double overtimePay = (hoursWorked - 40) * hourlyPayRate * 1.5;
            return regularPay + overtimePay;
        }
    }

    public String displayWeeklyPay(double hoursWorked) {
        double pay = calculateWeeklyPay(hoursWorked);
        return String.format("%-20s $%,10.2f", getFullName(), pay);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "IDNum='" + getIDNum() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", yob=" + getYob() +
                ", hourlyPayRate=$" + String.format("%.2f", hourlyPayRate) +
                '}';
    }
}