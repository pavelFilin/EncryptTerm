<#import "parts/common.ftl" as common>

<@common.page>
<h1>
    Vigenere сhiper
</h1>

<div class="row">
    <form method="POST" action="/Encrypts/VigenereChiper" class="col-10 offset-1">
        <div class="">
            <h3>Before</h3>
        </div>
        <div class="input-group before-encrypt">
            <textarea class="form-control" name="text">${message?if_exists}</textarea>
        </div>
        <div class="input-group my-3">
            <input class="input-control" name="keys">
        </div>
        <div class="row mt-3">
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
            <textarea class="form-control after-encrypt" readonly>${encryptMessage?if_exists}</textarea>
        </div>
    </div>
</div>

</@common.page>