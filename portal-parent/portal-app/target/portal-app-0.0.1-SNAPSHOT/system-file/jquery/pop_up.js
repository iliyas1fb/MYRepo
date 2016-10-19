$(document).ready(function() {
	// Close Popups and Fade Layer
	$('#close_existing').click(function() {
		$('#fade , .popup_block').fadeOut("fast", function() {
		});
		return false;
	});

	$('#close_existing1').click(function() { // When clicking on the close or fade layer...
		$('#fade1 , .popup_block1').fadeOut("fast", function() {
			// alert("Animation done");
		});
		return false;
	});
	$('#close_existing2').click(function() { // When clicking on the close or fade layer...
		$('#fade1 , .popup_block2').fadeOut("fast", function() {
			// alert("Animation done");
		});
		return false;
	});
	$('#close_existing3').click(function() { // When clicking on the close or fade layer...
		$('#fade1 , .popup_block2').fadeOut("fast", function() {
			// alert("Animation done");
		});
		return false;
	});

	$('#closepopup2').click(function() {
		$('#fade , .popup_block').fadeOut("fast", function() {
		});
		return false;
	});
	$('#closepopup3').click(function() {
		$('#fade , .popup_block').fadeOut("fast", function() {
		});
		return false;
	});
	$('#closepopup4').click(function() {
		$('#fade , .popup_block').fadeOut("fast", function() {
		});
		return false;
	});
	$('#closepopup5').click(function() {
		$('#fade , .popup_block').fadeOut("fast", function() {
		});
		return false;
	});
	$('#closepopup6').click(function() {
		$('#fade , .popup_block').fadeOut("fast", function() {
		});
		return false;
	});
	$('#closepopup7').click(function() {
		$('#fade , .popup_block').fadeOut("fast", function() {
		});
		return false;
	});
	$('#closepopup8').click(function() {
		$('#fade , .popup_block').fadeOut("fast", function() {
		});
		return false;
	});
	$('#closepopup9').click(function() {
		$('#fade , .popup_block').fadeOut("fast", function() {
		});
		return false;
	});
	$('#closepopup10').click(function() {
		$('#fade , .popup_block').fadeOut("fast", function() {
		});
		return false;
	});
	$('#closepopup11').click(function() {
		$('#fade , .popup_block').fadeOut("fast", function() {
		});
		return false;
	});
	$('#closepopup12').click(function() {
		$('#fade , .popup_block').fadeOut("fast", function() {
		});
		return false;
	});
	$('#closepopup13').click(function() {
		$('#fade , .popup_block').fadeOut("fast", function() {
		});
		return false;
	});
	$('#closepopup14').click(function() {
		$('#fade , .popup_block').fadeOut("fast", function() {
		});
		return false;
	});
	$('#closepopup15').click(function() {
		$('#fade , .popup_block').fadeOut("fast", function() {
		});
		return false;
	});
	$('#closepopup16').click(function() {
		$('#fade , .popup_block').fadeOut("fast", function() {
		});
		return false;
	});
	$('#closepopup17').click(function() {
		$('#fade , .popup_block').fadeOut("fast", function() {
		});
		return false;
	});
	$('#closepopup18').click(function() {
		$('#fade , .popup_block2').fadeOut("fast", function() {
		});
		return false;
	});
	$('#closepopup19').click(function() {
		$('#fade , .popup_block').fadeOut("fast", function() {
		});
		return false;
	});
	$('#closepopup20').click(function() {
		$('#fade , .popup_block').fadeOut("fast", function() {
		});
		return false;
	});
	$('#viewpopupclose').click(function() {
		$('#fade , .popup_block').fadeOut("fast", function() {
		});
		return false;
	});

	$('#close_existing2').click(function() { // When clicking on the close or fade layer...
		$('#fade1 , .popup_block2').fadeOut("fast", function() {
			// alert("Animation done");
		});
		return false;
	});
	$('#close_existing4').click(function() { // When clicking on the close or fade layer...
		$('#fade1 , #selectInactive').fadeOut("fast", function() {});
		return false;
	});
	
	$('#close_existing5').click(function() { // When clicking on the close or fade layer...
		$('#fade , .popup_block2').fadeOut("fast", function() {});
		return false;
	});
	$('#close_existing6').click(function() { // When clicking on the close or fade layer...
		$('#fade1 , .popup_block2').fadeOut("fast", function() {});
		return false;
	});
});
function closePopup() {
	$('#fade1 , .popup_block2').fadeOut("fast", function() {
		// alert("Animation done");
	});
}

function closePopup1() {
	$('#fade1 , .popup_block').fadeOut("fast", function() {
	//	alert("Animation done");
	});
}
function closePopup2() {
	$('#fade1 , .popup_block1').fadeOut("fast", function() {
		//	alert("Animation done");
	});
}

function closePopUpCredit()
{
	$('#fade1 , .popup_block2').fadeOut("fast", function() {
	});
	return false;
}

function closePopUpCredit1()
{
	$('#fade , .popup_block').fadeOut("fast", function() {
	});
	return false;
}

function closePopUpCredit2()
{
	$('#fade , .popup_block2').fadeOut("fast", function() {
	});
	return false;
}
/*
 * @Author Kartikeys @Date: 24-01-2013
 * This method is used to close report_franchisees pop up screen.
 */

// method for popup message on profile save
function popupNew(popID, popWidth) {
	//alert('Hekko'+popID);
	// Pull Query & Variables from href URL
	// Fade in the Popup and add close button
	$('#' + popID).fadeIn().css({
		'width' : popWidth + "%"
	});
	// Define margin for center alignment (vertical horizontal) - we add 80px to
	// the height/width to accomodate for the padding and border width defined in the css
	var popMargTop = ($('#' + popID).height() + 80) / 2;
	var popMargLeft = ($('#' + popID).width() + 80) / 2;
	// Apply Margin to Popup
	$('#' + popID).css({
		'margin-top' : -popMargTop,
		'margin-left' : -popMargLeft
	});
	// Fade in Background
	/*$('body').append('<div id="fade"></div>'); // Add the fade layer to bottom of the body tag.
	$('#fade').css({
		'filter' : 'alpha(opacity=80)'
	}).fadeIn(); // Fade in the fade layer - .css({'filter' : 'alpha(opacity=80)'}) is used to fix the IE Bug on fading transparencies
*/	return false;
}
// method for popup message on profile save
function popupNew1(popID, popWidth) {
	// Pull Query & Variables from href URL
	// Fade in the Popup and add close button
	$('#' + popID).fadeIn().css({
		'width' : Number(popWidth)
	});
	// Define margin for center alignment (vertical horizontal) - we add 80px to
	// the height/width to accomodate for the padding and border width defined
	// in the css
	var popMargTop = ($('#' + popID).height() + 80) / 2;
	var popMargLeft = ($('#' + popID).width() + 80) / 2;
	// Apply Margin to Popup
	$('#' + popID).css({
		'margin-top' : -popMargTop,
		'margin-left' : -popMargLeft
	});
	// Fade in Background
	$('body').append('<div id="fade1"></div>'); // Add the fade layer to bottom of the body tag.
	$('#fade1').css({
		'filter' : 'alpha(opacity=80)'
	}).fadeIn(); // Fade in the fade layer - .css({'filter' : 'alpha(opacity=80)'}) is used to fix the IE Bug on fading transparencies
	return true;
}
