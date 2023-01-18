package assignment;

import java.util.List;
import java.util.Vector;

public class ThreadDemo {
	List<Dataclass> list = new Vector<>();

	{
		for (int i = 0; i < 20; i++) {
			Dataclass d = new Dataclass();
			d.setAge(i + 10);
			d.setCity("city");
			d.setName("name");
			list.add(d);
		}
	}

	public void runthreads() {
		UpdateThread thread1= new UpdateThread(list, 0);
        UpdateThread thread2 =new UpdateThread(list, list.size()-1);
                
        thread1.start();
        thread2.start();
//create 2 Thread Objects, Thread1 updates the Vector from start index and thread 2 updates the //Vector from end index. Threads just change the city to Uppercase in Dataclass.
}
}
