package DSA_Java.Algorithms.BackTracking;

import java.util.ArrayList;
import java.util.List;

// Java program to print all permutations of a 
// given string. 
public class Permutation { 
  
    // Function call 
    public static void main(String[] args) 
    { 
        List<String> list = new ArrayList<>();
        String str = "ABC"; 
        int n = str.length(); 
        Permutation permutation = new Permutation(); 
        permutation.permute(str, 0, n - 1,list); 
        System.out.println(list);
    } 
  
    private void permute(String str, int l, int r, List<String> list) 
    { 
        if (l == r) 
            list.add(str);
        else { 
            for (int i = l; i <= r; i++) { 
                str = swap(str, l, i); 
                permute(str, l + 1, r,list); 
                str = swap(str, l, i);  
            } 
        } 
    } 
  
    
    public String swap(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i]; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
    } 
} 