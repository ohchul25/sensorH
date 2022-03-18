
function cfnCallAjax(url, type, async, data, callback) {
	$.ajax({
		url: url
		, type : type
		, contentType : "application/json"
		, dataType : "json"
		, async : async
		, data : JSON.stringify(data, cfnXssReplace)
		, success : function(response) {
			//var result = response.result;
			callback(JSON.parse(JSON.stringify(response, cfnXssReplace)));
		}
		, error : function(xhr, option, error) {
			alert("ERROR");
			/*
			var status = cfnEmpty(xhr.status);
			if (status == "403") {
				if (cfnEmpty(location.href).indexOf("localhost") == -1) {
					cfnPageMvmn('/ErrorAuthAjax.do');
				} else {
					alert("권한이 없거나 로그인정보가 없습니다.");
				}
			} else {
				if (cfnEmpty(location.href).indexOf("localhost") == -1) {
					cfnPageMvmn('/ErrorAjax.do');
				} else {
					alert("서버와 통신 중 장애가 발생 하였습니다.");
				}
			}
			*/
		}
/*		, beforeSend : function() {
			$(".loading").show();
			$(".loading").css("opacity", "20");
		}
		, complete : function() {
			$(".loading").hide();
		}*/
	});
}

// json data xss replace 처리
function cfnXssReplace(key, value) {
	var val = value;
	if (typeof value === "string") {
		if ($.isNotEmpty(value)) {
			//val = val.replace(/[']/gi, "&#039;").replace(/["]/gi, "&#034;");
			val = val.replace(/<(\/script|script)([^>]*)>(.*?)<(\/?)script>/gi,"");
			val = val.replace(/<(\/script|script)([^>]*)>/gi,"");
			val = val.replace(/\javascript:/g,"");
			val = val.replace(/\vbscript:/g, "");
			val = val.replace(/\onload/g, "");
			val = val.replace(/\onclick/g, "");
			val = val.replace(/\onmouseover/g, "");
		    val = val.replace(/\onmouseout/g, "");
		    val = val.replace(/\expression/g, "");
		    val = val.replace(/\</g, "");
		    val = val.replace(/\>/g, "");
		}
	}
	return val;
}

(function( $ ) {
	/*
		빈갑 여부 확인
		ex) $.isEmpty('') -> true
			$.isEmpty('test') -> false
    /*/
	$.isEmpty = function(obj){
        return (!obj || undefined === obj || null === obj);
    };

	/*
		빈값이 아닌지 여부 확인
		ex) $.isNotEmpty('') -> false
			$.isNotEmpty('test') -> true
	/*/
    $.isNotEmpty = function(obj){
        return (!obj || undefined === obj || null === obj)?false:true;
    };

	/*
		 숫자인지 확인
		ex) $.isNumeric(0) -> true
			$.isNumeric('test') -> false
	/*/
    $.isNumeric = function(obj){
        var regExp = /^[0-9]+$/g;
        return regExp.test(obj);
    };

    /*
		핸드폰번호 형식인지 확인
	    ex) $.isMoblphonNo('01012345678') -> true
			$.isMoblphonNo('021234567') -> false
	/*/
	$.isMoblphonNo = function(obj){
	    var regExp = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/i;
	    return regExp.test(obj);
	};

    /*
		메일주소 형식인지 확인
	    ex) $.isEmail('test@test.com') -> true
			$.isEmail('test.com') -> false
	/*/
	$.isEmail = function(obj){
	    var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	    return regExp.test(obj);
	};

    /*
		메일 도메인주소 형식인지 확인
	    ex) $.isEmailAddr('test.com') -> true
			$.isEmailAddr('test') -> false
	/*/
    $.isEmailAddr = function(obj){
        var regExp = /^((\w|[\-\.])+)\.([A-Za-z]+)$/;
        return regExp.test(obj);
    };

    /*
		날짜인지 확인(년도4자리-월2자리-일2자리 인 경우)
		ex) $.isDate('2020-01-01') -> true
			$.isDate('20200101') -> false
	/*/
    $.isDate = function(obj){
        var regExp = /^(19|20)\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1])$/;
        return regExp.test(obj);
    };

    /*
		모바일인지 확인
		ex) $.isMobile() -> true or false
	/*/
    $.isMobile = function() {
        return /Android|webOS|iPhone|iPad|iPod|BlackBerry/i.test(navigator.userAgent);
    };

    /*
		form 객체 json 형태로 변환
		ex) $("#frm").serializeObject() -> {test: "test"}
	/*/
    $.fn.serializeObject = function() {
       var obj = {};
       var arr = this.serializeArray();

       $.each(arr, function() {
           if (obj[this.name]) {
               if (!obj[this.name].push) {
            	   obj[this.name] = [obj[this.name]];
               }
               obj[this.name].push(this.value || '');
           } else {
        	   obj[this.name] = this.value || '';
           }
       });
       return obj;
    };
})( jQuery );




























    /* layer popup */
    layerpop = {
        showLayerPop: function(layerId) {

            var $layerId = $("#"+layerId);
            var $layerW=$layerId.width(),
                $layerH=$layerId.height();

            	if ($layerId.hasClass("level2") || $layerId.hasClass("level3")) {
            		$layerId.css({
            			'top' :(($(window).height()-$layerId.outerHeight())/2+$(window).scrollTop()),
            			'marginLeft':-($layerW/2)
            		});
            	} else {
            		$layerId.css({
            			//marginTop :-($layerH/2),
            			'marginLeft':-($layerW/2)
            		});
            	}

            $("body").bind('touchmove', function(e){e.preventDefault()});
            //$("body").addClass("hidden");

            $(window).on("resize",function(){
                var $layerW=$layerId.width(),
                    $layerH=$layerId.height();

                $layerId.css({
                    //marginTop :-($layerH/2),
                    marginLeft :-($layerW/2)

                });

                $cnt = $layerId.find(".layer_cnt");
                //$cnt.css({ top  : "0", marginTop : ""});
            });


		    //$("body").append('<div id="dim" class="dim"></div>');
            $layerId.show().focus();

            /* layer1 */
            $(".pop_close, .close").on("click", function(){
                $(this).parents('.layer_wrap').hide();
                //$("#dim").remove();
                if ($("[data-id='" + layerId + "']").length > 0) {
                	$("[data-id='" + layerId + "']").focus();
                }
            });

        },
        close : function (layerId){
            var $layerId = $("#"+layerId);

            //$("#dim").remove();
            $("body").removeClass("on");

            $layerId.hide();
            if ($("[data-id='" + layerId + "']").length > 0) {
            	$("[data-id='" + layerId + "']").focus();
            }
        }
    };

    // Spinner
    var spinner = function () {
        setTimeout(function () {
            if ($('#spinner').length > 0) {
                $('#spinner').removeClass('show');
            }
        }, 1);
    };
    spinner();


