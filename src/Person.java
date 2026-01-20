public class Person {
    private String IDNum;
    private String firstName;
    private String lastName;
    private String title;
    private int yob;

    //constructor
    public Person(String IDNum, String firstName, String lastName, String title, int yob) {
        this.IDNum = IDNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.yob = yob;
    }
    //getters
    public String getIDNum() {
        return IDNum;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getTitle() {
        return title;
    }
    public int getYob() {
        return yob;
    }

    @Override
    public String toString() {
        return "Person{" +
                "IDNum='" + IDNum + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", yob=" + yob +
                '}';
    }
    public String toCSVDataString() {
        return IDNum + "," + firstName + "," + lastName + "," + title + "," + yob;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
    public String getFormalName() {
        return title + " " + firstName +" " + lastName;
    }

    public String toJSONDataString() {
        return "{ \"IDNum\": \"" + IDNum + "\", \"firstName\": \"" + firstName + "\", \"lastName\": \"" + lastName + "\", \"title\": \"" + title + "\", \"yob\": " + yob + " }";
    }

    public String toXMLDataString() {
        return "<Person>\n" +
                "  <IDNum>" + IDNum + "</IDNum>\n" +
                "  <firstName>" + firstName + "</firstName>\n" +
                "  <lastName>" + lastName + "</lastName>\n" +
                "  <title>" + title + "</title>\n" +
                "  <yob>" + yob + "</yob>\n" +
                "</Person>";
    }
    public String toJSONDataStringFormatted() {
        return "{\n" +
                "  \"IDNum\": \"" + IDNum + "\",\n" +
                "  \"firstName\": \"" + firstName + "\",\n" +
                "  \"lastName\": \"" + lastName + "\",\n" +
                "  \"title\": \"" + title + "\",\n" +
                "  \"yob\": " + yob + "\n" +
                "}";
    }
}