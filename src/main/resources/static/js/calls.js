"use strict";

function createCallRecord(record) {
	let output = 
	`
	  <h3>Hello</h3>
	`;
	
	return output;
}

fetch('/calls')
	.then( response => {
		return response.json();
	}).then( payload => {
		const callContainer = document.getElementById('callList');
		payload.forEach(c => {
			callContainer.innerHTML += createCallRecord(c);
		});
	});