package VirtualMemoryManagement;

public class Stats {
	private int page_size;
	private int num_of_pages;
	private String algorithm;
	private int num_of_page_faults;
	private int num_of_lookups;
	
	public Stats(int page_size, int num_of_pages, String algorithm, int num_of_page_faults, int num_of_lookups){
		this.page_size = page_size;
		this.num_of_pages = num_of_pages;
		this.algorithm = algorithm;
		this.num_of_page_faults = num_of_page_faults;
		this.num_of_lookups = num_of_lookups;
	}
	
	public String render(){
		double num_of_page_faults = (double)this.num_of_page_faults*100;
		double num_of_lookups = (double)this.num_of_lookups;
		double page_fault_percentage = num_of_page_faults / num_of_lookups;
		
		String stats = "Page Size: " + Integer.toString(this.page_size) +
					   " #of pages: " + Integer.toString(this.num_of_pages) +
					   " Page replacement ALG: " + algorithm +
					   " Page fault percentage: " + Double.toString(page_fault_percentage);
		return stats;
	}
}
