<?php
//coge las variables del json y las guarda en variables para la conexion
$json = file_get_contents('json/variables.json');
$json_data = json_decode($json, true);
$servername = $json_data["servername"];
$username = "sge";
$password = "DAM2v2023!";
$database = $json_data["database"];
$server="hl1173.dinaserver.com";
$user="sge";
$pass="DAM2v2023!";
$dab="pharmadam";
//conexion a la base de datos
try {
    $conn = new PDO("mysql:host=$server;dbname=$dab;charset=utf8", $user, $pass);
    // set the PDO error mode to exception
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
} catch (PDOException $e) {
    echo "Fallo en conexion : " . $e->getMessage();

}
?>