<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="ef" tagdir="/WEB-INF/tags" %>
<ef:contentHeader title="权限" index="false" includeTable="true"/>
<%@include file="/WEB-INF/views/modal/permissionModel.jspf" %>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-12">
            <h2>
                <i class="glyphicon glyphicon-list"></i> 权限管理
            </h2>
        </div>
    </div>
    <div class="btn-group" style="margin-bottom: 10px">
        <button id="btn_refresh" type="button" class="btn btn-info btn-small" style="padding-right: 10px">
            刷新 <i class="glyphicon glyphicon-refresh"></i>
        </button>
        <button id="btn_plus" type="button" class="btn btn-primary btn-small" data-toggle="modal"
                data-target="#permissionModal" data-title="添加权限"
                data-url="<%=request.getContextPath()%>/permission/add" style="padding-right: 10px">
            添加 <i class="glyphicon glyphicon-plus"></i>
        </button>
        <button id="btn_delete" type="button" class="btn btn-danger btn-small"
                data-url="<%=request.getContextPath()%>/permission/delete" style="padding-right: 10px">
            删除<i class="glyphicon glyphicon-trash"></i>
        </button>
    </div>
    <!--/.row-fluid-->
    <div class="dataTables_wrapper form-inline no-footer">
        <table id="table" class="table table-striped table-bordered dataTable hover">
            <thead>
            <tr>
                <th>编号</th>
                <th>名称</th>
                <th>权限</th>
                <th>备注</th>
            </tr>
            </thead>
        </table>
    </div>
</div>
<ef:contentFooter includeTable="true"/>
<script>
    $(document).ready(function () {
        var mytable=$('#table').DataTable(
                {
                    ajax: {
                        url: "<%=request.getContextPath()%>/permission/list",
                    },
                    lengthMenu: [[8, -1], [8, "ALL"]],
                    columns: [
                        {data: 'id'},
                        {data: 'name'},
                        {data: 'permission'},
                        {data: 'description'},
                    ]
                });
        $('table tbody').on('click', 'tr', function () {
            if ($(this).hasClass('active')) {
                $(this).removeClass('active');
            } else {
                $('#table tr.active').removeClass('active');
                $(this).addClass('active');
            }
        });
        $('#btn_refresh').click(function () {
            mytable.ajax.reload();
        });
        $('#permissionModal').on('show.bs.modal', function (event) {
            // Button that triggered the modal
            var button = $(event.relatedTarget);
            var url = button.data('url');
            var title = button.data('title');
            $('#permissionModal .modal-title').text(title);
            $('#permissionModal').attr({
                "data-url": url
            });
        });
        $('#btn_save').click(function () {
            $.ajax({
                type: "POST",
                url: $('#permissionModal').data('url'),
                contentType: "application/x-www-form-urlencoded;charset=utf-8",
                dataType: "text",
                data: $('#permissionModal form').serialize(),
                success: function (msg) {
                    $('#permissionModal').modal('hide');
                },
                error: function (msg) {
                    $('#permissionModal').modal('hide');
                    alert(msg);
                }
            });
        });
        $('#btn_delete').click(function () {
            var model = table.row('.active').data();
            $.ajax({
                type: "POST",
                url: $('#btn_delete').data('url'),
                data: "id=" + model.id,
                success: function (message) {
                    mytable.ajax.reload();
                },
                error: function (message) {
                    alert(message);
                }
            });
        });
    });
</script>