<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jstl/core_rt"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />

<div id="editRole" class="popup_block" style="display: none">
	<div class='header'>
		<span><spring:message code="label.EditRole" /></span>
		<a href="#" id="closepopup2" style="float: right;" class="close"><img src="${contextPath}/system-file/images/cancel.png" /></a>
	</div>
	<div class='message altbox' style="padding:0 10px 5px 20px;">
		<div id="errorMsg1" class="displayErrMsg"></div>
		<form action="${contextPath}/dcs/user/updateRole" method="post" name="editRoleForm" id="editRoleForm">
			<table id="editRoleMainHeaderId" width="100%">
				<tr>
					<td width="10%"><spring:message code="label.Hierarchy" /><span style="color: #ff0000">*</span></td>
					<td>
						<input type="text" class="txt_width" name="hierarchyListName" id="hierarchyListName" readonly="readonly" disabled="disabled"/>
						<input type="hidden" name="hierarchyListId" id="hierarchyListId" readonly="readonly" />
					</td>
					<td colspan="5"></td>
				</tr>
				<tr>
					<td><spring:message code="label.RoleName" /><span style="color: #ff0000">*</span></td>
					<td>
						<input type="text" class="txt_width" name="roleNameEdit" id="roleNameEdit" value="" disabled="disabled"/>
						<input type="hidden" name="roleIdEdit" id="roleIdEdit" readonly="readonly" />
					</td>
					<td><spring:message code="label.Description" /><span style="color: #ff0000">*</span></td>
					<td>
						<input type="text" class="txt_width" name="roleDescEdit" id="roleDescEdit" maxlength="200" onkeyup="textAreaLength(this,200)" value="" tabindex="1" />
						<input type="hidden" name="roleDescIdEdit" id="roleDescIdEdit" />
					</td>
					<td><spring:message code="label.Status" /><span style="color: #ff0000">*</span></td>
					<td>
						<select name="status" id="statusEdit"  onchange="statusChange()" class="date" tabindex="2">
							<option value=''><spring:message code="option.Select" /></option>
							<option value='ACTIVE'><spring:message code="option.ACTIVE" /></option>
							<option value='INACTIVE'><spring:message code="option.INACTIVE" /></option>
						</select>
					</td>
					<td>
						<input type="checkbox" id="eidtCheckAll" onclick="checkAllCheckbox();" tabindex="3"/><spring:message code = "label.SelectAll" />
					</td>
				</tr>
			</table>
			
			<div id="editPemissionDisplay" style="width: 100%; height: 300px; overflow: auto;"></div>
			<div class="sep">
				<input class="button altbutton yes" type="button" value='<spring:message code = "button.Save"/>' onclick="updateRole()" tabindex="5"/>
				<input class="button no simplemodal-close" type="button" value='<spring:message code = "button.Cancel"/>' onclick="closePopUp()" tabindex="6" onblur="tabFocus('roleDescEdit')"/>
			</div>
		</form>
	</div>
</div>
<script type="text/javascript">
	function checkAllCheckbox()
	{
		$('#errorMsg1').html('');
		var checkAll = document.getElementById("eidtCheckAll");
		if(checkAll.checked == true)
		{
			var cbs = document.getElementsByTagName("input");
			for(var i=0; i < cbs.length; i++)
			{
				if('checkbox' == cbs[i].type)
				{
					if(cbs[i])
						cbs[i].checked = true;
				}
			}
		}
		else
		{
			var cbs = document.getElementsByTagName("input");
			for(var i=0; i < cbs.length; i++)
			{
				if(cbs[i].type == 'checkbox')
				{
					if(cbs[i].hasAttribute('disabled') == false)
						cbs[i].checked = false;
				}
			}
		}
	}
</script>