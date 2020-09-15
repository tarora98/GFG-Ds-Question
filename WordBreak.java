
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