
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<script type="text/javascript">
	var specialCharacters = /^.*(?=.*[~`!@#$%^&*()_+-=\{}|:;,.?\[\]\>\""\\]).*$/;
	var specialCharAddr = /^.*(?=.*[~`'!@$%^&*()_+=\{}|:;?\[\]\>\""\\]).*$/;
	var specialCharNum = /^.*(?=.*[0-9~`!@#$%^&*()_+-=\{}|:;,.?\[\]\>\""\\]).*$/;
	var doubleSpace = /^.*(\s{2}).*$/;
	
	function isValidName(nameVal)
	{
		var name = /^([a-zA-Z0-9_\x81-\xFF]+\s?)+[a-zA-Z0-9_\x81-\xFF]+$/;
		if (!nameVal.match(name)){
			return true;
		}
		return false;
	}
	
	function isValidAddress(addressVal)
	{
		var name = /^([^!$%^@()&*=+|?<>\\\\`~{}\\[\\];:]+\s?)+[^!$%^@()&*=+|?<>\\\\`~{}\\[\\];:]+$/;
		if (!addressVal.match(name)){
			return true;
		}
		return false;
	}
	
/*** This function has been used for validation for Zipcode field in Bank, Corporate, User, Merchant, Customer and Virtual Terminal modules. ***/	
	function validateZipCode(countryName, zipcode, errMsg){
		var flag = true;

		if(countryName == "Australia" || countryName == "Canada" || countryName == "France" || countryName == "Germany" || countryName == "India" || countryName == "Japan" || countryName == "United States" || countryName == "United Kingdom"){
			if(zipcode == '' || null == zipcode){
				errMsg.html('<p class=error><spring:message code="script.error.Zipcode"/></p>');
				return false;
			}
		}
		if(countryName == "India"){
			if(!zipcode.match(/^([0-9])+$/) || zipcode.length != 6){
				errMsg.html('<p class=error><spring:message code="script.error.ZipcodePatternIndia"/></p>');
				flag = false;
				return;
			}
		}else if(countryName == "Australia"){
			if(!zipcode.match(/^([0-9])+$/) || zipcode.length != 4){
				errMsg.html('<p class=error><spring:message code="script.error.ZipcodePatternAustralia"/></p>');
				flag = false;
				return;
			}
		}else if(countryName == "Canada"){
			if(!zipcode.match(/^([A-Z]{1}[0-9]{1}[A-Z]{1}\s[0-9]{1}[A-Z]{1}[0-9]{1})$/) || zipcode.length != 7){
				errMsg.html('<p class=error><spring:message code="script.error.ZipcodePatternCanada"/></p>');
				flag = false;
				return;
			}
		}else if(countryName == "France" || countryName == "Germany"){
			if(!zipcode.match(/^([0-9])+$/) || zipcode.length != 5){
				errMsg.html('<p class=error><spring:message code="script.error.ZipcodePatternFranceGermany"/></p>');
				flag = false;
				return;
			}
		}else if(countryName == "Japan"){
			if(zipcode.length==7){
				if(!zipcode.match(/^([0-9])+$/)){
					errMsg.html('<p class=error><spring:message code="script.error.ZipcodePatternJapan"/></p>');
					flag = false;
					return;
				}
			}else if(zipcode.length==8){
				if(!zipcode.match(/^([0-9]{3}\-[0-9]{4})$/)){
					errMsg.html('<p class=error><spring:message code="script.error.ZipcodePatternJapan"/></p>');
					flag = false;
					return;
				}
			}else{
				errMsg.html('<p class=error><spring:message code="script.error.ZipcodeLengthJapan"/></p>');
				flag = false;
				return;
			}
		}else if(countryName == "United Kingdom"){
			if(zipcode.length < 6 || zipcode.length > 8){
				errMsg.html('<p class=error><spring:message code="script.error.ZipcodeLengthUK"/></p>');
				flag = false;
				return;
			}else if(!zipcode.match(/^([0-9A-Z]{2,4})\s([0-9]{1}[A-Z]{2})$/)){
				errMsg.html('<p class=error><spring:message code="script.error.ZipcodePatternUK"/></p>');
				flag = false;
				return;
			}
			
		}else if(countryName == "United States"){
			if(zipcode.length==5){
				if(!zipcode.match(/^([0-9])+$/)){
					errMsg.html('<p class=error><spring:message code="script.error.ZipcodePatternUS"/></p>');
					flag = false;
					return;
				}
			}else if(zipcode.length==10){
				if(!zipcode.match(/^([0-9]{5}\-[0-9]{4})$/)){
					errMsg.html('<p class=error><spring:message code="script.error.ZipcodePatternUS"/></p>');
					flag = false;
					return;
				}
			}else{
				errMsg.html('<p class=error><spring:message code="script.error.ZipcodeLengthUS"/></p>');
				flag = false;
			//	return;
			}
		}else{
			if(!zipcode.match(/^([A-Z0-9\-\s]+)$/) && zipcode != ''){
				errMsg.html('<p class=error><spring:message code="script.error.ZipcodeAplphanumerics"/></p>');
				flag = false;
			}
		}
		return flag;
	}
	
	function isValidCreditCard(type, ccnum) {
		   if (type == "3457777408") {
		      // Visa: length 16, prefix 4, dashes optional.
		      var re = /^4\d{3}-?\d{4}-?\d{4}-?\d{4}$/;
		   } else if (type == "3457777409") {
		      // Mastercard: length 16, prefix 51-55, dashes optional.
		      var re = /^5[1-5]\d{2}-?\d{4}-?\d{4}-?\d{4}$/;
		   }
		   if (!re.test(ccnum)) return false;
		   // Remove all dashes for the checksum checks to eliminate negative numbers
		   ccnum = ccnum.split("-").join("");
		   // Checksum ("Mod 10")
		   // Add even digits in even length strings or odd digits in odd length strings.
		   var checksum = 0;
		for (var i=(2-(ccnum.length % 2)); i<=ccnum.length; i+=2) {
			checksum += parseInt(ccnum.charAt(i-1));
		}
		   // Analyze odd digits in even length strings or even digits in odd length strings.
		for (var i=(ccnum.length % 2) + 1; i<ccnum.length; i+=2) {
			var digit = parseInt(ccnum.charAt(i-1)) * 2;
			if (digit < 10) { checksum += digit; } else { checksum += (digit-9); }
		}
		if ((checksum % 10) == 0)
			return true;
		else
			return false;
	}
/*** This function has been used for validation for City field in Bank, Corporate, User, Customer, Merchant and Virtual Terminal modules. ***/	
	function validateCity(city, errMsg){
		var flag = true;
		city = trim(city);
		if (city == '') {
			errMsg.html('<p class=error><spring:message code="script.error.City"/></p>');
	 		flag = false;
			return;
		} else if (trim(city).length < 2) {
			errMsg.html('<p class=error><spring:message code="script.error.CityMinLength"/></p>');
	 		flag = false;
			return;
		} else if (city.length > 25) {
			errMsg.html('<p class=error><spring:message code="script.error.CityMaxLength"/></p>');
	 		flag = false;
			return;
		} else if (city.match(specialCharacters) || city.match(doubleSpace)){
			errMsg.html('<p class=error><spring:message code="script.error.CityPattern"/></p>');
	 		flag = false;
			return;
		}
		
		return flag;
	}
	
/*** This function has been used for validation for Address1 field in Bank, Corporate, User, Merchant and Virtual Terminal modules. ***/	
	function validateAddress1(address, errMsg){
		var flag = true;
		address = trim(address);
		
		if (address == '') {
			errMsg.html('<p class=error><spring:message code="script.error.Address1"/></p>');
	 		flag = false;
			return;
		} else if (address.length > 100) {
			errMsg.html('<p class=error><spring:message code="script.error.Address1MaxLength"/></p>');
	 		flag = false;
			return;
		} else if(address.search('\n') != -1){
			address = address.replace(/\n/g, 'a');
			if(address.match(specialCharAddr) || address.match(doubleSpace)){
				errMsg.html('<p class=error><spring:message code="script.error.Address1AlphaNumeric"/></p>');
				flag = false;
				return;
			}
		} else if(address.match(specialCharAddr) || address.match(doubleSpace)){
			errMsg.html('<p class=error><spring:message code="script.error.Address1AlphaNumeric"/></p>');
			flag = false;
			return;
		}
		return flag;
	}
	
/*** This function has been used for validation for Address2 field in Bank, Corporate, User, Merchant modules and Virtual Terminal modules. ***/	
	function validateAddress2(address, errMsg){
		var flag = true;
		address = trim(address);
		
		if (address.length > 100) {
			errMsg.html('<p class=error><spring:message code="script.error.Address2MaxLength"/></p>');
	 		flag = false;
			return;
		} else if(address.search('\n') != -1){
			address = address.replace(/\n/g, 'a');
			if(address.match(specialCharAddr) || address.match(doubleSpace)){
				errMsg.html('<p class=error><spring:message code="script.error.Address2AlphaNumeric"/></p>');
				flag = false;
				return;
			}
		} else if(address.match(specialCharAddr) || address.match(doubleSpace)){
			errMsg.html('<p class=error><spring:message code="script.error.Address2AlphaNumeric"/></p>');
			flag = false;
			return;
		}
		return flag;
	}
	
/*** This function has been used for validation for Beneficial Address field in KYC (Merchant) module. ***/	
	function validateAddress(address, errMsg){
		var flag = true;
		address = trim(address);
		
		if (address.length > 100) {
			errMsg.html('<p class=error><spring:message code="script.error.PleaseEnterBeneficialOwnerAddress"/></p>');
	 		flag = false;
			return;
		} else if (address.length > 100) {
			errMsg.html('<p class=error><spring:message code="script.error.BeneficialOwnerAddressShouldBeLessthan100Characters"/></p>');
	 		flag = false;
			return;
		} else if(address.search('\n') != -1){
			address = address.replace(/\n/g, 'a');
			if(address.match(specialCharAddr) || address.match(doubleSpace)){
				errMsg.html('<p class=error><spring:message code="script.error.BeneficialOwnerAddressAlphanumerics"/></p>');
				flag = false;
				return;
			}
		} else if(address.match(specialCharAddr) || address.match(doubleSpace)){
			errMsg.html('<p class=error><spring:message code="script.error.BeneficialOwnerAddressAlphanumerics"/></p>');
			flag = false;
			return;
		}
		return flag;
	}
	
/*** This function has been used for validation for Email field in Bank, Corporate, User, Customer, My Profile and Processor modules. 
 * This function has not been used for Merchant module due to the difference in Error Message.
***/
	function validateEmail(email, errMsg){
		var flag = true;
		var pattern = /^([a-zA-Z0-9_.\-\\'])+@([a-zA-Z0-9_.-])+\.([a-zA-Z])+([a-zA-Z])+$/;
		var filter = /^([a-zA-Z0-9_\.\-\\'])+\@(([a-zA-Z0-9\-])+\.){1,3}([a-zA-Z0-9]{2,4})+$/;
		var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		if (email == ''){
			errMsg.html('<p class=error><spring:message code="script.error.EnterEmail"/></p>');
	 		flag = false;
			return;
		}else if(!pattern.test(email)){
			errMsg.html('<p class=error><spring:message code="script.error.InvalidEmail"/></p>');
	 		flag = false;
			return;
		}else if(!filter.test(email)){
			errMsg.html('<p class=error><spring:message code="script.error.InvalidEmail"/></p>');
	 		flag = false;
			return;
		}
		return flag;
	}
	
/*** This function has been used for validation for Area Code field in Bank, Corporate, User and My Profile modules. 
 * This function has not been used for Merchant module(Level 1 & Level 2, only in case of empty) due to the difference in Error Message.
 ***/	
	function validateAreaCode(areaCode, errMsg){
		var flag = true;
		if(areaCode == ''){
			errMsg.html('<p class=error><spring:message code="script.error.AreaCodeManageBanks"/></p>');
			flag = false;
			return;
		}else if (!areaCode.match(/^([0-9])+$/)) {
			errMsg.html('<p class=error><spring:message code="script.error.AreaCodePattern"/></p>');
			flag = false;
			return;
		}else if (areaCode != '' && areaCode[0] == 0) {
			errMsg.html('<p class=error><spring:message code="script.error.InvalidAreaCode"/></p>');
			flag = false;
			return;
		}
		return flag;
	}
	
/*** This function has been used for validation for Phone Number field in Bank, Corporate, User and My Profile modules. 
 * This function has not been used for Merchant module due to the difference in Error Message.
 ***/	
	function validatePhoneNumber(phoneNumber, errMsg){
		var flag = true;

		if(phoneNumber == ''){
			errMsg.html('<p class=error><spring:message code="script.error.PhoneNumb"/></p>');
			flag = false;
			return;
		}else if (phoneNumber.length < 6) {
			errMsg.html('<p class=error><spring:message code="script.error.PhoneNumbMinLength"/></p>');
			flag = false;
			return;
		}else if (!phoneNumber.match(/^([0-9])+$/)) {
			errMsg.html('<p class=error><spring:message code="script.error.PhoneNumberPattern"/></p>');
			flag = false;
			return;
		}else if (phoneNumber[0] == 0) {
			errMsg.html('<p class=error><spring:message code="script.error.ContactNoManageUser"/></p>');
			flag = false;
			return;
		}
		return flag;
	}
/*
 * Validation for amount 
 * Done in TransactionSearch
*/
	function amountCheck(amount){
		var flag = true;
		if(isNaN(amount) || (amount.length-1 == amount.lastIndexOf('.') || amount.indexOf('.') == 0))
			flag = false;
		return flag;
	}
	
	function validateURL(value){
		var urlregex = new RegExp("^((http|ftp|https|ftps)://|(www|ftp|)\.)[a-z]+(\.[a-z0-9]+)+\.[a-z]+([/?].*)?$");
		var urlregexIp = new RegExp("^((((http?|https|ftp|ftps)://)|)(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5]))+$)");
		var urlregexPort = new RegExp("^(:[0-9][0-9][0-9][0-9][0-9]?([/?].*)?$)");
		var specialCharSpace1 = /^.*(?=.*[~`!@#$%^&*()+-=\{}|;,?\[\]\>\""\\\s]).*$/;
		var urlCharSpace = /^.*(?=.*[~`!@#$%^&*+=?;,|(){}\[\]\<\>\\\s]).*$/;
		
		if(value.match(urlCharSpace)){
			return false;
		}
		else if(value.split(".").length <= 1)
		{
			return false;
		}
		else if(value.split(":").length-1 <= 1)
		{
			
			if(urlregex.test(value) || urlregexIp.test(value) )
			{
				return true;
			}
		}
		else
		{
			if(urlregexIp.test(value.substr(0,value.lastIndexOf((':'))) ) ) 
			{
				var a1= value.substr(value.lastIndexOf((':')));
				var a2 = value.substr(a1.indexOf('/'));
			//	if(urlregexPort.test(a1) && !a2.contains('<') && !a2.contains('>') && !a2.contains('\\'))
				if(urlregexPort.test(a1) && (a2.indexOf('<') == -1) && (a2.indexOf('>') == -1) && (a2.indexOf('\\') == -1))
				{
					return true;
				}
			}
		}
		return false;
	}
	
	function cardValidation(s){
		
		var j = s.length;
		var s1 = new Array(j);		
		for (var i = 0; i < s.length; i++)
			s1[i] = "" + s.charAt(i);
		
		var checksum = 0;

		for (var i = s1.length - 1; i >= 0; i -= 2) {
			var k = 0;
			if (i > 0) {
				k = parseInt(s1[i - 1]) * 2;
				if (k > 9) {
					var s = "" + k;
					k = parseInt(s.substring(0, 1)) + parseInt(s.substring(1));
				}
				checksum += parseInt(s1[i]) + k;
			} else
				checksum += parseInt(s1[0]);
		}
		return ((checksum % 10) == 0);
	}
	
	function closePopUpCredit()
	{
		$('#fade1 , .popup_block2').fadeOut("fast", function() {
		});
		return false;
	}
	
	function countChar(val) {
	    var len = val.value.length;
	    if (len >= 100) {
	      val.value = val.value.substring(0, 100);
	    }
	  };
	  
	  function textAreaLength(val,maxlen) {
		    var len = val.value.length;
		    if (len >= maxlen) {
		      val.value = val.value.substring(0, maxlen);
		    }
		  };
	/**
	 * this method will disallow all zero
	 */
    function checkAllZeroRestriction(value, length){
    	var allZeroValue = '';
    	for(var i =0; i< length;i++){
    		allZeroValue = allZeroValue + '0';
    	}
    	if(allZeroValue == value){
    		return true;
    	}else{
    		return false;
    	}
    }
	
	function disableCtrl(){
		document.oncopy=new Function("return false");
		document.onpaste=new Function("return false");
	}
	
</script>