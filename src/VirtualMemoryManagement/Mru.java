package VirtualMemoryManagement;

import java.util.ArrayList;

public class Mru extends Algorithm{
	
	public Mru(int page_size, int num_frames, String algorithm){
		this.page_size = page_size;
		this.pages = new int [num_frames];
		this.page_counts = new int [num_frames];
		this.algorithm = algorithm;
	}
	
	public void lookupPage(String address){
		//calculate page_number
		int page_number = Integer.parseInt(address, 10) / page_size;
	}
}
