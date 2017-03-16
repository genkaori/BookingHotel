<%--
  Created by IntelliJ IDEA.
  User: FRAMGIA\duong.van.tien
  Date: 07/03/2017
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<section class="wrapper">
    <h3>List items</h3>
    <div class="row">
        <div class="col-md-12">
            <div class="content-panel">
                <hr>
                <c:if test="${!empty listItemsBeanEmpty}">
                    <h3  style="color: red"><c:out value="${listItemsBeanEmpty}"/></h3>
                </c:if>
                <c:if test="${!empty listItemsBean}">
                <table class="table">
                    <thead>
                    <tr>
                        <th>STT</th>
                        <th>Room name</th>
                        <th>Price</th>
                        <th>Description</th>
                        <th>Permision</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listItemsBean}" var="item">
                    <tr>
                        <td><a href=""><c:out value="${item.id}"/></a></td>
                        <td><c:out value="${item.name}"/></td>
                        <td><c:out value="${item.price}"/></td>
                        <td><c:out value="${item.description}"/></td>
                        <td>
                            <button class="btn btn-primary btn-xs"><a href="/edit_item?id=${item.id}">Edit</a></button>
                            <button class="btn btn-danger btn-xs"><a href="/delete_item?id=${item.id}">Delete</a></button>
                        </td>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
                </c:if>

                <div class="btn">
                    <a href="${pageContext.request.contextPath}/new_item">Add New Item</a>
                </div>
            </div>
        </div>
    </div>
</section>
