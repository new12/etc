<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="ef" tagdir="/WEB-INF/tags" %>
<ef:contentHeader title="欢迎" index="true"/>
<%@include file="/WEB-INF/views/modal/permissionModel.jspf" %>
<div id="wrapper">
    <%@include file="common/nav.jspf" %>
    <div id="page-wrapper">
        <iframe name="mainframe" frameborder="no" style="min-height: 720px;overflow: visible;" scrolling="no" width="100%" height="100%"
                src="<%=request.getContextPath()%>/welcome"></iframe>
    </div>
</div>
<ef:contentFooter/>
<script>
    $('#changePasswordModal form').validate(
            {
                errorPlacement:function(error,element){
                    error.appendTo(element.parent().parent())
                },
                rules:{
                    password:{required:true},
                    new_password:{required:true},
                    new_password_again:{required:true,equalTo:'#new_password'},
                }
            }
    );
    function changepwd(){
          if($('#changePasswordModal form').valid()){
              $.ajax({
                  url:"<%=request.getContextPath()%>/changePassword",
                  type:"POST",
                  data: $('#changePasswordModal form').serialize(),
                  success:function(msg){
                      if(msg!='success')alert("修改密码失败!");
                      else{
                          $('#changePasswordModal form').modal('hide');
                      }
                  },
                  error:function(msg){
                      alert("修改密码失败!");
                  }
            });
          }
    }
</script>