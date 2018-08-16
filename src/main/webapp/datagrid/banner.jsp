<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript">

    $(function () {
        var toolbar = [{
            iconCls: 'icon-add',
            text:"添加",
            handler: function () {
                $("#dd").dialog("open");

            }
        }, '-', {
            iconCls: 'icon-edit',
            text: "修改",
            handler: function () {
                /*将选中行变为可编辑*/
                var row = $("#dg").edatagrid("getSelected");
                if (row == null) {
                    alert("请选中行")
                } else {
                    $("#dg").edatagrid("editRow", $("#dg").edatagrid("getRowIndex", row))
                }
            }
        }, '-', {
            iconCls: 'icon-remove',
            text: "删除",
            handler: function () {
                var row = $("#dg").edatagrid("getSelected");
                if (row==null){
                    alert("请选中行");
                }else {
                    $('#dg').edatagrid('destroyRow');
//                    $("#dg").edatagrid({
//
//                    });
                        $.ajax({
                            type:"get",
                            url:"${pageContext.request.contextPath}/shu/delete?id="+row.id,
                            dataType:"text/plain",

                             });
                }

            }
        }, '-', {
            iconCls: 'icon-save',
            text: "保存",
            handler: function () {
                var row = $("#dg").edatagrid("getSelected");
                $("#dg").edatagrid("saveRow");
                alert(row.status);
                $.ajax({
                    type:"get",
                    url:"${pageContext.request.contextPath}/shu/update?id="+row.id+'&status='+row.status,
                    dataType:"text/plain",
                });
                $('#dg').datagrid("reload");
            }

        }, '-', {
            iconCls: 'icon-print',
            text: "自定义导出",
            handler: function () {
                $("#custom_dialog").dialog("open")
            }
        },'-', {
            iconCls: 'icon-redo',
            text: "自定义导入",
            handler: function () {
                $("#custom_import").dialog("open")
            }
        }]
        $('#fb').filebox({
            buttonText: '选择文件',
            buttonAlign: 'right'
        })

        $("#btn2").click(function () {
            $.ajax({
                url:"${pageContext.request.contextPath}/shu/customerExport2?type=fb&filename="+$("fb").val(),
                type:"get",
                success:function(data) {
                 alert(data);
                }
            })


        })



        $("#btn").click(function () {
            //   提交form表单
            var titles = $("#customer_cc").combotree("getText");
            var value = $("#customer_cc").combotree("getValues");
            var c = "";
            $.each(value, function (index, title) {
                if (index != value.length - 1) {
                    c += title + ",";
                } else {
                    c += title;
                }
            })
            $('#customer_form').form('submit', {
                queryParams: {"titles": titles, "fileds": c},
                url:"${pageContext.request.contextPath}/shu/customerExport"

            });
            $("#custom_dialog").dialog("close")
        })

        $("#dg").edatagrid({
            singleSelect:false,
            url: "${pageContext.request.contextPath}/shu/shuff",
            columns: [[
                {field: 'title', title: '名字', width: 100,align: 'left'},
                {
                    field: 'status', title: '状态', width: 100,align: 'left',
                    editor: {
                        type: 'text',
                        options: {required: true}
                    }
                },
                {field: 'imgPath', title: '路径', width: 100, align: 'left'},
                {field: 'date', title: '时间', width: 100, align: 'left'}
            ]],
            fit: true,
            fitColumns: true,
            pagination: true,
            pageList: [5, 10, 15, 20],
            pageSize: 5,
            toolbar: toolbar,
            view: detailview,

            detailFormatter: function (rowIndex, rowData) {
                if(rowData.status=='y'){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="..' + rowData.imgPath + '" style="height:50px;"></td>' +

                    '<td style="border:0">' +
                    '<p>date: ' + rowData.date + '</p>' +
                    '<p>desecription: ' + rowData.dese + '</p>' +
                    '<p>path: ' + rowData.status + '</p>' +
                    '</td>' +
                    '</tr></table>';
                }
            }
        })

    })
    $("#ff").form({
        success:function(){
            $('#dd').dialog('close');
            $('#dg').datagrid('load');
        }
    })
   function submit() {
        $('#ff').form('submit', {
          url: "${pageContext.request.contextPath}/banner/add.do"
        })
    }

</script>


<table id="dg"></table>

<div id="dd" class="easyui-dialog" title="添加轮播图" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                $('#ff').form('submit', {
                 url:'${pageContext.request.contextPath}/shu/add',

                 })
                  <%--$('#dd').dialog('close');--%>
                  <%--$('#dg').datagrid('load');--%>
				}
			},{
				text:'关闭',
				handler:function(){
				$('#dd').dialog('close');
				}
			}]">

    <form id="ff" method="post" enctype="multipart/form-data">
        <div>
            <label for="title">标题:</label>
            <input class="easyui-textbox" id="title" type="text" name="title" data-options="required:true"/>
        </div>
        <div>
            <label for="desc">描述:</label>
            <input class="easyui-textbox" id="desc" type="text" name="dese" data-options="required:true"/>
        </div>
        <div>
            <label for="status">状态:</label>
            <select id="status" class="easyui-combobox" name="status" style="width:200px;">
                <option value="y">展示</option>
                <option value="n">不展示</option>
            </select>

        </div>
        <div>
            <input class="easyui-filebox" name="img" style="width:300px">
        </div>
    </form>

</div>
<div id="custom_dialog" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
     data-options="iconCls:'icon-print',resizable:true,modal:true,closed:true">
    <form id="customer_form" method="post">
        <select id="customer_cc" class="easyui-combotree" style="width:200px;"
                data-options="url:'${pageContext.request.contextPath}/json/comboTree.json',required:true,checkbox:true,onlyLeafCheck:true,multiple:true"></select>
    </form>


    <a id="btn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">确定导出</a>

</div>

<div id="custom_import" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
     data-options="iconCls:'icon-redo',resizable:true,modal:true,closed:true">
    <input id="fb" type="text" style="width:300px">
    <a id="btn2" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'">确定导入</a>
</div>

