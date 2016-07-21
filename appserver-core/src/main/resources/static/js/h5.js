/**
 * Created by lizhw on 2016/4/29.
 */
function fPostData(url, dataObj, callback) {
    $.ajax({
        type: "post",
        contentType: "application/json",
        url: url,
        data: JSON.stringify(dataObj),
        dataType: "json",
        success: function (data) {
            console.log(data);
            callback(data);
        }, error: function (data) {
            console.log(data);
        }
    });
}

function fGetDate(url, dataObj, callback) {
    $.ajax({
        type: "post",
        url: url,
        data: JSON.stringify(dataObj),
        dataType: "json",
        success: function (data) {
            console.log(data);
            callback(data);
        },
        error: function (data) {
            console.log(data);
        }
    });
}

function fGetFormData(frm) {
    var $f = $(frm);
    var data = {};
    $("input[name]", $f).each(function () {
        var $i = $(this);
        var v = $i.val();
        if (($i.attr("type") + "").toLowerCase() == "password") {
            v = $.md5(v);
        }
        data[$i.attr("name")] = v;
    });
    return data;
}
function fPostForm(frm, callback) {
    var data = fGetFormData(frm);
    var url = $(frm).attr("action");
    fPostData(url, data, callback);
}

function submitForm(frm) {
    var url = $(frm).attr("action");
    var data = fGetFormData(frm);
    fPostData(url, data, function (d) {
        $(".result", $f).remove();
        $f.append("<div class='result'>" + d + "</div>")
    });
}
function showLogin() {
    var d = $('#loginModal');
    d.modal('show');

}

function login(frm) {
    fPostForm(frm, function (data) {
        if (data == null) {
            return;
        } else if (data.error != null && data.error != "") {
            $("#loginErrMsg").html(data.error);
            $("#loginErrMsg").show();
        } else {
            $('#loginModal').modal('hide');
            getShopInfo();
        }
    });
}


function getShopInfo() {
    var url = "/home/getShop";
    fGetDate(url, {}, function (data) {
        if (data == null) {
            return;
        } else if (data.error == "needLogin") {
            showLogin();
        } else {
            $("#mainPanel .field").each(function () {
                var $f = $(this);
                var fName = $f.attr("name");
                if ($f.hasClass("pic")) {
                    var url = data[fName];
                    $f.html("<img src='" + url + "'/>");
                } else {
                    $f.html(data[fName]);
                }

            });

        }
    });
}
$(function () {
    getShopInfo();
});