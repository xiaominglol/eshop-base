<div th:replace="${table.moduleName}/dict_crud"></div>

<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md2">
            <div class="layui-card">
                <div class="layui-card-body">
                    <div id="tree"></div>
                </div>
            </div>
        </div>
        <div class="layui-col-md10">
            <div class="layui-card">
                <div class="layui-card-body">
                    <div id="content">
                        <div class="layui-row">
                            <div class="layui-col-md12">
                                <blockquote class="layui-elem-quote layui-quote-nm">
                                    <form class="layui-form layui-form-pane queryFrom">
                                        <div class="layui-form-item">
                                            <div class="layui-inline">
                                                <label class="layui-form-label">名称</label>
                                                <div class="layui-input-inline">
                                                    <input type="text" name="name" placeholder="请输入名称"
                                                           autocomplete="off"
                                                           class="layui-input">
                                                </div>
                                            </div>

                                            <div class="layui-inline">
                                                <div class="layui-input-inline" style="width: 100%">
                                                    <div class="layui-btn-container">
                                                        <button class="layui-btn layui-btn-sm layui-btn-normal"
                                                                lay-submit
                                                                lay-filter="queryButton">
                                                            <i class="layui-icon layui-icon-search"></i>查询
                                                        </button>
                                                        <button type="reset"
                                                                class="layui-btn layui-btn-sm layui-btn-rest">
                                                            <i class="layui-icon layui-icon-refresh-1"></i>重置
                                                        </button>
                                                        <span class="layui-btn layui-btn-sm addButton">
                                                <i class="layui-icon layui-icon-add-circle"></i> 添加
                                            </span>
                                                        <span class="layui-btn layui-btn-sm layui-btn-warm editButton">
                                                <i class="layui-icon layui-icon-edit"></i> 修改
                                            </span>
                                                        <span class="layui-btn layui-btn-sm layui-btn-danger delButton">
                                                <i class="layui-icon layui-icon-delete"></i> 删除
                                            </span>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </blockquote>
                            </div>
                        </div>

                        <div class="layui-row">
                            <div class="layui-col-md12">
                                <table id="table" lay-filter="table"></table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script th:inline="none">

    layui.use(['form', 'table'], function () {
        var form = layui.form;
        var table = layui.table;
        var baseUrl = "/goods/category";
        var moduleName = "分类";
        var requestType;
        var baseCols = [[
            {checkbox: true}
            , {field: 'name', title: '名称'}
            , {field: 'icon', title: 'icon'}
            , {field: 'sort', title: '排序'}
            , {title: '操作', width: 120, toolbar: '#optToolBar'}
        ]];
        var baseDetailCols = [
            {type: 'checkbox', width: 35}
            , {field: 'name', title: '名称', edit: 'text'}
            , {field: 'icon', title: 'icon', edit: 'text'}
            , {field: 'sort', title: '排序', edit: 'text'}
        ];
        var baseUpdateCols = [
            {field: 'name', type: "text"}
            , {field: 'icon', type: "text"}
            , {field: 'sort', type: "text"}
        ];

        //左侧树
        renderTree({
            url: baseUrl
            , click: function (node) {
                renderTreeTable({
                    url: baseUrl
                    , data: {id: node.id}
                    , cols: baseCols
                });
            }
        });

        //右侧树形表格
        renderTreeTable({
            url: baseUrl
            , cols: baseCols
        });

        //查询
        form.on('submit(queryButton)', function (data) {
            renderTreeTable({
                url: baseUrl
                , data: data.field
                , cols: baseCols
            });
            return false;
        });

        //添加
        $(".addButton").click(function () {
            requestType = add({
                title: '添加' + moduleName
                , cols: baseDetailCols
            });
        });

        // 修改
        $(".editButton").click(function () {
            requestType = edit({
                title: '修改' + moduleName
                , url: baseUrl
                , cols: baseDetailCols
                , fields: baseUpdateCols
            });
        });

        // 添加/修改 保存
        form.on('submit(saveButton)', function (data) {
            data.field.detailList = table.cache.detailTable;
            saveOrUpdate({
                url: baseUrl
                , baseUrl: baseUrl
                , baseCols: baseCols
                , type: requestType
                , data: data.field
            });
            return false;
        });

        // 删除
        $(".delButton").click(function () {
            var selectedData = table.checkStatus('table');
            if (selectedData.data.length != 0) {
                del({
                    url: baseUrl + "/" + selectedData.data[0].id
                    , baseUrl: baseUrl
                    , baseCols: baseCols
                });
            } else {
                layer.msg('请选择一条数据', {icon: 0});
            }
        });

        // 新增一行 明细
        $(".add_detail").click(function () {
            addRowButton({
                table: "detailTable"
                , cols: baseDetailCols
            })
        });

        // 批量删除 明细
        $(".delete_detail").click(function () {
            batchDelButton({
                table: "detailTable"
                , cols: baseDetailCols
            })
        });
    });

</script>

<script type="text/html" id="optToolBar">
    {{#  if(d.stateCode == 'Enable'){ }}
    <a class="layui-btn layui-btn-sm layui-btn-danger" lay-event="disable"><i
                class="layui-icon layui-icon-password"></i>禁用</a>
    {{#  } else { }}
    <a class="layui-btn layui-btn-sm layui-btn-rest" lay-event="enabled"><i class="layui-icon layui-icon-auz"></i>启用</a>
    {{#  } }}
</script>
