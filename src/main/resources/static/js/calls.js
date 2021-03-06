/* jshint esversion: 6 */
/* globals Vue:false */

(function() {
	'use strict';

	const app = new Vue({
		el: '#app',
		data: {
			calls: []
		},
		created() {
			fetch('/calls')
			  .then(response => response.json())
			  .then(json => {
				  this.calls = json;
			  });
		}
	});

	document.getElementById('btnRunFilter').addEventListener('click', event => {
		event.preventDefault();
		fetch('/calls/filterByRuleSet', {
			method: 'post'
		}).then( response => response.json())
		.then( json => {
			app.calls = json;
		});
	});

	document.getElementById('btnCallReset').addEventListener('click', event => {
		event.preventDefault();
		fetch('/calls/reset', {
			method: 'post'
		})
		.then( response => response.json())
		.then( json => {
			app.calls = json;
		});
	});
})();
