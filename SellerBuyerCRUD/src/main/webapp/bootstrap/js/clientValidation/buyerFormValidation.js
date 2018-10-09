/**
 * 
 */

function buyerRegisterFormValidation(){
	var fname=document.buyerRegister.firstName.value;  
	var lname=document.buyerRegister.lastName.value;
	
	if(fname==""||fname==null){	
		alert("Please Enter the Buyer firstName");
		return false;
	}
	if(lname==""||lname==null){	
		alert("Please Enter the Buyer LastName");
		return false;
	}
	return true;

}
