public class SalaryWorker extends Worker {
    private double annualSalary;

    public SalaryWorker(String IDNum, String firstName, String lastName, String title, int yob, double annualSalary) {
        // Pass 0 as hourly rate since salary workers don't use it
        super(IDNum, firstName, lastName, title, yob, 0);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        // Salary workers get the same pay regardless of hours worked
        // Annual salary divided by 52 weeks
        return annualSalary / 52.0;
    }

    @Override
    public String displayWeeklyPay(double hoursWorked) {
        double pay = calculateWeeklyPay(hoursWorked);
        return String.format("%-20s $%,10.2f (Salary)", getFullName(), pay);
    }

    @Override
    public String toString() {
        return "SalaryWorker{" +
                "IDNum='" + getIDNum() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", yob=" + getYob() +
                ", annualSalary=$" + String.format("%,.2f", annualSalary) +
                '}';
    }
}