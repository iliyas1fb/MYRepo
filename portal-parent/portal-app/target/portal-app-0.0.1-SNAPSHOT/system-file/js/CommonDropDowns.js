$(document).unbind('keydown').bind('keydown', function (event) {
    var doPrevent = false;
    if (event.keyCode === 8) {
        var d = event.srcElement || event.target;
        if ((d.tagName.toUpperCase() === 'INPUT' && (d.type.toUpperCase() === 'TEXT' || d.type.toUpperCase() === 'PASSWORD')) 
             || d.tagName.toUpperCase() === 'TEXTAREA') {
            doPrevent = d.readOnly || d.disabled;
        }
        else {
            doPrevent = true;
        }
    }

    if (doPrevent) {
        event.preventDefault();
    }
});
var arrCountry = [];
var arrCountryCode = [];
var getMethod = 'GET';
var postMethod = 'POST';
function countryList(contextPath,target,selected){
	jQuery.ajax({
		url : contextPath,
		type : getMethod,
		datatype : 'json',
		success : function(data) {
			arrCountry = data.response;
			setCountry(arrCountry,target,selected);						
		}
	});	
}
function setCountry(arrCountry1,target,selected){
	var encDDL;
  	var encOption;
  	encDDL = document.getElementById(target);
   	jq.each(arrCountry1, function(i, itemData) {
   	
   		if(null != selected && selected !='undefined'&& selected==itemData.countryId){
   			encOption = new Option(itemData.countryName,itemData.countryId,false,true);
   		}
   		else{
   			encOption = new Option(itemData.countryName,itemData.countryId,false,false);
   		}
      try{
   		encDDL.add(encOption,null);
		}catch(e){
			//sencDDL.add(encOption,-1);
		}             
      }); 
}

function countryListNew(contextPath,target,selected){
	jQuery.ajax({
		url : contextPath,
		type : getMethod,
		datatype : 'json',
		success : function(data) {
			arrCountry = data.response;
			setCountryNew(arrCountry,target,selected);						
		}
	});	
}
function setCountryNew(arrCountry1,target,selected){
	var encDDL;
  	var encOption;
  	encDDL = document.getElementById(target);
   	jq.each(arrCountry1, function(i, itemData) {
   	 var str=itemData.countryCode+"-"+itemData.countryId;
   		if(null != selected && selected !='undefined'&& selected==str){
   			encOption = new Option(itemData.countryName,str,false,true);
   		}
   		else{
   			encOption = new Option(itemData.countryName,str,false,false);
   		}
      try{
   		encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}             
      }); 
}


function storeList(contextPath,target){
	
	jQuery.ajax({
		url : contextPath,
		type : getMethod,
		datatype : 'json',
		success : function(data) {
			
			setStore(data.storeNameList,target);	
			
		}
	});	
}
function setStore(arrCountry1,target){
	
	var encDDL;
  	var encOption;
  	encDDL = document.getElementById(target);
   	jq.each(arrCountry1, function(i, itemData) {
   	encOption = new Option(itemData.storeName,itemData.storeName,false,false);
      try{
   		encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}             
      });
}





function exceptionList(contextPath,target){
	
	jQuery.ajax({
		url : contextPath,
		type : getMethod,
		datatype : 'json',
		success : function(data) {
			
			setException(data.couponExceptionList,target);	
			
		}
	});	
}
function setException(exceptionList,target){
	
	var encDDL;
  	var encOption;
  	encDDL = document.getElementById(target);
   	jq.each(exceptionList, function(i, itemData) {
   	encOption = new Option(itemData.exceptionDesc,itemData.exceptionDesc,false,false);
      try{
   		encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}             
      });
}



function discountDescList(contextPath,target){
	
	jQuery.ajax({
		url : contextPath,
		type : getMethod,
		datatype : 'json',
		success : function(data) {
			
			setDiscountDesc(data.discountDescList,target);	
			
		}
	});	
}
function setDiscountDesc(discountList,target){
	
	var encDDL;
  	var encOption;
  	encDDL = document.getElementById(target);
   	jq.each(discountList, function(i, itemData) {
   
   	encOption = new Option(itemData.discount_desc,itemData.discountId,false,false);
      try{
   		encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}             
      });
}




function discountTypeList(contextPath,target){
	
	jQuery.ajax({
		url : contextPath,
		type : getMethod,
		datatype : 'json',
		success : function(data) {
			
			setDiscountType(data.discountTypeList,target);	
			
		}
	});	
}
function setDiscountType(discountTypeList,target){
	
	var encDDL;
  	var encOption;
  	encDDL = document.getElementById(target);
   	jq.each(discountTypeList, function(i, itemData) {
   
   	encOption = new Option(itemData.discount_type,itemData.discount_type,false,false);
      try{
   		encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}             
      });
}






function stateList(contextPath,target){
	jQuery.ajax({
		url : contextPath,
		type : getMethod,
		datatype : 'json',
		success : function(data) {
			setState(data.response,target);						
		}
	});	
}
function setState(arrCountry1,target){
	var encDDL;
  	var encOption;
  	encDDL = document.getElementById(target);
  	encOption = new Option("------Select------",'',false,false);
  	encDDL.add(encOption,null);
  	jq.each(arrCountry1, function(i, itemData) {
   	encOption = new Option(itemData.stateName,itemData.stateId,false,false);
      try{
   		encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}             
      });
}

function setVTState(arrCountry1,target,selected){
	var encDDL;
  	var encOption;
  	encDDL = document.getElementById(target);
  	encOption = new Option("------Select------",'',false,false);
  	encDDL.add(encOption,null);
  	jq.each(arrCountry1, function(i, itemData) {
  	
  		if(null != selected && selected !='undefined'&& selected==itemData.stateName){
  			encOption = new Option(itemData.stateName,itemData.stateName,false,true);
   		}
  		else{
  		encOption = new Option(itemData.stateName,itemData.stateName,false,false);
  		}
      try{
   		encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}             
      });
}

function corporateList(contextPath,target){
	jQuery.ajax({
		url : contextPath,
		type : getMethod,
		datatype : 'json',
		success : function(data) {
			setState(data.response,target);						
		}
	});	
}
function setCorporate(arrCountry1,target){
	var encDDL;
  	var encOption;
  	encDDL = document.getElementById(target);
  	encOption = new Option("------Select------",'',false,false);
  	encDDL.add(encOption,null);
  	jq.each(arrCountry1, function(i, itemData) {
   	encOption = new Option(itemData.cooperateCode,itemData.salesChannelCooperateId,false,false);
      try{
   		encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}             
      });
}

function setRoleList(arrCountry1,target){
	alert('ll');
	var encDDL;
  	var encOption;
  	encDDL = document.getElementById(target);
  	encDDL.length = 0;
    encOption = new Option("------Select------",'',false,false);
  	encDDL.add(encOption,null);
  	jq.each(arrCountry1, function(i, itemData) {
   	encOption = new Option(itemData.subRoleName,itemData.roleGroupId,false,false);
      try{
    	  alert(itemData.roleGroupId); 
   		encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}             
      });
}

function setEntityList(arrCountry1,target){
	var encDDL;
  	var encOption;
  	encDDL = document.getElementById(target);
  	encDDL.length = 0;
    encOption = new Option("------Select------",'',false,false);
  	encDDL.add(encOption,null);	
  	jq.each(arrCountry1, function(i, itemData) {
   	encOption = new Option(itemData.entityName,itemData.entityId,false,false);
      try{
   		encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}             
      });
}

// This new method provides Entity Code(Merchant Report)
function setEntityList1(arrResponse,target){
	var encDDL;
	var encOption;
	encDDL = document.getElementById(target);
	encDDL.length = 0;
	encOption = new Option("------Select------",'','',false,false);
	encDDL.add(encOption,null);	
	jq.each(arrResponse, function(i, itemData) {
		encOption = new Option(itemData.entityCode,itemData.entityId,false,false);
		try{
			encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}             
	});
}

function currencyList(contextPath,target,target1){
	jQuery.ajax({
		url : contextPath,
		type : getMethod,
		datatype : 'json',
		success : function(data) {
			setCurrency(data.response,target,target1);						
		}
	});	
}
function setCurrency(arrCurrency1,target,target1){
	var encDDL;
	var encDDL1;
  	var encOption;
	var encOption1;
  	encDDL = document.getElementById(target);
  	if(target1!=null)
  	encDDL1 = document.getElementById(target1);
   	jq.each(arrCurrency1, function(i, itemData) {
   	encOption = new Option(itemData.charCode,itemData.currencyId,false,false);
   	if(target1!=null)
   	encOption1 = new Option(itemData.charCode,itemData.currencyId,false,false);
      try{
   		encDDL.add(encOption,null);
   		if(target1!=null)
   		encDDL1.add(encOption1,null);
      }catch(e){
			encDDL.add(encOption,-1);
			if(target1!=null)
			encDDL1.add(encOption1,-1);
		}             
      }); 
}


function timeZoneList(contextPath,target){
	jQuery.ajax({
		url : contextPath,
		type : getMethod,
		datatype : 'json',
		success : function(data) {
			setTimeZone(data.response,target);						
		}
	});	
}
function setTimeZone(arrCurrency1,target){
	var encDDL;
  	var encOption;
  	encDDL = document.getElementById(target);
   	jq.each(arrCurrency1, function(i, itemData) {
   	encOption = new Option(itemData.timezoneVal,itemData.timeZoneId,false,false);
      try{
   		encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}             
      }); 
}

function languageList(contextPath,target){
	jQuery.ajax({
		url : contextPath,
		type : getMethod,
		datatype : 'json',
		success : function(data) {
			setLanguage(data.response,target);						
		}
	});	
}
function setLanguage(arrlanguage,target){
	
	var encDDL;
  	var encOption;
  	encDDL = document.getElementById(target);
   	jq.each(arrlanguage, function(i, itemData) {
   	encOption = new Option(itemData.languageCode,itemData.languageId,false,false);
      try{
   		encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}             
      }); 
}


function bankIdList(contextPath,target){
	jQuery.ajax({
		url : contextPath,
		type : getMethod,
		datatype : 'json',
		success : function(data) {
			setbankId(data.bankIdList,target);						
		}
	});	
}
function setbankId(arrBankId,target){
	var encDDL;
  	var encOption;
  	encDDL = document.getElementById(target);
   	jq.each(arrBankId, function(i, itemData) {
   	encOption = new Option(itemData.bankCode+"-"+itemData.bankName,itemData.salesChannelBankId,false,false);
      try{
   		encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}             
      }); 
}
 

function setCountryProcessor(arrCountry1,target){
	var encDDL;
  	var encOption;
  	encDDL = document.getElementById(target);
   	jq.each(arrCountry1, function(i, itemData) {
   	encOption = new Option(itemData.countryName,itemData.countryId,false,false);
      try{
   		encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1); 
		}             
      });  
}
function paymentMethodList(contextPath,target,selected){
	jQuery.ajax({
		url : contextPath,
		type : getMethod,
		datatype : 'json',
		success : function(data) {
			arrpaymentMethod = data.response;
			setPaymentMethodList(arrpaymentMethod,target,selected);						
		}
	});	
}
function setPaymentMethodList(arrpaymentMethod,target,selected){
	var encDDL;
  	var encOption;  
  	encDDL = document.getElementById(target);
  	encDDL.length = 0;
//  encOption = new Option("------Select------",'',true,true);
//  encDDL.add(encOption,null);
  	jq.each(arrpaymentMethod, function(i, itemData) {
  		//encOption = new Option(itemData.paymentMethodName,itemData.paymentMethodId,false,false);
  		if(null != selected && selected !='undefined'&& selected==itemData.paymentMethodId)
   			encOption = new Option(itemData.paymentMethodName,itemData.paymentMethodId,false,true);
   		else{
   		
   			encOption = new Option(itemData.paymentMethodName,itemData.paymentMethodId,false,false);
   		}
      try{
   		encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}             
      }); 
  	if(null != selected && selected !='undefined'){
  		for(j=0;j<selected.length;j++){
  			for(i=0;i<encDDL.length;i++){
  				if(encDDL.options[i].value == selected[j].paymentMethodId){
  					encDDL.options[i].selected = true;
  					break;
  				}
  			}
  		}
  	}
}

function paymentTypeMethodList(contextPath,target,selected){
	jQuery.ajax({
		url : contextPath,
		type : getMethod,
		datatype : 'json',
		success : function(data) {
			arrpaymentMethod = data.response;
			setPaymentTypeMethodList(arrpaymentMethod,target,selected);						
		}
	});	
}
function setPaymentTypeMethodList(arrpaymentMethod,target,selected){
	
	var encDDL;
  	var encOption;  
  	encDDL = document.getElementById(target);
  	encDDL.length = 0;
  	encOption = new Option("------Select------",'',true,true);
	encDDL.add(encOption,null);
  	jq.each(arrpaymentMethod, function(i, itemData) {
  		//encOption = new Option(itemData.paymentMethodName,itemData.paymentMethodId,false,false);
  		if(null != selected && selected !='undefined' && selected==itemData.commModeId)
   			encOption = new Option(itemData.commMode,itemData.commModeId,false,true);
   		else
   			encOption = new Option(itemData.commMode,itemData.commModeId,false,false);
  		try
  		{
  			encDDL.add(encOption,null);
  		}
  		catch(e)
  		{
			encDDL.add(encOption,-1);
		}             
      }); 
	if(null != selected && selected !='undefined')
	{
  		for(j=0;j<selected.length;j++){
  			for(i=0;i<encDDL.length;i++){
  				if(encDDL.options[i].value == selected[j].commModeId){
  					encDDL.options[i].selected = true;
  					break;
  				}
  			}
  		}
  	}
  	document.getElementById(target).disabled = true;
  	document.getElementById(target).r = true;
}

function CardTypeMethodList(contextPath,target,selected){ 
	jQuery.ajax({
		url : contextPath,
		type : getMethod,
		datatype : 'json',
		success : function(data) {
			arrpaymentMethod = data.response;
			setCardTypeMethodList(arrpaymentMethod,target,selected);						
		}
	});	
}
function setCardTypeMethodList(arrpaymentMethod,target,selected){
	
	var encDDL;
  	var encOption;  
  	encDDL = document.getElementById(target);
  	encDDL.length = 0;
  encOption = new Option("------Select------",'',true,true);
  encDDL.add(encOption,null);
  	jq.each(arrpaymentMethod, function(i, itemData) {
  		//encOption = new Option(itemData.paymentMethodName,itemData.paymentMethodId,false,false);
  		if(null != selected && selected !='undefined'&& selected==itemData.paymentMethodId)
   			encOption = new Option(itemData.paymentMethodName,itemData.paymentMethodId,false,true);
   		else{
   		
   			encOption = new Option(itemData.paymentMethodName,itemData.paymentMethodId,false,false);
   		}
      try{
   		encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}             
      }); 
  	if(null != selected && selected !='undefined'){
  		for(j=0;j<selected.length;j++){
  			for(i=0;i<encDDL.length;i++){
  				if(encDDL.options[i].value == selected[j].paymentMethodId){
  					encDDL.options[i].selected = true;
  					break;
  				}
  			}
  		}
  	}
}



function MerchantConfiguredCurrencyAndPayMethod(contextPath,target,target1){ 
	jQuery.ajax({
		url : contextPath,
		type : getMethod,
		datatype : 'json',
		success : function(data) {
			arrpaymentMethod = data.merchantcurrencyList;
			arrpaymentMethod1 = data.merchantPaymentMethodList;
			setMerchantConfiguredCurrencyAndPayMethod(arrpaymentMethod,arrpaymentMethod1,target,target1);	
			}
	});	
}

function setMerchantConfiguredCurrencyAndPayMethod(arrpaymentMethod,arrpaymentMethod1,target,target1,selected,selected1){
	var encDDL;
	var encDDL1;
  	var encOption;  
  	var encOption1;  
  	encDDL = document.getElementById(target);
  	encDDL1 = document.getElementById(target1);
  	encDDL.length = 0;
  	encDDL1.length = 0;
  	encOption = new Option("------Select------",'',true,true);
    encDDL.add(encOption,null);
    encOption1 = new Option("------Select------",'',true,true);
    encDDL1.add(encOption1,null);
  	jq.each(arrpaymentMethod, function(i, itemData) {
  		if(null != selected && selected !='undefined'&& selected==itemData.authCurrencyName)
  			encOption = new Option(itemData.authCurrencyName,itemData.authCurrencyName,false,true);
  		else
  			encOption = new Option(itemData.authCurrencyName,itemData.authCurrencyName,false,false);
  	 	    		
      try{
       	encDDL.add(encOption,null);
    	}catch(e){
			encDDL.add(encOption,-1);
			}             
      }); 
  	
  	jq.each(arrpaymentMethod1, function(i, itemData) {
  		if(null != selected1 && selected1 !='undefined'&& selected1==itemData.paymentMethodName)
  			encOption1 = new Option(itemData.paymentMethodName,itemData.paymentMethodName,false,true);
  		else
	 	   encOption1 = new Option(itemData.paymentMethodName,itemData.paymentMethodName,false,false);
	
try{
    encDDL1.add(encOption1,null);
	}catch(e){
		encDDL1.add(encOption1,-1);
	}             
}); 
  }





function hierarchyList(contextPath,target){
	jQuery.ajax({
		url : contextPath,
		type : getMethod,
		datatype : 'json',
		success : function(data) {
			
			arrpaymentMethod = data.response;
			setHierarchyList(arrpaymentMethod,target);						
		}
	});	
}
function setHierarchyList(arrpaymentMethod,target){

	var encDDL;
  	var encOption;                                     
  	encDDL = document.getElementById(target);
	encDDL.length = 0;
	encOption = new Option("------Select------",'',false,false);
	encDDL.add(encOption,null);
	  
   	jq.each(arrpaymentMethod, function(i, itemData) {
   	  		encOption = new Option(itemData.groupName,itemData.groupId,false,false);   	
   	  		
      try{
   		encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}             
      }); 
}

function hierarchyListNew(contextPath,target){
	jQuery.ajax({
		url : contextPath,
		type : getMethod,
		datatype : 'json',
		success : function(data) {
			arrpaymentMethod = data.response;
			setHierarchyList1(arrpaymentMethod,target);						
		}
	});	
}
function setHierarchyList1(arrpaymentMethod,target){
	var encDDL;
	var encOption;                                     
	encDDL = document.getElementById(target);
	encDDL.length = 0;
	encOption = new Option("------Select------",'',false,false);
	encDDL.add(encOption,null);
	
	jq.each(arrpaymentMethod, function(i, itemData) {
		encOption = new Option(itemData.groupName,itemData.groupId,false,false);   	
		try{
			if(itemData.groupName != 'System Admin - Manager')
				encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}             
	}); 
}
function checkedAll(){  
	document.getElementById('checkbox').value='NOT ALL';
    if (document.getElementById('checkbox').checked) {
    	
    	document.getElementById('checkbox').value='ALL';
        for(i=0; i<document.getElementsByTagName('input').length;i++){
        document.getElementsByTagName('input')[i].checked = true;
        }
    }
    else {
    	document.getElementById('checkbox').value='NOT ALL';
        for(i=0; i<document.getElementsByTagName('input').length;i++){
         document.getElementsByTagName('input')[i].checked = false;
        }
    }
  }

function commModeList(contextPath,target,checkBoxList,callingfunction,saveBtn){
	
	jQuery.ajax({
		url : contextPath,
		type : getMethod,
		datatype : 'json',
		success : function(data) {
			arrpaymentMethod = data.response;
			createCheckBox(arrpaymentMethod,target,checkBoxList,saveBtn);	
			if(null!=callingfunction){
				checkedAll();
			}
		}
	});	
}

function createCheckBox(response,target,checkBoxList,saveBtn){
	 var arr = response;
	 var str ="";
	
	var flag="false";
	 for(i=0;i<arr.length;i++){
		 var t=i+5;
		 var k=i+4;
		 var m=i+7;
		 flag="false";
		if(checkBoxList!=null && checkBoxList!='undefined'){
		 for(j=0;j<checkBoxList.length;j++){
			 if(checkBoxList[j].commModeId==response[i].commModeId)
			 flag="true"; 
			 }
	 }

          // if(null != checkBoxList && i<checkBoxList.length &&
			// checkBoxList[i].commModeId==response[i].commModeId){
		 if(null != checkBoxList && flag=="true"){
			 str=str+"<input type=\"checkbox\" name=\"commMode\" tabindex=\""+k+"\" id=\"commModeEcom"+i+"\" value="+response[i].commModeId+" checked />"+ response[i].commMode;
		 }
		 else{
			 if(target=='channelConf'){
				 str=str+"<input type=\"checkbox\" name=\"commMode\" tabindex=\""+m+"\" id=\"commModeEcom"+i+"\" value="+response[i].commModeId+" />"+ response[i].commMode;
			 }else{
				 str=str+"<input type=\"checkbox\" name=\"commMode\" tabindex=\""+t+"\" id=\"commModeEcom"+i+"\" value="+response[i].commModeId+" />"+ response[i].commMode;
			 }
			
		 }
	 }	 
	 document.getElementById(target).innerHTML = str;
	 if(null != document.getElementById(saveBtn)){
		 document.getElementById(saveBtn).disabled = false;
	 }
}

function SelectMoveRows(SS1,SS2)
{
    var SelID='';
    var SelText='';
    // Move rows from SS1 to SS2 from bottom to top
    for (i=SS1.options.length - 1; i>=0; i--)
    {
        if (SS1.options[i].selected == true)
        {
            SelID=SS1.options[i].value;
            SelText=SS1.options[i].text;
            var newRow = new Option(SelText,SelID);
            SS2.options[SS2.length]=newRow;
            SS1.options[i]=null;
        }
    }
    SelectSort(SS2);
}
function SelectSort(SelList)
{
    var ID='';
    var Text='';
    for (x=0; x < SelList.length - 1; x++)
    {
        for (y=x + 1; y < SelList.length; y++)
        {
            if (SelList[x].text > SelList[y].text)
            {
                // Swap rows
                ID=SelList[x].value;
                Text=SelList[x].text;
                SelList[x].value=SelList[y].value;
                SelList[x].text=SelList[y].text;
                SelList[y].value=ID;
                SelList[y].text=Text;
            }
        }
    }
}

function selectedList(rightList){
	var SelID = "";
	for (i=rightList.options.length - 1; i>=0; i--){
        SelID=SelID+rightList.options[i].value+",";         
    }
	return SelID;
}

function isNumberKey(val)
{
   var charCode = (val.which) ? val.which : event.keyCode;
   if (val.ctrlKey==true && (charCode==118 || charCode==99)){
	   return true;
   }
   if (charCode > 31 && (charCode < 48 || charCode > 57))
      return false;

   return true;
}
function isNumberOnlyKey(val)
{
   var charCode = (val.which) ? val.which : event.keyCode;
   if (charCode > 31 && (charCode < 48 || charCode > 57))
      return false;

   return true;
}
function makeEnable(){
	var hierarchyList1 =$("#hierarchyList option:selected").val(); 
	hierarchyList1=document.getElementById("hierarchyList").value;
	if(hierarchyList1==""){
	document.getElementById('pemissionDisplay').innerHTML = "" ;
	var el = document.getElementById('addRoleMainHeaderId');
    all = el.getElementsByTagName('input');
    var i;
    for (i = 0; i < all.length; i++) {
    	all[i].disabled = true; 
    }
     
    jQuery("input#roleName").val('');
    jQuery("input#roleDesc").val('');  
    $('#status option:eq(0)').attr('selected','selected');
     
	}else {				
     var el = document.getElementById('addRoleMainHeaderId');
     all = el.getElementsByTagName('input');
     var i;
     for (i = 0; i < all.length; i++) {
     all[i].disabled = false;
     }
     getPermission();
	}
}
function getPermission(){
	var hierarchyList1=document.getElementById("hierarchyList").value;
    jQuery.ajax({
		    url: context+'/getPermissionVOList?groupId='+hierarchyList1,
		    type: 'GET',
		    datatype: 'json',
		    success: function (data) {
		    	displayPermission(data.response,'pemissionDisplay');
		    }});
   } 

function displayPermission(response,target){
	
	
	
	
	 var moduleList = response;
	 var start ="<table width=\"100%\" border=\"2\"><tr><th><strong>Module</strong></th><th><strong>Functionality</strong></th><th><strong>Permission</strong></th></tr>";
	 var end ="</table>";
	 var module = "";
	 var functionality="";	 
	 var data="";
	 for(i=moduleList.length-1; i>=0; i--)
	 {
		 tdStart="<td rowspan="+moduleList[i].permissionFunctionalityVO.length+"\">";
		 tdEnd = "</td>";
		 module = tdStart+moduleList[i].permissionDesc+tdEnd;
		 functionalityList=moduleList[i].permissionFunctionalityVO;
		 flag= true;
		 for(j=0; j<moduleList[i].permissionFunctionalityVO.length; j++)
		 {
			functionality = "<td>"+functionalityList[j].permissionName+"</td>"; 
			console.log(functionality);
			permissionList = functionalityList[j].permissionComponentVO;
			var permission="";
			for(k=0; k<functionalityList[j].permissionComponentVO.length; k++)
			{
				if(module.indexOf('Dashboard') != -1){
					str="<input type=\"checkbox\" value="+permissionList[k].permissionId+" disabled=\"true\" checked=\"true\"/>"+ permissionList[k].permissionName;
				}
				else if(permissionList[k].permissionName == 'VIEW'){
					str="<input type=\"checkbox\" id=\"VIEW"+functionalityList[j].permissionName+"\" value="+permissionList[k].permissionId+" onclick=\"toggleCheckboxView('"+functionalityList[j].permissionName+"',this), checkSelectAll()\" />"+ permissionList[k].permissionName;
				}
				else if(permissionList[k].permissionName == 'ADD'){
					str="<input type=\"checkbox\" id=\"ADD"+functionalityList[j].permissionName+"\" value="+permissionList[k].permissionId+" onclick=\"toggleCheckbox('"+functionalityList[j].permissionName+"',this), checkSelectAll()\" />"+ permissionList[k].permissionName;
				}
				else if(permissionList[k].permissionName == 'EDIT'){
					str="<input type=\"checkbox\" id=\"EDIT"+functionalityList[j].permissionName+"\" value="+permissionList[k].permissionId+" onclick=\"toggleCheckbox('"+functionalityList[j].permissionName+"',this), checkSelectAll()\" />"+ permissionList[k].permissionName;
				}
				else if(permissionList[k].permissionName == 'DELETE'){
					str="<input type=\"checkbox\" id=\"DELETE"+functionalityList[j].permissionName+"\" value="+permissionList[k].permissionId+" onclick=\"toggleCheckbox('"+functionalityList[j].permissionName+"',this), checkSelectAll()\" />"+ permissionList[k].permissionName;
				}
				else if(permissionList[k].permissionName == 'SETTLE'){
					str="<input type=\"checkbox\" id=\"SETTLE"+functionalityList[j].permissionName+"\" value="+permissionList[k].permissionId+" onclick=\"toggleCheckbox('"+functionalityList[j].permissionName+"',this), checkSelectAll()\" />"+ permissionList[k].permissionName;
				}
				else if(permissionList[k].permissionName == 'REFUND'){
					str="<input type=\"checkbox\" id=\"REFUND"+functionalityList[j].permissionName+"\" value="+permissionList[k].permissionId+" onclick=\"toggleCheckbox('"+functionalityList[j].permissionName+"',this), checkSelectAll()\" />"+ permissionList[k].permissionName;
				}
				else if(permissionList[k].permissionName == 'CANCEL'){
					str="<input type=\"checkbox\" id=\"CANCEL"+functionalityList[j].permissionName+"\" value="+permissionList[k].permissionId+" onclick=\"toggleCheckbox('"+functionalityList[j].permissionName+"',this), checkSelectAll()\" />"+ permissionList[k].permissionName;
				}
				else if(permissionList[k].permissionName == 'RESET PASSWORD'){
					str="<input type=\"checkbox\" id=\"RESET"+functionalityList[j].permissionName+"\" value="+permissionList[k].permissionId+" onclick=\"toggleCheckbox('"+functionalityList[j].permissionName+"',this), checkSelectAll()\" />"+ permissionList[k].permissionName;
				}
				else if(permissionList[k].permissionName == 'APPROVE-REJECT'){
					str="<input type=\"checkbox\" id=\"APPROVE-REJECT"+functionalityList[j].permissionName+"\" value="+permissionList[k].permissionId+" onclick=\"toggleCheckbox('"+functionalityList[j].permissionName+"',this), checkSelectAll()\" />"+ permissionList[k].permissionName;
				}
				// JIRA: UAT-33
				else if(permissionList[k].permissionName == 'START BIN FILE UPDATE'){
					str="<input type=\"checkbox\" id=\"START"+functionalityList[j].permissionName+"\" value="+permissionList[k].permissionId+" onclick=\"toggleCheckbox('"+functionalityList[j].permissionName+"',this), checkSelectAll()\" />"+ permissionList[k].permissionName;
				}
				else if(permissionList[k].permissionName == 'LOCK-UNLOCK'){
					str="<input type=\"checkbox\" id=\"START"+functionalityList[j].permissionName+"\" value="+permissionList[k].permissionId+" onclick=\"toggleCheckbox('"+functionalityList[j].permissionName+"',this), checkSelectAll()\" />"+ permissionList[k].permissionName;
				}
				else if(permissionList[k].permissionName == 'LICENSE VALIDITY'){
					str="<input type=\"checkbox\" id=\"START"+functionalityList[j].permissionName+"\" value="+permissionList[k].permissionId+" onclick=\"toggleCheckbox('"+functionalityList[j].permissionName+"',this), checkSelectAll()\" />"+ permissionList[k].permissionName;
				}
				else if(permissionList[k].permissionName == 'UPLOAD-FILES'){
					str="<input type=\"checkbox\" id=\"UPLOAD-FILES"+functionalityList[j].permissionName+"\" value="+permissionList[k].permissionId+" onclick=\"toggleCheckbox('"+functionalityList[j].permissionName+"',this), checkSelectAll()\" />"+ permissionList[k].permissionName;
				}
				permission = permission+str;
			}
			if(flag==true){
				data = data+"<tr>"+module+functionality+"<td>"+permission+"</td></tr>";
				flag=false;
			}
			else{
				data = data+"<tr>"+functionality+"<td>"+permission+"</td></tr>";
			}
		 }		 
	 }
	 

	 document.getElementById(target).innerHTML = start+data+end;
}
function checkSelectAll()
{
	var flag = false;
	var cbs = document.getElementsByTagName("input");
	for(var i=0; i < cbs.length; i++){
		if('checkbox' == cbs[i].type){
			if(!cbs[i].checked){
				flag = true;
				break;
			}
		}
	}
	if(null != document.getElementById('eidtCheckAll')){
		if(!flag)
			document.getElementById('eidtCheckAll').checked = true;
		else{
			document.getElementById('eidtCheckAll').checked = false;
		}
	}
	if(null != document.getElementById('checkAll')){
		if(!flag)
			document.getElementById('checkAll').checked = true;
		else{
			document.getElementById('checkAll').checked = false;
		}
	}
	
	if(document.getElementById('checkAll').checked == false)
	{
		var checkStatus = checkStatusCheckbox();
		if(checkStatus == true && null != document.getElementById('checkAll'))
			document.getElementById('checkAll').checked = true;
	}
	if(document.getElementById('eidtCheckAll').checked == false)
	{
		var checkStatus = checkStatusCheckbox();
		if(checkStatus == true && null != document.getElementById('eidtCheckAll'))
			document.getElementById('eidtCheckAll').checked = true;
	}
}
function checkStatusCheckbox() {
	var checkStatus = true;
	var cbs = document.getElementsByTagName("input");
	for(var i=0; i < cbs.length; i++)
	{
		if(cbs[i].type == 'checkbox')
		{
			if(!cbs[i].checked)
			{
				if(cbs[i].value != "on")
				{
					checkStatus = false;
					break;
				}
			}
		}
	}
	return checkStatus;
}

function toggleCheckbox(obj,obj1){
	 if(obj1.checked)
	 document.getElementById("VIEW"+obj).checked = true;
}
 
function toggleCheckboxView(obj,obj1){
	 if(!obj1.checked){
		 if(document.getElementById("ADD"+obj) && document.getElementById("ADD"+obj).checked){
			 obj1.checked = true;
		 }
		 if(document.getElementById("EDIT"+obj) && document.getElementById("EDIT"+obj).checked){
			 obj1.checked = true;
		 }
		 if(document.getElementById("APPROVE-REJECT"+obj) && document.getElementById("APPROVE-REJECT"+obj).checked){
			 obj1.checked = true;
		 }
		 // JIRA: UAT-33
		 if(document.getElementById("DELETE"+obj) && document.getElementById("DELETE"+obj).checked){
			 obj1.checked = true;
		 }
		 if(document.getElementById("RESET"+obj) && document.getElementById("RESET"+obj).checked){
			 obj1.checked = true;
		 }
		 if(document.getElementById("SETTLE"+obj) && document.getElementById("SETTLE"+obj).checked){
			 obj1.checked = true;
		 }
		 if(document.getElementById("REFUND"+obj) && document.getElementById("REFUND"+obj).checked){
			 obj1.checked = true;
		 }
		 if(document.getElementById("CANCEL"+obj) && document.getElementById("CANCEL"+obj).checked){
			 obj1.checked = true;
		 }
		 if(document.getElementById("START"+obj) && document.getElementById("START"+obj).checked){
			 obj1.checked = true;
		 }
		 if(document.getElementById("UPLOAD-FILES"+obj) && document.getElementById("UPLOAD-FILES"+obj).checked){
			 obj1.checked = true;
		 }
	 }
}
 
 function roleList(contextPath,target){
	 alert(contextPath);
		jQuery.ajax({
			url : contextPath,
			type : getMethod,
			datatype : 'json',
			success : function(data) {
				arrpaymentMethod = data.response;
				setHirarchyNameList(arrpaymentMethod,target,selected);	
				setRoleList(arrpaymentMethod,target);						
			}
		});	
	}
 
 function roleListData(contextPath,target){
		jQuery.ajax({
			url : contextPath,
			type : getMethod,
			datatype : 'json',
			success : function(data) {
				arrpaymentMethod = data.response;  
				setRoleListData(arrpaymentMethod,target);    						
			}
		});	
	}
	function setRoleListData(arrpaymentMethod,target){
		var encDDL;
	  	var encOption;                                     
	  	encDDL = document.getElementById(target);
	   	jq.each(arrpaymentMethod, function(i, itemData) {	   		
	   	  		encOption = new Option(itemData.roleName,itemData.roleId,false,false);   	
	      try{
	   		encDDL.add(encOption,null);
			}catch(e){
				encDDL.add(encOption,-1);
			}             
	      }); 
	}
 
 function isZipCode(val)
 {
    var charCode = (val.which) ? val.which : event.keyCode;
    if (charCode > 31 && (charCode < 48 || charCode > 57) && (charCode < 65 || charCode > 90) && (charCode!=45) && (charCode!=32))
       return false;

    return true;
 }
 
 function readOnlyDisplayPermission(response,target){
	 var moduleList = response;
	 var start ="<table width=\"100%\" border=\"2\"><tr><th><strong>Module</strong></th><th><strong>Functionality</strong></th><th><strong>Permission</strong></th></tr>";
	 var end ="</table>";
	 var module = "";
	 var functionality="";	 
	 var data="";
	 var len=1;
	 for(i=moduleList.length-1;i>=0;i--){
		// tdStart="<td rowspan="+moduleList[i].permissionFunctionalityVO.length+"\">";
		 tdStart="<td rowspan="+len+"\">";
		 tdEnd = "</td>";
		 module = tdStart+moduleList[i].permissionDesc+tdEnd;
		 //functionalityList=moduleList[i].permissionFunctionalityVO;
		 flag= true;
		// for(j=0;j<moduleList[i].permissionFunctionalityVO.length;j++){
			//functionality = "<td>"+functionalityList[j].permissionName+"</td>";
		 functionality = "<td>"+moduleList[i].permissionName+"</td>";
		///	permissionList = functionalityList[j].permissionComponentVO;
			var permission="";
			//for(k=0;k<functionalityList[j].permissionComponentVO.length;k++){
				//str="<input type=\"checkbox\" value="+permissionList[k].permissionId+" disabled=\"true\" />"+ permissionList[k].permissionName;
			str="<input type=\"checkbox\" value="+moduleList[i].permissionId+" disabled=\"true\" />"+ moduleList[i].permissionName;
				permission = permission+str; 				
			// }
			if(flag==true){
				data = data+"<tr>"+module+functionality+"<td>"+permission+"</td></tr>";
				flag=false;
			}
			else{
				data = data+"<tr>"+functionality+"<td>"+permission+"</td></tr>";
			}
		// }		 
	 }	
	 document.getElementById(target).innerHTML = start+data+end;
 }
 
function corporateCodeCheck(val)
{
    var charCode = (val.which) ? val.which : event.keyCode;
    if (charCode == 48 || (charCode >= 65 && charCode <= 90) || (charCode >= 97 && charCode <= 122))
       return true;
    else
    {
    	alert("Only '0' or Alphabets are allowed ");
    	return false;
    }
}
 
function ValidateEmail(mail)
{
	var pattern = /^([a-zA-Z0-9_.\-\\'])+@([a-zA-Z0-9_.-])+\.([a-zA-Z])+([a-zA-Z])+/;
	var filter = /^([a-zA-Z0-9_\.\-\\'])+\@(([a-zA-Z0-9\-])+\.){1,3}([a-zA-Z0-9]{2,4})+$/;
	
	if(pattern.test(mail) && filter.test(mail)){
		return true;
	}
	else{
		return false;
	}
}
function enable(id){
	document.getElementById(id).disabled = false;
}
function disable(id){
	document.getElementById(id).disabled = true;
}

// Merchant Field Mapping (by Bhanu Pratap)-->

function DropDownList(contextPath,target1,target2,target3,target4,target5){
	 jQuery.ajax({
		 url : contextPath,
		 type : getMethod,
		 datatype : 'json',
		 success : function(data) {
			 setCommMode(data.commModeList,target1);
			 setAuthMode(data.authModeList, target2);
			 setUrlType(data.urlTypeList, target3);
			 setTxnType(data.txnTypeList, target4);
			 setLevelList(data.levelTypeList, target5);
		 }
	 });	
}
function setCommMode(arrCommModeList,target){
	var encDDL;
	var encOption;
	encDDL = document.getElementById(target);
	encOption = new Option("------Select------",'',false,false);
	encDDL.add(encOption,null);
	jq.each(arrCommModeList, function(i, itemData) {
		encOption = new Option(itemData.name,itemData.id,false,false);
		try{
			encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}             
	});
}
function setAuthMode(arrAuthModeList,target){
	var encDDL;
	var encOption;
	encDDL = document.getElementById(target);
	encOption = new Option("------Select------",'',false,false);
	encDDL.add(encOption,null);
	jq.each(arrAuthModeList, function(i, itemData) {
		encOption = new Option(itemData.name,itemData.id,false,false);
		try{
			encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}             
	});
}
function setUrlType(arrUrlTypeList,target){
	var encDDL;
	var encOption;
	encDDL = document.getElementById(target);
	encOption = new Option("------Select------",'',false,false);
	encDDL.add(encOption,null);
	jq.each(arrUrlTypeList, function(i, itemData) {
		encOption = new Option(itemData.name,itemData.id,false,false);
		try{
			encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}             
	});
}
function setTxnType(arrTxnTypeList,target){
	var encDDL;
	var encOption;
	encDDL = document.getElementById(target);
	encOption = new Option("------Select------",'',false,false);
	encDDL.add(encOption,null);
	jq.each(arrTxnTypeList, function(i, itemData) {
		encOption = new Option(itemData.name,itemData.id,false,false);
		try{
			encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}             
	});
}
function setLevelList(arrLevelList,target){
	var encDDL;
	var encOption;
	encDDL = document.getElementById(target);
	encOption = new Option("------Select------",'',false,false);
	encDDL.add(encOption,null);
	jq.each(arrLevelList, function(i, itemData) {
		encOption = new Option(itemData.name,itemData.id,false,false);
		try{
			encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}             
	});
}

function fieldNameList(contextPath,target){
	jQuery.ajax({
		url : contextPath,
		type : getMethod,
		datatype : 'json',
		success : function(data) {
			setFieldName(data.fieldNameList,target);						
		}
	});	
}
function setFieldName(arrFieldNameList,target){
	var encDDL;
	var encOption;
	encDDL = document.getElementById(target);
	encDDL.length = 0;
	encOption = new Option("------Select------",'',false,false);
	encDDL.add(encOption,null);
	jq.each(arrFieldNameList, function(i, itemData) {
		encOption = new Option(itemData.name,itemData.id,false,false);
		try{
			encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}             
	});
}

// End of Merchant Field Mapping

 function processorList(contextPath,target,selected){
	 jQuery.ajax({
			url : contextPath,
			type : getMethod,
			datatype : 'json',
			success : function(data) {
				arrProcessor1 = data.response;
				setProcessorList(arrProcessor1,target,selected);						
			}
		});	
	}
	function setProcessorList(arrProcessor1,target,selected){
		var encDDL;
	  	var encOption;                                     
	  	encDDL = document.getElementById(target);
	   	jq.each(arrProcessor1, function(i, itemData) {
	   	  encOption = new Option(itemData.processorName,itemData.processorId,false,false);   	
	      try{
	   		encDDL.add(encOption,null);
			}catch(e){
				encDDL.add(encOption,-1);
			}             
	      }); 
	}
	function processorNameList(contextPath,target,selected){
			jQuery.ajax({
			url : contextPath,
			type : getMethod,
			datatype : 'json',
			success : function(data) {
				arrProcessorName1 =data.response;
				setProcessorName(arrProcessorName1,target,selected);						
			}
		});	
	}
	function setProcessorName(arrProcessorName1,target,selected){
		var encDDL;
	  	var encOption;
	  	encDDL = document.getElementById(target);
	   	jq.each(arrProcessorName1, function(i, itemData) {
	   		
	   		if(null != selected && selected !='undefined'&& selected==itemData.processorName)
	   			encOption = new Option(itemData.processorName,itemData.processorName,false,true);
	   		else{
	   		encOption = new Option(itemData.processorName,itemData.processorName,false,false);
	   		}
	      try{
	   		encDDL.add(encOption,null);
			}catch(e){
				encDDL.add(encOption,-1);
			}             
	      }); 
	}
	
	function processorList(contextPath,target,selected){
		jQuery.ajax({
		url : contextPath,
		type : getMethod,
		datatype : 'json',
		success : function(data) {
			arrProcessorName1 =data.response;
			setprocessorList(arrProcessorName1,target,selected);						
		}
	});	
}
function setprocessorList(arrProcessorName1,target,selected){
	var encDDL;
  	var encOption;
  	encDDL = document.getElementById(target);
   	jq.each(arrProcessorName1, function(i, itemData) {
   		
   		if(null != selected && selected !='undefined'&& selected==itemData.processorName)
   			encOption = new Option(itemData.processorName,itemData.processorId,false,true);
   		else{
   		encOption = new Option(itemData.processorName,itemData.processorId,false,false);
   		}
      try{
   		encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}             
      }); 
}
	
function channelConfList(contextPath,target,selected){
	jQuery.ajax({
		url : contextPath,
		type : getMethod,
		datatype : 'json',
		success : function(data) {
			arrchannelConf =data.response;
			setchannelConfList(arrchannelConf,target,selected);						
		}
	});	
}
function setchannelConfList(arrchannelConf1,target,selected){
	var encDDL;
  	var encOption;
  	encDDL = document.getElementById(target);
   	jq.each(arrchannelConf1, function(i, itemData) {
   	if(null != selected && selected !='undefined'&& selected==itemData.commModeId)
   			encOption = new Option(itemData.commMode,itemData.commModeId,false,true);
   		else{
   		encOption = new Option(itemData.commMode,itemData.commModeId,false,false);
   		}
      try{
   		encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}             
      }); 
}

function channelConfListTransaction(contextPath,target,selected){
	jQuery.ajax({
		url : contextPath,
		type : getMethod,
		datatype : 'json',
		success : function(data) {
			arrchannelConf =data.response;
			setchannelConfListTransaction(arrchannelConf,target,selected);						
		}
	});	
}
function setchannelConfListTransaction(arrchannelConf1,target,selected){
	var encDDL;
	var encOption;
	encDDL = document.getElementById(target);
	jq.each(arrchannelConf1, function(i, itemData) {
		if(null != selected && selected !='undefined'&& selected==itemData.commModeId)
			encOption = new Option(itemData.commMode,itemData.commModeId,false,true);
		else{
			encOption = new Option(itemData.commMode+" - "+itemData.commModeValue,itemData.commModeId,false,false);
		}
		try{
			encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}             
	}); 
}

function GatewayResponseCodeList(contextPath,target,selected){
	jQuery.ajax({
	url : contextPath,
	type : getMethod,
	datatype : 'json',
	success : function(data) {
		arrGatewayResponseCode =data.response;
		setGatewayResponseCodeList(arrGatewayResponseCode,target,selected);						
	}
});	
}
function setGatewayResponseCodeList(arrGatewayResponseCode1,target,selected){
var encDDL;
	var encOption;
	var encOption1;
	encDDL = document.getElementById(target);
	encOption1 = new Option('------Select--------','',false,false);
	encDDL.add(encOption1,null);
	jq.each(arrGatewayResponseCode1, function(i, itemData) {
	var val=itemData.gatewayResponseCode+"-"+itemData.getwayResponseDescription;
	
	if(null != selected && selected !='undefined'&& selected==itemData.gatewayResponseCode)
			encOption = new Option(itemData.gatewayResponseCode,val,false,true);
		else{
		encOption = new Option(itemData.gatewayResponseCode,val,false,false);
		}
  try{
		encDDL.add(encOption,null);
	}catch(e){
		encDDL.add(encOption,-1);
	}             
  }); 
}


function hirarchyNameList(contextPath,target,selected){
	//alert('loadAdd2bccccccc');
	jQuery.ajax({
	url : contextPath,
	type : getMethod,
	datatype : 'json',
	success : function(data) {
		arrhirarchy =data.response;
		setHirarchyNameList(arrhirarchy,target,selected);						
	}
});	
}
function setHirarchyNameList(arrhirarchy1,target,selected){
var encDDL;
	var encOption;
	var encOption1;
	encDDL = document.getElementById(target);
	jq.each(arrhirarchy1, function(i, itemData) {
	//var val=itemData.groupId+"-"+itemData.groupName;
	
	if(null != selected && selected !='undefined'&& selected==itemData.groupName)
			//encOption = new Option(itemData.groupName,val,false,true);
			encOption = new Option(itemData.subRoleName,itemData.roleGroupId,false,true);
	
		else{
		encOption = new Option(itemData.groupName,val,false,false);
		}
  try{
		encDDL.add(encOption,null);
	}catch(e){
		encDDL.add(encOption,-1);
	}             
  }); 
}
	
	
	// function for validation of float value
	function isFloat(val)
	{
		var charCode = (val.which) ? val.which : event.keyCode;
		if (charCode > 31 && (charCode < 48 || charCode > 57) && (charCode != 46))
			return false;
		
		return true;
	}

	
	function LTrim(value) {	
		var re = /\s*((\S+\s*)*)/;
		return value.replace(re, "$1");	
	}

	// Removes ending whitespaces
	function RTrim(value) {	
		var re = /((\s*\S+)*)\s*/;
		return value.replace(re, "$1");	
	}

	// Removes leading and ending whitespaces
	function trim(value) {
		if(value != null && value != '' && value != undefined)
			return LTrim(RTrim(value));
		else
			return '';
	}
	
	function setStateValues(countryVal,target,stateLbl,contextPath,channel){
	var country = document.getElementById(countryVal).value;
	if(country <=1 || "" == country || null == country){
		document.getElementById(target).selectedIndex = 0;
		document.getElementById(target).disabled = true;
		document.getElementById(stateLbl).style.display = "none";
		isStateAvailable = false;
	}else{
		jQuery.ajax({
			url: contextPath+'/app/'+channel+'/stateListByCountry?countryId='+country,
			type: 'GET',
			datatype: 'json',
			success: function (data) {
				$(document.getElementById(target)).empty();
				setState(data.response,target);
				if(""!= data.response){
					document.getElementById(target).disabled = false;
					document.getElementById(stateLbl).style.display = "block";
					isStateAvailable = true;
				}else{
					document.getElementById(target).disabled = true;
					document.getElementById(stateLbl).style.display = "none";
					isStateAvailable = false;
				}
			}
		});
	}
} 	

	function setVTStateValues(countryVal,target,stateLbl,contextPath,channel,flag,indica,selected){
		var country = document.getElementById(countryVal).value;
		if(indica!=null && indica!='')
			country=indica;
		var arr=country.split("-");
		country=arr[1];
		if(country <=1 || "" == country || null == country){
			document.getElementById(target).selectedIndex = 0;
			document.getElementById(target).disabled = true;
			document.getElementById(stateLbl).style.display = "none";
			isStateAvailable = false;
		}else{
			jQuery.ajax({
				url: contextPath+'/app/'+channel+'/stateListByCountry?countryId='+country,
				type: 'GET',
				datatype: 'json',
				success: function (data) {
					$(document.getElementById(target)).empty();
					setVTState(data.response,target,selected);
					if(""!= data.response){
						document.getElementById(target).disabled = false;
						document.getElementById(stateLbl).style.display = "block";
						isStateAvailable = true;
						document.getElementById(flag).value=isStateAvailable;
					}else{
						document.getElementById(target).disabled = true;
						document.getElementById(stateLbl).style.display = "none";
						isStateAvailable = false;
						document.getElementById(flag).value=isStateAvailable;
					}
				}
			});
		}
	}

function compareToToday(date){
	var array = date.split("-");
	var from_mm = Number(array[0]);
	var from_dd = Number(array[1]);
	var from_yyyy = Number(array[2]);
	var fd = new Date();
	fd.setFullYear(from_yyyy,from_mm-1,from_dd);
	var today = new Date();
	var flag=false;
	if(fd>today)
		flag=true;
	return flag;
}

function isPastDate(date){
	var array = date.split("-");
	var from_mm = Number(array[0]);
	var from_dd = Number(array[1]);
	var from_yyyy = Number(array[2]);
	var fd = new Date();
	fd.setFullYear(from_yyyy,from_mm-1,from_dd);
	var today = new Date();
	var flag=false;
	if(fd<today)
		flag=true;
	return flag;
}
	
function isToday(date){
	var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1; //January is 0!
    var yyyy = today.getFullYear();
    if(dd<10)
    	dd='0'+dd;
    if(mm<10)
    	mm='0'+mm;
    var today = mm+'-'+dd+'-'+yyyy;
    var flag = false;
	if(date == today)
		flag = true;
	return flag;
}

function startAndEndDate(startDate,endDate) {
	var fromArray = startDate.split("/");
	var from_mm = Number(fromArray[0]);
	var from_dd = Number(fromArray[1]);
	var from_yyyy = Number(fromArray[2]);

	var toArray = endDate.split("/");
	var to_mm = Number(toArray[0]);
	var to_dd = Number(toArray[1]);
	var to_yyyy = Number(toArray[2]);

	var fd = new Date();
	fd.setFullYear(from_yyyy,from_mm-1,from_dd);

	var td = new Date();
	td.setFullYear(to_yyyy,to_mm-1,to_dd);
	var flag=false;
	if(td<fd)
		flag=true;
	return flag;
}

function valStartAndEndDate(startDate,endDate) {
	var fromArray = startDate.split("-");
	var from_mm = Number(fromArray[0]);
	var from_dd = Number(fromArray[1]);
	var from_yyyy = Number(fromArray[2]);

	var toArray = endDate.split("-");
	var to_mm = Number(toArray[0]);
	var to_dd = Number(toArray[1]);
	var to_yyyy = Number(toArray[2]);

	var fd = new Date();
	fd.setFullYear(from_yyyy,from_mm-1,from_dd);

	var td = new Date();
	td.setFullYear(to_yyyy,to_mm-1,to_dd);
	var flag=false;
	if(td<fd)
		flag=true;
	return flag;
}
function replaceAll(find, replace, str) {
  return str.replace(new RegExp(find, 'g'), replace);
}
function valStartAndEndDateTime(startDate, endDate) {
	var startDate1 =  startDate.split(" ");
	var fromArray = startDate1[0].split("-");
	var from_mm = Number(fromArray[0]);
	var from_dd = Number(fromArray[1]);
	var from_yyyy = Number(fromArray[2]);

	var endDate1 =  endDate.split(" ");
	var toArray = endDate1[0].split("-");
	var to_mm = Number(toArray[0]);
	var to_dd = Number(toArray[1]);
	var to_yyyy = Number(toArray[2]);

	var fd = new Date();
	fd.setFullYear(from_yyyy,from_mm-1,from_dd);

	var td = new Date();
	td.setFullYear(to_yyyy,to_mm-1,to_dd);
	var flag=false;
	if(td<fd)
		flag=true;	
	else if(td-fd == 0){
		if(Number(replaceAll(":","",endDate1[1])) < Number(replaceAll(":","",startDate1[1])))
			flag= true;
	}
	return flag;
}

function setStateValuesNew(countryVal,target,stateLbl,contextPath,channel,selected){
	
	var country = document.getElementById(countryVal).value;
if(country <=1 || "" == country || null == country){
	document.getElementById(target).selectedIndex = 0;
	document.getElementById(target).disabled = true;
	document.getElementById(stateLbl).style.display = "none";
	isStateAvailable = false;
}else{
	jQuery.ajax({
		url: contextPath+'/app/'+channel+'/stateListByCountry?countryId='+country,
		type: 'GET',
		datatype: 'json',
		success: function (data) {
			$(document.getElementById(target)).empty();
			setStateNew(data.response,target,selected);
			if(""!= data.response){
			document.getElementById(target).disabled = false;
			document.getElementById(stateLbl).style.display = "block";
			isStateAvailable = true;
			}else{
			document.getElementById(target).disabled = true;
			document.getElementById(stateLbl).style.display = "none";
			isStateAvailable = false;
			}
		}
	});
}
} 	

function setStateNew(arrCountry1,target,selected){
	var encDDL;
  	var encOption;
  	encDDL = document.getElementById(target);
  	encOption = new Option("------Select------",'',false,false);
  	encDDL.add(encOption,null);
  	jq.each(arrCountry1, function(i, itemData) {
  		if(null != selected && selected !='undefined'&& selected==itemData.stateId)
  			encOption = new Option(itemData.stateName,itemData.stateId,false,true);
  		else
  			encOption = new Option(itemData.stateName,itemData.stateId,false,false);
      try{
   		encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}             
      });
}


function setCorporateNew(arrCountry1,target,selected){
var encDDL;
	var encOption;
	encDDL = document.getElementById(target);
	encOption = new Option("------Select------",'',false,false);
	encDDL.add(encOption,null);
	jq.each(arrCountry1, function(i, itemData) {
		if(null != selected && selected !='undefined'&& selected==itemData.salesChannelCooperateId)
		encOption = new Option(itemData.cooperateCode,itemData.salesChannelCooperateId,false,true);
		else
		encOption = new Option(itemData.cooperateCode,itemData.salesChannelCooperateId,false,false);
  try{
		encDDL.add(encOption,null);
	}catch(e){
		encDDL.add(encOption,-1);
	}             
  });
}

function goToTop(){
	window.scrollTo(0, 150);
}

function upperValue(zipcode){
	var zip = document.getElementById(zipcode);
	zip.value = zip.value.toUpperCase();
}
function paymentInfoList(contextPath,target,selected){
	jQuery.ajax({
	url : contextPath,
	type : getMethod,
	contentType: 'application/json',
	datatype : 'json',
	success : function(data) {		
		arrpaymentInfoCode =data.response;
		setpaymentInfoList(arrpaymentInfoCode,target,selected);						
	}
});	
}
function setpaymentInfoList(arrpaymentInfoCode1,target,selected){
var encDDL;
	var encOption;
	var encOption1;
	encDDL = document.getElementById(target);
	encDDL.length = 0;
	encOption1 = new Option('------Select--------','',false,false);
	encDDL.add(encOption1,null);
	jq.each(arrpaymentInfoCode1, function(i, itemData) {
	//var val=itemData.numberOnCard;
	var val=itemData.customerpaymentinfoid;
	
	if(null != selected && selected !='undefined'&& selected==itemData.customerpaymentinfoid)
			encOption = new Option(itemData.paymentType+itemData.numberOnCard,val,false,true);
		else{
		encOption = new Option(itemData.paymentType+itemData.numberOnCard,val,false,false);
		}
  try{
		encDDL.add(encOption,null);
		
	}catch(e){
		
		encDDL.add(encOption,-1);
	}             
  }); 
}

function contractExecuteList(contextPath,target,selected){
	jQuery.ajax({
	url : contextPath,
	type : getMethod,
	datatype : 'json',
	contentType: 'application/json',
	success : function(data) {
		arrContractExCode =data.response;
		setContractExecuteList(arrContractExCode,target,selected);						
	}
});	
}
function setContractExecuteList(arrContractExCode1,target,selected){
var encDDL;
	var encOption;
	var encOption1;
	encDDL = document.getElementById(target);
	
	encOption1 = new Option('------Select--------','',false,false);
	encDDL.add(encOption1,null);
	jq.each(arrContractExCode1, function(i, itemData) {
		val=itemData.contractExecuteId;
		
	if(null != selected && selected !='undefined'&& selected==itemData.contractExecuteId){
		
			encOption = new Option(itemData.contractExecuteName,val,false,true);
	}else{
		encOption = new Option(itemData.contractExecuteName,val,false,false);
		}
  try{
		encDDL.add(encOption,null);
		
	}catch(e){
		
		encDDL.add(encOption,-1);
	}             
  }); 
}
function currencyList1(contextPath,target,selected){
	jQuery.ajax({
		url : contextPath,
		type : getMethod,
		datatype : 'json',
		success : function(data) {
			arrCurrencyCode =data.response;
			setCurrency1(arrCurrencyCode,target,selected);						
		}
	});	
}
function setCurrency1(arrCurrency2,target,selected){
	var encDDL;
	var encOption;
	var encOption1;
	encDDL = document.getElementById(target);
  	encOption1 = new Option('------Select--------','',false,false);
  	encDDL.add(encOption1,null);
  	jq.each(arrCurrency2, function(i, itemData) {
		
  		var val=itemData.currencyId;
  		 
  		if(null != selected && selected !='undefined'&& selected==itemData.currencyId){
  			
  				encOption = new Option(itemData.charCode,val,false,true);
  		}else{
  			encOption = new Option(itemData.charCode,val,false,false);
  			}
  	  try{
  			encDDL.add(encOption,null);
  			
  		}catch(e){
  			
  			encDDL.add(encOption,-1);
  		}             
  	  }); 
 
}

function currencyList2(contextPath, target, selected1, selected2)
{
	jQuery.ajax({
		url : contextPath,
		type : getMethod,
		datatype : 'json',
		success : function(data)
		{
			arrCurrencyCode = data.response;
			setCurrency2(arrCurrencyCode, target, selected1, selected2);						
		}
	});	
}
function setCurrency2(arrCurrencyCode,target, selected1, selected2)
{
	var encDDL;
	var encDDL1=0;
	var encDDL2=0;
	var encOption=null;
	var encOption1=null;
	var encOption2=null;
	
	encDDL = document.getElementById(target);
	if(selected1!=null)
		encDDL1 = document.getElementById(selected1);
	if(selected2!=null)
		encDDL2 = document.getElementById(selected2);
	
	jq.each(arrCurrencyCode, function(i, itemData)
	{
		encOption = new Option(itemData.charCode, itemData.currencyId, false, false);
		if(null != selected1){
			encOption1 = new Option(itemData.charCode, itemData.currencyId, false, false);
		}
		if(null != selected2){
			encOption2 = new Option(itemData.charCode, itemData.currencyId, false, false);
		}

		try
		{
			encDDL.add(encOption,null);
			if(selected1!=null){
				encDDL1.add(encOption1,null);
			}
			if(selected2!=null){
				encDDL2.add(encOption2,null);
			}
		}
		catch(e)
		{
			encDDL.add(encOption,-1);
			if(selected1!=null)
				encDDL1.add(encOption1,-1);
			if(selected2!=null)
				encDDL2.add(encOption2,-1);
		}             
	}); 
}

function setZipMark(countryId,zipLabel){
	var countryObj = document.getElementById(countryId);
	var	countryName = countryObj.options[countryObj.selectedIndex].text;
	if(countryName == "Australia" || countryName == "Canada" || countryName == "France" || countryName == "Germany" || countryName == "India" || countryName == "Japan" || countryName == "United States" || countryName == "United Kingdom"){
		document.getElementById(zipLabel).style.display = "block";
	}else{
		document.getElementById(zipLabel).style.display = "none";
	}
}

function blockTypeList(contextPath,target){
	jQuery.ajax({
		url : contextPath,
		type : getMethod,
		datatype : 'json',
		success : function(data) {
			setBlockType(data.response,target);						
		}
	});	
}
function setBlockType(arrBlockType,target){
	var encDDL;
	var encOption;
	encDDL = document.getElementById(target);
  	jq.each(arrBlockType, function(i, itemData) {
		encOption = new Option(itemData.blockValue,itemData.blockId,false,false);
		try{
			encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}
   	}); 
}

function merchantIdList(contextPath,target,selected){
	var arrMerchantId = [];
	jQuery.ajax({
		url : contextPath,
		type : 'GET',
		datatype : 'json',
		success : function(data) {
			arrMerchantId = data.response;
			setMerchantId(arrMerchantId,target,selected);						
		}
	});	
}
function setMerchantId(arrMerchantId1,target,selected){
	var encDDL;
  	var encOption;
  	encDDL = document.getElementById(target);
   	jq.each(arrMerchantId1, function(i, itemData) {
   	
   		if(null != selected && selected !='undefined'&& selected==itemData.merchantIdCode){
   			encOption = new Option(itemData.merchantIdName,itemData.merchantIdCode,false,true);
   		}
   		else{
   			encOption = new Option(itemData.merchantIdName,itemData.merchantIdCode,false,false);
   		}
	    try{
	   		encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}            
   	}); 
}

function tabFocus(obj){
	document.getElementById(obj).focus();
}
function focusElement(targ){
	document.getElementById(targ).focus();
}
function changetoStndValue(obj)
{
	var commission = document.getElementById(obj).value;
	if(commission.indexOf('') == 0 )
	{
		 if(commission.indexOf('.') == 0){
			commission = '0'+commission;
		}
		else{
		commission = commission;
		}
		document.getElementById(obj).value = commission;
		
	}
}
function setTxnStatusList(arrStatus,target){
	var encDDL;
	var encOption;
	encDDL = document.getElementById(target);
	encDDL.length = 0;
	encOption = new Option("------Select------");
  	encDDL.add(encOption,null);
  	jq.each(arrStatus, function(i, itemData){
	   	encOption = new Option(itemData);
		try{
	   		encDDL.add(encOption,null);
		}catch(e){
			encDDL.add(encOption,-1);
		}
	});
}
function countryAreaList(contextPath,target,selected){
	jQuery.ajax({
		url : contextPath,
		type : getMethod,
		datatype : 'json',
		success : function(data) {
			arrCountryCode = data.countryCode;
			setCountryAreaCode(arrCountryCode,target,selected);						
		}
	});	
}
function setCountryAreaCode(arrCountry2,target,selected){
	var encDDL;
  	var encOption;
  	encDDL = document.getElementById(target);
   	jq.each(arrCountry2, function(i, itemData) {
   	
   		if(null != selected && selected !='undefined'&& selected==itemData.countryAreaCode){
   			encOption = new Option(itemData.countryAreaCode,itemData.countryAreaCode,false,true);
   		}
   		else{
   			encOption = new Option(itemData.countryAreaCode,itemData.countryAreaCode,false,false);
   		}
      try{
   		encDDL.add(encOption,null);
		}catch(e){
			//encDDL.add(encOption,-1);
		}             
      }); 
}
function countryAreaFundingList(contextPath,target,target1){
	jQuery.ajax({
		url : contextPath,
		type : getMethod,
		datatype : 'json',
		success : function(data) {
			arrCountry3 = data.countryCode;
			setCountryAreaCodeFunding(arrCountry3,target,target1);						
		}
	});	
}
function setCountryAreaCodeFunding(arrCountry3,target,target1){
	var encDDL;
	var encDDL1;
  	var encOption;
	var encOption1;
  	encDDL = document.getElementById(target);
  	if(target1!=null)
  	encDDL1 = document.getElementById(target1);
   	jq.each(arrCountry3, function(i, itemData) {
   	encOption = new Option(itemData.countryAreaCode,itemData.countryAreaCode,false,false);
   	if(target1!=null)
   	encOption1 = new Option(itemData.countryAreaCode,itemData.countryAreaCode,false,false);
      try{
   		encDDL.add(encOption,null);
   		if(target1!=null)
   		encDDL1.add(encOption1,null);
      }catch(e){
			encDDL.add(encOption,-1);
			if(target1!=null)
			encDDL1.add(encOption1,-1);
		}             
      }); 
}
