/**
 * 
 */

function sellerRegisterFormValidation(){
	var name=document.sellerRegister.name.value;  
	if(name==""||name==null){	
		alert("Please Enter the Seller name");
		return false;
	}
	return true;

}

