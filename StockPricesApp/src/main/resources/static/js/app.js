$(function() {
	var socket = new SockJS('/stocks-prices');
	var stompClient = Stomp.over(socket);

	stompClient.connect({}, function(frame) {
		console.log('Connected: ' + frame);
		stompClient.subscribe('/topic/stocks', function(message) {
			var stock = JSON.parse(message.body);
			updateStockTable(stock);
		});
	});

	
		function updateStockTable(stocks) {
			for (var i = 0; i < stocks.length; i++) {
				var stock = stocks[i];
				var tableRow = $('#stock-table').find('tr#' + stock.stockName);

				if (tableRow.length === 0) {
					tableRow = $('<tr>').attr('id', stock.stockName).appendTo('#stock-table tbody');
					tableRow.append($('<td>').text(stock.stockName));
					tableRow.append($('<td>').text(stock.stockPrice));
				} else {
					tableRow.find('td:last-child').text(stock.stockPrice);
				}
			}
		}

	});