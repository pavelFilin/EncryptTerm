<#import "parts/common.ftl" as common>

<@common.page>
<h1>
   
</h1>

<div class="row">
    <form method="POST" action="/Encrypts/CombinationCipher" class="col-10 offset-1">
        <div class="">
            <h3>Before</h3>
        </div>
        <div class="input-group before-encrypt">
            <textarea class="form-control" name="text">${message?if_exists}</textarea>
        </div>

        <div class="input-group my-3">
            <input type="number" min="1" max="999" value="1" class="input-control" name="shift">
        </div>

        <div class="row mt-4">
            <div class="col-2 offset-5">
                <input type="submit" class="btn btn-outline-success" style="width: 100%" value="Encrypt"/>
            </div>
        </div>
    </form>

</div>

<div class="row">
    <div class="col-10 offset-1">
        <div>
            <h3>Prepared</h3>
        </div>
        <div>
            <textarea class="form-control after-encrypt" readonly>${prepMessage?if_exists}</textarea>
        </div>
    </div>
</div>

<#if keys??>
<div class="row my-3">
    <div class="col-10 offset-1">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th scope="col">letter</th>
                <th scope="col">code</th>
            </tr>
            </thead>
            <tbody>    `
            <#list keys as k, v>
            <tr>
            <th>${k}</th>
            <th>
                <#list v as kee>
                    ${kee + " "}
                </#list>
            </th>
            </tr>
            </#list>
            </tbody>
        </table>
    </div>
</div>
</#if>

<div class="row">
    <div class="col-10 offset-1">
        <div>
            <h3>After</h3>
        </div>
        <div>
            <textarea class="form-control after-encrypt" readonly>${encryptMessage?if_exists}</textarea>
        </div>
    </div>
</div>

</@common.page>