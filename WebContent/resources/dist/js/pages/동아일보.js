$(document).ready(function() {
	function formatDate(d) {
		var year = "" + d.getFullYear(),
			month = "" + (d.getMonth() + 1),
			day = "" + d.getDate(),
			hour = "" + d.getHours(),
			minute = "" + d.getMinutes();

		if (month.length < 2) month = "0" + month;
		if (day.length < 2) day = "0" + day;
		if (hour.length < 2) hour = "0" + hour;
		if (minute.length < 2) minute = "0" + minute;

		return year + "-" + month + "-" + day + " " + hour + ":" + minute;
	}

	var rss2json = "https://api.rss2json.com/v1/api.json";
	var params = {
		rss_url: "https://rss.donga.com/total.xml",
		api_key: "ivwtyyw2ovenmjzcrf3jpedqrnsr7tn2s4xfsfhb",
		order_by: "pubDate",
		order_dir: "desc",
		count: 200
	};
	$.ajax({
		url: rss2json.concat("?", $.param(params)),
		dataType: "json",
		success: function(response) {
			$.each(response.items, function(i, d) {
				var thumbnail = d["thumbnail"],
					title = d["title"],
					pubDate = formatDate(new Date(new Date(d["pubDate"]).getTime() + 32400000)),
					link = d["link"];
				$("#donga tbody").append(
					"<tr>" +
					"<td>" + "<a href='" + link + "' target='_blank'>" + "<img src='" + thumbnail + "'>" + "</a>" + "</td>" +
					"<td>" + "<a href='" + link + "' target='_blank'>" + title + "</a>" + "</td>" +
					"<td>" + pubDate + "</td>" +
					"</tr>"
				);
			});
		},
		complete: function() {
			$("#donga tbody img").attr({
				width: 150 + "px",
				height: 100 + "px"
			});
			$("#donga tbody tr td:first-child").css("width", function() {
				return $("img", $(this)).attr("width");
			});
			$('#donga').DataTable({
				"language": {
					"sEmptyTable": "데이터가 없습니다",
					"sInfo": "_START_ - _END_ / _TOTAL_",
					"sInfoEmpty": "0 - 0 / 0",
					"sInfoFiltered": "(총 _MAX_ 개)",
					"sInfoPostFix": "",
					"sInfoThousands": ",",
					"sLengthMenu": "페이지당 줄수 _MENU_",
					"sLoadingRecords": "읽는중...",
					"sProcessing": "처리중...",
					"sSearch": "검색:",
					"sZeroRecords": "검색 결과가 없습니다",
					"oPaginate": {
						"sFirst": "처음",
						"sLast": "마지막",
						"sNext": "다음",
						"sPrevious": "이전"
					},
					"oAria": {
						"sSortAscending": ": 오름차순 정렬",
						"sSortDescending": ": 내림차순 정렬"
					}
				}
			}); // end of DataTable()
		}
	});
})