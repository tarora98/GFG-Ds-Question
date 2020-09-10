//231
class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n&(n-1)) ==0;
        
    }
}


//191
public class Solution {
    // you need to treat n as an unsigned value
    // static
    public int hammingWeight(int n) {
     int counter=0;
      while(n!=0){
          counter++;
          n&=(n-1);
      }
        return counter;
}
}

//342
class Solution {
    public boolean isPowerOfFour(int num) {
        if(num> 0 && (num&(num-1))==0){
            int count=0;
            while(num!=1){
                num>>=1;
                count++;
            }
            return (count&1)==0; // check even or odd // if count is even then power of 4 else not 
        }
           return false;
    }
}

//136
class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans^=nums[i]; // left only the  single one as in xor the same same(for eg.      0,0) will be 0 
        }
        return ans;
    }
}

//137
class Solution {
    public int singleNumber(int[] nums) {
        int k=3;
        int ans=0;
        for(int i=0;i<32;i++){
            int count=0;
            int mask=(1<<i);
            for(int ele:nums){
                if((ele&mask)!=0){
                    count++;
                }
            }
            if(count%k!=0){
                ans|=mask;
            }
        }
        return ans;
    }
}
 //Word Break PRoblem recursion====================================================================
 import java.util.*;
import java.lang.*;
import java.io.*;
class Solution {
    static int solved(String input,String st,HashSet<String> word, int len){
        // Base Case
        if(input.length()==0){
            return 1;
        }
         //Loop
        int count=0;
         for(int i=0;i<=len && i<=input.length();i++){
             String s=input.substring(0,i);
             if(word.contains(s)){
                 count+=solved(input.substring(i),st+s+" ",word,len);
             }
         }
        return count;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> word=new HashSet<>();
        int len=0;
        for(int str=0;str<wordDict.size();str++){
         word.add(wordDict.get(str));
         String st=wordDict.get(str);
         len = Math.max(len,st.length());
        }
        int count =solved(s,"",word,len);
        if(count!=0){
            return true;
        }
        return false;
    }
}