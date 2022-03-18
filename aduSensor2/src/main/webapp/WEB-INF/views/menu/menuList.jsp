<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<script>


$(function(){
	
	menuZtreeList();
	
	for(var i=1; i<100; i++){
		$("#sortOrdr").append('<option value="'+i+'">'+i+'</option>');
	}
	
	
});

	function menuZtreeList() {

		var url = "/menu/getMnData.do";
	    var type = "POST";
		var param = {};

	    cfnCallAjax(url, type, true, param, function(resultData) {
	    	if (resultData != null) {
	    		var dbList = resultData.list;

	    		var menuList = [];
	    		if (dbList.length > 0) {
	    			$.each(dbList, function(index, item) {
	   					menuList.push({
	    	                "id" :item.menuId,
	    	                "pId" : item.upperMenuId,
	    	                "name" : item.sj
	    	            });
	    			});
	    		}

	    		var setting = {
	    	        data: {
	    	            simpleData: {
	    	                enable: true,
	    	            }
	    	        },
	    	        callback: {
	    				onClick: after
	    			}
	    	    }

 	    	    function onClick(event, treeId, treeNode, clickFlag) {
	    			console.log("treeNode", treeNode);
	    		}

	    	    $(document).ready(function(){
	    	        $.fn.zTree.init($("#treeMenu"), setting, menuList);
	    	    });
	    	}
	    });

	}
	
	function after(event, treeId, treeNode, clickFlag) {
		
		var url = "/menu/selectDetail.do";
	    var type = "POST";
		var param = {"menuId" : treeNode.id};

	    cfnCallAjax(url, type, true, param, function(resultData) {

	    	var list = resultData.list;
	    	
	    	$.each(list, function(key, value) {
	    		if(key == "upperMenuId"){
	    			$("#upperMenuNm").html(value);
	    			if(value=="ROOT"){
	    				$("#menuId").prop("disabled",true);
	    				$("#webPath").prop("disabled",true);
	    			}else{
	    				$("#menuId").prop("disabled",false);
	    				$("#webPath").prop("disabled",false);
	    			}
	    		}
	    		if(key == "menuId"){
	    			if(value == "DM" || value == "DMMM"){
	    				$("#delBtn").hide();
	    			}else{
	    				$("#delBtn").show();
	    			}
	    		}
	    		if(key == "useAt"){
	    			$("input[name=useAt]:input[value="+value+"]").prop("checked",true);
	    		}
	    		$("#"+key).val(value);
	    		
			});
	    	
	    });
		
		console.log("�ݹ�");
		
	}
	
	function registMenu(state) {
		
		layerPop.showLayerPop();
		
	}
</script>
	<div class="contentPers">
	
		<div class="conTop clearfix">
			<div class="title">
				<h3 class="h3">�޴�����</h3>
			</div>
			<div class="location">
				<ol>
					<li><span class="home ico"><i class="blind"></i></span></li>
					<li><span>2</span></li>
					<li class="active">
						<!-- active page �̵��� Ȱ��ȭ --> <span>3</span>
					</li>
				</ol>
			</div>
		</div>
		
 		<div class="divConWrap">
 		<div class="treeWrap fl" style="float: left; width:200px;">
            <div class="treeTit">
                <h4 class="h4"></h4>
            </div>
            <div class="treeBox scrollTbl_y">
                <div class="treeCon">
                	<ul id="treeMenu" class="ztree"></ul>
                </div>
            </div>
            <div>
	            <a href="#" class="btn sBtn h40 w155" style="margin-bottom:10px;">���� �޴� �߰�</a>
	            <a href="#" class="btn sBtn h40 w155">���� �޴� �߰�</a>
            </div>
        </div>

	        <div class="cateOrgMmg" >
				<table class="tbl0000 tbh520">
	                <caption></caption>
	                <colgroup>
	                    <col style="width:160px;">
	                    <col style="width:auto;">
	                </colgroup>
	                <tbody>
	                    <tr>
	                        <th scope="row">���� �޴���</th>
	                        <td>
	                        	<div id="upperMenuNm"></div>
	                        	<input type="hidden" id="upperMenuId" name="upperMenuId">
	                        	<input type="hidden" id="dp" name="dp">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th scope="row">�޴���<i class="iconStar"></i></th>
	                        <td>
	                            <input type="text" id="sj" name="sj" title="�޴��� �Է�" class="input w100">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th scope="row">�޴�����<i class="iconStar"></i></th>
	                        <td>
	                            <input type="text" id="dc" name="dc" title="�޴����� �Է�" class="input w100">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th scope="row">�޴�ID<i class="iconStar"></i></th>
	                        <td>
	                            <input type="text" id="menuId" name="menuId" title="�޴�ID �Է�" class="input w100" disabled>
		                		<input type="hidden" id="oriMenuId" name="oriMenuId">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th scope="row" id="webPathTitle">�޴�URL</th>
	                        <td>
	                            <input type="text" id="webPath" name="webPath" title="�޴�URL �Է�" class="input w100" maxlength="100" disabled>
	                        </td>
	                    </tr>
	                    <tr>
	                        <th scope="row">���ļ���<i class="iconStar"></i></th>
	                        <td>
	                            <select class="sel w180" id="sortOrdr" name="sortOrdr" title="���ļ��� ����">
	                            </select>
	                            <input type="hidden" id="oriSortOrdr" name="oriSortOrdr">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th scope="row">�������<i class="iconStar"></i></th>
	                        <td>
	                            <div class="formChkRdo" id="mainDiv">
	                                <ul class="basic">
	                                    <li><label class="label"><input type="radio" class="rdo" id="useAt1" title="���" name="useAt" value="Y"><span class="ico"></span><span class="lTxt">���</span></label></li>
	                                    <li><label class="label"><input type="radio" class="rdo" id="useAt2" title="�̻��" name="useAt" value="N"><span class="ico"></span><span class="lTxt">�̻��</span></label></li>
	                                </ul>
	                            </div>
	                        </td>
	                    </tr>
	                </tbody>
	            </table>
	                <div>
                        <a href="#" class="btn dBtn" id="delBtn">����</a>
                        <a href="#" class="btn sBtn">����</a>
	                </div>
	        </div>
	       </div>   
	</div>


