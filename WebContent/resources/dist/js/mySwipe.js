$(function () {
    window.mySwipe = $('#mySwipe').Swipe({
        startSlide: 0, // 초기 노출 인덱스
        auto: 0, // 자동이동 시간
        continuous: true, // 반복여부
        disableScroll: true, // 스크롤바
        stopPropagation: true, // 하위 요소에 이벤트 전달을 차단
        callback: function (i, d) {
            let prevImg = $(".touch_bullet img[src*='on.png']");
            prevImg.attr("src", prevImg.attr("src").replace("on.png", "off.png"));

            let currentImg = $(".touch_bullet img").eq(i);
            currentImg.attr("src", currentImg.attr("src").replace("off.png", "on.png"));
        }
    }).data('Swipe');

    $(".touch_left_btn").click(() => mySwipe.prev());
    $(".touch_right_btn").click(() => mySwipe.next());
});