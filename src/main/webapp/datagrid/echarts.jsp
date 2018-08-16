<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '持明法州App用户活跃图'
        },
        tooltip: {},
        legend: {
            data:['销量']
        },
        xAxis: {
            data: ["7天","15天","30天","90天","半年","一年"]
        },
        yAxis: {},
        series: [{
            type: 'bar',
            data: []
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    $.ajax({
        url:'${pageContext.request.contextPath}/json/user.json',
        type:'get',
        dataType:'JSON',
        success:function(data){
            myChart.setOption({
                series: [{
                    type: 'bar',
                    data: data.data
                }]

            })

    }
    })
</script>
