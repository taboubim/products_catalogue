var ajaxReq = function () {

    var api = {};

    api.load = function (url, success, failure) {
        return $.ajax({
            type: 'GET',
            url: url,
            cache: false
        }).done(success).error(failure);
    };

    api.create = function (url, object, success, failure) {
        return $.ajax({
            contentType: 'application/json',
            type: 'POST',
            data: $.toJSON(object),
            url: url
        }).done(success).error(failure);
    };


    api.update = function (object, url, success, failure) {
        return $.ajax({
            type: 'PUT',
            data: object,
            url: url,
            success: success,
            error: failure
        });
    };

    api.put = function (object, url, success, failure) {
        return $.ajax({
            headers: api.commonHeaders(),
            type: 'PUT',
            data: $.toJSON(object),
            url: url
        }).done(success).error(failure);
    };

    api.remove = function (object, url, success, failure) {
        return $.ajax({
            type: 'DELETE',
            url: url,
            success: success,
            error: failure
        });
    };

    return api;

};




