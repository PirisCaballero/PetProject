<?php

$pulso = $_GET['pulso'];
$oxigeno = $_GET['oxigeno'];
$temperatura = $_GET['temperatura'];

echo "El pulso es: ". $pulso. "ppm<br>El oxigeno en sangre es: ". $oxigeno. "%<br>La temperatura es: ". $temperatura. "ºC";

$usuario = "root";
$contrasena = "";
$servidor = "localhost";
$basededatos = "pulsoytemperatura";

$conexion = mysqli_connect( $servidor, $usuario, "") or die ("No se ha podido conectar al servidor de base de datos");

$db = mysqli_select_db( $conexion, $basededatos ) or die ("No se ha podido seleccionar la base de datos");

$fecha = time();
$consulta = "INSERT INTO datos (fecha, pulso, oxigeno, temperatura) VALUES (".$fecha.", ".$pulso.", ".$oxigeno.",".$temperatura.")";

$resultado = mysqli_query( $conexion, $consulta );


?>