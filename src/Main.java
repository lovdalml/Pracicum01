import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>();


        Worker w1 = new Worker("Worker1", "John", "Smith", "Mr.", 1990, 20.00);
        Worker w2 = new Worker("Worker2", "Sarah", "Johnson", "Ms.", 1985, 25.00);
        Worker w3 = new Worker("Worker3", "Michael", "Brown", "Mr.", 1992, 30.00);


        SalaryWorker sw1 = new SalaryWorker("SalWorker1", "Emily", "Davis", "Dr.", 1988, 70000);
        SalaryWorker sw2 = new SalaryWorker("SalWorker2", "David", "Wilson", "Mr.", 1983, 90000);
        SalaryWorker sw3 = new SalaryWorker("SalWorker3", "Jennifer", "Martinez", "Ms.", 1991, 80000);

        workers.add(w1);
        workers.add(w2);
        workers.add(w3);
        workers.add(sw1);
        workers.add(sw2);
        workers.add(sw3);


        System.out.println("=".repeat(80));
        System.out.println("Workers");
        System.out.println("=".repeat(80));
        for (Worker worker : workers) {
            System.out.println(worker);
        }
        System.out.println();


        int[] weeklyHours = {40, 50, 40};
        String[] weekDescriptions = {
                "Week 1 - Regular Hours (40 hours)",
                "Week 2 - Crunch Time (50 hours)",
                "Week 3 - Back to Normal (40 hours)"
        };


        for (int week = 0; week < 3; week++) {
            System.out.println("=".repeat(80));
            System.out.println(weekDescriptions[week]);
            System.out.println("=".repeat(80));
            System.out.printf("%-20s %15s%n", "Worker Name", "Weekly Pay");
            System.out.println("-".repeat(80));

            double totalWeeklyPay = 0;

            for (Worker worker : workers) {
                double pay = worker.calculateWeeklyPay(weeklyHours[week]);
                System.out.println(worker.displayWeeklyPay(weeklyHours[week]));
                totalWeeklyPay += pay;
            }

            System.out.println("-".repeat(80));
            System.out.printf("%-20s $%,10.2f%n", "TOTAL PAYROLL:", totalWeeklyPay);
            System.out.println();
        }

        System.out.println("=".repeat(100));
        System.out.println("THREE-WEEK PAYROLL SUMMARY");
        System.out.println("=".repeat(100));
        System.out.printf("%-20s %15s %15s %15s %15s%n",
                "Employee Name", "Week 1 (40h)", "Week 2 (50h)", "Week 3 (40h)", "Total");
        System.out.println("-".repeat(100));

        double[] weekTotals = new double[3];

        for (Worker worker : workers) {
            double week1Pay = worker.calculateWeeklyPay(40);
            double week2Pay = worker.calculateWeeklyPay(50);
            double week3Pay = worker.calculateWeeklyPay(40);
            double total = week1Pay + week2Pay + week3Pay;

            weekTotals[0] += week1Pay;
            weekTotals[1] += week2Pay;
            weekTotals[2] += week3Pay;

            System.out.printf("%-20s $%,13.2f $%,13.2f $%,13.2f $%,13.2f%n",
                    worker.getFullName(), week1Pay, week2Pay, week3Pay, total);
        }

        System.out.println("-".repeat(100));
        System.out.printf("%-20s $%,13.2f $%,13.2f $%,13.2f $%,13.2f%n",
                "TOTAL PAYROLL:", weekTotals[0], weekTotals[1], weekTotals[2],
                weekTotals[0] + weekTotals[1] + weekTotals[2]);
        System.out.println("=".repeat(100));
    }
}