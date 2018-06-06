 function addHoverDom(treeId, treeNode) {
     var sObj = $("#" + treeNode.tId + "_span");
     if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
     var addStr = "<span class='button add' id='addBtn_" + treeNode.tId+ "' title='add node' onfocus='this.blur();'></span>";
     sObj.after(addStr);
     var btn = $("#addBtn_"+treeNode.tId);

     if (btn){
    	 btn.bind("click", function(){
    		 $('#addmenu').modal('show');
    		 $('#menuname').val("");
    		 $('#pid').val(treeNode.id);
    		 $('#level').val(treeNode.level+1);
    		 $('#menuno').val(treeNode.menuNo+"_");
    	//	 window.open("menu.html","新增","menubar=0,scrollbars=1, resizable=1,status=0,titlebar=1,toolbar=0,location=0,height=200,left=250,top=200,width=400");   
             return false;
         });
     }
 }; 
function addMenu(){
	 $.ajax({
         type: "Post",
         url: "${rc.contextPath}/menu/addmenu",
         dataType:"json",
         data:$('#menuform').serialize(),
         success: function (data) {
        	 var msg=data.message;
        	 if(!msg){
        		 var zTree = $.fn.zTree.getZTreeObj("treeDemo");
            	 var tree =  eval(data);   
                 zTree.addNodes(zTree.getNodeByParam("id",data.pId,null),tree);
        		 $('#addmenu').modal('hide');
        	 }else{
        		 alert("添加菜单失败:菜单编码重复！");
        	 }
        	
         },
         error: function (XMLHttpRequest, textStatus, errorThrown) {
             alert("树形菜单添加失败！")
         }
     });
	};
