<?php

$aceleracionx = $_GET['acelx'];
$aceleraciony = $_GET['acely'];
$aceleracionz = $_GET['acelz'];
$temperatura = $_GET['temp'];

echo "La aceleracion en x es: ". $aceleracionx. " <br>La aceleracion en y es: ". $aceleraciony. "<br>La aceleracion en z es: " . $aceleracionz. "<br>La temperatura es: ".$temperatura;

$usuario = "root";
$contrasena = "";
$servidor = "localhost";
$basededatos = "acelerometroytemperatura";

$conexion = mysqli_connect( $servidor, $usuario, "") or die ("No se ha podido conectar al servidor de base de datos");

$db = mysqli_select_db( $conexion, $basededatos ) or die ("No se ha podido seleccionar la base de datos");

$fecha = time();
$consulta = "INSERT INTO datos (fecha, aceleracionx, aceleraciony, aceleracionz, temperatura) VALUES (".$fecha.", ".$aceleracionx.", ".$aceleraciony.", ".$aceleracionz.", ".$temperatura.")";

$resultado = mysqli_query( $conexion, $consulta );


?>