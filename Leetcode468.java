class Solution {
    static int valid(String IP){
        int count4=0;
        int count6=0; 
        for(int i=0;i<IP.length();i++){
            if(IP.charAt(i)=='.'){
                count4++;
            }
            if(IP.charAt(i)==':'){
                count6++;
            }
        }
        if(count4==3){
            return 0; //IPV4
        }
        else if(count6==7){
            return 1; //IPV6
        }
        else{
            return -1;
        }
    } 
    public String validIPAddress(String IP) {
        if(IP.length()==0){
            String st="Neither";
            return st;
        }
        if(valid(IP)==0){
            return validIPV4(IP);
        }
        else if(valid(IP)==1){
            return validIPV6(IP);
        }
        else{
            System.out.print("HEHE");
            String st="Neither";
            return st;
        }
    }
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
    static String validIPV4(String IP4){
        String st="";
        String result="IPv4";
        IP4+=".";
        for(int i=0;i<IP4.length();i++){
            if(IP4.charAt(i)=='.'){
                if(st.length() > 3) {
                    result="Neither";
                    break;   
                }
                if(isNumeric(st)==true && st.charAt(0)!='0'){
                    int num=Integer.parseInt(st);
                    if(0<=num && num<=255){
                        st="";
                    }else{
                    result="Neither";
                    break;   
                    }
                }
                else if(isNumeric(st)==true && st.charAt(0)=='0' &&st.length()==1){
                    st="";
                }
                else{
                    result="Neither";
                    break;
                } 
            }
            else{
                st+=IP4.charAt(i);
            }
        }
        return result;
    }
    
    static String validIPV6(String IP6){
        String st="";
        String result="IPv6";
        IP6+=":";
        for(int i=0;i<IP6.length();i++){
            if(IP6.charAt(i)==':'){
               if(st.length()>=1 && st.length()<=4){
                   for(int s=0;s<st.length();s++){
                       char ch1=st.charAt(s);
                       // System.out.print(ch1);
                       if ((ch1 >= 'A' && ch1 <= 'F')  ||  (ch1 >= '0' && ch1 <= '9') || (ch1 >= 'a' && ch1 <= 'f')){
                       }
                       else{
                           result="Neither";
                           break;
                       }
               }
               }else{
                   result="Neither";
                   break;
               }
                st="";
            }else{
                st+=IP6.charAt(i);
            }
        }
            return result;
        }
    }  