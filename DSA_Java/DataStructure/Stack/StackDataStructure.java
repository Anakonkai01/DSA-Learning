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



class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String str : tokens){
            int operant = 0;
            switch(str){

                case "+":
                    operant = stack.pop() + stack.pop();
                    stack.push(operant);
                    break;
                case "-":
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    operant = num1 - num2;
                    stack.push(operant);
                    break;
                case "*":
                    operant = stack.pop() * stack.pop();
                    stack.push(operant);
                    break;
                case "/":
                    num2 = stack.pop();
                    num1 = stack.pop();
                    operant = num1 / num2;
                    stack.push(operant);
                    break;
                default:
                    int num = Integer.parseInt(str);
                    stack.push(num);
                    break;
            }
        }
        return stack.pop();
    }
}


class Solution1{
    public int carFleet(int target, int[] position, int[] speed) {
        int cars = position.length;
        double[][] pairs = new double[cars][2];
        for(int i = 0; i < cars; i++){
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i]; 
        }
        // sap xep giam dan
        Arrays.sort(pairs,(a,b) -> Double.compare(b[0],a[0]));

        Stack<Double> stack = new Stack<>();
        for(int i = 0; i < cars; i++){
            double time = (target - pairs[i][0])/pairs[i][1];
            if(stack.isEmpty() || time >= stack.peek()){
                stack.push(time);
            }
        }
        return stack.size();    
    }
}
