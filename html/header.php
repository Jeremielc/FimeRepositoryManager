<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="">
  <meta name="author" content="Hue_Leclerc">

  <title>Reman</title>

  <?php
    $uri = $_SERVER["REQUEST_URI"];
    $uriArray = explode("/", $uri);
    $rootSite = $uriArray[1];
  ?>

  <!-- Bootstrap core CSS -->
  <link href="/<?php echo $rootSite ?>/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Bootstrap theme -->
  <link href="/<?php echo $rootSite ?>/js/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
  <!-- Main styleSheet -->
  <link href="/<?php echo $rootSite ?>/css/styleSheet.css" rel="stylesheet">

  <script src='./js/jquery.min.js'></script>
  <script src='./js/bootstrap/js/bootstrap.min.js'></script>

  <!-- Lib of validating field-->
  <script src='./js/bootstrap/js/bootstrapvalidator.min.js'></script>

</head>
<body>