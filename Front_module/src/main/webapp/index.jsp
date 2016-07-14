<html>

<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="./common_libs/jquery-1.12.0.min.js"></script>
    <script type="text/javascript" src="./common_libs/XHRequests.js"></script>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

    <title>Product Shopping</title>
</head>


<body>
<h2>Hello You!</h2>

<div class="row">
    <div class="col-md-3">
        <div class="btn-group btn-group-vertical floating-panel">
            <button id="addProduct" class="btn btn-default">addProduct</button>
            <button id="displayProducts_Catalogue" class="btn btn-default">displayProducts_Catalogue</button>
            <button id="displayProducts_Bag" class="btn btn-default">displayProducts_Bag</button>
        </div>

    </div>
    <div class="col-md-3">
        <div id="Products_Catalogue" style="width: 500px; height: 375px; border: solid 2px #666;">
        </div>
    </div>

    <div class="col-md-3">
        <div id="Products_Bag" style="width: 500px; height: 375px; border: solid 2px #666;">
        </div>
    </div>
</div>



</body>
</html>
