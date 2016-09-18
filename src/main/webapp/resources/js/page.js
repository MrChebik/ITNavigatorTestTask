function change(id, name) {
    var types = document.getElementsByName(name);
    for (var i = 0; i < types.length; i++) {
        if (types[i].id == id) {
            types[i].style.display = 'none';

            document.getElementById(name + id).value = types[i].textContent;
            document.getElementById(name + id).style.display = 'block';

            if (name == 'number' || name == 'comment') {
                if (name == 'number') {
                    var mask;
                    var elementText = $("span[name = 'type'][id = '" + id + "']").text();
                    if (elementText == 'Домашний') {
                        mask = '000-00-00';
                    } else if (elementText == 'Мобильный') {
                        mask = '+000 (00) 000-00-00';
                    } else {
                        mask = '000000000000';
                    }
                    $("#" + name + id).mask(mask);
                }
                $("input[class = " + name + "Input" + "][id = " + name + id + "]").keyup(function (e) {
                    if (e.keyCode == 13) {
                        if ($(this).attr("class") == "numberInput" && $(this).val() == '') {
                            alert("Номер телефона не введен");
                        } else {
                            if ($(this).val() == '') {
                                $(this).val("Нет комментария");
                            }
                            sendData(this, name, id);
                        }
                    }
                })
            } else if (name == 'type') {
                $("select[id = " + name + id + "]").change(function () {
                    sendData(this, name, id);
                })
            }
            break;
        }
    }
}

function sendData(element, name, id) {
    var data;
    if (name == 'number') {
        data = {
            id: id,
            number: $(element).val(),
            type: $("span[name = 'type'][id = '" + id + "']")[0].textContent,
            comment: $("span[name = 'comment'][id = '" + id + "']")[0].textContent
        }
    } else if (name == 'type') {
        data = {
            id: id,
            number: $("span[name = 'number'][id = '" + id + "']")[0].textContent,
            type: $(element).val(),
            comment: $("span[name = 'comment'][id = '" + id + "']")[0].textContent
        }
    } else {
        data = {
            id: id,
            number: $("span[name = 'number'][id = '" + id + "']")[0].textContent,
            type: $("span[name = 'type'][id = '" + id + "']")[0].textContent,
            comment: $(element).val()
        }
    }


    $.ajax({
        type: "POST",
        contentType: "application/json; charset=utf-8",
        url: "/test/page",
        data: JSON.stringify(data),
        success: function (data) {
            if (data == 'OK') {
                var types = document.getElementsByName(name);
                for (var i = 0; i < types.length; i++) {
                    if (types[i].id == id) {
                        $(element).css('display', 'none');
                        types[i].innerHTML = $(element).val();
                        types[i].style.display = 'block';
                    }
                }
            } else {
                alert("Error from the Server.");
            }
        },
        error: function () {
            alert("Error from the Page");
        }
    });
}