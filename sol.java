package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class main_misc {
	
	
	public static final int MAX = 1_000_000;
	
	
	
	public static void main(String[] args) {
		

		
	List<Integer> arr1 = new ArrayList<>(Arrays.asList(30,15,15,100,15,45));
		
	System.out.println(best_sum(arr1));
	
	List<Integer> arr2 = new ArrayList<>(Arrays.asList(30,15,60,75,45,15,15,45));
	
	System.out.println(best_sum(arr2));
		
	}
	
	private static int best_sum(List<Integer> arr,int strt,int end,int last_idx){
		
		if(strt == end){
			if(last_idx == -1){
				return arr.get(end);
			}
			if(last_idx + 1 != end){
				return arr.get(end);
			}
			//nothing will be summed because its adjacent last_idx + 1 == end
			return 0;
		}
		
		int max_sum = 0;
		
		//I can choose between strt and strt+1
		
		for(int i = strt;i <= strt+1;i++){
			
			int sum = 0;
			
			if(i <= end){
				sum += arr.get(i);
				sum += best_sum(arr,i+2,end,i);
			}
			
			if(sum > max_sum) {
				max_sum = sum;
			}
			
		}
		return max_sum;
		
	}
	
	//overload
	
	private static int best_sum(List<Integer> arr){
		
		return best_sum(arr,0,arr.size()-1,-1);
		
	}

}
