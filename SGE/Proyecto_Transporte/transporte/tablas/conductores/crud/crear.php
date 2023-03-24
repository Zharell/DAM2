
<?php
require('../../../php/db.php');


$sql = "INSERT INTO conductor (nombre, apellidos, dni ,matricula ,telefono ,email ,nacionalidad) VALUES
(:name,:apellidos,:dni,:matricula,:telefono,:email,:nacionalidad)";

$stmt = $conn->prepare($sql);

$stmt->bindParam(':name', $_POST["nombre"], PDO::PARAM_STR); 
$stmt->bindParam(':apellidos', $_POST["apellidos"], PDO::PARAM_STR);
$stmt->bindParam(':dni', $_POST["dni"], PDO::PARAM_STR);
$stmt->bindParam(':matricula', $_POST["matricula"], PDO::PARAM_STR);
$stmt->bindParam(':telefono', $_POST["telefono"], PDO::PARAM_STR);
$stmt->bindParam(':email', $_POST["email"], PDO::PARAM_STR);
$stmt->bindParam(':nacionalidad', $_POST["nacionalidad"], PDO::PARAM_STR);

/*if($stmt->execute()==true)
var_dump($_POST);
    header("Location: ../../../index.php");*/

    if ($stmt->execute()==true) {
        header("Location: PagCrear.php");    
    }
?>
