<#import "parts/common.ftl" as common>

<@common.page>
<h1>Методы интерполяции</h1>
<h3>x = 1,725 + 0,002n , n=1..30</h3>
<div class="row">
    <div class="col-8 offset-2">
        <table class="table table-sm table-bordered table-striped ">
            <thead>
            <tr>
                <th>x</th>
                <th>y</th>
                <th>Δy</th>
                <th>Δ<sup>2</sup>y</th>
                <th>Δ<sup>3</sup>y</th>
            </tr>
            </thead>
            <tbody>
                <#list table as row>
                <tr>
                    <#list row as cloumn>
                        <td>${cloumn?if_exists}</td>
                    </#list>
                </tr>
                </#list>
            </tbody>
        </table>
    </div>
</div>

<div class="row">
    <div class="col-4"></div>
    <div class="col-4"></div>
    <div class="col-4"></div>
</div>


</@common.page>