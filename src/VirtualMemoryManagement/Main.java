package VirtualMemoryManagement;

import java.io.*;
import java.util.ArrayList;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		//INITIALIZE THE ALGORITHM OBJECTS FOR EACH COMBINATION
		//Page size  = 2048, Number of Frames = 4;
		Fifo p512f4fifo = new Fifo(512, 4, "FIFO");
		Lru p512f4lru = new Lru(512, 4, "LRU");
		Mru p512f4mru = new Mru(512, 4, "MRU");
		Optimal p512f4optimal = new Optimal(512, 4, "OPTIMAL");
		
		//Page size  = 512, Number of Frames = 8;
		Fifo p512f8fifo = new Fifo(512, 8, "FIFO");
		Lru p512f8lru = new Lru(512, 8, "LRU");
		Mru p512f8mru = new Mru(512, 8, "MRU");
		Optimal p512f8optimal = new Optimal(512, 8, "OPTIMAL");
		
		//Page size  = 512, Number of Frames = 12;
		Fifo p512f12fifo = new Fifo(512, 12, "FIFO");
		Lru p512f12lru = new Lru(512, 12 , "LRU");
		Mru p512f12mru = new Mru(512, 12, "MRU");
		Optimal p512f12optimal = new Optimal(512, 12, "OPTIMAL");
		
		//Page size  = 1024, Number of Frames = 4;
		Fifo p1024f4fifo = new Fifo(1024, 4, "FIFO");
		Lru p1024f4lru = new Lru(1024, 4, "LRU");
		Mru p1024f4mru = new Mru(1024, 4, "MRU");
		Optimal p1024f4optimal = new Optimal(1024, 4, "OPTIMAL");
		
		//Page size  = 1024, Number of Frames = 8;
		Fifo p1024f8fifo = new Fifo(1024, 8, "FIFO");
		Lru p1024f8lru = new Lru(1024, 8, "LRU");
		Mru p1024f8mru = new Mru(1024, 8, "MRU");
		Optimal p1024f8optimal = new Optimal(1024, 8, "OPTIMAL");
		
		//Page size  = 1024, Number of Frames = 12;
		Fifo p1024f12fifo = new Fifo(1024, 12, "FIFO");
		Lru p1024f12lru = new Lru(1024, 12, "LRU");
		Mru p1024f12mru = new Mru(1024, 12, "MRU");
		Optimal p1024f12optimal = new Optimal(1024, 12, "OPTIMAL");
		
		//Page size  = 2048, Number of Frames = 4;
		Fifo p2048f4fifo = new Fifo(2048, 4, "FIFO");
		Lru p2048f4lru = new Lru(2048, 4, "LRU");
		Mru p2048f4mru = new Mru(2048, 4, "MRU");
		Optimal p2048f4optimal = new Optimal(2048, 4, "OPTIMAL");
		
		//Page size  = 2048, Number of Frames = 8;
		Fifo p2048f8fifo = new Fifo(2048, 8, "FIFO");
		Lru p2048f8lru = new Lru(2048, 8, "LRU");
		Mru p2048f8mru = new Mru(2048, 8, "MRU");
		Optimal p2048f8optimal = new Optimal(2048, 8, "OPTIMAL");
		
		//Page size  = 2048, Number of Frames = 12;
		Fifo p2048f12fifo = new Fifo(2048, 12, "FIFO");
		Lru p2048f12lru = new Lru(2048, 12, "LRU");
		Mru p2048f12mru = new Mru(2048, 12, "MRU");
		Optimal p2048f12optimal = new Optimal(2048, 12, "OPTIMAL");
		
		//INITIALIZE THE READER AND READ IN THE FILE
		FileReader file = new FileReader("/home/dean/workspace/VirtualMemoryManagement/testfile.dat");
		BufferedReader reader = new BufferedReader(file);
		String address = reader.readLine();
		ArrayList<String> address_list = new ArrayList<String>();
		
		//RUN EACH ALGORITHM WITH EACH ADDRESS
		while (address != null)
		{
			if(address != null){
				address = address.toString();
				
				//Run the algorithms with the address
				p512f4fifo.lookupPage(address);
				p512f4lru.lookupPage(address);
				p512f4mru.lookupPage(address);
				
				p512f8fifo.lookupPage(address);
				p512f8lru.lookupPage(address);
				p512f8mru.lookupPage(address);
				
				p512f12fifo.lookupPage(address);
				p512f12lru.lookupPage(address);
				p512f12mru.lookupPage(address);
				
				p1024f4fifo.lookupPage(address);
				p1024f4lru.lookupPage(address);
				p1024f4mru.lookupPage(address);
				
				p1024f8fifo.lookupPage(address);
				p1024f8lru.lookupPage(address);
				p1024f8mru.lookupPage(address);
				
				p1024f12fifo.lookupPage(address);
				p1024f12lru.lookupPage(address);
				p1024f12mru.lookupPage(address);
				
				p2048f4fifo.lookupPage(address);
				p2048f4lru.lookupPage(address);
				p2048f4mru.lookupPage(address);
				
				p2048f8fifo.lookupPage(address);
				p2048f8lru.lookupPage(address);
				p2048f8mru.lookupPage(address);
				
				p2048f12fifo.lookupPage(address);
				p2048f12lru.lookupPage(address);
				p2048f12mru.lookupPage(address);
				
			}
			address_list.add(address);
			address = reader.readLine();
		}
		
		/*p512f4optimal.lookupPage(address_list);
		p512f8optimal.lookupPage(address_list);
		p512f12optimal.lookupPage(address_list);
		p1024f4optimal.lookupPage(address_list);
		p1024f8optimal.lookupPage(address_list);
		p1024f12optimal.lookupPage(address_list);
		p2048f4optimal.lookupPage(address_list);
		p2048f8optimal.lookupPage(address_list);
		p2048f12optimal.lookupPage(address_list);*/
		
		//PRINT OUT THE STATS FOR EACH RUN
		System.out.println(p512f4fifo.getStats(p512f4fifo));
		System.out.println(p512f4lru.getStats(p512f4lru));
		System.out.println(p512f4mru.getStats(p512f4mru));
		//System.out.println(p512f4optimal.getStats(p512f4optimal));
		
		System.out.println(p512f8fifo.getStats(p512f8fifo));
		System.out.println(p512f8lru.getStats(p512f8lru));
		System.out.println(p512f8mru.getStats(p512f8mru));
		//System.out.println(p512f8optimal.getStats(p512f8optimal));
		
		System.out.println(p512f12fifo.getStats(p512f12fifo));
		System.out.println(p512f12lru.getStats(p512f12lru));
		System.out.println(p512f12mru.getStats(p512f12mru));
		//System.out.println(p512f12optimal.getStats(p512f12optimal));
		
		System.out.println(p1024f4fifo.getStats(p1024f4fifo));
		System.out.println(p1024f4lru.getStats(p1024f4lru));
		System.out.println(p1024f4mru.getStats(p1024f4mru));
		//System.out.println(p1024f4optimal.getStats(p1024f4optimal));
		
		System.out.println(p1024f8fifo.getStats(p1024f8fifo));
		System.out.println(p1024f8lru.getStats(p1024f8lru));
		System.out.println(p1024f8mru.getStats(p1024f8mru));
		//System.out.println(p1024f8optimal.getStats(p1024f8optimal));
		
		System.out.println(p1024f12fifo.getStats(p1024f12fifo));
		System.out.println(p1024f12lru.getStats(p1024f12lru));
		System.out.println(p1024f12mru.getStats(p1024f12mru));
		//System.out.println(p1024f12optimal.getStats(p1024f12optimal));
		
		System.out.println(p2048f4fifo.getStats(p2048f4fifo));
		System.out.println(p2048f4lru.getStats(p2048f4lru));
		System.out.println(p2048f4mru.getStats(p2048f4mru));
		//System.out.println(p2048f4optimal.getStats(p2048f4optimal));
		
		System.out.println(p2048f8fifo.getStats(p2048f8fifo));
		System.out.println(p2048f8lru.getStats(p2048f8lru));
		System.out.println(p2048f8mru.getStats(p2048f8mru));
		//System.out.println(p2048f8optimal.getStats(p2048f8optimal));
		
		System.out.println(p2048f12fifo.getStats(p2048f12fifo));
		System.out.println(p2048f12lru.getStats(p2048f12lru));
		System.out.println(p2048f12mru.getStats(p2048f12mru));
		//System.out.println(p2048f12optimal.getStats(p2048f12optimal));
	}

}
