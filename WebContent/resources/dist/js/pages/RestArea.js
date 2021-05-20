function formatDate(date) {
	var d = new Date(date),
		year = d.getFullYear(),
		month = "" + (d.getMonth() + 1),
		day = "" + d.getDate();

	if (month.length < 2)
		month = "0" + month;
	if (day.length < 2)
		day = "0" + day;

	return year + month + day;
}

$(function() {
	const API = "http://data.ex.co.kr/openapi/restinfo/restWeatherList";
	var params = {
		key: 1315651132,
		type: "json",
		sdate: formatDate(new Date()),
		stdHour: new Date(new Date().getTime() - 10800000).getHours()
	};
	$.ajax({
		url: API.concat("?", $.param(params)),
		dataType: "json",
		success: function(response) {
			$("#restarea_weather").append(
				"<thead>" + "<tr>" + 
					"<td>" + "휴게소명" + "</td>" +
					"<td>" + "도로명" + "</td>" +
					"<td>" + "기준시각" + "</td>" +
					"<td>" + "날씨" + "</td>" +
					"<td>" + "현재기온" + "</td>" +
				"</tr>" + "</thead>"
			);
			$("#restarea_weather").append("<tbody>");
			$.each(response.list, function(i, d) {
				if (i == 10)	return false;

				var unitName = d["unitName"],
					routeName = d["routeName"],
					baseTime = d["sdate"] + " " + d["stdHour"] + "시",
					weatherContents = d["weatherContents"],
					tempValue = d["tempValue"] + "℃";
				$("#restarea_weather").append(
					"<tr>" + 
						"<td>" + unitName + "</td>" +
						"<td>" + routeName + "</td>" +
						"<td>" + baseTime + "</td>" +
						"<td>" + weatherContents + "</td>" +
						"<td>" + tempValue + "</td>" +
					"</tr>"
				);
			});
			$("#restarea_weather").append("</tbody>");
		}
	});
});