<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="loginInfo" value="${sessionScope.LOGIN_INFO}"/>

<script>
var mnCode = "<%=session.getAttribute("menuId")%>";
$(function(){
	var menuIdList = [];
	fnMenuList(); // 메뉴 조회
	fnMkLeftMenu(); // 왼쪽 메뉴 그리기
	cfnGetViewAuth();//버튼권한체크
});

function fnMenuList(groupCode){
	var url = "/common/SearchMenuAjaxList.do";
	var type = "POST";
	var authChgChk = false;//권한변경체크
	if(groupCode == undefined){
		if('<c:out value="${loginInfo.groupCode}"/>' != ""){
			groupCode = '<c:out value="${loginInfo.groupCode}"/>';
		}else{
			groupCode = '<c:out value="${loginInfo.loginGroupCode}"/>';
		}
	}else{
		authChgChk = true;
	}
	document.menuForm.groupCode.value = groupCode;
	var param = {"groupCode":groupCode};

	cfnCallAjax(url, type, false, param, function(jsonData) {
		if(jsonData != null) {
			menuIdList = [];
			menuIdList = jsonData.resultList;

			//1단계 메뉴리스트를 가져와서 뿌린다.
			var mainMenuList = $.grep(menuIdList, function(item, index) {
				return (item.dp == 1);
			});

			//기존 1단계 메뉴를 지운다.
			$("#gnb>ul>li").remove();

			for (var i=0; i<mainMenuList.length; i++) {
				var selUpperMenuId = cfnEmpty("<c:out value="${upperMenuId}" />");
				var upperMenuId = cfnEmpty(mainMenuList[i].menuId);
				if (upperMenuId == selUpperMenuId) {
					$("#gnb>ul").append("<li class=\"li active\"><a href=\"javascript:void(0);\">"+mainMenuList[i].sj+"</a></li>");
				} else {
					$("#gnb>ul").append("<li class=\"li\"><a href=\"javascript:void(0);\">"+mainMenuList[i].sj+"</a></li>");
				}
			}
			var subMenuList = $.grep(menuIdList, function(item, index) {
				return (item.dp == 2);
			});

			//기존2단계 메뉴를 지운다.
			$(".alignCenter>ul").remove();

			//2단계 메뉴리스트를 가져와서 뿌린다.
			var preUpperMenuId = "";
			var smCnt = 0;
			var smId = 0;
			var mkTag = "";
			for (var i=0; i<subMenuList.length; i++) {
				if (preUpperMenuId != subMenuList[i].upperMenuId) {
					if (preUpperMenuId!="") {
						mkTag += "</ul>";
					}
					smId = ++smCnt;
					mkTag += "<ul class=\"sub"+smId+"\" data-id=\"subMenu"+smId+"\"><li><a href=\"javascript:fnGoMenu('"+subMenuList[i].upperMenuId+"','"+subMenuList[i].menuId+"','"+subMenuList[i].webPath+"');\">"+subMenuList[i].sj+"</a></li>";
					preUpperMenuId = subMenuList[i].upperMenuId;
				} else {
					mkTag += "<li><a href=\"javascript:fnGoMenu('"+subMenuList[i].upperMenuId+"','"+subMenuList[i].menuId+"','"+subMenuList[i].webPath+"');\">"+subMenuList[i].sj+"</a></li>";
				}
			}
			$(".alignCenter").append(mkTag);
		}

		$(document).on('mouseenter','#gnb .li > a , .subMenu',function(){
	        if($('#header .menuButton').hasClass('on')){
	            return false;
	        }else{
	            $('#header').addClass('on');
	            $('.subMenu').stop().slideDown(300);
	        }

	        $('.alignCenter ul li a').css({fontSize:'16px'}).delay(2000);
	    });
	    $(document).on('mouseleave','#gnb .li > a, .subMenu',function(){
	        if($('#header .menuButton').hasClass('on')){
	            return false;
	        }else{
	            $('#header').removeClass('on');
	            $('.subMenu').stop().slideUp(300);
	        }
	    });
	});
}

//일단 화면 링크시 ajax 방식으로 할건지(tiles변경)? 아니면 링크시 menuId 가져오게 할지(세션) 정해야 함
function fnGoMenu(upperMenuId, menuId, memnUrl){
	var frm = document.menuForm;
	if(memnUrl != null && memnUrl != "null"){
		frm.upperMenuId.value = upperMenuId;
		frm.menuId.value = menuId;
		frm.action = memnUrl;
		frm.submit();
	}
}

function fnMkLeftMenu(){
	var upperMenuId = '<c:out value="${upperMenuId}"/>';
	var menuId = '<c:out value="${menuId}"/>';

	$(".lnbMenu>ul>li").remove();
	var subMenuList = $.grep(menuIdList, function(item, index){
		return (item.dp == 2 && item.upperMenuId == upperMenuId);
	});

	//LEFT 메뉴 콘트롤
	$.each(subMenuList, function(idx, data){
		if(data.menuId == menuId){
			$(".lnbMenu>ul:last").append("<li class=\"on\"><a href=\"javascript:fnGoMenu('"+data.upperMenuId+"','"+data.menuId+"','"+data.webPath+"');\">"+data.sj+"</a></li>");
		}else{
			$(".lnbMenu>ul:last").append("<li><a href=\"javascript:fnGoMenu('"+data.upperMenuId+"','"+data.menuId+"','"+data.webPath+"');\">"+data.sj+"</a></li>");
		}
	});
}

// 비밀번호 변경 팝업
function fnChangeLayer() {
	cfnInptInit('passwordChangeLayer'); // 입력 초기화
	layerpop.showLayerPop('passwordChangeLayer');
}

// 비밀번호 변경
function fnPasswordChange() {
	if ($.isEmpty($("#chgPassword").val())) {
		alert("비밀번호은(는) 필수 항목입니다.");
		$("#chgPassword").focus();
		return false;
	}

	if ($.isEmpty($("#chgPasswordCnfirm").val())) {
		alert("비밀번호 확인은(는) 필수 항목입니다.");
		$("#chgPasswordCnfirm").focus();
		return false;
	}

	var password = cfnEmpty($("#chgPassword").val());
	var pwCheck1 = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$!@#$%^])[A-Za-z\d$!@#$%^]{8,20}$/.test(password); // 영문자, 숫자, 특수문자(!@#$%^)중 3가지 조합(8-20)자리
	var pwCheck2 = /^(?=.*[a-zA-Z0-9])(?=.*[a-zA-Z!@#$%^])(?=.*[0-9!@#$%^]).{10,20}$/.test(password); // 영문자, 숫자, 특수문자(!@#$%^)중 2가지 조합(10-20)자리

	if (!(pwCheck1 || pwCheck2)) {
		alert("비밀번호는 영문자, 숫자, 특수문자(!@#$%^)중 2가지 조합(10-20)자리 또는 3가지 조합(8-20)자리로 입력하셔야 합니다.");
		$("#chgPassword").focus();
		return false;
	}

	if (/(\d)\1/.test(password)) {
		alert("비밀번호에 연속적인 숫자는 사용할 수 없습니다.");
		$("#chgPassword").focus();
		return false;
	}

	if ($("#chgPassword").val() !== $("#chgPasswordCnfirm").val()) {
		alert("비밀번호가 일치하지 않습니다.");
		$("#chgPasswordCnfirm").focus();
		return false;
	}

	var url = "<c:url value='/PasswordChange.do'/>";
	var type = "POST";
	var param = {
		"password" : $("#chgPassword").val()
	};

	cfnCallAjax(url, type, true, param, function (data) {
		if (cfnEmpty(data.resultType) == "succ") {
			alert("변경되었습니다.");
			layerpop.close("passwordChangeLayer"); // 레이어팝업 닫기
			cfnPageMvmn('/LoginOut.do');
		} else if (cfnEmpty(data.resultType) == "historyPasswordFail") {
			alert("최근에 사용한 비밀번호는 사용할 수 없습니다.");
		} else if (cfnEmpty(data.resultType) == "idPasswordCheckFail") {
			alert("비밀번호에 아이디가 포함될 수 없습니다.");
		}else if(cfnEmpty(data.resultType) == "fail"){
			alert("변경에 실패하였습니다.");
		}
		});
}
</script>
<div id="header">
    <div class="headerTop clearfix">
        <div class="logoWrap">
        	<h1 class="logo">
                <a href="<c:out value='${siteUrl}' />"><span class="blind">LG</span></a>
                <p class="logo_tt">XR통합앱 관리자</p>
            </h1>
        </div>
        <c:if test="${not empty loginInfo.loginId}">
	        <div class="loginInfo">
	        	<c:if test="${not empty loginInfo.loginNm}">
	            	<p class="log"><span class="fc9"><c:out value='${loginInfo.loginNm}'/>님</span></p>
	            </c:if>
	            <a href="javascript:fnChangeLayer();" class="btn gr_btn">비밀번호변경</a>
	            <a href="/LoginOut.do" class="btn og_btn ico">로그아웃</a>
	        </div>
        </c:if>
        <div class="areaMenu">
           <div id="gnb">
                <ul>
                </ul>
                <div class="subMenu">
                    <div class="subMenuInner">
                        <div class="alignCenter clearfix">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <form name="menuForm" method="post">
	    <input type="hidden" name="upperMenuId">
	    <input type="hidden" name="menuId">
	    <input type="hidden" name="webPath">
	    <input type="hidden" name="groupCode">
	    <input type="hidden" name="menuAt" value="Y" />
    </form>
</div>

<!-- layer popup 비밀번호 변경 -->
<div class="layer_wrap" id="passwordChangeLayer" tabindex="0" style="width:680px;">
    <div class="l_inner">
        <div class="l_tit"><h1 class="title">비밀번호 변경</h1></div>
        <!-- 레이어 컨텐츠 -->
        <div class="l_cnt">
            <!-- in -->
            <div class="l_in">
                <div class="divCon">
                    <!-- table -->
                    <table class="tbl">
                        <caption>비밀번호 변경</caption>
                        <colgroup>
                            <col style="width:160px;">
                            <col style="width:auto;">
                        </colgroup>
                        <tbody>
                            <tr>
                                <th>변경비밀번호<i class=""></i></th>
                                <td>
                                    <input type="password" id="chgPassword" name="chgPassword" class="input w180" maxlength="100" />
                                    <p class="mt10">※ 영문자, 숫자, 특수문자(!@#$%^)중 2가지 조합(10-20)자리 또는 3가지 조합 (8-20자리)</p>
				                	<p>※ 연속적인 숫자, 아이디와 같은 비밀번호는 사용 불가</p>
                                </td>
                            </tr>
                            <tr>
                                <th>변경비밀번호 확인<i class=""></i></th>
                                <td>
                                    <input type="password" id="chgPasswordCnfirm" name="chgPasswordCnfirm" class="input w180" maxlength="100" />
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <!-- tbl_footer -->
            <div class="l_footer">
                <button type="button" class="btn btn_l gb_btn" onclick="fnPasswordChange();">저장</button>
                <button type="button" class="btn btn_l bg9" onclick="layerpop.close('passwordChangeLayer');">닫기</button>
            </div>
        </div>
        <a href="javascript:void(0);" class="pop_close"><span class="l_close_ico">닫기</span></a>
        <!-- 레이어 컨텐츠 -->
    </div>
</div>
<!-- //layer -->