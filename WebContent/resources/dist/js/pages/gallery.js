//<![CDATA[
window.onload = function () {

    var list_zone = document.getElementById("inner_list");
    var list_a = list_zone.getElementsByTagName("a");
    document.getElementById("inner_list").style.width = (list_a.length * 100) + 100 + "px";

    for (var i = 0; i < list_a.length; i++) {
        list_a[i].onclick = function () {
            var ph = document.getElementById("photo").children[0];
            ph.src = this.href;
            return false;
        }
    }

    var m_num = 0;

    var before_btn = document.getElementById("before_btn");
    before_btn.onclick = function () {
        if (m_num <= 0)
            return false;
        m_num--;
        list_zone.style.marginLeft = -100 * m_num + "px";

        return false;
    }

    var next_btn = document.getElementById("next_btn");
    next_btn.onclick = function () {
        if (m_num >= list_a.length - 3)
            return false;
        m_num++;
        list_zone.style.marginLeft = -100 * m_num + "px";

        return false;
    }
}
//]]>