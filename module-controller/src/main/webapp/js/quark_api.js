/*链接*/
var project_api = "http://localhost:8080/community"
var community_login_api = project_api + "/login/signIn";
var community_getUser_api = project_api + "/message/";
var community_logout_api = project_api + "/login/signOut";
var community_register_api = project_api + "/login/regist";
var community_upload_api = project_api + "/image/uploadImg";
var community_upload_icon_api = project_api + "/image/upload/";
var community_posts_add_api = project_api + "/add/addInfo";
var community_posts_get_api = project_api + "/post/esther";
var community_posts_detail_api = project_api + "/post/detail/";
var community_reply_add_api = project_api + "/reply/replyInfo";
var community_label_getall_api = project_api + "/label/findLabels";
var community_rank_posts_api = project_api + "/rank/topPost";
var community_rank_users_api = project_api + "/rank/newUser";
var community_user_detail_api = project_api + "/login/detail/";
var community_user_update_api = project_api + "/message/updateUser/";
var community_user_update_psd_api = project_api + "/message/forget/";
var community_label_posts_api = project_api + "/label/findLabelDetail/";
var community_webSocket_api = "http://127.0.0.1:8081/quarkServer";
var community_notification_api = project_api + "/reply/notification/";
var community_chat_webSocket_api = "ws://127.0.0.1:8083/websocket";

function setCookie(data) {
    var expiresDate = new Date();
    expiresDate.setTime(expiresDate.getTime() + (60 * 60 * 1000));
    $.cookie("QUARK_TOKEN", data, {
        path: '/',
        expires: 1
    });
}

function getCookie() {
    return $.cookie('QUARK_TOKEN');
}

function deleteCookie() {
    $.cookie("QUARK_TOKEN", null, {
        path: '/'
    });
}

(function ($) {
    $.getUrlParam = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    }
})(jQuery);

function applyHeader() {
    var htm;
    $.get(community_getUser_api + getCookie(), function (data) {
        if (data.status == 200) {
            htm = "<a class='avatar' href='/community/user/setting'>" +
                "<img src='" + data.data.icon + "'>" +
                "<cite>" + data.data.username + "</cite>" +
                "</a>" +
                "<div class='nav'>" +
                "<a href='/community/user/setting'><i class='iconfont icon-shezhi'></i>设置</a>" +
                "<a href='' onclick='logout()'><i class='iconfont icon-tuichu' style='top: 0; font-size: 22px;'></i>退了</a>" +
                "</div>";
        } else {
            htm = "<a class='unlogin' href='#'><i class='iconfont icon-touxiang'></i></a>" +
                "<span><a href='/community/user/login'>登入</a><a href='/community/user/register'>注册</a></span>";
        }

        $(".nav-user").append(htm);
    });
}

function logout() {

    $.post(community_logout_api, {
        token: getCookie()
    }, function (obj) {
        if (obj.status == 200) {
            deleteCookie();
            location.href = "/index";
        } else {
            layer.msg(obj.msg, {icon: 5});
        }
    });

}