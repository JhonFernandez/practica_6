<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>

<div class="container">
    <nav class="navbar navbar-inverse">
        <div class="container">
            <ul class="nav navbar-nav">
                <li class=""><a href="/"><span class="lyphicon glyphicon glyphicon-home"></span> Home</a></li>
                <li class="active"><a href="/"><span class="lyphicon glyphicon glyphicon-list-alt"></span> Estudiantes List</a></li>
                <li class=""><a href="/agregar"><span class="lyphicon glyphicon glyphicon-plus"></span> New Estudiante</a></li>

            </ul>
        </div>
    </nav>

    <div class="table-responsive">
        <table class="table table-bordered table-inverse">
            <thead>
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Telefono</th>
                <th>Matricula</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
                <#list listaEstudiante as estudiante>
                    <tr>
                        <form class="" action="/ver" method="post">
                            <td><name="id" type="hidden" value="${estudiante.id}"/>${estudiante.id}</td>
                            <td><input name="nombre" type="hidden" value="${estudiante.nombre}"/>${estudiante.nombre}</td>
                            <td><input name="apellido" type="hidden" value="${estudiante.apellido}"/>${estudiante.apellido}</td>
                            <td><input name="telefono" type="hidden" value="${estudiante.telefono}"/>${estudiante.telefono}</td>
                            <td><input name="matricula" type="hidden" value="${estudiante.matricula}"/>${estudiante.matricula}</td>
                            <td><input class="btn" type="submit" value="Ver"></td>
                        </form>
                    </tr>
                </#list>
            </tbody>
        </table>
    </div>


    <nav class="navbar navbar-inverse">
        <div class="container">

        </div>
    </nav>


</div>

<!-- Latest compiled and minified JavaScript -->
<script src="js/bootstrap.min.js"></script>
</body>

</html>
