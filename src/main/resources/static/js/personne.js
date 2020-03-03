$(document).ready(function () {
    personneList();

    $("#personne-add").submit(function (event) {
        event.preventDefault();
        savePersonne();
    })
});

function savePersonne() {
    const personne = {
        nom: $("#nompersonne").val(),
        prenom: $("#prenompersonne").val()
    };

    console.log(personne);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/personnes",
        data: JSON.stringify(personne),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {
            console.log(data);
        },
        error: function (e) {
            console.log(e);
            // $("#btn-search").prop("disabled", false);

        }
    });
}

function personneList() {
    $.ajax({
        url: "/personnes",
        type: 'GET',
        success: function (x) {
            console.log(x);
        }
    });
}
