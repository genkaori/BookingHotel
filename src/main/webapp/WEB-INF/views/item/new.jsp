<%--
  Created by IntelliJ IDEA.
  User: FRAMGIA\duong.van.tien
  Date: 07/03/2017
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<section class="wrapper">
    <div class="row mt">
        <div class="col-lg-12">
            <div class="form-panel">
                <h4>Add Item </h4>
                <form:form class="form-horizontal style-form" modelAttribute="itemBeanForm"
                      action="${pageContext.request.contextPath}/new_item" method="post" id="formItem">
                    <c:if test="${!empty err_AddItem}">
                        <p><h3  style="color: red"><c:out value="${err_AddItem}"/></h3></p>
                    </c:if>
                    <div class="form-group">
                        <label class="col-sm-2 col-sm-2 control-label">Item name</label>
                        <div class="col-sm-10">
                            <p id="err_name" style="color: red"></p>
                            <input class="form-control" name="name" type="text" path="name" placeholder=" item name..."
                                id="name">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 col-sm-2 control-label">Price</label>
                        <div class="col-sm-10">
                            <p id="err_price" style="color: red"></p>
                            <p id="err_format" style="color: red"></p>
                            <input class="form-control" name="price" type="text" path="price" placeholder=" price..."
                                   id="price">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 col-sm-2 control-label">Description</label>
                        <div class="col-sm-10">
                            <input class="form-control" name="description" type="text"
                                   path="description" placeholder="description..." id="description">
                        </div>
                    </div>
                    <div style="text-align: left;">
                        <a class="btn btn-theme" id="btnSubmit" href="#">Add</a>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>
<script type="text/javascript">
    $("#btnSubmit").on("click", function () {
//        e.preventDefault();
        var priceVal = $("#price").val();
        var nameVal = $("#name").val();
        var check = true;
        if (checkEmpty(nameVal)) {
            $("#err_name").text("name is not empty");
            check = false;
        }
        if (checkEmpty(priceVal)) {
            $("#err_price").text("price is not empty");
            check = false;
        }
        console.log("--------"+checkNumber(priceVal))
        if (checkNumber(priceVal)) {
            $("#err_format").text("price is not number");
            check = false
        }
        if(check){
            $("#formItem").submit();
        }
    });

    function checkNumber(str) {
        if (isNaN(str)) {
            return true;
        } else {
            return false;
        }
    }

    function checkEmpty(str) {
        if (str == "") {
            return true;
        }
        return false;
    }
</script>
