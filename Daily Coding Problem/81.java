class Main {
    static String[] hashTable = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}; 
    
    static void printWordsUtil(int number[], int curr_digit, char output[], int n) 
    { 
        // Base case, if current output word is prepared 
        if (curr_digit == n) 
        { 
            for(char ch : output){
                System.out.print(output); 
            }
            
            return; 
        } 

        if (number[curr_digit] == 0 || number[curr_digit] == 1) {
            output[curr_digit] = 0;
            printWordsUtil(number, curr_digit+1, output, n); 
            return;
        }
        
        String curr = hashTable[number[curr_digit]];
        int len = curr.length();
        // Try all 3 possible characters for current digir in number[] 
        // and recur for remaining digits 
        for (int i = 0; i < len; i++) 
        { 
            output[curr_digit] = hashTable[number[curr_digit]].charAt(i); 
            printWordsUtil(number, curr_digit+1, output, n); 
            //if (number[curr_digit] == 0 || number[curr_digit] == 1) 
            //    return; 
        } 
    } 

    // A wrapper over printWordsUtil().  It creates an output array and 
    // calls printWordsUtil() 
    static void printWords(int number[], int n) 
    { 
        char[] result = new char[n+1]; 
        result[n] ='\n'; 
        printWordsUtil(number, 0, result, n); 
    } 
    
    public static void main(String[] args) {
        int number[] = {0, 3, 4}; 
        printWords(number, number.length);
    }
}