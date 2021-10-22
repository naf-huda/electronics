document.addEventListener("DOMContentLoaded", function () {

	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function () {

		if (xhr.readyState === 4) {

			console.log(xhr.responseText);

			var orderArray = JSON.parse(xhr.responseText);

			orderArray.forEach(orderElement => {
				addOrderToTable(orderElement);
			});
		}
	}

	xhr.open('GET', '/electronics/api/orders');

	xhr.send();

});


function addOrderToTable(order) {

	var tr = document.createElement('tr');

	var id = document.createElement('td');
	var full_name = document.createElement('td');
	var product_name = document.createElement('td');
	var price = document.createElement('td');
	var company = document.createElement('td');
	var category = document.createElement('td');
	var stock = document.createElement('td');
	var order_date = document.createElement('td');
	var order_status = document.createElement('td');

	id.innerText = order.id;
	full_name.innerText = order.full_name;
	product_name.innerText = order.product_name;
	price.innerText = order.price;
	company.innerText = order.company;
	category.innerText = order.category;
	stock.innerText = order.stock;
	order_date.innerText = order.order_date;
	order_status.innerText = order.order_status;

	tr.appendChild(id);
	tr.appendChild(full_name);
	tr.appendChild(product_name);
	tr.appendChild(price);
	tr.appendChild(company);
	tr.appendChild(category);
	tr.appendChild(stock);
	tr.appendChild(order_date);
	tr.appendChild(order_status);

	document.getElementById('order-table-body').appendChild(tr);

}

function deleteOrderFromTable(id) {
	var length = document.getElementById('order-table-body').rows.length;
	for (let i = 0; i < length; i++) {
		// find row to be deleted
		console.log(document.getElementById('order-table-body').rows[i].cells[0].value);
		if (document.getElementById('order-table-body').rows[i].cells[0].value == id) {
			// delete row
			document.getElementById('order-table-body').deleteRow(i);
		}
	}
}



document.getElementById('add').addEventListener('click', function (event) {
	event.preventDefault();		// prevent default form actions from occuring

	// get the data from the form
	var fullNameOnForm = document.getElementById('order-full-name').value;		// retrieve the data in the title input box
	var productNameOnForm = document.getElementById('order-product-name').value;	// retrieve the data in the rating input box
	var priceOnForm = document.getElementById('order-price').value;
	var companyOnForm = document.getElementById('order-company').value;
	var categoryOnForm = document.getElementById('order-category').value;
	var stockOnForm = document.getElementById('order-stock').value;
	var orderDateOnForm = document.getElementById('order-order-date').value;
	var orderStatusOnForm = document.getElementById('order-order-status').value;

	// ES6+ allows for object literal syntax: basically JSON objects on the fly
	var order = {
		full_name: fullNameOnForm,
		product_name: productNameOnForm,
		price: priceOnForm,
		company: companyOnForm,
		category: categoryOnForm,
		stock: stockOnForm,
		order_date: orderDateOnForm,
		order_status: orderStatusOnForm
	};

	// make AJAX call


	// 1. make an xhr object (ready state is 0)
	let xhr = new XMLHttpRequest();		// make HTTP requests

	// 2. define what happens during the AJAX call
	xhr.onreadystatechange = function () {

		if (xhr.readyState === 4) {

			// getting back the updated movie object
			var updatedOrder = JSON.parse(xhr.responseText);

			// adding the updated movie to our table
			addOrderToTable(updatedOrder);

			// reset the form
			document.getElementById('delete-order-form').reset();

			location.reload();
		}
	}


	// 3. open the xhr call with the http request verb and the url
	xhr.open('POST', '/electronics/api/orders');

	// 4. send the ajax call
	xhr.send(JSON.stringify(order));	// converting from variable to JSON and sending it in the POST request
});


document.getElementById('delete').addEventListener('click', function (event) {
	event.preventDefault();

	// get id from the form
	var idOnForm = document.getElementById('order-id').value;

	// find data for delete row by searching for its id
	var length = document.getElementById('order-table-body').rows.length;
	var index = 0;
	for (let i = 0; i < length; i++) {
		// find row to be deleted
		if (document.getElementById('order-table-body').rows[i].cells[0].value == id) {
			index = i;
		}
	}
		// get the data from the form
		var idOnForm = document.getElementById('order-id').value;
		var fullNameOnForm = document.getElementById('order-full-name').value;		// retrieve the data in the title input box
		var productNameOnForm = document.getElementById('order-product-name').value;	// retrieve the data in the rating input box
		var priceOnForm = document.getElementById('order-price').value;
		var companyOnForm = document.getElementById('order-company').value;
		var categoryOnForm = document.getElementById('order-category').value;
		var stockOnForm = document.getElementById('order-stock').value;
		var orderDateOnForm = document.getElementById('order-order-date').value;
		var orderStatusOnForm = document.getElementById('order-order-status').value;

		// ES6+ allows for object literal syntax: basically JSON objects on the fly
		var order = {
			id: idOnForm,
			full_name: fullNameOnForm,
			product_name: productNameOnForm,
			price: priceOnForm,
			company: companyOnForm,
			category: categoryOnForm,
			stock: stockOnForm,
			order_date: orderDateOnForm,
			order_status: orderStatusOnForm
		};

		var id = {
			id: idOnForm
		};

		// make AJAX call
		// 1. make an xhr object (ready state is 0)
		let xhr = new XMLHttpRequest();		// make HTTP requests

		// 2. define what happens during the AJAX call
		xhr.onreadystatechange = function () {

			if (xhr.readyState === 4) {

				// deleting order from our table
				deleteOrderFromTable(id);

				// reset the form
				document.getElementById('delete-order-form').reset();

				location.reload();
			}
		}


		// 3. open the xhr call with the http request verb and the url
		xhr.open('DELETE', '/electronics/api/orders');

		// 4. send the ajax call
		xhr.send(JSON.stringify(order));	// converting from variable to JSON and sending it in the DELETE request

	});


document.getElementById('update').addEventListener('click', function(event) {
	event.preventDefault();		// prevent default form actions from occuring

	// get the data from the form
	var idOnForm = document.getElementById('order-id').value;
	var fullNameOnForm = document.getElementById('order-full-name').value;		// retrieve the data in the title input box
	var productNameOnForm = document.getElementById('order-product-name').value;	// retrieve the data in the rating input box
	var priceOnForm = document.getElementById('order-price').value;
	var companyOnForm = document.getElementById('order-company').value;
	var categoryOnForm = document.getElementById('order-category').value;
	var stockOnForm = document.getElementById('order-stock').value;
	var orderDateOnForm = document.getElementById('order-order-date').value;
	var orderStatusOnForm = document.getElementById('order-order-status').value;

	// ES6+ allows for object literal syntax: basically JSON objects on the fly
	var order = {
		id: idOnForm,
		full_name: fullNameOnForm,
		product_name: productNameOnForm,
		price: priceOnForm,
		company: companyOnForm,
		category: categoryOnForm,
		stock: stockOnForm,
		order_date: orderDateOnForm,
		order_status: orderStatusOnForm
	};


	var id = {
		id: idOnForm
	};


	// make AJAX call

	// 1. make an xhr object (ready state is 0)
	let xhr = new XMLHttpRequest();		// make HTTP requests

	// 2. define what happens during the AJAX call
	xhr.onreadystatechange = function() {

		if (xhr.readyState === 4) {

			deleteOrderFromTable(id);

			// adding the new order to our table
			addOrderToTable(order);

			// reset the form
			document.getElementById('delete-order-form').reset();

			location.reload();
		}
	}

	// 3. open the xhr call with the http request verb and the url
	xhr.open('PUT', '/electronics/api/orders');

	// 4. send the ajax call
	xhr.send(JSON.stringify(order));	// converting from variable to JSON and sending it in the POST request
});

