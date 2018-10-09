/**
 * 
 */

function orderRegisterFormValidation(){
	var buyer=document.orderRegisterForm.buyer.value;  
	
	if(buyer==""||buyer==null){	
		alert("please Select One of the Buyer");
		return false;
	}
	return true;

}
