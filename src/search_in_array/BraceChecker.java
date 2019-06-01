package search_in_array;

import java.util.Arrays;
import java.util.Stack;

public class BraceChecker {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(braces(new String[]{"()"})));
    }

    static String[] braces(String[] values) {
        String[] result = new String[values.length];
        for (int i=0;i<values.length;i++) {
            String s = values[i];
            int length = s.length();
            Stack br=new Stack();
            boolean a=true;
            for(int j=0;j<length;j++){
                char c = s.charAt(j);
                if(c=='(' || c=='{' || c=='['){
                    br.push(c);
                }else if( c==')' || c==']' || c=='}'){
                    if(!br.isEmpty()){
                        char pope = (char) br.pop();
                        switch(c)
                        {
                            case ')':
                                if(pope!='('){
                                    a=false;
                                }
                                break;
                            case ']':
                                if(pope!='['){
                                    a=false;
                                }
                                break;
                            case '}':
                                if(pope!='{'){
                                    a=false;
                                }
                        }
                    }else{
                        a=false;
                    }
                }
            }
            result[i] = a && br.isEmpty() ? "YES" : "NO";
        }
        return result;
    }
}
