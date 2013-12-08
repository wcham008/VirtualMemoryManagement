package VirtualMemoryManagement;

import java.util.ArrayList;
import java.util.Arrays;

public class Optimal extends Algorithm{
	
	public Optimal(int page_size, int num_frames, String algorithm){
		this.page_size = page_size;
		this.pages = new int [num_frames];
		this.page_counts = new int [num_frames];
		this.algorithm = algorithm;
		this.num_of_frames = num_frames;
	}
	
	public void lookupPage(ArrayList <String> address_list){
		for(String address : address_list){
		
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
			
			//If not look for possible empty spot
			if (position == -1){
				for(int i = 0; i < this.pages.length; i++){
					if(this.pages[i] == 0){
						this.pages[i] = pn;
					}
				}
			}
			//If empty frame was found loop through the array list to find the upcoming positions
			//of pages already in frames.
			else
			{
				int [] temp = new int [this.num_of_frames];
				for(int i = 0; i < this.num_of_frames; i++){
					temp[i] = address_list.indexOf(this.pages[i]);
				}
				int [] temp2 = temp;
				Arrays.sort(temp2);
				int pos = MyUtils.isElementInArray(temp2[0], this.pages);
				System.out.println(pos);
				
				this.pages[pos] = pn;
			
			}
		}
	}
}
