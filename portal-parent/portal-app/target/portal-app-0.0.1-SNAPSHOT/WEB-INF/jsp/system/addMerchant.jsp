<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />
<c:set var="configSize" value="<%=session.getAttribute(\"CONFIG_SIZE\")%>" />
<c:set var="errorMessage" value="<%=request.getAttribute(\"errorMessage\")%>" />
<c:set var="stateId" value="<%=request.getAttribute(\"stateId\")%>" />
<c:set var="CorporateId" value="<%=request.getAttribute(\"CorporateId\")%>" />
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title><spring:message code="title.AddMerchant"/></title>
	<jsp:include page="../common/stylesheets.jsp"/>
	<jsp:include page="../common/scripts.jsp"/>
	
    <link rel="stylesheet" href="${contextPath}/system-file/css/calender.css" />
    
    <script type="text/javascript" src="${contextPath}/system-file/jquery/jquery.jqGrid.min.js"></script>
    <script type="text/javascript" src="${contextPath}/system-file/js/CommonDropDowns.js"></script>
    <script type="text/javascript" src="${contextPath}/system-file/js/jquery.ui.datepicker.js"></script>
	<link href="${contextPath}/system-file/css/jquery.ui.datepicker.css" rel="stylesheet" type="text/css" />
    
<%--     <script type="text/javascript">
		urlValue='${contextPath}/dcs/manageMerchant/getList';
		<%if(null != request.getParameter("corporateCode") && request.getParameter("corporateId") != null){%>
		var corpCode='<%=request.getParameter("corporateCode")%>';
		var corpId='<%=request.getParameter("corporateId")%>';
		urlValue='${contextPath}/dcs/manageMerchant/getList?corporateCode='+corpCode+'&corporateId='+corpId;
		<%}%>
	</script> --%>
    
    <script type="text/javascript">
    //alert('aadd me s');
		var context = '${contextPath}/dcs';
		countryList(context+'/countryList','countryId');
		//countryAreaList(context+'/countryList','countryAreaList');
	</script>
	
	<script type="text/javascript">
	
	alert('aadd me s1');
		 var cntxPath = '${contextPath}';
		 <%--var stateId='${stateId}';
		var CorporateId='${CorporateId}';
		var isStateAvailable = false;
		jq(function() {
			<% if(request.getAttribute("errorMessage")!=null){%>
			$('#errorMsg1').html('<p class=error>'+ '<%=(String)request.getAttribute("errorMessage")%>'  + '</p><br>');
			setStateValuesNew('countryId','state','stateLbl',cntxPath,'manageMerchant',stateId);
			var creditCard='<%=request.getParameter("creditCard")%>';
            var debitCard='<%=request.getParameter("debitCard")%>';
             if(creditCard=='YES'){
            	 $("input[name='creditCardList']:checkbox").each(function (){
                     $(this).prop('disabled', false);
                 });
            }
            if(debitCard=='YES'){
            	 $("input[name='debitCardList']:checkbox").each(function (){
                     $(this).prop('disabled', false);
                 });
            } 
            
			<%}%>
		}); --%>
	</script>
	
	<script>
		$(function() {
			$("#validFrom").datepicker({dateFormat: "mm-dd-yy"});
		});
		$(function() {
			$("#validTo").datepicker({
				dateFormat: "mm-dd-yy",
				minDate :0
			});
		});
	</script>

	<script type="text/javascript">
	function enableDisableCheckBox(target){
        var sbmt = document.getElementById(target).checked;
        if(sbmt == true){
            document.getElementById(target).value = "YES";
            return false;
        }else {
            document.getElementById(target).value = "NO";
            return true;
        }
    }
		 function enableDisableCheckBoxList(target,obj){
			var sbmt = document.getElementById(target).checked;
			var listObj = document.getElementById(obj);
			var countryObj = document.getElementById('obj')
			if('creditCard' == target && sbmt==true) {
				$("input[name='creditCardList']:checkbox").each(function (){
	                $(this).prop('checked', false);
	                $(this).prop('disabled', false);
	            });
	                document.getElementById(target).value = "YES";
			}else if('creditCard' == target && sbmt==false) {
				$("input[name='creditCardList']:checkbox").each(function (){
                    $(this).prop('checked', false);
                    $(this).prop('disabled', true);
                });
                    document.getElementById(target).value = "NO";
			}
			
			if('debitCard' == target && sbmt==true) {
                $("input[name='debitCardList']:checkbox").each(function (){
                    $(this).prop('checked', false);
                    $(this).prop('disabled', false);
                });
                    document.getElementById(target).value = "YES";
            }else if('debitCard' == target && sbmt==false) {
                $("input[name='debitCardList']:checkbox").each(function (){
                    $(this).prop('checked', false);
                    $(this).prop('disabled', true);
                });
                    document.getElementById(target).value = "NO";
            }
		}
		
	    $(document).ready(function(){
	   /*  	var parentMidVal=document.getElementById("parentMid").value;
	    	if(parentMidVal==0){
	    		document.getElementById("parentMid").disabled = true;
				document.getElementById("parentMid").value = 0;
	    	} */
			//tabFocus('businessName');
		});    
		$(function() {
			$('input#cancel').click(
				function() {
					window.location = '${contextPath}/dcs/manageMerchant/manageMerchantPage';
				}
			);
		});
	
		function disableCustomName() {
			document.getElementById("customName").disabled = true;
			document.getElementById("customName").value = '';
			
		}
		
		function disableMid() {
			document.getElementById("parentMid").disabled = true;
			document.getElementById("parentMid").value = 0;
		}
		
		function enableMid() {
			document.getElementById("parentMid").disabled = false;
		}
		function enableCustomName() {
			document.getElementById("customName").disabled = false;
		}
	
		function changeCorporateList(bankVal,target,selected){
	    	var index = document.getElementById(bankVal).selectedIndex;
	    	var bankId = document.getElementById(bankVal).options[index].text;     
	 
	    	if(document.getElementById(bankVal).selectedIndex == 0)
	    	{
	    		document.getElementById(target).value="";
	    		document.getElementById(target).disabled=true;
   		 	}else{
	    		jQuery.ajax({
			    url: '${contextPath}/dcs/manageMerchant/corporateListBybankCode?bankId='+bankId,
			    type: 'GET',
			    datatype: 'json',
			    success: function (data) {
			    	if(null != data.errorMessage){
	 					$('#errorMsg').html('<p class=error>'+data.errorMessage+'</p><br>');
	 				}else{
				    	$(document.getElementById(target)).empty();
				    	setCorporateNew(data.response,target,CorporateId,selected);
	 				}
			    }});
	    		enable(target);
	  		}
		}; 
		function removeListItems(obj){
			var i;
			for(i=obj.options.length-1;i>=1;i--){
				obj.remove(i);
			}
	  	}
		
		
		
		

	</script>

</head>

<body class="merchant" >
<%-- <jsp:include page="merchantValidation.jsp"/> --%>
<jsp:include page="../common/header.jsp"/>

<div class="container_12"> 
	<div class="grid_12">
		<p class="breadcrumb">
			<a href="#" class="breadcrumblink_no"><spring:message code="menu_link.Configuration"/></a>
			<a href="#" class="breadcrumblink_no"><spring:message code="menu_link.MerchantConfiguration"/></a>
			<a href="${contextPath}/doc/manageMerchant/manageMerchantPage" class="breadcrumblink"><spring:message code="menu_link.ManageMerchants"/></a>
			<spring:message code="label.AddMerchant"/>
		</p>
	</div>
</div>
	
<div class="container_12"> 
	
	<div class="grid_12">
		<div class="box box-100 altbox">
			<div class="header" id="collapse" style="overflow: hidden;"><h3><spring:message code="label.AddMerchant"/></h3></div>
			<br/>
		</div>
		<form:form id="merchantForm" name="addMerchForm" method="POST" commandName="addMerchant" action="${contextPath}/doc/manageMerchant/saveMerchant">
			<div id="errorMsg1" class="displayErrMsg"></div>
			<div class="box box-100 altbox" id="box1">
				<div class="boxinNew">
					<div class="content" id="box1-tabular" style="width:100%!important;"><!-- content box 1 for tab switching -->
						<fieldset style="width:100%!important;">
							<table id="gridNew" border="0" width="100%">
								<tr>
									<td><spring:message code="label.BusinessName"/>:<span style="color: #ff0000">*</span></td>
									<td><form:input class="txt_width" path="businessName" name ="businessName" id="businessName" maxlength="25" tabindex="1"/></td>
									<td><spring:message code="label.DisplayName"/>:<span style="color: #ff0000">*</span></td>
									<td><form:input class="txt_width" path="dispalyName" name ="dispalyName" id="dispalyName" maxlength="25" tabindex="2"/></td>
									<td></td>
								</tr>
								
							</table>
						</fieldset>
						</div>
					</div>
				</div>
				
				<div class="box box-100 altbox" id="box1" style="margin-top: 1%">
					<div id="errorMsg2" class="displayErrMsg"></div>
					<div class="boxinNew">
						<div class="header" id="collapse" style="overflow: hidden;">
							<h3><spring:message code="label.LicenseValidity"/></h3>
							<span style="float: right; padding-right: 20px; padding-top: 2px;">
								<img style="visibility: hidden;" src="${contextPath}/system-file/images/add.png" />
							</span>
						</div>
						<div class="content" id="box1-tabular" style="width:100%!important;">
							<fieldset style="width:100%!important;">
								<table id="gridNew" border="0" width="100%">
									<tr>
										<%-- <td><spring:message code="label.ValidTo"/>:<span style="color: #ff0000">*</span></td>
										<td><form:input class="txt_width" path="validTo" id="validTo" value="" tabindex="30"/></td> --%>
										<td><form:radiobutton path="midGenerated" name="midGenerated1" id="midGenerated1" value="SYSTEM" onchange="disableCustomName();" tabindex="19"/>&nbsp;<spring:message code="label.SystemGenerated"/><span style="color: #ff0000">*</span></td>
										<td><form:radiobutton path="midGenerated" name="midGenerated2" id="midGenerated2" value="CUSTOM" onchange="enableCustomName();" tabindex="20"/>&nbsp;<spring:message code="label.CustomElement"/><span style="color: #ff0000">*</span></td>
										<td><spring:message code="label.CustomName"/>:<span style="color: #ff0000">*</span></td>
										<td><form:input class="txt_width" path="custom" name="customName" id="customName" disabled="true" maxlength="6" tabindex="21"/></td>
									</tr>
																	
								</table>
							</fieldset>
						</div>
					</div>
				</div>
				<div class="box box-100 altbox" id="box1" style="margin-top: 1%">
					<div id="errorMsg4" class="displayErrMsg" style="padding-bottom: 5px;"></div>
					<div class="boxinNew">
						<div class="header" id="collapse" style="overflow: hidden;">
							<h3><spring:message code="label.ContactDetails"/>&nbsp;&nbsp;(<spring:message code="label.Business"/>)</h3>
							<span style="float: right; padding-right: 20px; padding-top: 2px;">
								<img style="visibility: hidden;" src="${contextPath}/system-file/images/add.png" />
							</span>
						</div>
						<div class="content" id="box1-tabular" style="width:100%!important;"><!-- content box 1 for tab switching -->
							<fieldset style="width:100%!important;">
								<table id="gridNew" border="0" width="100%">
									<tr>
										<td><spring:message code="label.Title"/>:</td>
										<td>
											<form:select path="cntctTitle" id="cntctTitle" class="txt_width_select" tabindex="24">
												<form:option value='' >----<spring:message code="option.Select"/>----</form:option>
												<form:option value="Mr" ><spring:message code="option.Mr"/></form:option>
												<form:option value="Mrs" ><spring:message code="option.Mrs"/></form:option>
												<form:option value="Ms" ><spring:message code="option.Ms"/></form:option>
												<form:option value="Miss" ><spring:message code="option.Miss"/></form:option>
											</form:select>
										</td>
										<td><spring:message code="label.FirstName"/>:<span style="color: #ff0000">*</span></td>
										<td><form:input class="txt_width" path="cntctFirstName" name="cntctFirstName" id="cntctFirstName" maxlength="25" tabindex="25"/></td>
										<td><spring:message code="label.LastName"/>:<span style="color: #ff0000">*</span></td>
										<td><form:input class="txt_width" path="cntctLastName" name="cntctLastName" id="cntctLastName" maxlength="25" tabindex="26"/></td>
									</tr>
									<tr>

										<td><spring:message code="label.ContactNo" />:<span
											style="color: #ff0000">*</span></td>
										<td><form:input class="txt_width" path="cntctPhoneNo"
												maxlength="18" name="cntctPhoneNo" id="cntctPhoneNo"
												onkeypress="return isNumberKey(event)"
												onclick="disableCtrl();" tabindex="34" /></td>
										<td><spring:message code="label.PrimaryEmail" />:<span
											style="color: #ff0000">*</span></td>
										<td><form:input class="txt_width"
												path="cntctPrimaryEmail" name="cntctPrimaryEmail"
												id="cntctPrimaryEmail" maxlength="64" tabindex="35" /></td>
										<td><spring:message code="label.Address1" />:<span
											style="color: #ff0000">*</span></td>
										<td><form:textarea class="txt_width"
												path="address1" name="address1" id="address1"
												tabindex="37" maxlength="64" /></td>

									</tr>
									<tr>
										<td><spring:message code="label.Country"/>:<span style="color: #ff0000">*</span></td>
										<td>
											<form:select class="txt_width_select" path="country" id="countryId"  tabindex="39" onchange="setStateValues('countryId','state','stateLbl',cntxPath,'manageMerchant')">
												 <form:option value="0" >----<spring:message code="option.Select"/>----</form:option>
												 <%--  <form:option value="10229" >United States</form:option> --%>
											<%-- 	<form:options items="${countryList}" /> --%>
											</form:select>
										</td>
										<td><span style="float: left;"><spring:message code="label.State/Province"/>:</span><span id = "stateLbl" style="color: #ff0000;">*</span></td>
										<td>
											<form:select path="state" id="state" class="txt_width_select" disabled="true" tabindex="40">
												<form:option value="0" >----<spring:message code="option.Select"/>----</form:option>
											</form:select>
										</td>
										<td><spring:message code="label.City"/>:<span style="color: #ff0000">*</span></td>
										<td><form:input class="txt_width" path="city" name="city" id="city" tabindex="41"/></td>
									</tr>
									<tr>
										<td><span style="float: left;"><spring:message code="label.Zip/PostalCode"/>:</span><span id = "zipLabel" style="color: #ff0000">*</span></td>
										<td><form:input class="txt_width" path="zipcode" name="zipcode" id="zipcode" maxlength="10" onblur="upperValue('zipcode')" tabindex="42"/></td>
										<td colspan="4"></td>
									</tr> 
								</table>
							</fieldset>
						</div>
					</div>
				</div>
					<div class="grid_12" align="center" >
			<div class="sep">
				<input class="button" type="submit" name="button" id="save" value='<spring:message code="button.Save"/>' title='<spring:message code="button.Save"/>' tabindex="53"/>
				<input class="button altbutton" type="button" name="button2" id="cancel" value='<spring:message code="button.Cancel"/>' title='<spring:message code="button.Cancel"/>' onblur="tabFocus('businessName')"  tabindex="54"/>
			</div>
		</div>
			</form:form>
		</div>
	
	</div>
<%-- <div id="enterPassword" class="popup_block2" style="display: none;">
	<div class='header'>
		<span><spring:message code="label.PasswordCheck"/></span>
		<a href="#" id="closepopup18" style="float: right;margin-right:-8px;" class="close"><img src="${contextPath}/resources1/images/cancel.png" /></a>
	</div>
	<div id="errorPassword" class="displayErrMsg"></div>
	<table width="100%" style="padding: 1% 0 2% 2%;">
		<tbody>
			<tr>
			<td style="width: 2%"><spring:message code="label.Password" /> :<span style="color: #ff0000">*</span></td>
			<td style="width: 10%"><input type="password" name="password" id="password" maxlength="30" tabindex="55" class="txt_width" /></td>
			</tr>
		</tbody>
	</table>
	<div class="sep" style="padding: 0% 0 0% 2%;margin-bottom:0px;">
     <input class="button altbutton yes" type="button" id="validatepassword" value='<spring:message code="button.Ok" />' tabindex="56"/>
    <input class="button  no simplemodal-close" type="button" value='<spring:message code="button.Cancel" />' onclick="closePopUpCredit2()" tabindex="57"  onblur="tabFocus('password')"/>
     </div>
</div> --%>
<div style="clear: both;"></div>
<jsp:include page="../common/footer.jsp"/>
<div style="clear: both;"></div>
</body>
</html>
