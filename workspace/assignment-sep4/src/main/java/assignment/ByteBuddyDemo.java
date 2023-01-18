package assignment;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;

public class ByteBuddyDemo {



   public String createDynamicMethod() throws InstantiationException, IllegalAccessException {
         



          Class<?> dynamicType = new ByteBuddy()
                    .subclass(Object.class)//complete
                    .method(ElementMatchers.nameContains("toString")) //complete
                    .intercept(FixedValue.value("\"Hi There\""))// complete
                    .make()
                    .load(getClass().getClassLoader())
                    .getLoaded();
          return dynamicType.newInstance().toString();
        }
    
    public static void main(String[] args) throws Exception
    {
        ByteBuddyDemo b1= new ByteBuddyDemo();
        System.out.println(b1.createDynamicMethod());
    }
    }