package VirtualMemoryManagement;

import java.util.ArrayList;

public class Algorithm {
	protected int num_of_page_faults = 0;
	protected int num_of_addresses = 0;
	protected int page_size;
	protected int [] pages;
	protected int [] page_counts;
	protected String algorithm;
	protected int num_of_frames;
	protected ArrayList<Integer> unique_pages = new ArrayList<Integer>();
	
	public String getStats(Algorithm algorithm){
		Stats stats = new Stats(this.page_size, algorithm.getNumOfPages(), this.algorithm, this.num_of_page_faults, algorithm.getNumOfLookups());
		return stats.render();
	}
	
	public int getNumOfLookups(){
		return this.num_of_addresses;
	}
	
	public int getNumOfPages(){
		return unique_pages.size();
	}
}
