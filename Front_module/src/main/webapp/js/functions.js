/**
 * Created by mtaboubi on 16-07-16.
 */


$(document).ready(function () {

    $("#resetData").on("click", function () {
        $("#listMembers").empty();
        $("#Products_Catalogue").empty();
        $("#Products_Bag").empty();
        $("#shoppingBagMember").empty();

        ajaxReq().load("/services/reset", function () {
            window.alert("Reset Done");
        }, function () {
            window.alert("Reset not Done - Error somewhere");
        });
    });

    $("#loadMembers").on("click", function () {
        $("#listMembers").empty();

        ajaxReq().load("/services/listMembers", function (xhr) {
            var members = $.parseJSON(xhr);
            $.each(members, function (index, value) {
                $("#listMembers").append('<input type="radio" name="members_rd" value=\"' + value.id + '\">' + value.pseudonym + '<br>')
            });
        });
    });

    $("#loadCatalogue").on("click", function () {
        $("#Products_Catalogue").empty();
        ajaxReq().load("/services/listProductsCatalogue", function (xhr) {
            var catalogue = $.parseJSON(xhr);
            $.each(catalogue, function (index, value) {
                $("#Products_Catalogue").append('<input type="checkbox" name="catalogue_check" value=\"' + value.id + '\">' + value.name + '<br>')
            });
        });

    });

    $("#loadDescriptionProducts").on("click", function () {

        $("#productsDetails").empty();

        // Get all checked checkbox :
        $("input[name=catalogue_check]:checkbox").each(function () {
            var $this = $(this);
            var id = $this.val();

            if ($this.is(":checked")) {
                ajaxReq().load("/services/loadProductByID?product_id=" + id, function (xhr) {
                    var data = $.parseJSON(xhr)[0];
                    $("#productsDetails").append("<p> ProductName = " + data.name + "|| Product Details = " + data.description + " </p><br/>");
                });
            }
        });
    });

    $("#addSelectedProduct").on("click", function () {

        // Get all selected Products :
        var selectedProducts = $("input[name=catalogue_check]:checked").map(function () {
            return this.value;
        }).get();

        // Get selected Member
        var selectedMember_id = $("input[name=members_rd]:checked")[0].value;

        ajaxReq().create("/services/addProduct", {
            member_id: selectedMember_id,
            products_id: selectedProducts
        }, function (xhr) {
        });

    });

    $("#loadShoppingBag").on("click", function () {
        $("#shoppingBagMember").empty();

        var selectedMember_id = $("input[name=members_rd]:checked")[0].value;

        ajaxReq().load("/services/listShoppingBag?member_id=" + selectedMember_id, function (xhr) {
            var data = $.parseJSON(xhr);
            $.each(data, function(index, value){
                $("#shoppingBagMember").append("<p> ProductName = " + value.name +
                    "|| Product Details = " + value.description + " </p><br/>");
            })
        });
    });
});



