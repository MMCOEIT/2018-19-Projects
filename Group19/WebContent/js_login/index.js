$('.message a').click(function(){
   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});

$('.message1 a').click(function(){
	alert("In function ");
	   $('#form1').animate({height: "toggle", opacity: "toggle"}, "slow");
	});

