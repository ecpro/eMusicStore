<%@ include file="/WEB-INF/views/template/header.jsp"%>

<div class="container container-wrapper col-off">
    <div class="page-header">
        <h1>Add new products.</h1>
        <p class="lead">Fill the form below with product details</p>
    </div>

    <form:form action="${pageContext.request.contextPath}/admin/productInventory/addProduct" method="post" commandName="product" enctype="multipart/form-data">
        <%-- Product name --%>
        <div class="form-group">
            <label for="name">Name</label>
            <form:input path="productName" type="text" id="name" class="form-control"/>
        </div>
        <%-- Product category --%>
        <div class="form-group">
            <label for="category">Category</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="Instrument"/>Instrument</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="Record"/>Record</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category" value="Accessory"/>Accessory</label>
        </div>

        <%-- Product Description --%>
        <div class="form-group">
            <label for="description">Description</label>
            <form:textarea path="productDescription" type="textarea" id="description" class="form-control"/>
        </div>
        <%-- Product Price --%>
        <div class="form-group">
            <label for="price">Price</label>
            <form:input path="productPrice" type="text" id="price" class="form-control"/>
        </div>
        <%-- Product Condition --%>
        <div class="form-group">
            <label for="condition">Condition</label>
            <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition" value="New"/>New</label>
            <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition" value="Used"/>Old</label>
        </div>

        <%-- Product Status --%>
        <div class="form-group">
            <label for="status">Product Status</label>
            <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" value="Active"/>Active</label>
            <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status" value="Inactive"/>Inactive</label>
        </div>

        <%-- Product Units in stock --%>
        <div class="form-group">
            <label for="units">Units In Stock</label>
            <form:input path="unitInStock" id="units" type="text" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="manufacturer">Manufacturer</label>
            <form:input path="productManufacturer" id="manufacturer" class="form-control"/>
        </div>

        <div class="form-group">
            <label class="control-label" for="productImage">Upload Product Image</label>
            <form:input path="productImage" type="file" id="productImage" class="form:input-large"/>
        </div>
        <br><br>
        <input type="submit" class="btn btn-success">
        <a class="btn btn-danger" href="${pageContext.request.contextPath}/admin/productInventory">Cancel</a>

    </form:form>
</div>

<%@ include file="/WEB-INF/views/template/footer.jsp"%>