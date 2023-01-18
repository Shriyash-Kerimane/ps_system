package assignment;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProcessStream {

   public List<Integer> number;
    public List<Integer> square;
    public List<String> names = Arrays.asList("Sparrow","Cobra","Star","Kite");
    public List<String> result;
    public void process(){
    	
          number = Arrays.asList(3,2,5,6);

         // create a list of integers
          number.stream().map(x->Integer.valueOf(x)).collect(Collectors.toList());
          System.out.println(number);
          
         //write code to convert every number in the list to its square and collect them in a List
         square = number.stream().map(x->x*x).collect(Collectors.toList());      
         System.out.println(square);
          
         // Write code using stream and filter all the names start with "S" and store in arraylist in  result.
         result=names.stream().filter(s->s.charAt(0)=='S').collect(Collectors.toList());     
         System.out.println(result);
    }
}