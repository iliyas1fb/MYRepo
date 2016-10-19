/*
 * SimpleModal Confirm Modal Dialog
 * http://simplemodal.com
 *
 * Copyright (c) 2013 Eric Martin - http://ericmmartin.com
 *
 * Licensed under the MIT license:
 *   http://www.opensource.org/licenses/mit-license.php
 */

jQuery(function ($) {
	$('#confirm-dialog input.confirm, #confirm-dialog a.confirm').click(function (e) {
		e.preventDefault();

		// example of calling the confirm function
		// you must use a callback function to perform the "yes" action
		confirm("", function () {
			window.location.href = '#';
		});
	});
});

function confirm(message, callback) {
	$('#confirm').modal({
		closeHTML: "<a href='#' title='Close' class='modal-close'>x</a>",
		position: ["10%",],
		overlayId: 'confirm-overlay',
		
		containerId: 'confirm-container', 
		onShow: function (dialog) {
			var modal = this;

			$('.message', dialog.data[0]).append(message);

			// if the user clicks "yes"
			$('.yes', dialog.data[0]).click(function () {
				// call the callback
				if ($.isFunction(callback)) {
					callback.apply();
				}
				// close the dialog
				modal.close(); // or $.modal.close();
			});
		}
	});
}

jQuery(function ($) {
	$('#confirm-dialog input.confirm1, #confirm-dialog a.confirm1   ').click(function (f) {
		f.preventDefault();

		// example of calling the confirm function
		// you must use a callback function to perform the "yes" action
		confirm1("", function () {
			window.location.href = '#';
		});
	});
});

function confirm1(message, callback) {
	$('#confirm1  ' ).modal({
		closeHTML: "<a href='#' title='Close' class='modal-close'>x</a>",
		position: ["10%",],
		overlayId: 'confirm-overlay',
		
		containerId: 'confirm-container', 
		onShow: function (dialog) {
			var modal = this;

			$('.message', dialog.data[0]).append(message);

			// if the user clicks "yes"
			$('.yes', dialog.data[0]).click(function () {
				// call the callback
				if ($.isFunction(callback)) {
					callback.apply();
				}
				// close the dialog
				modal.close(); // or $.modal.close();
			});
		}
	});
}


jQuery(function ($) {
	$('#confirm-dialog input.confirm2, #confirm-dialog a.confirm2   ').click(function (f) {
		f.preventDefault();

		// example of calling the confirm function
		// you must use a callback function to perform the "yes" action
		confirm2("", function () {
			window.location.href = '#';
		});
	});
});

function confirm2(message, callback) {
	$('#confirm2  ' ).modal({
		closeHTML: "<a href='#' title='Close' class='modal-close'>x</a>",
		position: ["10%",],
		overlayId: 'confirm-overlay',
		
		containerId: 'confirm-container', 
		onShow: function (dialog) {
			var modal = this;

			$('.message', dialog.data[0]).append(message);

			// if the user clicks "yes"
			$('.yes', dialog.data[0]).click(function () {
				// call the callback
				if ($.isFunction(callback)) {
					callback.apply();
				}
				// close the dialog
				modal.close(); // or $.modal.close();
			});
		}
	});
}


