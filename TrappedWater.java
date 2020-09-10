import java.util.*;
import java.lang.*;
import java.io.*;
public class TrappedWater{
	static int solved(int [] nums){
		int left[]=new int[nums.length];
		left[0]=nums[0];
		for(int i=1;i<nums.length;i++){ //left side
			left[i]=Math.max(left[i-1],nums[i]);
		}
		int right[]=new int[nums.length];
		right[nums.length-1]=nums[nums.length-1];
		for(int i=nums.length-2;i>=0;i--){
			right[i]=Math.max(right[i+1],nums[i]);
		}
		int result=0;
		for(int i=0;i<nums.length;i++){
			result+=(Math.min(left[i],right[i])-nums[i]);
		}
		return result;
	}
	public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
	int T=sc.nextInt();
	for(int j=0;j<T;j++){
	int n=sc.nextInt();
	int arr[]=new int[n];
	for(int i=0;i<n;i++){
		arr[i]=sc.nextInt();
	}
	System.out.println(solved(arr));
	}
	}
}










// import java.util.*;
// import java.lang.*;
// import java.io.*;
// public class TrappedWater{
// 	static int solved(int [] nums){
// 		int lo=0;
// 		int hi=nums.length-1;		
// 		int left=nums[0];
// 		int right=nums[nums.length-1];
// 		int result=0;
// 		while(lo<hi){
// 			if(nums[lo]<nums[hi]){
// 				if(nums[lo]>left){
// 					left=nums[lo];
// 				}
// 				else{
// 					result+=left-nums[lo];
// 				}
// 				lo++;
// 			}
// 			else{
// 				if(nums[hi]>right){
// 					right=nums[hi];
// 				}
// 				else{
// 					result+=right-nums[hi];
// 				}
// 			    hi--;
// 			}
// 		}
// 		return result;
// 	}
// 	public static void main(String[] args){
// 	Scanner sc=new Scanner(System.in);
// 	int T=sc.nextInt();
// 	for(int j=0;j<T;j++){
// 	int n=sc.nextInt();
// 	int arr[]=new int[n];
// 	for(int i=0;i<n;i++){
// 		arr[i]=sc.nextInt();
// 	}
// 	System.out.println(solved(arr));
// 	}
// 	}
// }