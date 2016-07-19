<html>

<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="./common_libs/jquery-1.12.0.min.js"></script>
    <script type="text/javascript" src="./common_libs/jquery.json.min.js"></script>

    <script type="text/javascript" src="./common_libs/XHRequests.js"></script>
    <script type="text/javascript" src="./js/functions.js"></script>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

    <title>Product Shopping</title>
</head>


<body>
<h2 align="center">Hello You!</h2>

<div class="row">

    <div class="col-lg-2 col-md-2">
        <button id="resetData" class="btn btn-default">Reset Data</button>
        <p id="resetState"></p>
    </div>

    <div class="col-lg-3 col-md-3">
        <button id="loadCatalogue" class="btn btn-default">Load Catalogue</button>

        <div id="Products_Catalogue" style="height: 300px; border: solid 2px #666;">
        </div>

        <button id="addSelectedProduct" class="btn btn-default">add Selected Product for selected Member</button>

        <button id="loadDescriptionProducts" class="btn btn-default">Load Description for selected Products</button>

    </div>

    <div class="col-lg-3 col-md-3">
        <button id="loadMembers" class="btn btn-default">Load All Members</button>
        <form id="listMembers" style="height: 300px; border: solid 2px #666;">
        </form>
    </div>

    <div class="col-lg-3 col-md-3">
        <button id="loadShoppingBag" class="btn btn-default">load ShoppingBag for Member</button>
        <form id="shoppingBagMember" style="height: 300px; border: solid 2px #666;">
        </form>
    </div>
</div>
<div class="row">
    <div id="productsDetails" class="col-lg-8 col-md-8"  style="height: 300px; border: solid 2px #666;">

    </div>
</div>


</body>
</html>
