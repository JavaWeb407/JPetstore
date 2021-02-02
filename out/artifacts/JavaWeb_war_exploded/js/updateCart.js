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

function updateCart() {
    var quantity = document.getElementById("quantity").value;

    sendRequest("updateCartJS?quantity="+ quantity);
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
            var resp = xmlHttpRequest.responseText;
            var array = resp.split(",");
            var num=array;
                var quantity = document.getElementById("quantity");
                var total = document.getElementById("total");
                var subtotal = document.getElementById("subtotal");
                quantity.innerText = array[3];
                total.innerText = array[1];
                subtotal.innerText = array[2];

        }
    }
}
