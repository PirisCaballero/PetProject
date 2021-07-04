<?php

$pulso = $_GET['pulso'];
$oxigeno = $_GET['oxigeno'];

echo "El pulso es: ". $pulso. " <br>El oxigeno en sangre es: ". $oxigeno;

$usuario = "root";
$contrasena = "";
$servidor = "localhost";
$basededatos = "pulsioximetro";

$conexion = mysqli_connect( $servidor, $usuario, "") or die ("No se ha podido conectar al servidor de base de datos");

$db = mysqli_select_db( $conexion, $basededatos ) or die ("No se ha podido seleccionar la base de datos");

$fecha = time();
$consulta = "INSERT INTO datos (fecha, pulso, oxigeno) VALUES (".$fecha.", ".$pulso.", ".$oxigeno.")";

$resultado = mysqli_query( $conexion, $consulta );



?>