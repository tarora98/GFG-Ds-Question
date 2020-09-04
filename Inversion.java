import java.util.*;
public class Inversion{
	static int solved(int [] arr,int n){
        int counter=0;
		for(int i=0;i<arr.length;i++){
			for(int j=1;j<arr.length;j++){
				if(arr[i]>arr[j]){
					counter++;
				}
			}
		}
		return counter;
	}
	public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
	int arr[]=new int[n];
	for(int i=0;i<arr.length;i++){
		arr[i]=sc.nextInt();
	}
	System.out.println(solved(arr,n));
	}
}