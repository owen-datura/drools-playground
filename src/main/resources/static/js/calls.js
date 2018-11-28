"use strict"

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
		  })
	}
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

function filterCallingRecords(filterId) {
	let url = '/calls/filterByRuleSet/' + filterId;
	fetch(url, {
		method: 'post'
	})
	.then( response => response.json())
	.then( json => {
		app.calls = json;
	});
};

document.getElementById('btnFilterLgCo').addEventListener('click', event => {
	event.preventDefault();
	const filterId = event.target.dataset.filterid;
	filterCallingRecords(filterId);
});

document.getElementById('btnFilterAmOnPrem').addEventListener('click', event => {
	event.preventDefault();
	const filterId = event.target.dataset.filterid;
	filterCallingRecords(filterId);
});