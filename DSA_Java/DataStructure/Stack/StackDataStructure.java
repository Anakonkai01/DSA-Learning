package DSA_Java.DataStructure.Stack;


import java.util.*;
public class StackDataStructure {
    public static boolean validate_Parentheses(String s){
        Stack<Character> myStack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(c == '{' || c == '[' || c == '(') {
                myStack.push(c);
            }
            else{
                if(myStack.isEmpty()) return false;
                char check = myStack.pop();
                if(c == '}' && check != '{') return false;
                if(c == ')' && check != '(') return false;
                if(c == ']' && check != '[') return false;
            }
        }

        return myStack.isEmpty(); 
    }
    public static void main(String[] args) {
        // Test cases
        System.out.println(validate_Parentheses("{[()]}")); // true
        System.out.println(validate_Parentheses("(((([[]]))))")); // true
        System.out.println(validate_Parentheses("{[()]}(")); // false
        System.out.println(validate_Parentheses("{[(])}")); // false
        System.out.println(validate_Parentheses("((]")); // false
        System.out.println(validate_Parentheses("")); // true
        System.out.println(validate_Parentheses("(")); // false
        System.out.println(validate_Parentheses(")")); // false
        System.out.println(validate_Parentheses("{[({})]}")); // true
        System.out.println(validate_Parentheses("{[(])}")); // false
        System.out.println(validate_Parentheses("{[][]}({})")); // true
    }
}
