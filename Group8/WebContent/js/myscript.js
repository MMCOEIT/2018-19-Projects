function insertvalue()
{
	var select=document.getElementById("select"),
	
	    txtval=document.getElementById("val").value,
	    
	    newOption=document.createElement("OPTION"),
	    
	    newOptionVal=document.createTextNode(txtval);
	
		newOption.appendChild(newOptionVal);
		
		select.insertBefore(newOption, select.lastChild);
	
	    
}