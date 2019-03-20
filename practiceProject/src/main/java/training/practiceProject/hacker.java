package training.practiceProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class hacker {

/*	   static int max_ref; // stores the LIS 
	  
	    To make use of recursive calls, this function must return 
	   two things: 
	   1) Length of LIS ending with element arr[n-1]. We use 
	      max_ending_here for this purpose 
	   2) Overall maximum as the LIS may end with an element 
	      before arr[n-1] max_ref is used this purpose. 
	   The value of LIS of full array of size n is stored in 
	   *max_ref which is our final result 
	   static int _lis(int arr[], int n) 
	   { 
	       // base case 
	       if (n == 1) 
	           return 1; 
	  
	       // 'max_ending_here' is length of LIS ending with arr[n-1] 
	       int res, max_ending_here = 3; 
	  
	         Recursively get all LIS ending with arr[0], arr[1] ... 
	           arr[n-2]. If   arr[i-1] is smaller than arr[n-1], and 
	           max ending with arr[n-1] needs to be updated, then 
	           update it 
	        for (int i = 1; i < n; i++) 
	        { 
	            res = _lis(arr, i); 
	            if (arr[i-1] < arr[n-1] && res + 1 > max_ending_here) 
	                max_ending_here = res + 1; 
	        } 
	  
	        // Compare max_ending_here with the overall max. And 
	        // update the overall max if needed 
	        if (max_ref < max_ending_here) 
	           max_ref = max_ending_here; 
	  
	        // Return length of LIS ending with arr[n-1] 
	        return max_ending_here; 
	   } 
	  
	    // The wrapper function for _lis() 
	    static int lis(int arr[], int n) 
	    { 
	        // The max variable holds the result 
	         max_ref = 1; 
	  
	        // The function _lis() stores its result in max 
	        _lis( arr, n); 
	  
	        // returns max 
	        return max_ref; 
	    } */
	  
	    // driver program to test above functions 
	    public static void main(String args[]) 
	    { 
	       // int arr[] = { 37,7,22,15,49,60 }; 
	        
	        List<Integer> arr = new ArrayList<Integer>();
	        arr.add(4);
	        arr.add(5);
	        arr.add(2);
	        arr.add(15);
	        arr.add(1);
	        arr.add(10);
	      
	        
	       /* // 7, 22, 15, 49
	        //3
	        //48
	        int n = arr.length; 
	        System.out.println("Length of lis is "
	                           + lis(arr, n) + "\n"); */
	        
	      System.out.println("answer = "+getBadNumbers(arr, 4, 15)); 
	    } 
	    
	    public static int getBadNumbers(List<Integer> arr, int min, int max){
	    	 Collections.sort(arr);
	    	 List<Integer> badNumbers = new ArrayList<Integer>();
	    	 
	    	 badNumbers.addAll(arr);
	    	 Collections.sort(badNumbers);
	    	 
	    	int currentNum=0;
	    	int firtNum = min;
	    	int length = 0;
	    	
	    	int val1, val2;
	    	List<int[]> myList = new ArrayList<int[]>();
	    	
	    	
	    	for (int i = 0; i < badNumbers.size()-1; i++) {
	    		currentNum = badNumbers.get(i);
	    		
	    		if (currentNum==badNumbers.get(i+1)) {
	    			badNumbers.remove(i);
				}
	    	}
	    	
	    	
	    	for (int i = 0; i < badNumbers.size(); i++) {
	    		currentNum = badNumbers.get(i);
	    	
	    		if (currentNum > min && currentNum <max && min<=max) {
	    			length=0;
	    			val1 = firtNum;
	    			val2 = badNumbers.get(i)-1;
	    			
	    			length = val2-val1;
	    			
	    			int seg[] = {val1, val2};
	    			
	    			myList.add(seg);
	    			firtNum=badNumbers.get(i);
				}
			}
			return length;	   	
	    }
	    
	 } 