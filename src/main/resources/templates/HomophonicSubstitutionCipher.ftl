<#import "parts/common.ftl" as common>

<@common.page>
<h1>
    Омофоническая замена
</h1>

<div class="row">
    <form method="POST" action="/Encrypts/HomophonicSubstitutionCipher" class="col-10 offset-1">
        <div class="">
            <h3>Before</h3>
        </div>
        <div class="input-group before-encrypt">
            <textarea class="form-control" name="text"></textarea>
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
            <h3>After</h3>
        </div>
        <div>
            <textarea class="form-control after-encrypt" readonly></textarea>
        </div>
    </div>
</div>

</@common.page>