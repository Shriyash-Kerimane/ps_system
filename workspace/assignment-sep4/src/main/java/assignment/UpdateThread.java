package assignment;

import java.util.List;

//Thread class Template is given below. You need to override run() method to write your logic.
public class UpdateThread extends Thread {
    
    public List<Dataclass> obj;
    public int index;

    public UpdateThread (List<Dataclass> obj, int index) {
        this.obj = obj;
        this.index = index;
    }

     // override run method
    // the run method should convert city to upper case based on the given index
    public void run()
    {
        int half = obj.size()/2;
        
        if(index<half)
        {
            for(int i=0;i<half;i++)
            {
                Dataclass d =obj.get(i);
                d.setCity(d.getCity().toUpperCase());
            }
        }
        else {
            for(int i=obj.size()-1;i>half-1;i--)
            {
                Dataclass d = obj.get(i);
                d.setCity(d.getCity().toUpperCase());
            }
        }            
    }
}