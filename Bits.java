import java.util.*;
public class Bits{
	public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
    int counter=0;
	while(n!=0){
		// int rbsm=n&-n; ///
		// n-=rbsm;
		// counter++;
		counter+=n&1;
		n>>=1;
	}
	System.out.print(counter);
	}
}