package ch21pc04;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Stack;
/**
 * 
 * @author frank
 */
public class Ch21pc04 {

    /**
     * The Main Method
     * @param args String[] The command line arguments
     */
    public static void main(String[] args) {
        Stack <Character> st = new Stack<Character>();
        System.out.println("Welcome to the Properly Nested Delimiters program.");
        try {
            FileInputStream fileRead = new FileInputStream("MyFile.txt");
            char ch;
            int j=0;
            while (fileRead.available() > 0) {
                ch = (char) fileRead.read();
                j++;
                switch (ch) {
                    case '{':
                    case '[':
                    case '(':
                        st.push(ch);
                        break;
                    case '}':
                    case ']':
                    case ')':
                        if (!st.isEmpty()) {
                            char chpop = st.pop();
                            if ((ch == '}' && chpop != '{') || (ch == ']' && chpop != '[') || (ch == ')' && chpop != '(')) {
                                System.out.println();
                                System.out.println("-----------------");
                                System.out.println("The file has errors. ");
                                return ;
                            }
                        }
                    default:
                        break;
                }
                System.out.print(ch);
            }
            System.out.println();
            System.out.println("-------the file is properly nested------");
            fileRead.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
