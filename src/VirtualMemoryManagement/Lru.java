package VirtualMemoryManagement;

import java.util.Arrays;

public class Lru extends Algorithm{
	
	public Lru(int page_size, int num_frames, String algorithm){
		this.page_size = page_size;
		this.pages = new int [num_frames];
		this.page_counts = new int [num_frames];
		this.algorithm = algorithm;
		this.num_of_frames = num_frames;
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
		
		//If not update the counter of all existing pages in frames
		//while you are doing this look for a possible empty slot.
		int empty_slot = -1;
		if (position == -1){
			for(int i = 0; i < this.pages.length; i++){
				if(this.pages[i] != 0){
					this.page_counts[i]++;
				}
				else{
					empty_slot = i;
				}
			}
		}
		
		//If empty frame was found put page there.
		if(empty_slot != -1)
		{
			this.pages[empty_slot] = pn;
			this.page_counts[empty_slot] = 0;
		}
		else
		{
			//if not boot the least recently used
			this.num_of_page_faults++;
			int lru_value;
			int temp[] = this.page_counts;
			Arrays.sort(temp);
			lru_value = temp[this.num_of_frames - 1];
			
			for(int i = 0; i < this.pages.length; i++){
				if(this.page_counts[i] == lru_value){
					this.pages[i] = pn;
				    this.page_counts[i] = 0;
				}
			}
		}	
	}
}
