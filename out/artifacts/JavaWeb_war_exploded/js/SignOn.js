var xmlHttpRequest;
function createXMLHttpRequest()
{
    if (window.XMLHttpRequest) //非IE浏览器
    {
        xmlHttpRequest = new XMLHttpRequest();
    }
    else if (window.ActiveObject)//IE6以上版本的IE浏览器
    {
        xmlHttpRequest = new ActiveObject("Msxml2.XMLHTTP");
    }
    else //IE6及以下版本IE浏览器
    {
        xmlHttpRequest = new ActiveObject("Microsoft.XMLHTTP");
    }
}

function usernameIsExist() {
    var username = document.getElementById('username').value;
    sendRequest("IsNameExists?username="+username);
}

function sendRequest(url) {
    createXMLHttpRequest();
    xmlHttpRequest.open("GET", url, true);
    xmlHttpRequest.onreadystatechange = processResponse;
    xmlHttpRequest.send();
}

function processResponse() {
    if (xmlHttpRequest.readyState == 4) {
        if (xmlHttpRequest.status == 200) {
            var responseInfo = xmlHttpRequest.responseXML.getElementsByTagName("msg")[0].firstChild.data;

            var div1 = document.getElementById('usernameMsg');

            if (responseInfo == "Exist") {
                div1.innerHTML = "<font color='green'>用户名存在</font>";
            } else {
                div1.innerHTML = "<font color='red'>用户名不存在,请先注册</font>";
            }
        }
    }
}
