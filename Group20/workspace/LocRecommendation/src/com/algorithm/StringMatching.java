package com.algorithm;

public class StringMatching {
	
	public String remove(String text){
		String[] stopWrds={ "raigad", "pune", "mumbai", "delhi", "nashik", "chandigarh", "jaipur", "bengaluru","shimla","agra","gwalior","hyderabad","vidisha"};
		String ss=null;
		String[] tokens = text.split("\\P{Alpha}+");
		if(text!=null&&text!="")
		{
			for(int i=0;i<stopWrds.length;i++){
				for(int j=0;j<tokens.length;j++) {
				if(tokens[j].equalsIgnoreCase(stopWrds[i])){
					ss=stopWrds[i];
				}
			}
		}
		}
		
		return ss;
	}
	
}
