package com.project.Methods;

import java.util.Comparator;

public class frequencyComparitorinHeaderTable  implements Comparator<UPtree_table>{

	 public frequencyComparitorinHeaderTable() {
	    }

	   

		@Override
		public int compare(UPtree_table o1, UPtree_table o2) {
			// TODO Auto-generated method stub
			
			 if(o1.count>o2.count){
		            return 1;
		        }
		        else if(o1.count < o2.count)
		            return -1;
		        else
		            return 0;
			
		}
	
}
