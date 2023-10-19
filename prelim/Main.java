import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String expression;
        
        System.out.println("Enter an expression: ");
        expression = scan.nextLine();
        System.out.println(expression + " = " +calculate(expression));

    }

    public static String calculate(String expression){
        Stack<Character> operators = new Stack<Character>();
        Stack<String> operands = new Stack<String>();

        for(int i = 0; i<expression.length(); i++){
            Character c = expression.charAt(i);
            String str = String.valueOf(c);
            if (c == '+' || c == '-' || c == '/' || c == '*'){
                while(!operators.isEmpty() && precedence(operators.peek(), c) ){
                    solve(operands, operators);
                }
                operators.push(c);
  
            }
            else if (c == '('){
                operators.push(c);
            }
            else if (c == ')'){
                while (operators.peek() != '('){
                    solve(operands, operators);
                }
                operators.pop();
            }
            else if (isNumeric(str)){
                String temp = str;
                for (int j = i+1; j < expression.length(); j++){
                    if (Character.isDigit(expression.charAt(j))){
                        temp += expression.charAt(j);
                        i++;
                    }
                    else if(!Character.isDigit(expression.charAt(j))){
                        break;
                    }
                }
                operands.push(temp);
                //System.out.println(operands.peek());
            }


        }
        while (!operators.isEmpty()) {
          solve(operands, operators);
        }
        return operands.peek();
    }

    public static boolean precedence(char operator1, char operator2){
        return (operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-');
    }

    public static void solve(Stack<String> operands, Stack<Character> operator){
        double opnd1 = Double.parseDouble(operands.pop());
        double opnd2 = Double.parseDouble(operands.pop());
        char opr = operator.pop();
        double result =' ';

        switch (opr){
            case '+':
                result = opnd1 + opnd2;
                break;
            case '-':
                result = opnd2 - opnd1;
                break;
            case '*':
                result = opnd1 * opnd2;
                break;
            case '/':
                result = opnd2 / opnd1;
                break;
        }
        String resultString  = Double.toString(result);
        operands.push(resultString);
    }

    public static boolean isNumeric(String strNum) 
    {
        if (strNum == null) 
        {
            return false;
        }
        try 
        {
            double d = Double.parseDouble(strNum);
        } 
            catch (NumberFormatException nfe) 
        {
            return false;
        }
        return true;
    }

}