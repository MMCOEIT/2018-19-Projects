package com.controller;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Utility.SendMail;
import com.dao.DataAccessLayer;
import com.model.Qestionstoredatabase;
import com.model.RealQestion;
import com.model.checkqestion;
import com.model.checkqestiondata;
import com.model.expert;
import com.model.finalcomunity;
import com.model.findnoun;
import com.model.likewordnoun;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

/**
 * Servlet implementation class AskQestion
 */
@WebServlet("/AskQestion")
public class AskQestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AskQestion() {
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
		
		String val = "";
		DataAccessLayer.deleteinsertcheckqestion();
		RealQestion rq = new RealQestion();
		findnoun find = new findnoun(); 
		finalcomunity fcomunity = new finalcomunity();
		likewordnoun likewordnoun = new likewordnoun();
		String qestion = request.getParameter("askqestion");
		
		
//*************************************************************************************
  int checkqestionid = 0;
  List<checkqestion>checkqes =  DataAccessLayer.checkqestionavailableornot(qestion);

  checkqestiondata cdata = new checkqestiondata();
   for(checkqestion check: checkqes)
   {
	     checkqestionid =  check.getId();
	      
	      cdata.setQestion(check.getQestion());
	      cdata.setAnswer(check.getAnswer());
	      cdata.setExpert(check.getExpertname());
	      
	      DataAccessLayer.allreadyavailableqestion(cdata);
   }
   
	if(checkqestionid!=0)
	{
		
		response.sendRedirect("allredyavilableanswer.jsp");
		
	}
	else
	{
		
		
	        rq.setQestion(qestion);
			System.out.println("qestion----->"+qestion);
			HttpSession session = request.getSession();
			session.setAttribute("qestion", qestion);
			// creates a StanfordCoreNLP object, with POS tagging, lemmatization, NER, parsing, and coreference resolution
	        Properties props = new Properties();
	        props.setProperty("ner.useSUTime", "false");
	        props.setProperty("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
	        StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
	       // Scanner scan = new Scanner(System.in);
	        // read some text in the text variable
	       // System.out.println("enter string text");
	        
	       //  String text = scan.nextLine();
	       // String text = "I lost my mobile and i am feeling very sad";

	        // create an empty Annotation just with the given text
	        Annotation document = new Annotation(qestion);

	        // run all Annotators on this text
	        pipeline.annotate(document);
	        List<CoreMap> sentences = document.get(SentencesAnnotation.class);

	        for(CoreMap sentence: sentences) {
	          // traversing the words in the current sentence
	          // a CoreLabel is a CoreMap with additional token-specific methods
	          for (CoreLabel token: sentence.get(TokensAnnotation.class)) 
	          {
		            // this is the text of the token
		            String word = token.get(TextAnnotation.class);
		            // this is the POS tag of the token
		            String pos = token.get(PartOfSpeechAnnotation.class);
		            // this is the NER label of the token
		            String ne = token.get(NamedEntityTagAnnotation.class);
		            System.out.println(String.format("Print: Word : [%s] Pos: [%s] ne: [%s]",word,pos,ne));
		            
		            DataAccessLayer.qestion(word, pos);
	          }
	          
	          DataAccessLayer.realqestion(rq);
	            
	          System.out.println("question add");

	        List<findnoun> fn =  DataAccessLayer.fatchnounkeyword();
	          
	          for(findnoun f:fn)
	          {
	        	  
	        	System.out.println("word as ---->"+f.getWord());
	        	
	        	System.out.println( "noun as -->"+f.getNoun());
	        
	        	 likewordnoun.setFinalkeywordword(f.getWord());
	        	 ///////////////////////////////////////////////
	        	  val = f.getWord();
	             DataAccessLayer.finalkeyword(likewordnoun);
	             
	             fcomunity  = DataAccessLayer.finalcomunitymethod(val);
	             
	             System.out.println("outputvalue------>"+fcomunity.getOutputid());
	             
	             int op = fcomunity.getOutputid();
	         
	             
	             
   //**************************************************************************	
	     //send specific expert mail
	             
	    List<expert> emailid = DataAccessLayer.fatchexpert(op);	
	     		
	     	for(expert eid :emailid)
	     	{
	     	
	          String ename = eid.getEmail();
	     		
	          try {
				SendMail.sendEmail(ename, qestion);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("errormag-->"+e.getMessage());
				
			}
	     	
	     	}
	     	//**************************************************************************
	             
	          Qestionstoredatabase qd =new Qestionstoredatabase();
	             
	              qd.setQestion(qestion);
	              qd.setQid(op);
	             
	             try
	             {
	            	
	            	 
	            	 if(op==1)
	            	 {
	            		 
	            		 DataAccessLayer.QestionStoreDatabase(qd);
	            		 
	            	   	response.sendRedirect("java.jsp"); 
	            		
	            	}
	            
	            	 if(op==2)
	            	 {
	            		 DataAccessLayer.QestionStoreDatabase(qd);
	            		 response.sendRedirect("music.jsp");
	            		 
	            	 }
	            	 
	            	 if(op==3)
	            	 {
	            		 DataAccessLayer.QestionStoreDatabase(qd);
	            		 response.sendRedirect("sports.jsp");
	            		 
	            	 }
	            	 
	            	 else
	            	 {
	            		 
	            		 response.sendRedirect("missing.jsp");
	            		 System.out.println("qestion not relative to community");
	            		 
	            	 }
	            	 
	             }
	            catch (Exception e)
	             {
					// TODO: handle exception
	            	
				 }
	             
	             //end loop
	          }
	          
	          DataAccessLayer.deleteqestion();
	          System.out.println("data clean");
	          System.out.println("all process done");
	          
	    }
		
	}
		
}

}
