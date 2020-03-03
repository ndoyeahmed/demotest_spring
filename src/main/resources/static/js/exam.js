$(document).ready(function () {
    matiereList();

    $("#personne-add").submit(function (event) {
        event.preventDefault();
        searchCours();
    })
});

function searchCours() {
    const coursSearch = {
        codeProf: $("#codeProf").val(),
        matiere: $("#matiere").val()
    };

    $.ajax({
        url: "/cours/" + coursSearch.codeProf + "/" + coursSearch.matiere,
        type: 'GET',
        success: function (x) {
            console.log(x);
        }
    });
}

function matiereList() {
    $.ajax({
        url: "/matieres",
        type: 'GET',
        success: function (x) {
            console.log(x);
            let json =
                "<table class=\"table table-hover\">" +
                "                            <thead>" +
                "                            <tr>\n" +
                "                                <th>Id</th>" +
                "                                <th>Libelle</th>" +
                "                            </tr>\n" +
                "                            </thead>\n" +
                "<tbody>";
            for (const m of x) {
                json = json +
                    "<tr>" +
                    "<td>" + m.id + "</td>" +
                    "<td>" + m.libelle + "</td>" +
                    "</tr>"
            }

            json = json + "</tbody>" +
                "                        </table>";
            $('#feedback').html(json);
        }
    });
}
