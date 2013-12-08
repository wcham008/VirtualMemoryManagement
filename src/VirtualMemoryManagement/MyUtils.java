package VirtualMemoryManagement;

public class MyUtils {
	public static int isElementInArray(int element, int target[]){
		int position = -1;
		for(int i = 0; i < target.length; i++){
			if(target[i] == element){
				position = i;
			}
		}
		return position;
	}
}
