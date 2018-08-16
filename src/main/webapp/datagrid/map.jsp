<%@ page language="java" contentType="text/html; charset=utf-8" isELIgnored="false" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main2" style="width: 600px;height:400px;"></div>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main2'));

    option = {
        title : {
            text: '持明法州App用户分布图',
            subtext: '2018年6月6日最新数据',
            left: 'center'
        },
        tooltip : {
            trigger: 'item'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data:['男','女']
        },
        visualMap: {
            min: 0,
            max: 2500,
            left: 'left',
            top: 'bottom',
            text:['高','低'],           // 文本，默认为数值文本
            calculable : true
        },
/*        toolbox: {
            show: true,
            orient : 'vertical',
            left: 'right',
            top: 'center',
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },*/
        series : [
            {
                name: '男',
                type: 'map',
                mapType: 'china',
                roam: false,
                label: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: true
                    }
                },
                data:[
                    {name: '北京',value: Math.round(Math.random())},
                    {name: '天津',value: Math.round(Math.random())},
                    {name: '上海',value: Math.round(Math.random())},
                    {name: '重庆',value: Math.round(Math.random())},
                    {name: '河北',value: Math.round(Math.random())},
                    {name: '河南',value: Math.round(Math.random())},
                    {name: '云南',value: Math.round(Math.random())},
                    {name: '辽宁',value: Math.round(Math.random())},
                    {name: '黑龙江',value: Math.round(Math.random())},
                    {name: '湖南',value: Math.round(Math.random())},
                    {name: '安徽',value: Math.round(Math.random())},
                    {name: '山东',value: Math.round(Math.random())},
                    {name: '新疆',value: Math.round(Math.random())},
                    {name: '江苏',value: Math.round(Math.random())},
                    {name: '浙江',value: Math.round(Math.random())},
                    {name: '江西',value: Math.round(Math.random())},
                    {name: '湖北',value: Math.round(Math.random())},
                    {name: '广西',value: Math.round(Math.random())},
                    {name: '甘肃',value: Math.round(Math.random())},
                    {name: '山西',value: Math.round(Math.random())},
                    {name: '内蒙古',value: Math.round(Math.random())},
                    {name: '陕西',value: Math.round(Math.random())},
                    {name: '吉林',value: Math.round(Math.random())},
                    {name: '福建',value: Math.round(Math.random())},
                    {name: '贵州',value: Math.round(Math.random())},
                    {name: '广东',value: Math.round(Math.random())},
                    {name: '青海',value: Math.round(Math.random())},
                    {name: '西藏',value: Math.round(Math.random())},
                    {name: '四川',value: Math.round(Math.random())},
                    {name: '宁夏',value: Math.round(Math.random())},
                    {name: '海南',value: Math.round(Math.random())},
                    {name: '台湾',value: Math.round(Math.random())},
                    {name: '香港',value: Math.round(Math.random())},
                    {name: '澳门',value: Math.round(Math.random())}
                ]
            },
            {
                name: '女',
                type: 'map',
                mapType: 'china',
                label: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: true
                    }
                },
                data:[
                    {name: '北京',value: Math.round(Math.random())},
                    {name: '天津',value: Math.round(Math.random())},
                    {name: '上海',value: Math.round(Math.random())},
                    {name: '重庆',value: Math.round(Math.random())},
                    {name: '河北',value: Math.round(Math.random())},
                    {name: '安徽',value: Math.round(Math.random())},
                    {name: '新疆',value: Math.round(Math.random())},
                    {name: '浙江',value: Math.round(Math.random())},
                    {name: '江西',value: Math.round(Math.random())},
                    {name: '山西',value: Math.round(Math.random())},
                    {name: '内蒙古',value: Math.round(Math.random())},
                    {name: '吉林',value: Math.round(Math.random())},
                    {name: '福建',value: Math.round(Math.random())},
                    {name: '广东',value: Math.round(Math.random())},
                    {name: '西藏',value: Math.round(Math.random())},
                    {name: '四川',value: Math.round(Math.random())},
                    {name: '宁夏',value: Math.round(Math.random())},
                    {name: '香港',value: Math.round(Math.random())},
                    {name: '澳门',value: Math.round(Math.random())}
                ]
            },
            {
                name: '',
                type: 'map',
                mapType: 'china',
                label: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: true
                    }
                },
                data:[
                    {name: '北京',value: Math.round(Math.random()*1000)},
                    {name: '天津',value: Math.round(Math.random()*1000)},
                    {name: '上海',value: Math.round(Math.random()*1000)},
                    {name: '广东',value: Math.round(Math.random()*1000)},
                    {name: '台湾',value: Math.round(Math.random()*1000)},
                    {name: '香港',value: Math.round(Math.random()*1000)},
                    {name: '澳门',value: Math.round(Math.random()*1000)}
                ]
            }
        ]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
