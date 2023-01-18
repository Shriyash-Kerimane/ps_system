package assignment;
public class ICalculation {

   int number1 = 200, number2 = 2, add = 0, sub = 0, mul = 0, div = 0;

   public void doCalculation() {

        Calculation obj = null;
        // implement obj by adding lambda expression to add number1 and number2
        obj = (number1, number2) -> number1 + number2;
        add = obj.getCal(number1, number2);

       // implement obj by adding lambda expression to subtract number1 and number2
        obj = (number1, number2) -> number1 - number2;
        sub = obj.getCal(number1, number2);

       // implement obj by adding lambda expression to multiply number1 and number2
        obj = (number1, number2) -> number1 * number2;
        mul = obj.getCal(number1, number2);

       // implement obj by adding lambda expression to divide number1 and number2
        obj = (number1, number2) -> number1 / number2;
        div = obj.getCal(number1, number2);
   }
}