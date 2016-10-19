<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@page import="org.common.service.User"%>

<%
User secUserVO = (User) request.getSession().getAttribute("secUserVO");
String role=secUserVO.getRoleName();
String subRoleName=secUserVO.getSubRoleName();
String password=secUserVO.getPassword();
String useId=secUserVO.getUserId(); 
%>
<head>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jstl/core_rt"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />

<title><spring:message code = "title.ManageRole" /></title>

<jsp:include page="../common/scripts.jsp"/>
<jsp:include page="../common/stylesheets.jsp"/>

<script type="text/javascript" src="${contextPath}/system-file/js/CommonDropDowns.js"></script>

<script>
	var context = '${contextPath}/doc/user';
	var searchFlag = false;
	var confirmFlag = false;
	
	function textAreaLength(val,maxlen) {
	    var len = val.value.length;
	    if (len >= maxlen) {
	      val.value = val.value.substring(0, maxlen);
	    }
	  };
	jq(function()
	{
		jq('input#reset').click(function(){
			$('#errorDate').html('');
			searchFlag = false;
			var url = "${contextPath}/doc/user/manageRoles";
			window.location.href = url;
		});
		
		jq('input#search').click(function(){
			searchFlag = true;
			$('#errorDate').html('');
			var roleName = $("#roleName1").val();  
			var roleDesc = $("#roleDesc1").val();	            
            var status = $("#status1").val();		
            var rowIds = jq('#grid').jqGrid('getDataIDs');
            
			if(roleName=='' && roleDesc=='' && status=='')
			{
				$('#errorDate').html('<p class=error><spring:message code="script.error.SearchManageCorporate"/></p>');
			}
			else  if(roleName!='' || roleDesc!='' || status!='')
			{
				jq("#grid").jqGrid('setGridParam',
				{   																										
					url : '${contextPath}/doc/user/search?roleName='
						+ roleName
						+ '&'
						+ 'roleDesc=' 
						+ roleDesc
						+ '&'
						+ 'status='
						+ status
				});
				jq("#grid").trigger('reloadGrid');
				jq("#grid").jqGrid('setGridParam', {datatype:'json'});
				jq("#grid").trigger('reloadGrid', [{page:1}]); 
			}	
		});
	});
 
	var statusClick = false;
	function statusChange(){
		statusClick = true;
	}
	function deleteConfirm(){
		$('#errorMsg1').html('');
		$('#fade1 , #selectInactive').fadeOut("fast", function() {});
		confirmFlag = true;
		updateRole();
	}
	function closeDialogue(){
		$('#fade , .popup_block').fadeOut("fast", function() {});
		return false;
	}
	function closeThisDialogue(){
		$('#fade1 , #selectInactive').fadeOut("fast", function() {});
		return false;
	}
	
</script>

<script type="text/javascript">
function loadAdd()
	{
	console.log("loadAdd");
		$('#errorMsg').html('');
		var el = document.getElementById('addRoleMainHeaderId');
        all = el.getElementsByTagName('input');
        var i;
        for(i = 0; i < all.length; i++)
        {
        	all[i].disabled = true; 
        } 
		jQuery("input#roleName").val('');
        jQuery("input#roleDesc").val('');    
        $('#checkAll').attr('checked', false); // Unchecks it
        $('#status option:eq(0)').attr('selected','selected');
        $('#hierarchyList option:eq(0)').attr('selected','selected');
        document.getElementById('pemissionDisplay').innerHTML = "" ;
	    //hierarchyList(context+'/hierarchyList','hierarchyList');
	    document.getElementById('hierarchyList').focus();
	} 
	
	function loadEdit()
	{
		var row = jq("#grid").jqGrid('getGridParam', 'selrow');
		var roleId = jq('#grid').jqGrid('getCell', row, 'roleId');
		var roleName = jq('#grid').jqGrid('getCell', row, 'roleName');
		var roleDesc = jq('#grid').jqGrid('getCell', row, 'roleDesc');
		var status = jq('#grid').jqGrid('getCell', row, 'status');
		$('#errorMsg1').html('');
		
		
		var value = "<%= subRoleName %>";  
		if(value==roleName){
			popupNew('selectInactiveId','45');
		}
		else if(row == null)
		{
			
			popupNew('dialogSelectRow','20');
		}
		else
		{
			popupNew('editRole','75');
			
		    console.log("loadEdit");
		 
			document.getElementById("editPemissionDisplay").innerHTML = "";
			$('#eidtCheckAll').attr('checked', false); // Unchecks it
		  $("input#roleNameEdit").val(roleName);
			$("input#roleDescEdit").val(roleDesc);
			$("input#statusEdit").val(status); 
			jQuery.ajax({
				url: '${contextPath}/doc/user/getRoleEdit?roleId=' + roleId,
				type: 'GET',
				datatype: 'json',
				success: function (data){
					
					$("input#hierarchyListName").val(data.role.hierachyVO.groupName);
					$("input#hierarchyListId").val(data.role.hierachyVO.groupId);
					$("input#roleIdEdit").val(data.role.roleId);
					$("input#roleDescIdEdit").val(data.role.roleDesc);
					$("select#statusEdit").val(data.role.status);
					var permissionList = data.role.permissionIds.split(","); 
					displayPermission(data.response,'editPemissionDisplay');
					var checkBoxList= document.getElementsByTagName("input");
					var k=0;
					var l=2;
					 for(var i=0;i<checkBoxList.length;i++)
					{
						if(checkBoxList[i].type == 'checkbox')
						{
							for(var j=0; j<permissionList.length; j++)
							{
								if(checkBoxList[i].value==permissionList[j])
								{
									checkBoxList[i].checked= true;
								}
							}
							k++;
							if(checkBoxList[i].checked)
								l++;
						}
					}
					if(k == l){
						document.getElementById("eidtCheckAll").checked = true;
					}else{
						document.getElementById("eidtCheckAll").checked = false;
					} 
				}
			});
			document.getElementById('roleDescEdit').focus();
		} 
	}
	
 function saveRole()
	{
		var roleName = $('#roleName').attr('value');
		var roleDesc = $('#roleDesc').attr('value') ;
		var hierarchyList =$("#hierarchyList option:selected").val();
		var status =$("#status option:selected").val();
		var checkBoxList= document.getElementsByTagName("input");
		var str="";
		var checkVal = 0;
		$('#errorPassword').html('');
		$("input#password").val('');
		for(var i=0;i<checkBoxList.length;i++)
		{
			if(checkBoxList[i].type == 'checkbox' && 'on' != checkBoxList[i].value)
			{
				if(checkBoxList[i].checked){
					str =str+checkBoxList[i].value+",";
					checkVal= checkVal+1;
				}
			}
		}
		
		var error_count = 0;
		if(hierarchyList == ''  || hierarchyList == "Select"){
			$('#errorMsg').html('<p class=error><spring:message code = "script.error.Hierarchy" /></p><br>');
			error_count += 1;
			jq('#hierarchyList').focus();
			return;
		}
		if(roleName == ''){
			$('#errorMsg').html('<p class=error><spring:message code = "script.error.RoleName" /></p>');
			error_count += 1;
			jq('#roleName').focus();
			return;
		}
		else if(trim(roleName )== ''){
			$('#errorMsg').html('<p class=error><spring:message code = "script.error.RoleName" /></p>');
			error_count += 1;
			jq('#roleName').focus();
			return;
		}
		if(!roleName.match(/^([0-9a-zA-Z\s!@,.]+)$/)){
			$('#errorMsg').html('<p class=error><spring:message code = "script.error.RoleNameAlphanumericWithSpecialCharacters" /></p><br>');
			error_count += 1;
			jq('#roleName').focus();
			return;
		}
		if(trim(roleName ).length > 20){
			$('#errorMsg').html('<p class=error><spring:message code = "script.error.RoleNameMaxCharLimit" /></p>');
			error_count += 1;
			jq('#roleName').focus();
			return;
		}
		if(roleDesc== ''){
			$('#errorMsg').html('<p class=error><spring:message code = "script.error.RoleDescription" /></p>');
			error_count += 1;
			jq('#roleDesc').focus();
			return;
		}
		else if(trim(roleDesc )== ''){
			$('#errorMsg').html('<p class=error><spring:message code = "script.error.RoleDescription" /></p>');
			error_count += 1;
			jq('#roleDesc').focus();
			return;
		}
		else if(!roleDesc.match(/^([0-9a-zA-Z\s!@,.]+)$/)){
			$('#errorMsg').html('<p class=error><spring:message code = "script.error.RoleDescriptionAlphanumericWithSpecialCharacters" /></p><br>');
			error_count += 1;
			jq('#roleDesc').focus();
			return;
		}
		if(trim(roleDesc ).length > 200){
			$('#errorMsg').html('<p class=error><spring:message code = "script.error.RoleDescriptionMaxCharLimit" /></p>');
			error_count += 1;
			jq('#roleDesc').focus();
			return;
		}
		if(status ==''){
			$('#errorMsg').html('<p class=error><spring:message code = "script.error.Status" /></p><br>');
			error_count += 1;
			jq('#status').focus();
			return;
		}
		
		if (error_count === 0) {
			$('#errorMsg').html('');
			$('#errorPassword').html('');
			popupNew('enterPassword','50');
			jq('#password').focus();
			$('#addRole').append('<div id="fade1"></div>');
			$('#fade1').css({
				'filter' : 'alpha(opacity=80)'
			}).fadeIn();
			$('input#validatepassword').unbind('click').bind('click', function (e) {
				var flag = false;
				var tempPassword = jq('#password').attr('value');
				 if(tempPassword == ''){
					$('#errorPassword').html('<p class=error><spring:message code="script.error.PasswordCheck"/></p>');
					return false;
				}
				//jQuery.ajax({
					/* type : 'GET',
					url : "${contextPath}/doc/validatePassword",
					data : {
						"tempPassword" : tempPassword
					},
					datatype : 'json',
					success : function(data) {
						if (null != data.errorMessage) {
							$('#errorPassword').html('<p class=error>' + data.errorMessage + '</p><br>');
						}else if(null != data.errorMessage1){
							$('#errorPassword').html('<p class=error>' + data.errorMessage1 + '</p><br>');
							var url = "${contextPath}/app/auth/login";
							window.location.href = url;
						} */
						//else {
							closePopUpCredit();
							jQuery.ajax({
								type: "GET",
								url : '${contextPath}/doc/user/saveRoleInfo?roleName='+ roleName
									+ '&'
									+ 'roleDesc='
									+ roleDesc
									+ '&'
									+ 'hierarchyList='
									+ hierarchyList
									+ '&'
									+ 'status='
									+ status
									+ '&'
									+ 'str='
									+ str ,
								datatype: 'json' ,
								success: function(data){
						if(null != data.errorMessage){
								$('#errorMsg').html('<p class=error>'+data.errorMessage+'</p><br>');
							}else{
									closePopUp();
									var url = "${contextPath}/doc/user/manageRoles";
									window.location.href = url;
								}
							}
						});
						//}
					//}
				//});
			});
		}
	} 
	
	 function updateRole()
	{
		var hierarchyListId =  $('#hierarchyListId').attr('value');
		var roleIdEdit =  $('#roleIdEdit').attr('value');
		var roleDescIdEdit =  $('#roleDescEdit').attr('value');
		var status =  $('#statusEdit').attr('value');
		var checkList;
		var checkBoxList= document.getElementsByTagName("input");
		var str="";
		var checkVal=0;
		$('#errorPassword').html('');
		$("input#password").val('');
		for(var i=0;i<checkBoxList.length;i++)
		{
			if('checkbox' == checkBoxList[i].type && 'on' != checkBoxList[i].value)
			{
				if(checkBoxList[i].checked)
				{
					str =str+checkBoxList[i].value+",";
					checkVal = checkVal+1;
				}
			}
		}
		
		var errMsg = '';
		var error_count =0;
		
		if(roleDescIdEdit== ''){
			$('#errorMsg1').html('<p class=error><spring:message code = "script.error.RoleDescription" /></p>');
			error_count += 1;
			jq('#roleDescEdit').focus();
			return;
		}
		else if(trim(roleDescIdEdit )== ''){
			$('#errorMsg1').html('<p class=error><spring:message code = "script.error.RoleDescription" /></p>');
			error_count += 1;
			jq('#roleDescEdit').focus();
			return;
		}
		else if(!roleDescIdEdit.match(/^([0-9a-zA-Z\s!@,.]+)$/)){
			$('#errorMsg1').html('<p class=error><spring:message code = "script.error.RoleDescriptionAlphanumericWithSpecialCharacters" /> </p><br>');
			error_count += 1;
			jq('#roleDescEdit').focus();
			return;
		}
		if(trim(roleDescIdEdit ).length > 200  ){
			$('#errorMsg1').html('<p class=error> <spring:message code = "script.error.RoleDescriptionMaxCharLimit" /> </p>');
			error_count += 1;
			jq('#roleDescEdit').focus();
			return;
		}
		if(status ==''){
			$('#errorMsg1').html('<p class=error> <spring:message code = "script.error.Status" /> </p><br>');
			error_count += 1;
			jq('#statusEdit').focus();
			return;
		}
		 if(status == 'INACTIVE' && statusClick && !confirmFlag){
			popupNew('selectInactive','40');
			$('#editRole').append('<div id="fade1"></div>');
			$('#fade1').css({
				'filter' : 'alpha(opacity=80)'
			}).fadeIn();
		} 
		else if (error_count == 0) {
			confirmFlag = false;
			$('#errorPassword').html('');
			$('#errorMsg1').html('');
			popupNew('enterPassword','50');
			jq('#password').focus();
			$('#editRole').append('<div id="fade1"></div>');
			$('#fade1').css({
				'filter' : 'alpha(opacity=80)'
			}).fadeIn();
			$('input#validatepassword').unbind('click').bind('click', function (e) {
				var flag = false;
				var tempPassword = jq('#password').attr('value');
				 if(tempPassword == ''){
					$('#errorPassword').html('<p class=error><spring:message code="script.error.PasswordCheck"/></p>');
					return false;
				}
				/* jQuery.ajax({
					 type : 'GET',
					url : "${contextPath}/doc/validatePassword",
					data : {
						"tempPassword" : tempPassword
					},
					datatype : 'json',
					success : function(data) {
						if (null != data.errorMessage) {
							$('#errorPassword').html('<p class=error>' + data.errorMessage + '</p><br>');
						}else if(null != data.errorMessage1){
							$('#errorPassword').html('<p class=error>' + data.errorMessage1 + '</p><br>');
							var url = "${contextPath}/app/auth/login";
							window.location.href = url;
						} 
						else { */
							closePopUpCredit();
							jQuery.ajax({
								type: 'GET',
								url: "${contextPath}/doc/user/updateRole?hierarchyListId="+hierarchyListId+
									"&roleIdEdit="+roleIdEdit+
									"&roleDescIdEdit="+roleDescIdEdit+
									"&statusIdEdit="+status+
									"&str="+str,
								datatype: 'json',
								success: function(data){
									if(null != data.errorMessage){
										$('#errorMsg1').html('<p class=error>'+data.errorMessage+'</p><br>');
									}
									else{
										closePopUp();
										var url = "${contextPath}/doc/user/manageRoles";
										window.location.href = url;
									}
								},
								error: function (data) {
									closePopUp();
									var url = "${contextPath}/doc/user/manageRoles";
									window.location.href = url;
								}
							});
						//}
					//}
				//});
			});
		}
		else{
			$('.error').show();
		}
		return false;
	} 

	function closePopUp()
	{
		$('#fade , .popup_block').fadeOut("fast", function() {});
		$('#fade1 , .popup_block2').fadeOut("fast", function() {});
		return false;
	}
</script>

<script>
	jq(function() {
		var flag = false;
		$("#collapse").click(function () {
		    $("#collapsable_window").slideToggle("slow");
		    var element = document.getElementById('img');
		    if(!flag){
		    	element.src = "${contextPath}/system-file/images/minus.png";
		    	flag = true;
		    }
	    	else{
	    		element.src = "${contextPath}/system-file/images/add.png";
		    	flag = false;
	    	}
		});
	});
	
	function modifyGridDefaultStyles()
	{
		$("#grid" + 'tr').removeClass("ui-widget-content");
		$("#grid" + ' tr:nth-child(odd)').addClass("evenTableRow");
		$("#grid" + 'tr:nth-child(even)').addClass("oddTableRow");
	}

	jq(function() {
		var authorization = enableDisableView("Manage Roles");
		authorization =true;
		
		if(authorization)
		{
			
		
			jq("#grid").jqGrid({
			    url:'${contextPath}/doc/user/getRoleList',
				datatype: 'json',
				mtype: 'GET',	   
			   	colNames:[
					<spring:message code = "script.label.RoleName" /> ,
					<spring:message code = "script.label.RoleDescription" />,
					<spring:message code = "script.label.Status" />,
					<spring:message code = "script.label.CreatedBy" />,
					<spring:message code = "script.label.CreatedDate" />,
					<spring:message code = "script.label.ModifiedBy" />,
					<spring:message code = "script.label.ModifiedDate" />,
					<spring:message code = "script.label.UsersList" />,
					<spring:message code = "script.label.ID" />,
					<spring:message code = "script.label.ID" />
				],
			   	colModel:[      
					{name:'roleName',index:'roleName', width:55,editable:true,editrules:{required:true}, editoptions:{size:10}},
					{name:'roleDesc',index:'roleDesc', width:55,editable:true,editrules:{required:true}, editoptions:{size:10}},
					{name:'status',index:'status', width:55,editable:true,editrules:{required:true}, editoptions:{size:10}},
					{name:'createdBy',index:'createdBy', width:55,editable:true,editrules:{required:true}, editoptions:{size:10}},
					{name:'createdDate',index:'createdDate', width:55,editable:true,editrules:{required:true}, editoptions:{size:10}, sorttype: "date", datefmt:"m-d-y"},
					{name:'modifiedBy',index:'modifiedBy', width:55,editable:true,editrules:{required:true}, editoptions:{size:10}},
					{name:'modifiedDate',index:'modifiedDate', width:55,editable:true,editrules:{required:true}, editoptions:{size:10}, sorttype: "date", datefmt:"m-d-y"},
					{name:'userList',index:'userList', width:50,align:"left",editable:true,search: true,editrules:{required:true}, editoptions:{size:10}, sortable:false},
					{name:'roleId',index:'roleId', editable:true,editrules:{edithidden: false}, editoptions:{size:10},sortable:true, hidden:true},
					{name:'id',index:'id', editable:true,editrules:{edithidden: false}, editoptions:{size:10},sortable:true, hidden:true}
				],
			   	postData: { 
				},				
				height:470,  // 355 
			   	autowidth: true,         
			   	hidegrid: false,
				rownumbers: false,
				rowNum : 20,
				pgbuttons: true,
				pgtext: null, 
			   	pager: '#pager',
			   	sortname: 'id',
			    viewrecords: true,
			    sortorder: "desc",	   
			    caption:<spring:message code = "script.label.Roles" />,	    
			    emptyrecords: <spring:message code = "script.label.EmptyRecords" /> ,
			    loadtext : <spring:message code="script.label.Loading"/>,
				recordtext : <spring:message code="script.label.PaginationView"/>,
				loadonce: true,
			    toolbar: [true,"bottom"],
			    loadComplete: function()
			    {
			    	modifyGridDefaultStyles();
				},
				gridComplete: function()
				{
					$("#AddJQ").hide();
					$("#EditJQ").hide();
					enableDisableButton("Manage Roles");
					
					var ids = jq("#grid").jqGrid('getDataIDs'); 
					if(ids.length==0){
						$("#next_pager").addClass('ui-state-disabled');
						$("#last_pager").addClass('ui-state-disabled');
					}
				
					if(ids.length == 0 && searchFlag){
						$('#errorDate').html('<p class=error><spring:message code="label.NoRecordFound"/></p>');
					}
					else{
						$('#errorDate').html('');
					}
					for(var i=0;i < ids.length;i++)
					{ 
						var el = ids[i];				
						vi = "<input style='height:22px;width:100px;' type='button'  value=\"<spring:message code='script.button.View'/>\" onclick=\" viewUser('"+el+"');\">";
						jq("#grid").jqGrid('setRowData',ids[i],{userList:vi}); 
					}
				},
					
	
				
			    jsonReader : {
			        root: "rows",
			        page: "page",
			        total: "total",
			        records: "records",
			        repeatitems: false,
			        cell: "cell",
			        id: "userId"
			    }
			});
		}
		 else
		{
			
			alert("in else")
			jq("#grid").jqGrid({
			    url:'${contextPath}/doc/user/getRoleList',
				datatype: 'json',
				mtype: 'GET',	   
			   	colNames:[
					<spring:message code = "script.label.RoleName" /> ,
					<spring:message code = "script.label.RoleDescription" />,
					<spring:message code = "script.label.Status" />,
					<spring:message code = "script.label.CreatedBy" />,
					<spring:message code = "script.label.CreatedDate" />,
					<spring:message code = "script.label.ModifiedBy" />,
					<spring:message code = "script.label.ModifiedDate" />,
					<spring:message code = "script.label.ID" />,
					<spring:message code = "script.label.ID" />
				],
			   	colModel:[      
					{name:'roleName',index:'roleName', width:55,editable:true,editrules:{required:true}, editoptions:{size:10}},
					{name:'roleDesc',index:'roleDesc', width:55,editable:true,editrules:{required:true}, editoptions:{size:10}},
					{name:'status',index:'status', width:55,editable:true,editrules:{required:true}, editoptions:{size:10}},
					{name:'createdBy',index:'createdBy', width:55,editable:true,editrules:{required:true}, editoptions:{size:10}},
					{name:'createdDate',index:'createdDate', width:55,editable:true,editrules:{required:true}, editoptions:{size:10}},
					{name:'modifiedBy',index:'modifiedBy', width:55,editable:true,editrules:{required:true}, editoptions:{size:10}},
					{name:'modifiedDate',index:'modifiedDate', width:55,editable:true,editrules:{required:true}, editoptions:{size:10}},
					{name:'roleId',index:'roleId', editable:true,editrules:{edithidden: false}, editoptions:{size:10},sortable:true, hidden:true},
					{name:'id',index:'id', editable:true,editrules:{edithidden: false}, editoptions:{size:10},sortable:true, hidden:true}
				],
			   	postData: { 
				},				
				height:470,  // 355 
			   	autowidth: true,         
			   	hidegrid: false,
				rownumbers: false,
				rowNum : 20,
				pgbuttons: true,
				pgtext: null, 
			   	pager: '#pager',
			   	sortname: 'id',
			    viewrecords: true,
			    sortorder: "desc",	   
			    caption:<spring:message code = "script.label.Roles" />,	    
			    emptyrecords: <spring:message code = "script.label.EmptyRecords" /> ,
			    loadtext : <spring:message code="script.label.Loading"/>,
				recordtext : <spring:message code="script.label.PaginationView"/>,
				loadonce: true,
			    toolbar: [true,"bottom"],
			    loadComplete: function()
			    {
			    	modifyGridDefaultStyles();
				},
				gridComplete: function()
				{
					$("#AddJQ").hide();
					$("#EditJQ").hide();
					enableDisableButton("Manage Roles");
					 
					var ids = jq("#grid").jqGrid('getDataIDs'); 
					if(ids.length==0){
						$("#next_pager").addClass('ui-state-disabled');
						$("#last_pager").addClass('ui-state-disabled');
					}
					if(ids.length == 0 && searchFlag){
						$('#errorDate').html('<p class=error><spring:message code="label.NoRecordFound"/></p>');
					}
					else{
						$('#errorDate').html('');
					}
				},
								
				
			    jsonReader : {
			        root: "rows",
			        page: "page",
			        total: "total",
			        records: "records",
			        repeatitems: false,
			        cell: "cell",
			        id: "userId"
			    }
			});
		} 
		
		jq("#t_grid").append(
			"<div class=\"mycart\" style=\"width:50%!important;\"><ul>"+
			"<li><a class=\"icon\" id=\"AddJQ\" onclick=\"popupNew('addRole','75');loadAdd();\" title='<spring:message code = 'label.AddRole' />'><spring:message code = 'label.Add' /></a></li>"+
			"<li><a class=\"edit\" id=\"EditJQ\" onclick=\"loadEdit();\" title='<spring:message code = 'label.EditRole' />'><spring:message code = 'label.Edit' /></a></li>"+
			"</ul></div>"
		);
		jq("#grid").jqGrid('navGrid','#pager',
		{edit:false,add:false,del:false,search:false,refresh:false},
		{ },
        { },
        { },
		{
			sopt:['eq', 'ne', 'lt', 'gt', 'cn', 'bw', 'ew'],
			closeOnEscape: true,
			multipleSearch: true,
			closeAfterSearch: true
		});
	});
	function viewUser(id)
	{
		var roleIdVal = jq('#grid').jqGrid('getCell', id, 'roleId');
		var url = "${contextPath}/doc/user/viewUsersPage?role="+roleIdVal;
	   	window.location.href = url;
	}
	$(window).bind('resize', function() {
		var pageWidth = jq("#gridIDValue").width();	
		jq("#grid").jqGrid('setGridWidth',pageWidth); //Resized to new width as per window
	 }).trigger('resize');
	
	function viewRole()
	{
		$('#fade , .popup_block').fadeOut("fast", function() {});
		var row = jq("#grid").jqGrid('getGridParam', 'selrow');
		var roleIdVal1 = jq('#grid').jqGrid('getCell', row, 'roleId');
		jQuery.ajax({
		    url: '${contextPath}/doc/manageUsers/getRoleEdit?roleId='+roleIdVal1,
		    type: 'GET',
  		    datatype: 'json',
  		    success: function (data)
  		    {
  		    	popupNew('viewRole','75');
  		    	hierarchyListName=data.role.hierachyVO.groupName;
  		    	roleNameEdit=data.role.subRoleName;
  		    	roleDescEdit=data.role.subRoleDesc;
  		    	statusEdit=data.role.status;  		    	
  		    	$("input#hierarchyListName1").val(hierarchyListName);
  		       	$("input#roleNameEdit1").val(roleNameEdit);
  		    	$("input#roleDescEdit1").val(roleDescEdit);
  		    	$("input#statusEdit1").val(statusEdit);
  		       	var permissionList = data.role.permissionIds.split(",");
				readOnlyDisplayPermission(data.response,'editPemissionDisplay1');
				var checkBoxList= document.getElementsByTagName("input");
				for(var i=0;i<checkBoxList.length;i++){
					if(checkBoxList[i].type == 'checkbox') {
						for(j=0;j<permissionList.length;j++){
							if(checkBoxList[i].value==permissionList[j]){
								checkBoxList[i].checked= true;
							}
						}
					}
                
				}
			}
		});
		$('#close_existing3').click(function() { 
			$('#fade , .popup_block2').fadeOut("fast", function() {
			});
			return false;
		});
		 
	}
	
</script>
</head>
<body>
<jsp:include page="../common/header.jsp" />
<div class="container_12">
	<div class="grid_12">
		<p class="breadcrumb">
			<a href="#" class="breadcrumblink_no"><spring:message code="label.Configuration"/></a>
			<a href="#" class="breadcrumblink_no"><spring:message code="label.UserConfiguration"/></a>
			<spring:message code="label.ManageRole"/>
		</p>
	</div>
</div>
<div class="container_12">	
	<div class="grid_12"> 
		<div class="box altbox">
			<div class="boxin">
				<div class="header" id="collapse" style="overflow: hidden;">
					<h3><spring:message code = "label.ManageRoleSearch" /></h3>
					<span class="add"><img id="img" src="${contextPath}/system-file/images/add.png" /></span>
				</div>
				<div id="collapsable_window" style="display: none;">				   
					<div id="errorDate" class="displayErrMsg"></div> 
					<table id="gridNew" width="100%" style="margin-top: 1%;">
						<tr>
							<td></td>
							<td>
								<spring:message code = "label.RoleName" />
							</td>
							<td>
								<input type="text" class="txt_width" name="roleName1" value="" id="roleName1"/>
							</td>
							<td>
								<spring:message code = "label.RoleDescription" />
							</td>
							<td>
								<input type="text" class="txt_width" name="roleDesc1" value="" id="roleDesc1"/>
							</td>
							<td>
								<spring:message code = "label.Status" />
							</td>
							<td>
								<select name="status1" style="width:160px\9;" id="status1" class="txt_width_select"> 
									<option value=''>------<spring:message code="label.Select" />------</option>
									<option value='NULL'><spring:message code="option.ALL"/></option>
									<option value='ACTIVE'><spring:message code="option.ACTIVE"/></option>
									<option value='INACTIVE'><spring:message code="option.INACTIVE"/></option>
								</select>
							</td>
				 		</tr>
				 	</table>				 	
					<div class="sep" style="margin: 0 0 1% 1%;">
						<input class="button altbutton" name="button2" id="search" value='<spring:message code = "button.Search" />' type="submit" title='<spring:message code = "button.Search" />' />
						<input class="button" name="button3" id="reset" value='<spring:message code = "button.Reload" />' type="submit" title='<spring:message code = "button.Reload" />' /> 
					</div>
				</div>
			</div>
		</div>
		<div style="clear:both;"></div>
	</div>
	
	<div class="grid_12" id="gridIDValue" >
		<div class="content" id="box1-tabular" style="width:100% !important;">
			<fieldset style="width:100%!important;">
				<table id="grid" class="scroll"></table>
			</fieldset>
			<div class="pagination"> 
				<div id="pager" class="scroll"></div>					
				<div class="clear"></div>
			</div>
		</div>		
	</div>
</div>
<jsp:include page="../common/footer.jsp" />
<jsp:include page="addRole.jsp" />
<jsp:include page="editRole.jsp" /> 
<jsp:include page="viewRole.jsp" />

<div id="dialogSelectRow" class="popup_block" title='<spring:message code="label.Warning" />' style="display: none">
	<div class='header'>
		<span><spring:message code = "label.ManageRole" /></span>
		<a href="#" id="closepopup4" style="float: right;" class="close"><img src="${contextPath}/system-file/images/cancel.png" /></a>
	</div>
	<h3 style="padding: 0 0 2% 2%;"><spring:message code = "error.message.PleaseSelectRow" /></h3>
</div>

<div id="selectInactiveId" class="popup_block2" style="display: none">
	<div class='header'>
		<span><spring:message code = "label.Alert" /></span> 
		<a href="#" id="close_existing" style="float: right;" class="close"><img src="${contextPath}/system-file/images/cancel.png" /></a>
	</div>
	<h3 style="padding-left: 1%;"><spring:message code="script.error.EditOwnManagaRole" /></h3>
	<div class="sep" style="padding: 2% 0 1% 1%;">
		<input class="button altbutton yes" type="button" value='<spring:message code="button.Ok" />' onclick="viewRole()"/>
		<input class="button no simplemodal-close" type="button" value='<spring:message code="button.Cancel" />' onclick="closeDialogue()"/>
	</div>
</div>

<div id="selectInactive" class="popup_block" title='<spring:message code="label.Warning" />' style="display: none">
	<div class='header'>
		<span><spring:message code = "label.Alert" /></span> 
		<a href="#" id="close_existing4" style="float: right;" class="close"><img src="${contextPath}/system-file/images/cancel.png" /></a>
	</div>
	<h3 style="padding-left: 1%;"><spring:message code="script.error.InactivateUserMsg" /></h3>
	<div class="sep" style="padding: 2% 0 1% 1%;">
		<input class="button altbutton yes" type="button" value='<spring:message code="label.Yes" />' onclick="deleteConfirm()" tabindex="4"/>
		<input class="button no simplemodal-close" type="button" value='<spring:message code="label.No" />' onclick="closeThisDialogue()" tabindex="5"/>
	</div>
</div>
<div id="enterPassword" class="popup_block2" style="display: none">
	<div class='header'>
		<span><spring:message code="label.PasswordCheck"/></span>
		<a href="#" id="close_existing2" style="float: right;margin-right:-8px;" class="close"><img src="${contextPath}/system-file/images/cancel.png" /></a>
	</div>
	<div id="errorPassword" class="displayErrMsg"></div>
	<table width="100%" style="padding: 1% 0 2% 2%;">
		<tbody>
			<tr>
			<td style="width: 2%"><spring:message code="label.Password" /> :<span style="color: #ff0000">*</span></td>
			<td style="width: 10%"><input type="password" name="password" id="password" maxlength="30" tabindex="8" class="txt_width" /></td>
			</tr>
		</tbody>
	</table>
	<div class="sep" style="padding: 0% 0 0% 2%;">
     <input class="button altbutton yes" type="button" id="validatepassword" value='<spring:message code="button.Ok" />' tabindex="9"/>
    <input class="button  no simplemodal-close" type="button" value='<spring:message code="button.Cancel" />' onclick="closePopup()" tabindex="10"  onblur="tabFocus('password')"/>
     </div>
</div>
</body>
</html>
