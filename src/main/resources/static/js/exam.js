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
        matiere: $("#matiere").val().toUpperCase()
    };

    $.ajax({
        url: "/cours/" + coursSearch.codeProf + "/" + coursSearch.matiere,
        type: 'GET',
        success: function (data) {
            if (data && data.classe && data.salle) {
                let json =
                    "<table class=\"table table-hover\">" +
                    "                            <thead>" +
                    "                            <tr>\n" +
                    "                                <th>Intitule</th>" +
                    "                                <th>Nom classe</th>" +
                    "                                <th>Nom salle</th>" +
                    "                                <th>Date cours</th>" +
                    "                                <th>Heure debut</th>" +
                    "                                <th>Heure fin</th>" +
                    "                                <th>Annee academique</th>" +
                    "                                <th>Coef</th>" +
                    "                            </tr>\n" +
                    "                            </thead>\n" +
                    "<tbody>";
                json = json +
                    "<tr>" +
                    "<td>" + data.intitule + "</td>" +
                    "<td>" + data.classe.libelle + "</td>" +
                    "<td>" + data.salle.libelle + "</td>" +
                    "<td>" + data.date + "</td>" +
                    "<td>" + data.heureDebut + "</td>" +
                    "<td>" + data.heureFin + "</td>" +
                    "<td>" + data.anneeAcademique + "</td>" +
                    "<td>" + data.coef + "</td>" +
                    "</tr>";

                json = json + "</tbody>" +
                    "                        </table>";
                $('#coursTables').html(json);
            } else {
                $('#coursTables').html("<h5>Aucun resultat trouvé</h5>");
            }
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
