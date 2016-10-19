<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8"/>
    <style>
        body {
            font-family: '微软雅黑';
            text-align: center;
            list-style: none;
        }

        div {
            border: 1px darkolivegreen solid;
            padding: 20px;
            margin: 20px;
        }
    </style>
</head>
<body>

welcome now date is ${currentTime}<br/>
<#assign lastUpdated = nowDateTime> <#-- no problem can occur here -->
<h3>java.util.Date 传值解决方案</h3>
<div>
    Last updated: ${lastUpdated?string("yyyy-MM-dd")} <#-- assume that lastUpdated is a date-time value --><br/>
    Last updated: ${lastUpdated?string("HH:mm:ss")} <#-- assume that lastUpdated is a date-time value --><br/>

</div>

<h3>块</h3>

<div>
<#assign seq = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j']>

<#list seq?chunk(4) as row>
    <#list row as cell>${cell} </#list>
</#list>

<#list seq?chunk(4 , "-") as row>
    <#list row as cell>${cell} </#list>
</#list>
</div>

<h3>宏定义</h3><br/>


<#macro listview items>
    <#list items as item>
    <a href="${item.url}">${item.name}</a><br/>
    </#list>
</#macro>
<@listview items=products></@listview>


<h4>cap_first 第一个字符大写</h4><br/>
<#macro list title items>
<p>${title?cap_first}:
<ul>
    <#list items as x>
    <li>${x?cap_first}
    </#list>
</ul>
</#macro>
<@list items=["mouse", "elephant", "python"] title="Animals"/>
<h4>自定义输入 效果如Object... args</h4><br/>

<#macro m a b ext...>
a = ${a}
b = ${b}
    <#if ext?is_sequence>
        <#list ext as e>
        ${e?index} = ${e}
        </#list>
    <#else>
        <#list ext?keys as k>
        ${k} = ${ext[k]}
        </#list>
    </#if>
</#macro>
<@m a=1 b=2 c=3 d=4 e=5 data\-foo=6 myns\:bar=7 />


<h3>单个model</h3><br/>
${aProduct.url}

<h3>modelList</h3><br/>
<#list products>
<ul>
    <#items as item>
        <li>${item.name}</li>
    </#items>
</ul>
</#list>
<h3>局部变量与全局变量</h3>
后台设置变量
<div>
    <br/>
    <div>
        <code>
            model.addAttribute("username","张三");
        </code>
        <br/>
        调用
        <br/>
        <code>
            $ {username}
        </code>
    </div>

    <br/>

${username} <br/>
<#assign  username="王五"/>

    <h4>设置username隐藏</h4>
${username}

    <h4>可以通过globals调用：</h4>
    从全局变量中返回:${.globals.username} <br/>
<#macro editusername>
    <#local username="李四">
${username}<br/>
</#macro>
    local设置局部变量后 ：<@editusername/>
    从模板中的变量获取：:${username}<br/>
    从循环变量获取(循环三次)：
<#list products as username>
<#--循环中的变量出了循环就消失-->
${username.name}
</#list>
    <br/>
    从模板中的变量获取：${username}

</div>

<div>
<#import "../lib/calculator.ftl" as c>
    < # import "../lib/calculator.ftl" as c>
    <br/>

<@c.add 1 ,2/>
</div>


<h3>number Format</h3>

<div>
<#assign x=42>
${x}
${x?string}  <#-- the same as ${x} -->
${x?string.number}
${x?string.currency}
${x?string.percent}
${x?string.computer}
</div>

<h3>空值 标签</h3>

<div>
    形式：variable!defaultValue<br/>
    ${nameasdasd!"default Value"?cap_first}
</div>
<h3>setting 标签</h3>
<div>
${1.2}
<#setting locale="de_DE">
${1.2}
</div>
<#assign me = "wuhulala">
<#include "../layout/footer.ftl">
</body>
</html>
