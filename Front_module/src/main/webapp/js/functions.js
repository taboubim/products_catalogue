/**
 * Created by mtaboubi on 16-07-16.
 */


$(document).ready(function () {

    $("#resetData").on("click", function () {
        $("#listMembers").empty();
        $("#Products_Catalogue").empty();
        $("#Products_Bag").empty();

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

        ajaxReq().load("/services/listCatalogue", function (xhr) {
            var catalogue = $.parseJSON(xhr);
            $.each(catalogue, function (index, value) {
                $("#Products_Catalogue").append('<input type="checkbox" name="catalogue_rd" value=\"' + value.id + '\">' + value.name + '<br>')
            });
        });

    });

    $("#loadShoppingBag").on("click", function () {
        ajaxReq().load("/services/listShoppingBag", function (xhr) {
            var data = $.parseJSON(xhr);

        });
    });

    $("#addSelectedProduct").on("click", function () {
        ajaxReq().create("/services/listCatalogue", function (xhr) {
            var data = $.parseJSON(xhr);

        });
    });

});



