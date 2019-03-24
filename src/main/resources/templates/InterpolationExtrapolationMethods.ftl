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

    <div class="col-6 offset-3">

        <div class="row">
            <div class="col-4">
                <table class="table table-sm table-bordered table-striped ">
                    <caption style="caption-side: top;">Gauss</caption>
                        <#list gauss as g>
                            <tr>
                                <td>${g?if_exists}</td>
                            </tr>
                        </#list>
                </table>
            </div>
            <div class="col-4">
                <table class="table table-sm table-bordered table-striped ">
                    <caption style="caption-side: top;">Bessel</caption>
                    <#list bessel as g>
                        <tr>
                            <td>${g?if_exists}</td>
                        </tr>
                    </#list>
                </table>
            </div>
            <div class="col-4">
                <table class="table table-sm table-bordered table-striped ">
                    <caption style="caption-side: top;">Stirling</caption>
                    <#list stirling as g>
                        <tr>
                            <td>${g?if_exists}</td>
                        </tr>
                    </#list>
                </table>
            </div>
        </div>
    </div>


</@common.page>