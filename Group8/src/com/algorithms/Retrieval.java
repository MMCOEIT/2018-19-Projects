package com.algorithms;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.algorithms.SiftDescriptor;
import com.controller.ImageSearchController;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Retrieval
{
	
	public static double[][] allFeatures=new double[3996][66];
	public static double[][] distances = new double[3996][2];
	
	public static void retrieve(String fileName)
	{
		System.out.println(fileName);
		
		double[] featureVector=FeatureExtraction.extractSingleImage(fileName);
		
		SiftDescriptor sift = new SiftDescriptor(16, 2);

		System.out.println("Neighbourhood");
		sift.printMatrix(sift.neighbourhood);

		System.out.println("VarianceImage");
		double dis;
				
		for (int i=0;i<3995;i++)
		{
			distances[i][0]=-1;
			distances[i][1]=100;
		}
		
		int k;
		double D;
		
		for (int i=0;i<3995;i++)
		{
			k=0;
			D=euclideanDistance(featureVector, allFeatures[i]);
			
		    while (distances[k][1]<D){
		        k=k+1;        
		    }
		    for (int n=3995;n>=k+1;n--){
		        distances[n][0]=distances[n-1][0];
		        distances[n][1]=distances[n-1][1];
		    }
		    distances[k][0]=i;
		    distances[k][1]=D;
		}
		
	}
	
	public static double euclideanDistance(double[] a, double[] b){
		double S=0;
		for (int i=0;i<18;i++){
			S+= Math.pow(a[i]-b[i],2);
		}
		for (int i=18;i<66;i++){
			S+= 10*Math.pow(a[i]-b[i],2);
		}
		return S;
		
	}
	
	public static void process(String filename)
	{
	      try
	      {
	    	
	    	  FileInputStream fstream = new FileInputStream("C://Users//Onkar//Desktop//workspace//MixedGenerative//WebContent//feature//Feature File.txt");
	    	  DataInputStream in = new DataInputStream(fstream);
	    	  BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    	  String strLine;
	    	  Scanner scan;
	    	  int imgInd=0;
	    	  while ((strLine = br.readLine()) != null)
	    	  {
	    		  //System.out.println(imgInd);
	    		  scan=new Scanner(strLine);
	    		  int ftrInd=0;
	    		  while(scan.hasNext())
	    		  {
	    			  allFeatures[imgInd][ftrInd]=scan.nextDouble();
	    			  ftrInd++;
	    		  }
	    		  imgInd++;	    		  	
	    	  }
	    	  in.close();
	      }catch (Exception e){
	    	  System.err.println("Error: " + e.getMessage());
	      }
	        
	     retrieve("C://Users//Onkar//Desktop//workspace//MixedGenerative//WebContent//blocks_image_orig//"+filename);
	      
	      String path;
	      Retrieval test;
	      

	      for (int i=0;i<15;i++)
	      {
	    	  System.out.println(Math.round(distances[i][0]/4));		      
	          ImageSearchController.imglist.add(Math.round(distances[i][0]/4)+"");  	  
	      }
	}
	
	BufferedImage image;
    Dimension size = new Dimension();

    public Retrieval(BufferedImage image) {
        this.image = image;
        size.setSize(image.getWidth(), image.getHeight());
    }
}
