<#import "parts/common.ftl" as common>

<@common.page>
    <div class="container">
        <#if message??>
            <div class="alert alert-primary" role="alert">
                ${message}
            </div>
        </#if>
        <div class="row">
            <div class="col-md-6 mb-3">
                <form content="form-group" class="mt-1">
                    <h4>add new message</h4>
                    <div class="form-group row">
                        <textarea class="form-group" id="message-RSA" style="width: 100%">

                        </textarea>
                    </div>
                    <div class="form-group row">
                        <div class="col-md-9">
                            <a class="btn btn-primary" id="add-btn-RSA" style="width: 40%;min-width: 150px">add</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <table class="table" id="message-table-rsa" style="max-width: 100%">
            <thead>
                <th>id</th>
                <th>message</th>
                <th>public key</th>
                <th>signature</th>
            </thead>
        </table>
    </div>
    <script src="/static/js/RsaEncryptScript.js"></script>
</@common.page>