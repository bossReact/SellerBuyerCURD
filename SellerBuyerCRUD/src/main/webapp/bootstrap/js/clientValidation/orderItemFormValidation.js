/**
 * 
 */

function orderItemRegisterFormValidation(){
	var quantity=document.orderItemForm.quantity;
	
	var order=document.orderItemForm.order.value;
	var product=document.orderItemForm.product.value;
	
	var numbersEx = /^[0-9]+$/;
	
	if(!quantity.value.match(numbersEx)){
		alert("pleasse Enter the quantity in digit");
		return false;
	}
	if(quantity.value<0){
		alert("pleasse Enter the quantity greater than 0");
		return false;
	}
	if(order==""||order==null){	
		alert("please Select One of the Buyer of the Order");
		return false;
	}
	if(product==""||product==null){	
		alert("please Select One of the Product");
		return false;
	}
	return true;

}
