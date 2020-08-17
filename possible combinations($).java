import java.io.*;
import java.util.*;

class GFG {
    static long solved(String st){
        long count=0;
        for(int i=0;i<st.length();i++){
            if(Character.isDigit(st.charAt(i)))
            {
                count++;
            }
        }
        long l=st.length()-count;
        long s=fact(l);
        long result=s*count;
        return result;
    }
    static long fact(long l){
        long factorial=1;
        for(int i = 1; i <= l; ++i)
        {
            factorial *= i;
        }
        return factorial;

    }
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		String st=sc.next();
		System.out.println(solved(st));
	}
}
