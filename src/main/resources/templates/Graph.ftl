<#import "parts/common.ftl" as common>


<@common.page>
    <div class="container graph-form">
        <div class="row">
            <div class="col-6">
                <form id="plotForm" class="mt-3">
                    <h4 style="margin-left:-15px ">plot the graph</h4>
                    <div class="form-group row">
                        <label for="leftX" class="col-xs-3 col-form-label mr-2 input-label">Left x</label>
                        <div class="col-xs-9">
                            <input type="number" min="-10000" max="10000" value="-10" class="form-control input-number"
                                   id="leftX" name="leftX">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="rightX" class="col-xs-3 col-form-label mr-2 input-label">Right x</label>
                        <div class="col-xs-9">
                            <input type="number" min="-10000" max="10000" value="10" class="form-control input-number"
                                   id="rightX" name="rightX">
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="step" class="col-xs-3 col-form-label mr-2 input-label">Step</label>
                        <div class="col-xs-9">
                            <input type="number" min="-100" max="100" value="1" class="form-control input-number"
                                   id="step" name="step">
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="offset-xs-3 col-xs-9">
                            <a class="btn btn-primary ml-5" id="plotBtn">plot</a>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-6">
                <form id="clarify-root-form" class="mt-3">
                    <h4 style="margin-left:-15px ">to clarify the root</h4>
                    <div class="form-group row">
                        <label for="leftX-clarify" class="col-xs-3 col-form-label mr-2 input-label">Left x</label>
                        <div class="col-xs-9">
                            <input type="number" min="-10000" max="10000" value="-10" class="form-control input-number"
                                   id="leftX-clarify" name="leftX">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="rightX-clarify" class="col-xs-3 col-form-label mr-2 input-label">Right x</label>
                        <div class="col-xs-9">
                            <input type="number" min="-10000" max="10000" value="10" class="form-control input-number"
                                   id="rightX-clarify" name="rightX">
                        </div>
                    </div>
                    <div class="form-group row">
                        <div class="offset-xs-3 col-xs-9">
                            <a class="btn btn-primary ml-5" id="btn-clarify">clarify</a>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="result-clarify" class="col-xs-3 col-form-label mr-2 input-label">Root</label>
                        <div class="col-xs-9">
                            <input type="number" readonly="readonly" min="-10000" max="10000" value="0"
                                   class="form-control input-number"
                                   id="result-clarify" style="width=150px">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <div class="ct-chart ct-perfect-fourth" id="chart"></div>

    <script src="https://cdn.jsdelivr.net/chartist.js/latest/chartist.min.js"></script>
    <script src="/static/js/main.js"></script>
</@common.page>