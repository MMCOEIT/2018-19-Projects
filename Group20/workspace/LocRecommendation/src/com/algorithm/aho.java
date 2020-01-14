package com.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.restfb.types.Place;



public class aho {
	 static final int ALPHABET_SIZE = 26;

	  Node[] nodes;
	  int nodeCount;

	  public static class Node {
	    int parent;
	    char charFromParent;
	    int suffLink = -1;
	    int[] children = new int[ALPHABET_SIZE];
	    int[] transitions = new int[ALPHABET_SIZE];
	    boolean leaf;

	    {
	      Arrays.fill(children, -1);
	      Arrays.fill(transitions, -1);
	    }
	  }

	  public void AhoCorasick(int maxNodes) {
	    nodes = new Node[maxNodes];
	    // create root
	    nodes[0] = new Node();
	    nodes[0].suffLink = 0;
	    nodes[0].parent = -1;
	    nodeCount = 1;
	  }

	  public void addString(String s) {
	    int cur = 0;
	    for (char ch : s.toCharArray()) {
	      int c = ch - 'a';
	      if (nodes[cur].children[c] == -1) {
	        nodes[nodeCount] = new Node();
	        nodes[nodeCount].parent = cur;
	        nodes[nodeCount].charFromParent = ch;
	        nodes[cur].children[c] = nodeCount++;
	      }
	      cur = nodes[cur].children[c];
	    }
	    nodes[cur].leaf = true;
	  }

	  public int suffLink(int nodeIndex) {
	    Node node = nodes[nodeIndex];
	    if (node.suffLink == -1)
	      node.suffLink = node.parent == 0 ? 0 : transition(suffLink(node.parent), node.charFromParent);
	    return node.suffLink;
	  }

	  public int transition(int nodeIndex, char ch) {
	    int c = ch - 'a';
	    Node node = nodes[nodeIndex];
	    if (node.transitions[c] == -1)
	      node.transitions[c] = node.children[c] != -1 ? node.children[c] : (nodeIndex == 0 ? 0 : transition(suffLink(nodeIndex), ch));
	    return node.transitions[c];
	  }

	  
	  public List<Integer> count(String sen,String query) {
		  List<Integer> positions = new ArrayList<Integer>();
		  try{
			 
		  AhoCorasick ahoCorasick = new AhoCorasick(1000);
		
		   String word=query;
		    ahoCorasick.addString(word);

		    
		    
		    sen=sen.toLowerCase();
		    sen=sen.replace(".","");
		    sen=sen.replace(",","");
		    sen=sen.replace("!","");
			//words=words.replace(":d","");
		    sen=sen.replace(":)","");
		    sen=sen.replace(":","");
		    sen=sen.replace(";","");
		    sen=sen.replace("?","");
			//words=words.replace("'","");
		    sen=sen.replace("*","");
		    sen=sen.replace("^","");
		    sen=sen.replace("<3","");
		    sen = sen.replaceAll("\\s", ""); 
		   // System.out.println(sen);
		    int node = 0;
		  
		    for (int i = 0; i < sen.length(); i++) {
		      node = ahoCorasick.transition(node, sen.charAt(i));
		      if (ahoCorasick.nodes[node].leaf)
		      
		 
		    	  positions.add(i);
		    }
		  
		  
		
		  }
		  catch(Exception e)
		  {
			
		  }
		
		return positions;
	}
	  // Usage example
	  public int count1(String sen,String query) {
	    AhoCorasick ahoCorasick = new AhoCorasick(1000);
	  
	    ahoCorasick.addString(query);
	  

	 
	    
	    
	   // String sen="facebook186mlikesthefacebookpagecelebrateshowourfriendsinspireussupportusandhelpusdiscovertheworldwhenweconnect";
	    
	    sen=sen.toLowerCase();
	    sen=sen.replace(".","");
	    sen=sen.replace(",","");
	    sen=sen.replace("!","");
		//words=words.replace(":d","");
	    sen=sen.replace(":)","");
	    sen=sen.replace(":","");
	    sen=sen.replace(";","");
	    sen=sen.replace("?","");
		//words=words.replace("'","");
	    sen=sen.replace("*","");
	    sen=sen.replace("^","");
	    sen=sen.replace("<3","");
	    sen = sen.replaceAll("\\s", "");
	    System.out.println(sen);
	    int node = 0;
	    List<Integer> positions = new ArrayList<Integer>();
	    for (int i = 0; i < sen.length(); i++) {
	      node = ahoCorasick.transition(node, sen.charAt(i));
	      if (ahoCorasick.nodes[node].leaf)
	        positions.add(i);
	    }
	  //  System.out.println(positions);
	    //System.out.println(node);
		return node;
	  }

	/*public List<Integer> count(ArrayList<Place> places) {
		  List<Integer> positions = new ArrayList<Integer>();
		  try{
		  AhoCorasick ahoCorasick = new AhoCorasick(1000);
		
		   String word=query;
		    ahoCorasick.addString(word);

		    
		    
		    sen=sen.toLowerCase();
		    sen=sen.replace(".","");
		    sen=sen.replace(",","");
		    sen=sen.replace("!","");
			//words=words.replace(":d","");
		    sen=sen.replace(":)","");
		    sen=sen.replace(":","");
		    sen=sen.replace(";","");
		    sen=sen.replace("?","");
			//words=words.replace("'","");
		    sen=sen.replace("*","");
		    sen=sen.replace("^","");
		    sen=sen.replace("<3","");
		    sen = sen.replaceAll("\\s", ""); 
		   // System.out.println(sen);
		    int node = 0;
		  
		    for (int i = 0; i < sen.length(); i++) {
		      node = ahoCorasick.transition(node, sen.charAt(i));
		      if (ahoCorasick.nodes[node].leaf)
		      
		 
		    	  positions.add(i);
		    }
		  
		  
		
		  }
		  catch(Exception e)
		  {
			
		  }
		return positions;
	}*/	
}
