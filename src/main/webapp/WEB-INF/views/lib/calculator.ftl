<#macro add a b>
${a} + ${b} = ${a+b}
</#macro>

<#function avg x y>
    <#return (x + y) / 2>
</#function>
${avg(10,20)}
