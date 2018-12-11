var DateUtils = {
	/**
     * 扩展Date 对象格式化方法
     */
    expandDate : function() {
        Date.prototype.format = function(fmt)   
        { //author: meizz   
          var o = {   
            "M+" : this.getMonth()+1,                 //月份   
            "d+" : this.getDate(),                    //日   
            "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时           
            "H+" : this.getHours(),                   //小时 
            "m+" : this.getMinutes(),                 //分   
            "s+" : this.getSeconds(),                 //秒   
            "q+" : Math.floor((this.getMonth()+3)/3), //季度   
            "S"  : this.getMilliseconds()             //毫秒   
          };   
          if(/(y+)/.test(fmt))   
            fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
          for(var k in o)   
            if(new RegExp("("+ k +")").test(fmt))   
          fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
          return fmt;   
        }
    },
	/**
	 * 获取具体年龄
	 * @param {} beginStr
	 * @param {} endStr
	 * @return {}
	 */
	getAgeInfo: function (beginStr, endStr) {
        var reg = new RegExp(/^(\d{1,4})(-|\/)(\d{1,2})(-|\/)(\d{1,2})(\s)(\d{1,2})(:)(\d{1,2})(:{0,1})(\d{0,2})$/);
		var beginArr = beginStr.match(reg);
		var endArr = endStr.match(reg);
	
		var days = 0;
		var month = 0;
		var year = 0;
	
		days = endArr[5] - beginArr[5];
		if (days < 0) {
			month = -1;
			days = 30 + days;
		}
	
		month = month + (endArr[3] - beginArr[3]);
		if (month < 0) {
			year = -1;
			month = 12 + month;
		}
	
		year = year + (endArr[1] - beginArr[1]);
	
		var yearString = year > 0 ? year + "岁" : "";
		var mnthString = month > 0 ? month + "月" : "";
		var dayString = days > 0 ? days + "天" : "";
	
		/*
		 * 1 如果岁 大于等于1 那么年龄取 几岁 2 如果 岁等于0 但是月大于1 那么如果天等于0天小于3天 取小时 例如出生2天 就取 48小时
		 */
		var result = "";
		if (year >= 1) {
			result = yearString + mnthString;
		} else {
			if (month >= 1) {
				result = days > 0 ? mnthString + dayString : mnthString;
			} else {
				var begDate = new Date(beginArr[1], beginArr[3] - 1, beginArr[5],
						beginArr[7], beginArr[9], beginArr[11]);
				var endDate = new Date(endArr[1], endArr[3] - 1, endArr[5],
						endArr[7], endArr[9], endArr[11]);
	
				var between = (endDate.getTime() - begDate.getTime()) / 1000;
				days = Math.floor(between / (24 * 3600));
				var hours = Math.floor(between / 3600 - (days * 24));
				var dayString = days > 0 ? days + "天" : "";
				result = days >= 3 ? dayString : days * 24 + hours + "小时";
			}
		}
	
		return result;
    },
    /**
     * 获取年龄，不满一天算天
     * @param {} birthday
     * @param {} today
     * @return {}
     */
    getAge :function(birthday,today) {
    	var reg = new RegExp(/^(\d{1,4})(-|\/)(\d{1,2})(-|\/)(\d{1,2})$/);
    	var beginArr = birthday.match(reg);
        var endArr = today.match(reg);
    
        var days = 0;
        var month = 0;
        var year = 0;
    
        days = endArr[5] - beginArr[5];
        if (days < 0) {
            month = -1;
            days = 30 + days;
        }
    
        month = month + (endArr[3] - beginArr[3]);
        if (month < 0) {
            year = -1;
            month = 12 + month;
        }
    
        year = year + (endArr[1] - beginArr[1]);
    
        var yearString = year > 0 ? year + "岁" : "";
        var mnthString = month > 0 ? month + "月" : "";
        var dayString = days > 0 ? days + "天" : "1天";
        
        /*
         * 1 如果岁 大于等于1 那么年龄取 几岁 2 如果 岁等于0 但是月大于1 name取几月 3 如果不足月， 则取天数 4 不满一天算一天
         */
        var result = "";
        if (year >= 1) {
            result = yearString + mnthString + dayString;
        } else {
            if (month >= 1) {
                result = days > 0 ? mnthString + dayString : mnthString;
            } else {
                result = dayString;
            }
        }
        return result;
    },
    /**
     * 获取月龄
     * @param {} birthday
     * @param {} today
     * @return {}
     */
    getMonthage :function(birthday,today) {
        var reg = new RegExp(/^(\d{1,4})(-|\/)(\d{1,2})(-|\/)(\d{1,2})$/);
        var beginArr = birthday.match(reg);
        var endArr = today.match(reg);
    
        var days = 0;
        var month = 0;
        var year = 0;
    
        days = endArr[5] - beginArr[5];
        if (days < 0) {
            month = -1;
            days = 30 + days;
        }
    
        month = month + (endArr[3] - beginArr[3]);
        if (month < 0) {
            year = -1;
            month = 12 + month;
        }
    
        year = year + (endArr[1] - beginArr[1]);
    
        var result = "";
        if (year >= 1) {
            result = (year * 12 + month + 1) + "个月";
        } else {
            if (month >= 1) {
                result = (month + 1) + "个月";
            } else {
                result = "1个月";
            }
        }
        return result;
    },
    // 获取当前月的第一天
    getCurrentMonthFirst:function(){
        var date=new Date();
        date.setDate(1);
        date.setHours(0);
        date.setMinutes(0);
        date.setSeconds(0);
        return date;
    },
    // 获取当前月的最后一天
    getCurrentMonthLast:function(){
        var date=new Date();

        var currentMonth=date.getMonth();
        var nextMonth=++currentMonth;
        var nextMonthFirstDay=new Date(date.getFullYear(),nextMonth,1,23,59,59);
        var oneDay=1000*60*60*24;
        return new Date(nextMonthFirstDay-oneDay);
    },
    /**
     *日期格式化 str:格式化字符，d:js日期对象或long值，d为空则自动获取当前日期格式化
     */
    dateFormat:function(str,d) {
        if( this.checkNull(str)){  //如果格式化字符为空，返回空字符
            return "";
        }
        if(this.checkNull(d)){  //如果日期为空，自动获取当前日期
            d=new Date();
        }else if(d.constructor!=Date){//如果参数不是一个日期对象，就认为是一个标准Long值日期
            d=new Date(d);
        }
        return  str.replace("yyyy",d.getFullYear()).replace("MM",this.fillZero(d.getMonth()+1)).replace("dd",this.fillZero(d.getDate())).replace("HH",this.fillZero( d.getHours())).replace("mm",this.fillZero(d.getMinutes())).replace("ss",this.fillZero(d.getSeconds())).replace("sss",d.getMilliseconds());
    },
    //填充0
    fillZero:function (value){
        if(value.toString().length<2){
            return "0"+value;
        }
        return value;
    },
    //判空
    checkNull:function(value){
        if(!value||value==null||typeof(value) == "undefined"||value==""){
            return true;
        }
        return false;
    }
}