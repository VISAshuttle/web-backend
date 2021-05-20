$(function () {
    var g = "https://api.rss2json.com/v1/api.json?rss_url=";

    $("#news_wrap h2 a").click(function (e) {
        e.preventDefault();
        $("#news_wrap h2 a").removeClass("on");
        $(this).addClass("on");
        $.ajax({
            url: g + $(this).attr("href"),
            dataType: "json",
            success: function (data) {
                $("#news_list").empty();

                $.each(data.items, function (i, d) {
                    if (i == 5) return false;

                    var title = d["title"];
                    var date = new Date(d["pubDate"]);
                    var m = date.getFullYear() + "-"
                        + (date.getMonth() + 1) + "-"
                        + date.getDate();
                    var lk = d["link"];

                    $("#news_list").append(
                        '<li><a href="' + lk + '" target="_blank">'
                        + title + '</a> <span>' + m
                        + '</span></li>');
                });
            }
        });
    });

    $("#news_wrap h2 a:eq(0)").click().addClass("on");
});