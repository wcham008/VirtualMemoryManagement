package VirtualMemoryManagement;

import java.util.*;
import java.lang.Boolean;

public class Fifo extends Algorithm{

	public Fifo(int page_size, int num_frames, String algorithm){
		this.page_size = page_size;
		this.pages = new int [num_frames];
		this.page_counts = new int [num_frames];
		this.algorithm = algorithm;
		this.num_of_frames  = num_frames;
	}
	
	public void lookupPage(String address){
		this.num_of_addresses++;
		
		//calculate page_number
		Integer page_number = Integer.parseInt(address, 10) / page_size;
		int pn = Integer.parseInt(address, 10) / page_size; // a hack due to time constraints.
		pn = pn + 1;
		
		//If this page number has not been encountered before add it to 
		//the unique page numbers array to be counted later.
		if(this.unique_pages.contains(page_number) == false){
			this.unique_pages.add(page_number);
		}
		
		//Check if the page number is already in a frame
		int position = MyUtils.isElementInArray(pn, this.pages);
		
		//If not try to add it.
		Boolean added = false;
		if(position == -1){
			//if there is an empty frame add it there
			for(int i = 0; i < this.pages.length; i++){
				if(this.pages[i] == 0){
					this.pages[i] = pn;
					this.page_counts[i] = this.num_of_addresses;
					added = true;
				}
			}
			//if not find the first in and replace it
			if(added == false){
				this.num_of_page_faults++;
				int temp [] = this.page_counts;
				Arrays.sort(temp);
				this.pages[MyUtils.isElementInArray(temp[0], this.page_counts)] = pn;
				this.page_counts[MyUtils.isElementInArray(temp[0], this.page_counts)] = this.num_of_addresses;
				added = true;	
			}
		}	
	}
	
	
	
}
