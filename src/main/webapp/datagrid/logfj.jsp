<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript">

    $(function () {
        $("#fg").edatagrid({
            singleSelect:false,
            url: "${pageContext.request.contextPath}/log/query",
            columns: [[
                {field: 'id', title: '标号', width: 100,align: 'left'},
                {field: 'name', title: '名字', width: 100,align: 'left'},
                {field: 'things', title: '什么事', width: 100, align: 'left'},
                {field: 'date', title: '时间', width: 200, align: 'left'}
            ]],
            fit: true,
            fitColumns: true,
            pagination: true,
            pageList: [5, 10, 15, 20],
            pageSize: 20,

        })

    })


</script>
<table id="fg"></table>



