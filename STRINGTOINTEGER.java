public class Valid{
    static boolean isNumeric(String strNum) {
    if (strNum == null) {
        return false;
    }
    boolean numeric = true;
    numeric = strNum.matches("-?\\d+(\\.\\d+)?");
    if(numeric)
        return true;
    else
        return false;
 }
 public static void main(String[] args){
    System.out.println(isNumeric("01"));
}
}
