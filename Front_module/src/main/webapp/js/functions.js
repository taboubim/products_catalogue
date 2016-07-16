/**
 * Created by mtaboubi on 16-07-16.
 */


$(document).ready(function () {

    $("#loadCatalogue").on("click", function () {
        ajaxReq().load("/services/listCatalogue", function (xhr) {
            var data = jQuery.parseJSON(xhr);

        });
    });

    $("#loadMembers").on("click", function () {

        $("#listMembers").empty();

        ajaxReq().load("/services/listMembers", function (xhr) {
            var members = jQuery.parseJSON(xhr);
            $.each(members, function(index,value) {
                $("#listMembers").append('<input type="radio" name="members_rd" value=\"'+value.id+'\">'+ value.pseudonym+'<br>')
            });
        });

    });

    $("#loadShoppingBag").on("click", function () {
        ajaxReq().load("/services/listShoppingBag", function (xhr) {
            var data = jQuery.parseJSON(xhr);

        });
    });

    $("#addSelectedProduct").on("click", function () {
        ajaxReq().create("/services/listCatalogue", function (xhr) {
            var data = jQuery.parseJSON(xhr);

        });
    });

});



