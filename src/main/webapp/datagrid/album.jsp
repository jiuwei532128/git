<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/javascript">
    var toolbar = [{
        iconCls: 'icon-edit',
        text: "专辑详情",
        handler: function () {
            var row = $("#album").treegrid("getSelected")
            if (row == null) {
                alert("请先选中行！！！")
            } else {
                if (row.size == null) {
                    $("#album_dialog").dialog("open")
                    /*填充内容*/
                    $("#album_ff").form("load", row);
                    $("#img").prop("src", row.img);
                } else {
                    alert("请先选专辑！！！")
                }
            }
            //获取专辑


        }
    }, '-', {
        iconCls: 'icon-help',
        text: "添加专辑",
        handler: function () {
            alert('帮助按钮')
        }
    }, '-', {
        iconCls: 'icon-help',
        text: "添加章节",
        handler: function () {
            var row = $("#album").treegrid("getSelected");
            if (row == null) {
                alert("请先选中行！！！")
            } else {
                if (row.size == null) {
                    $("#chapter_dialog").dialog("open");
                    console.log(row.id + "+++++++++++++++++++++++")
                    $("#album_id").textbox("setValue", row.id);
                } else {
                    alert("请先选专辑！！！")
                }
            }

        }
    }, '-', {
        iconCls: 'icon-help',
        text: "下载音频",
        handler: function () {
            var row = $("#album").treegrid("getSelected");
            location.href = "${pageContext.request.contextPath}/chapter/down.do?url=" + row.url + "&name=" + row.name;
        }
    }]


    $(function () {
        $('#album').treegrid({
            url: '${pageContext.request.contextPath}/json/album.json',
            idField: 'id',
            treeField: 'name',
            onDblClickRow: function (row) {
                $("#album_paly").dialog("open");
                $("#audio").prop("src",row.url)
            },
            toolbar: toolbar,
            fit: true,
            fitColumns: true,
            columns: [[
                {field: 'name', title: '名称', width: 60, align: 'right'},
                {field: 'size', title: '大小', width: 80},
                {field: 'time', title: '时长', width: 80},
                {field: 'url', title: '路径', width: 80}

            ]]
        });

    })


</script>

<table id="album"></table>


<div id="album_dialog" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">
    <form id="album_ff" method="post">
        <div>
            <label for="name">名称:</label>
            <input class="easyui-validatebox" id="name" type="text" name="name"/>
        </div>
        <div>
            <label for="count">集数:</label>
            <input class="easyui-validatebox" type="text" id="count" name="count"/>
        </div>
        <div>
            <label for="img">封面:</label>
            <img id="img" src="">
        </div>
    </form>


</div>

<div id="chapter_dialog" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,buttons:[{
				text:'保存',
				handler:function(){
                  $('#chapter_ff').form('submit',{
                  url:'${pageContext.request.contextPath}/chapter/add.do'
                  })
				}
			},{
				text:'关闭',
				handler:function(){
                    $('#chapter_dialog').dialog('close');
				}
			}]">

    <form id="chapter_ff" method="post" enctype="multipart/form-data">
        <div>
            <label for="album_id">id:</label>
            <input class="easyui-textbox" value="0" name="id" id="album_id"/>
        </div>
        <div>
            <label for="file">上传:</label>
            <input class="easyui-filebox" id="file" name="addFile"/>
        </div>

    </form>


</div>


<div id="album_paly" class="easyui-dialog" title="My Dialog" style="width:400px;height:200px;"
     data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">

    <audio id="audio" src="" controls="controls" autoplay="autoplay"></audio>

</div>
