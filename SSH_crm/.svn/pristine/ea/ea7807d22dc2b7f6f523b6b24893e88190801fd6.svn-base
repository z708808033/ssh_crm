//创建XMLHttpRequest对象
function createXMLHttpRequest() {
	try {
		return new XMLHttpRequest();
	} catch(e) {
		try {
			return ActiveXObject("Msxml2.XMLHTTP");
		} catch(e) {
			try {
				return ActiveXObject("Microsoft.XMLHTTP");
			} catch(e) {
				throw e;
			}
		}
	}
}

/*
 * option对象有如下属性:
 * method:请求方式.默认为GET请求
 * url:请求url.
 * asyn:是否异步.默认为true
 * params:请求体内容.
 * callback:回调方法.
 * type:服务器响应数据转换的类型.默认为Text
 */
function ajax(option) {
	/*
	 * 获得XMLHttpRequest对象
	 */
	var xmlHttp = createXMLHttpRequest();
	/*
	 * 连接服务器
	 */
	if(!option.method) {		//默认为GET请求
		option.method = "GET";
	}
	if(option.asyn == undefined) {	//默认为true
		option.asyn = true;
	}
	xmlHttp.open(option.method,option.url,option.asyn);
	/*
	 * 判断如果是POST请求则设置请求头
	 */
	if("POST" == option.method) {
		xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	}
	/*
	 * 发送请求
	 */
	xmlHttp.send(option.params);
	/*
	 * 注册监听
	 */
	xmlHttp.onreadystatechange = function() {
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200) {
			var data;
			//获取服务器的响应数据,进行转换
			if(!option.type) {			//默认为Text类型
				data = xmlHttp.responseText;
			}
			else if(option.type == "xml") {
				data = xmlHttp.responseXML;
			}else if(option.type == "text"){
				data = xmlHttp.responseText;
			}else if(option.type == "json"){
				var text = xmlHttp.responseText;
				data = eval("(" + text + ")");
			}
			option.callback(data);
		}
	};
}