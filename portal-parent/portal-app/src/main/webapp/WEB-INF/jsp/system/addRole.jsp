<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jstl/core_rt"%>
<c:set var="contextPath" value="<%=request.getContextPath()%>" />

<div id="addRole" class="popup_block" style="display: none">
	<div class='header'>
		<span><spring:message code="label.AddRole" /></span>
		<a href="#" id="closepopup3" style="float: right;" class="close"><img src="${contextPath}/system-file/images/cancel.png" /></a>
	</div>
	<div class='message altbox' style="padding:10px 10px 5px 20px;">
		<div id="errorMsg" class="displayErrMsg"></div>
		<!-- <table width="100%">
		</table> -->
		<table id="addRoleMainHeaderId" width="100%">
			<tr>
				<td><spring:message code="label.Hierarchy" /><span style="color: #ff0000">*</span></td>
				<td>
					<select name="hierarchyList" id="hierarchyList" name="hierarchyList" onchange="makeEnable(), makeDefault()"  class="txt_width_select" tabindex="1">
						<option value='0'><spring:message code="option.Select" /></option>
						<option value='3001'>Admin</option>
						<option value='420'>Custom</option>
					</select>
				</td>
				<td colspan="5"></td>
			</tr>
			<tr>
				<td><spring:message code="label.RoleName" /><span style="color: #ff0000">*</span></td>
				<td>
					<input type="text" class="txt_width" name="roleName" id="roleName" tabindex="2" maxlength="20" value="" />
				</td>
				<td>
					<spring:message code="label.Description" /><span style="color: #ff0000">*</span></td>
				<td>
					<input type="text" class="txt_width" name="roleDesc" id="roleDesc" maxlength="200" onkeyup="textAreaLength(this,200)" value="" tabindex="3" />
				</td>
		
				<td><spring:message code="label.Status" /><span style="color: #ff0000">*</span></td>
				<td>
					<select name="status" id="status" disabled="disabled" class="date" tabindex="4">
						<option value='ACTIVE'><spring:message code="option.ACTIVE" /></option>
						<option value='INACTIVE'><spring:message code="option.INACTIVE" /></option>
					</select>
				</td>
				<td>
					<input type="checkbox" id="checkAll" onclick="checkAllCheckBoxes();" tabindex="5"/><spring:message code = "label.SelectAll" />
				</td>
			</tr>
		</table>
		<div id="pemissionDisplay" style="width:100%; height:300px; overflow:auto;"></div>
		<!-- <div class="sep" style="float:right; margin-right:20px;margin-bottom:10px;"> -->
		<div class="sep">
			<input class="button altbutton yes" type="button" value='<spring:message code = "button.Save"/>' onclick="saveRole()" tabindex="6"/>
			<input class="button no simplemodal-close" type="button" value='<spring:message code = "button.Cancel"/>' onclick="closePopUp()" tabindex="7" onblur="tabFocus('hierarchyList')"/>
		</div>
	</div>
</div>

<script type="text/javascript">
	function checkAllCheckBoxes()
	{
		$('#errorMsg').html('');
		var checkAll = document.getElementById("checkAll");
		if(checkAll.checked == true)
		{
			var cbs = document.getElementsByTagName("input");
			for(var i=0; i < cbs.length; i++) {
				if(cbs[i].type == 'checkbox')
				{
					if(cbs[i].checked == false)
						cbs[i].checked = true;
				}
			}
		}
		else
		{
			var cbs = document.getElementsByTagName("input");
			for(var i=0; i < cbs.length; i++) {
				if(cbs[i].type == 'checkbox')
				{
					if(cbs[i].hasAttribute('disabled') == false)
						cbs[i].checked = false;
				}
			}
		}
	}
	function makeDefault(){
		document.getElementById('checkAll').checked = false;
		$('#pemissionDisplay').scrollTop(0);
		
	}
</script>