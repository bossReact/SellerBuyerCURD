/**
 * 
 */

function productRegisterFormValidation(){
	var pname=document.productRegister.name.value;  
	var price=document.productRegister.price; 
	var seller=document.productRegister.seller.value;
	var desc=document.productRegister.desc.value;
	
	var letterEx=/^[A-Za-z]+$/;
	
	if(pname==""||!pname.match(letterEx))
		{
		alert("enter the product Name Properly");
		return false;
		}
	
	if(seller==""){
		alert("Please select seller of the product");
		return false;
		}
	
	
	return true;

}
