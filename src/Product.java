public class Product {
    private String IDNum;
    private String pName;
    private String descript;
    private int Cost;

    //constructor
    public Product(String IDNum, String pName, String descript,  int Cost) {
        this.IDNum = IDNum;
        this.pName = pName;
        this.descript = descript;
        this.Cost = Cost;
    }
    //getters
    public String getIDNum() {return IDNum;}
    public String getPName() {return pName;}
    public String getDescript() {return descript;}
    public int getCost() {return Cost;}


    @Override
    public String toString() {
        return "Product{" +
                "IDNum='" + IDNum + '\'' +
                ", pName='" + pName + '\'' +
                ", descript='" + descript + '\'' +
                ", Cost=" + Cost +
                '}';
    }
    public String toCSVDataString() {
        return IDNum + "," + pName + "," + descript + "," + Cost;
    }
    public String toJSONDataString() {
        return "{ \"IDNum\": \"" + IDNum + "\", \"pName\": \"" + pName + "\", \"descript\": \"" + descript + "\", \"Cost\": " + Cost + " }";
    }
    public String toXMLDataString() {
        return "<Product>\n" +
                "  <IDNum>" + IDNum + "</IDNum>\n" +
                "  <pName>" + pName + "</pName>\n" +
                "  <descript>" + descript + "</descript>\n" +
                "  <Cost>" + Cost + "</Cost>\n" +
                "</Product>";
    }
    public String toJSONDataStringFormatted() {
        return "{\n" +
                "  \"IDNum\": \"" + IDNum + "\",\n" +
                "  \"pName\": \"" + pName + "\",\n" +
                "  \"descript\": \"" + descript + "\",\n" +
                "  \"Cost\": " + Cost + "\n" +
                "}";
    }
}


