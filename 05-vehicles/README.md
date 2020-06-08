
Aquest exercici el presento amb structura spring-boot però sense fer servir un controlador REST

He fet servir Vaadin per a fer la capa de presentació, no coneixia l'API i m'hi he complicat una mica la
vida :)

La vista principal és vehicles\src\main\java\itinerari\jordic\vehicles\view\MenuVehicles.java 

Aquí hi ha tota la part de presentació i que es podria fer en javascript, com que no he fet servir ni JPA ni SpringBoot en profunditat no hi ha les anotacions de tipus @Service, @Entity, etc ... 

El disseny no és el meu fort, precissament i per això faig la llista en una UnorderedList però lo seu seria treballar amb objectes de servidor fent servir el component Grid de Vaadin, no ho entés prou i no li he pogut dedicar el temps que m'hagués agradat. 

El controlador es troba en la classe vehicles\src\main\java\itinerari\jordic\vehicles\controller\VehicleController.java

conté una llista de Vehicle per a poder mostrar-la en pantalla i he creat una excepció per a mostrar els errors en pantalla (vehicles\src\main\java\itinerari\jordic\vehicles\exceptions\VehicleException.java)

El model l'he deixat pràcticament com el que s'ha proporcionat al repositori, afegint alguns mètodes per a verificar-los així com els getters i setters

