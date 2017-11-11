package etc;/* A Java program to evaluate a given expression where tokens are separated
   by space.
   Test Cases:
     "10 + 2 * 6"            ---> 22
     "100 * 2 + 12"          ---> 212
     "100 * ( 2 + 12 )"      ---> 1400
     "100 * ( 2 + 12 ) / 14" ---> 100    
*/
import java.util.Stack;
 
public class EvaluateString
{
    public static int evaluate(String expression)
    {
        char[] tokens = expression.toCharArray();
 
         // Stack for numbers: 'values'
        Stack<Integer> values = new Stack<Integer>();
 
        // Stack for Operators: 'ops'
        Stack<Character> ops = new Stack<Character>();
 
        for (int i = 0; i < tokens.length; i++)
        {
             // Current token is a whitespace, skip it
            if (tokens[i] == ' ')
                continue;
 
            // Current token is a number, push it to stack for numbers
            if (tokens[i] >= '0' && tokens[i] <= '9')
            {
                StringBuffer sbuf = new StringBuffer();
                // There may be more than one digits in number
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                i--;
                values.push(Integer.parseInt(sbuf.toString()));
            }
 
            // Current token is an opening brace, push it to 'ops'
            else if (tokens[i] == '(')
                ops.push(tokens[i]);
 
            // Closing brace encountered, solve entire brace
            else if (tokens[i] == ')')
            {
                while (ops.peek() != '(')
                  values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }
 
            // Current token is an operator.
            else if (tokens[i] == '+' || tokens[i] == '-' ||
                     tokens[i] == '*' || tokens[i] == '/')
            {
                // While top of 'ops' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                  values.push(applyOp(ops.pop(), values.pop(), values.pop()));
 
                // Push current token to 'ops'.
                ops.push(tokens[i]);
            }

           System.out.println(i+"-> "+tokens[i]+": " +values.toString()+" -> "+ops.toString());

        }
 
        // Entire expression has been parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
 
        // Top of 'values' contains result, return it
        return values.pop();
    }


    // Returns true if 'op2' has higher or same precedence as 'op1',

    // otherwise returns false.
    public static boolean hasPrecedence(char op1, char op2)
    {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }
    // A utility method to apply an operator 'op' on operands 'a'

    // and 'b'. Return the result.
    public static int applyOp(char op, int b, int a)
    {
        switch (op)
        {
        case '+':
            return a + b;
        case '-':
            return a - b;
        case '*':
            return a * b;
        case '/':
            if (b == 0)
                throw new
                UnsupportedOperationException("Cannot divide by zero");
            return a / b;
        }
        return 0;
    }
    // Driver method to test above methods

    public static void main(String[] args)
    {
//        System.out.println(etc.EvaluateString.evaluate("10 + 2 * 6"));
//        System.out.println(etc.EvaluateString.evaluate("100 * 2 + 12"));
//        System.out.println(etc.EvaluateString.evaluate("100 * ( 2 + 12 )"));
//        System.out.println(etc.EvaluateString.evaluate("100 * ( 2 + 12 ) / 14"));
        System.out.println(EvaluateString.evaluate("19 + 12 / 4 - ((4 - 7) * 3 / 1) "));
        System.out.println(EvaluateString.evaluate("1 + (2 - 3) * 4 + 5 - 6 * 8 - (18 * 12 * 13) - (11 / (5 + 2 + 4)) "));
        System.out.println(EvaluateString.evaluate("((2 + 4) / 3 - 2 + 1) "));
//        String[] ar = "19 + 12 / 4 - ((4 - 7) * 3 / 1)".split("(?=[\\+\\-\\*\\/\\(\\)])|((?<=[\\+\\-\\*\\/\\(\\)]))");
    }
    public static int evaluate1(String expression)
    {
        String[] tokens = expression.split("(?=[\\+\\-\\*\\/\\(\\)])|((?<=[\\+\\-\\*\\/\\(\\)]))");
                // Stack for numbers: 'values'
        Stack<Integer> values = new Stack<Integer>();

        // Stack for Operators: 'ops'
        Stack<Character> ops = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++)
        {
            // Current token is a whitespace, skip it
            String token = tokens[i].trim();

            if (token.isEmpty())
                continue;

            // Current token is a number, push it to stack for numbers
            int num = -1;
            try {
                num = Integer.parseInt(token);
            } catch (NumberFormatException e) {
                num = -1;
            }

            if (num != -1) { // number
                values.push(num);
            }
            // Current token is an opening brace, push it to 'ops'
            else if (token.equals("("))
                ops.push(token.charAt(0));

                // Closing brace encountered, solve entire brace
            else if (token.equals(")")) {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }

            // Current token is an operator.
            else if (token.equals("+") || token.equals("-") ||
                    token.equals("*") || token.equals("/")) {
                // While top of 'ops' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!ops.empty() && hasPrecedence(token.charAt(0), ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                // Push current token to 'ops'.
                ops.push(token.charAt(0));
            }

            System.out.println(i+"-> "+ token +": " +values.toString()+" -> "+ops.toString());

        }

        // Entire expression has been parsed at this point, apply remaining
        // ops to remaining values
        while (!ops.empty())
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));

        // Top of 'values' contains result, return it
        return values.pop();
    }
}