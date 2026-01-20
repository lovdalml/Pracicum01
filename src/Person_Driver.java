public class Person_Driver {

    public static void main(String[] args) {
        Person p1 = new Person("12345", "John", "Doe", "Mr.", 1990);

        System.out.println(p1);
        System.out.println();
        System.out.println("Person Details:");
        System.out.println("ID Number: " + p1.getIDNum());
        System.out.println("First Name: " + p1.getFirstName());
        System.out.println("Last Name: " + p1.getLastName());
        System.out.println("Title: " + p1.getTitle());
        System.out.println("Year of Birth: " + p1.getYob());
        System.out.println();
        System.out.println("Full Name: " + p1.getFullName());
        System.out.println("Formal Name: " + p1.getFormalName());
        System.out.println();
        System.out.println("CSV Data String:");
        System.out.println(p1.toCSVDataString());
        System.out.println();
        System.out.println("JSON Data String:");
        System.out.println(p1.toJSONDataString());
        System.out.println();
        System.out.println("XML Data String:");
        System.out.println(p1.toXMLDataString());
        System.out.println();
        System.out.println("Formatted JSON Data String:");
        System.out.println(p1.toJSONDataStringFormatted());

    }








}
