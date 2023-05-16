import java.util.*;
public class StackC {
    // 1::
    public static void pushAtBottom(Stack<Integer> s, int data) {
        // base cond
        if(s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    // 2::
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()) {
            sb.append(s.pop());
        }
        return sb.toString();
    }

    // 3::
    public static void reverseStack(Stack<Integer> s) {
        if(s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    // 4::
    public static void stockSpan(int[] stocks, int[] span) {
        Stack<Integer> s = new Stack<>();
        // push the 1st index
        s.push(0);
        span[0] = 1;
        for (int i = 1; i < span.length; i++) {
            int presStock = stocks[i]; 
            while(!s.isEmpty() && presStock >= stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()) {
                span[i] = i + 1;
            }
            else {
                span[i] = i - s.peek();
            }
            s.push(i);
        }
    }

    // 5::
    public static void nextGreater(int[] arr, int[] nextG) {
        Stack<Integer> s = new Stack<>();
        for (int i = nextG.length - 1; i >= 0; i--) {
            while(!s.isEmpty() && arr[i] >= arr[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nextG[i] = -1;
            } else {
                nextG[i] = arr[s.peek()];
            }
            s.push(i);
        }
    }

    // 6::
    public static Boolean validParenthesis(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char bracket = str.charAt(i);
            switch(bracket) {
                case '}':
                    if(!s.isEmpty() && s.peek() == '{') {
                        s.pop();
                    } else {
                        return false;
                    }
                    break;
                case ')':
                    if(!s.isEmpty() && s.peek() == '(') {
                        s.pop();
                    } else {
                        return false;
                    }
                    break;             
                case ']':
                    if(!s.isEmpty() && s.peek() == '[') {
                        s.pop();
                    } else {
                        return false;
                    }
                    break;    
                default:
                    s.push(bracket);
            }
        }
        if(s.isEmpty()) {
            return true;
        }
        return false;
    }

    // 6::
    public static Boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char bracket = str.charAt(i);

            // open bracket
            if(bracket == '{' || bracket == '[' || bracket == '(' ) {
                s.push(bracket);
            } 
            // close bracket
            else { 
                if(s.isEmpty()) { // --> stack empty
                    return false;
                }
                if((bracket == ')' && s.peek() == '(') ||
                    (bracket == ']' && s.peek() == '[') ||
                    (bracket == '}' && s.peek() == '{')) {
                        s.pop();
                } else {
                    return false;
                }
            }
        }
        if(s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    // 7::
    public static Boolean DuplicateParenthesis (String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c != ')') {
                s.push(c);
            } else {
                if(s.isEmpty()) {
                    return false;
                }
                int count = 0;
                while(s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if(count < 1) {
                    return true;
                } s.pop();
            }
        }
        return false;
    }

    // 8::
    public static void maxArea(int[] height) {

        // left smaller
        Stack<Integer> s = new Stack<>();
        int[] leftSpan = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            while(!s.isEmpty() && height[i] <= height[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                leftSpan[i] = -1;
            } else {
                leftSpan[i] = s.peek();   
            }s.push(i);
        }

        // right smaller
        Stack<Integer> ss = new Stack<>();
        int[] rightSpan = new int[height.length];
        for (int i = height.length - 1; i >= 0; i--) {
            while(!ss.isEmpty() && height[i] <= height[ss.peek()]) {
                ss.pop();
            }
            if(ss.isEmpty()) {
                rightSpan[i] = height.length;
            } else {
                rightSpan[i] = ss.peek();   
            }ss.push(i);
        }

        // max area
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < rightSpan.length; i++) {
            int width = rightSpan[i] - leftSpan[i] - 1;
            int area = width * height[i];
            maxArea = Math.max(maxArea, area);
        }
        System.out.println("maxArea = " + maxArea);
    }
    public static void main(String[] args) {
        int[] height = {2,1,5,6,2,3};
        maxArea(height);
        // 7::
        // String s = ")";
        // System.out.println(DuplicateParenthesis(s));

        // 6::
        // String str = "[]({})";
        // // System.out.println(validParenthesis(str));
        // System.out.println(isValid(str));

        // 5::
        // int[] arr = {6, 7, 8, 5, 1};
        // int[] nextG = new int[arr.length];
        // nextGreater(arr, nextG);
        // for (int i = 0; i < nextG.length; i++) {
        //     System.out.print(nextG[i] + " ");
        // }
        
        // 4::
        // int[] stocks = {100, 80, 60, 70, 60, 85, 100};
        // int[] span = new int[stocks.length];
        // stockSpan(stocks, span);
        // for (int i = 0; i < span.length; i++) {
        //     System.out.print(span[i] + " ");
        // }
        
        // 3::
        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // reverseStack(s);
        // while(!s.isEmpty()) {
        //     System.out.println(s.pop());
        // }

        // 2::
        // String str = "jncw";
        // System.out.println(reverseString(str));
        // 1::
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // pushAtBottom(s, 4);
        // while(!s.isEmpty()) {
        //     System.out.println(s.pop());
        // }
    }
}
