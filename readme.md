Ejemplos de uso de GIT
-
1) Lo primero que tenemos que hacer es crear un directorio y dentro de el
crear un repositorio GIT -> git init. Este comando nos creara una
carpeta oculta con extension .git. Dentro de esta carpeta estaran todas
nuestras versiones de nuestro workspace.
En caso de que queramos borrarlo, simplemente borrar la carpeta

2) para add ficheros al stage -> git add nombre_fichero
	2.1) Para quitar ficheros del stage podemos usar el comando
		-> git restore --staged NOMBRE_FICHERO

3) para ver el estado de nuestro git podemos usar el comando -> git status

4) para versionar los ficheros que estan en el stage el comando 
-> git commit. Lo que ocurre es que todos los commits que se hagan tienen
que tener un mensaje, por lo tanto es más comun utilizar el comando
-> git commit -m "la descripcion del commit". Todos los commits estan
asociados a un usuario con un correo.

5) Podemos ver todo nuestro historial de cambios con el comando ->
git log. Nos sacaria algo como esto:

(version o commit, seria un codigo hash que genera git por nosotros )
commit 50f9086a6cc1161ef2fb1a682d9d828c1c3bc587 (HEAD -> master)
Author: Felix de Pablo <f.depablo.lobo@gmail.com>
Date:   Wed Jan 20 18:44:41 2021 +0100

    primer commit de listaCompra.txt (mensaje)

Si queremos cerrar el log cuando tenga muchos commits podemos pulsar "q"
	
6) Si queremos add todos los documentos que tengamos en nuestro workspace
a nuestro stage,podemos usar -> git add .

7) Podemos ver los cambios de nuestro repositorio local con nuestro 
workspace con el comando -> git diff

7.1) Podemos eliminar los cambios nuevos de nuestro workspace con el
comando -> git restore nombre_fichero (o "git restore ." para todos los 
ficheros. Con lo cual nos bajamos los cambios de nuestro repositorio local

8) Podemos ir a cualquier commit a ver la "foto" de nuestro proyecto.
Para ello utilizaremos el comando -> git checkout CODIGO_HASH

9) Cuando estamos en otro commit podemos usar el comando -> git log --all
para ver todos los commits de mi proyecto, por defecto solo te muestra
desde el commit al que estes apuntando para atras

10) Para regresar a nuestro ultimo commit de nuestro proyecto principal
podemos usar -> git checkout master

11) ramas, una rama es un flujo de trabajo, sirven para hacer desarrollos
paralelos a nuestro trabajo principal, sin necesidad de estropear los 
cambios en el desarrollo principal. Por defecto git trabaja sobre la rama
master, que sería la principal. Las ramas en git son punteros o referencias
que apuntan siempre al ultimo commit de la rama a la que pertenecen. 
Podemos entender los commit como los objetos en java (poo), los commits 
son los que guardan la información del estado de nuestro repositorio. 
Podemos entenderlo tambien como fotos de nuestro repositorio.
Podemos crear ramas con el comando -> git checkout -b nombre_rama

12) podemos ver las ramas que tenemos con -> git branch

	12.1)Podemos empezar a hacer desarrollos y commits sobre la rama
	actual en la que hemos creado. Siempre que hagamos un commit avanza
	el puntero de la rama con la que estamos trabajando y el puntero HEAD

13) Podemos fusionar ramas ýendonos a la rama donde queremos hacer la
fusion, y luego ejecutar el comando -> git merge rama_a_fusionar
por ejemplo, podemos ir a master y ejecutar git merge videojuegos

Cuando fusionarmos ramas puede haber conflictos en caso de que varias 
personas hayan estado trabajando con los mismos ficheros.

	13.1) Para ver de manera grafica las ramas y los commits podemos
	ejecutar -> git log --graph --abbrev-commit --decorate --all

14) para borrar una rama (es  un puntero o una referencia) se ejecuta
el comando -> git branch -d nombre_rama

15) Si queremos ver el detalle de los cambios que hicimos en un commit
podemos usar el comando -> git show codigo_sha1

16) Si creamos una nueva rama y trabajamos con cambios en un fichero y 
ese fichero no va a ser usado por más ramas, no hay problema de hacer 
"merge" entre distintas ramas. Pero ojo! si varias ramas se pisan sobre 
las mismas lineas del fichero, puede haber conflictos.

17) con el comando "Gitk" podemos hacernos una idea generica de nuestro
repositorio a nivel de commits, se nos abré un programita de git 
totalmente visual.

18) Cuando fusionamos dos ramas que han estado trabajando con el mismos
fichero, git por defecto fusiona todos los cambios de ambas ramas. Luego
son los programadores los que deben decidir con que parte del codigo 
se quedan (puede ser todo!) y a continacion hacer un nuevo commmit

19) Si en algun caso no queremos versionar algun o algunos de los ficheros
que tenemos en un workspace podemos crear un fichero ".gitignore" y poner
ahi todos los ficheros que no quiero versionar. Este fichero va en el
directorio raiz de nuestro espacio de trabajo, y en principio, solo habra
1 fichero .gitignore
Ejemplo de ".gitignore" de ignarar archivos de entorno de eclipse que no
tiene sentido compartir con otros compañeros de equipo (o nosotros):
https://github.com/fdepablo/WorkspaceJava/blob/master/.gitignore

20) Para trabajar en un entorno colaborativo debemos de usar un repositorio
remoto, por ejemplo Github. Debemos de crear una cuenta y a continuacion
un repositorio. Una vez creado el repositorio en github, nos da una serie
de instrucciones para unirlo con un repositorio local:
Ej: git remote add origin https://github.com/fdepablo/WsEntornosDesarrolloTelefonica.git
remote add -> comando para decir a git que queremos contectarnos a un 
	repositorio remoto
origin -> es el nombre (alias) por defecto que le da git a nuestro repositorio 
	remoto
http://git... -> la direccion de nuestro repositorio remoto

21) Para subir cambios de nuestro repositorio local a nuestro repositorio
remoto usaremos el comando -> git push -u origin master
push -> subida al repo remoto
origin -> el nombre del repo remoto donde lo subimos
master -> nombre de la rama que queremos subir 
-u -> recordatorio de que siempre que hagamos un push, por defecto sea
de master a origin. Es decir, a partir de este momento, todos los "git push"
que haga seran automáticamente de la rama "master" al repositorio "origin"

22) una vez subido al repo remoto podemos empezar a trabajar con otros 
compañeros (o incluso con nostros en diferentes ordenadores).
Lo primero que hay que hacer es una clonacion del repositorio
comando -> git clone NOMBRE_REPOSITORIO
EJ: git clone https://github.com/fdepablo/WsEntornosDesarrolloTelefonica.git

23) Si queremos descarganos la ultima version (commits) del repositorio
podemos ejecutar el comando -> git pull.

24) Nadie podra trabajar con vuestro ws (es decir, hacer commits, pero si
clones o pulls) a no ser que le demos permiso. Para ello hay que ir 
a la parte de settings del workspace y add el usuario en "manage access".

25) Una de las mejores maneras de trabajar en un entorno colaborativo podría
ser que cada integrante trabaje sobre una rama propia, e ir fusionando sus
cambios con la rama master. Podriamos hacer los siguientes pasos:
	1) Cada integrante del equipo se crea un rama propia local
	Ej: git checkout -b felix_desarrollo
	2) El integrante hace el desarrollo previsto con su rama
	Ej: Hace los cambios y luego hace los commits que hagan falta
	git add .
	git commit -m "descripcion del cambio"
	3) Una vez que haya acabado de hacer el desarrolo y los commits con suç
	rama, nos cambiamos a la rama master, y ahi nos bajamos los posibles
	cambios que hayan hecho los demas integrantes del equipo.
	Ej: git checkout master
	git pull 
	4) Fusionamos la rama master con nuestra rama particular para hacer
	un merge de los cambios
	Ej: git merge felix_desarrollo
	5) Fusinar los cambios de la rama master con la rama nuestra de 
	desarrollo, para poder continuar luego con nuestros desarrollos
	Ej: git checkout felix_desarrollo
	git merge master
	6) Cambiar al master y subir los cambios al repositorio remoto
	Ej: git checkout master
	git push origin master
	7) Optativo, podriamos subir nuestra rama a origin para que la viesen
	otros integrantes del equipo. 
	Ej: git push origin felix_desarrollo

26) Otra manera de trabar colaborativamente, es hacer un "fork" desde 
github a otro repositorio remoto para hacernos una copia exacta del 
repositorio al que estamos haciendo "fork", a partir de aqui nosotros
podremos desarrollar en nuestro repositorio los cambios que queramos.
En un momento dado podriamos solicitar un "pull request" al reposotorio
original con los cambios que estimemos oportunos. El dueño del repositorio
remoto orignal tendrá la ultima palabra sobre si acepta o no acepta el
"pull request" que le estamos solicitando.
















