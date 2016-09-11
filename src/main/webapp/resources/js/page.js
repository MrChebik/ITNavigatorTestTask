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
                            sendData(this, name, id, i);
                        }
                    }
                })
            } else if (name == 'type') {
                $("select[id = " + name + id + "]").change(function () {
                    sendData(this, name, id, i);
                })
            }
            break;
        }
    }
}

function sendData(element, name, id, i) {
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=utf-8",
        url: "/test/page",
        data: JSON.stringify({
            type: name,
            data: $(element).val(),
            id: i + 1
        }),
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