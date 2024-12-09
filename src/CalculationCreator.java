public class CalculationCreator {

    private int num1;
    private int num2;

    public int createCalculation() {
        int operationInt = (int) (Math.random() * 4) + 1;
        String operationSymbol = determineOperationSymbol(operationInt);
        int correctAnswer = calculateAnswer(operationSymbol);
        System.out.print(num1 + " " + operationSymbol + " " + num2 + " = ");
        return correctAnswer;
    }

    private static String determineOperationSymbol(int operationInt) {
        String operationString = "";
        switch (operationInt) {
            case 1:
                operationString = "+";
                break;
            case 2:
                operationString = "-";
                break;
            case 3:
                operationString = "*";
                break;
            case 4:
                operationString = "/";
                break;
            default:
                break;
        }
        return operationString;
    }

    private int calculateAnswer(String operationSymbol) {
        int correctAnswer = 0;
        switch (operationSymbol) {
            case "+":
                num1 = (int) (Math.random() * 10) + 1;
                num2 = (int) (Math.random() * 10) + 1;
                correctAnswer = num1 + num2;
                break;
            case "-":
                num1 = (int) (Math.random() * 10) + 1;
                num2 = (int) (Math.random() * 10) + 1;

                // Make sure the result is positive
                if (num1 < num2) {
                    int temp = num1;
                    num1 = num2;
                    num2 = temp;
                }
                correctAnswer = num1 - num2;
                break;
            case "*":
                num1 = (int) (Math.random() * 10) + 1;
                num2 = (int) (Math.random() * 10) + 1;
                correctAnswer = num1 * num2;
                break;
            case "/":
                num1 = (int) (Math.random() * 10) + 1;
                num2 = (int) (Math.random() * 10) + 1;

                // Make sure the division is exact
                num1 = num1 * num2;
                correctAnswer = num1 / num2;
            default:
                break;
        }
        return correctAnswer;
    }
}
