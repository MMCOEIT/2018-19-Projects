package com.controller;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DataAccessLayer;
import com.model.AllAnswerData;
import com.model.answernounmodel;
import com.model.expert;

import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

/**
 * Servlet implementation class qestionanswer
 */
@WebServlet("/qestionanswer")
public class qestionanswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public qestionanswer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		int valuecount=0;
		
		  String val = null;
		  int value = 0;
		  
		  
		 String expertname = request.getParameter("expertname"); 
		  
		int aid = Integer.parseInt(request.getParameter("id"));
	    String qestion =request.getParameter("qestion");
		
		String answer = request.getParameter("answer");
		
		///////////////////////check expert valid or not code  //////////////
		
		int cid = Integer.parseInt(request.getParameter("cid"));
		
		System.out.println("coomunitycid----->"+cid);
		
		
       HttpSession ses = request.getSession();
       
      String expertusername = (String)ses.getAttribute("expertusername");
	  String expertpassword = (String)ses.getAttribute("expertpassword");
		
	  
	  if(expertusername==null && expertpassword==null)
	  {
		  
		response.sendRedirect("indexexpert.jsp?msginfo=You Are Not Login As Expert....  ");
  
	  }
	  
	  
	  
	  expert expert = new expert();
	  
	  expert.setUsername(expertusername);
	  expert.setPassword(expertpassword);
	  expert.setCid(cid);
	  
	   int communityspecificid =  DataAccessLayer.authenticateexpert(expert);
	  
	  System.out.println("communityspecificid---->"+communityspecificid);
	  
	  
	  if(communityspecificid!=0)
	  {
		
		  if(communityspecificid==cid)
		  {
			  
			  
			  
				
				System.out.println(answer);
				System.out.println(qestion);
				///////////////////////////////////nlp algorithm working////////////////
				
				
				// creates a StanfordCoreNLP object, with POS tagging, lemmatization, NER, parsing, and coreference resolution
		        Properties props = new Properties();
		        props.setProperty("ner.useSUTime", "false");
		        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
		        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
		        
		       
		       // String text = "I lost my mobile and i am feeling very sad";

		        // create an empty Annotation just with the given text
		        Annotation document = new Annotation(answer);

		        // run all Annotators on this text
		        pipeline.annotate(document);
		        List<CoreMap> sentences = document.get(SentencesAnnotation.class);

		        for(CoreMap sentence: sentences) {
		          // traversing the words in the current sentence
		          // a CoreLabel is a CoreMap with additional token-specific methods
		          for (CoreLabel token: sentence.get(TokensAnnotation.class)) {
		            // this is the text of the token
		        	  String   word = token.get(TextAnnotation.class);
		            // this is the POS tag of the token
		        	  String  pos = token.get(PartOfSpeechAnnotation.class);
		            // this is the NER label of the token
		            String ne = token.get(NamedEntityTagAnnotation.class);
		            
		            System.out.println(String.format("Print: Word : [%s] Pos: [%s] ne: [%s]",word,pos,ne));
		         
		                 DataAccessLayer.answernoun(word,pos);
		          
		          }
		          
		        }

		      List<answernounmodel> data = DataAccessLayer.answernoundata();
		        
		         for(answernounmodel d : data){
		        	 
		        	 System.out.println("Word Noun-->"+d.getWord());
		        	 
		        	  val = d.getWord();
		        	 
		        	  value = DataAccessLayer.checkexpertvalidanswer(val);
		        	  
		        	  valuecount = valuecount+value;
		        	  
		        	  System.out.println("valuecount--->"+valuecount);
		        	  
		        	  System.out.println("expert value---->"+value);  
		        	 
		         
		         } 
		         
		         
		       if (valuecount!=0)
		       {
		    	   
		    	   
		    	   AllAnswerData ad = new AllAnswerData();
		           
		           ad.setQestion(qestion);
		           ad.setAnswer(answer);
		           ad.setAid(aid);
		           ad.setExpertname(expertname);
		           
		           
		           
		   		DataAccessLayer.AllAnswerdata(ad);
		   		
		   		DataAccessLayer.deleteanswernoun();
		        
			    response.sendRedirect("msg.jsp");
		    	   
		       }
		       else 
		       {
		    	   
		    	  response.sendRedirect("notvalidanswer.jsp");
		    	   
		    	   
		       } 
			  
			  
		  }
		  else
		  {
			  response.sendRedirect("communityspecificexpert.jsp");
		  }
		  
		  
		  
	  }
	  else
	  {
		  
		//response.sendRedirect("indexexpert.jsp?msginfo=You Are Not Login As Expert....  ");
 
	  }
	  
	  
////////////////////////////////////////////end expert valid or not///////////

      	
	}

}

