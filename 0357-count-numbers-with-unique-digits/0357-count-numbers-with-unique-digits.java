class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if( n==0) return 1;

        int fixedUnique=10; // 0 to 9

        int uniqueStarting=9; // can start with 9 digits uniqly but not 0
        int available=9; // as insitaily 1 to 9 for startign number not zero again for 2nd pos use other that that first paec used digiit and so no tit will decrese by 1

        //doing iteration for palcing the digits 
         for(int i=2;i<=n;i++){
            uniqueStarting=uniqueStarting*available;
            fixedUnique+=uniqueStarting;
            available--;
         }
         return fixedUnique;
    }
}