package com.project.Methods;

import java.util.Vector;

public class UPtree_table {

	 public UPtree_table(String item) {
	        this.item = item;
	        next = null;
	        children = new Vector<UPtree_table>();
	        root = false;
	    }

	    boolean root;
	    String item;
	    Vector<UPtree_table> children;
	    UPtree_table parent;
	    UPtree_table next;
	    int count;

	    boolean isRoot(){
	        return root;
	    }

	
}
