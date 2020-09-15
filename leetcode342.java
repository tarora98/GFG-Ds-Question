
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
