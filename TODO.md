# Tareas
Las tareas son para cualquiera a menos que la tarea especifique quién debería realizarla.
Pasarlas a la sección de terminadas al finalizar para motivarnos.
Te amo pelotudo :P, Te amo boba <3

## Mejoras y cosas que hay que agregar

## Pendientes

* Pensar las pruebas (global, ambos)
* Implementar las tiendas y la estación de ventas (Clari)
* Interacción con las tiendas (Clari)
* Límite de inventario inicial: 7 (Clari) *Anduve tocando esto, :p. Igual hay que hacer mas cosas con el inventario*
* Jugador es larga comparado al resto, pero no se donde cortarla (Fran).
* Hay que pasar todo a constantes antes de que sea una paja
* La nafta vale $1 :P creo que puse 5, después lo actualizo (Clari)

### Clari:
* Hay que ver cuánta nafta gasta cuando se mueve :P creo que $1 x bloque *Esto igual esta sujeto a cambiar varias veces*
* Las reparaciones valen $10 x hp creo :P
* Opciones de nafta: 5, 10, 25, 50, full
* Opciones de reparación: 50, 100, 200, 500, total
* Ponerle al jugador un vector para las mejoras que se usan una vez, como el tanque extra, la dinamita, los explosivos y el teleport.

### Mejoras (Clari):
* Tanque extra para refill: sale 2000 y te llena 25L
* Mayor resistencia
* Mas cantidad de vida
* Mayor cantidad de nafta
* Dinamita: 2000, elimina un área a definir
* Explosivos: 5000, eliminan un área a definir (mayor a la de la dinamita)
* Teleport: 2000, te transporta a la superficie (en un lugar random)
* Hull repair nanobots: 7500 por 30 de vida anytime anywhere

## Terminadas
* Mejorar la implementación del terreno (Fran)
* Mejorar las partes que tienen muchos if (Clari)
* Implementar el movimiento (Fran)
* Cuando se compra con un valor predeterminado, solo se gasta la plata necesaria. (Clari, aunque todavía falta un toque juju)
* Jugador ya "cae", no puede subir cuando tiene un bloque por encima y agrega bloques a su inventario.
* Pase la interaccion jugador-terreno a una nueva clase, aparte de jugador.

# Cosas a mencionar:
* El manejo de la ubicacion del pj esta rarazo, pero con la implementacion actual era eso o dos loops que borren al pj anterior.
* Aire y Tierra son mas anémicas que no se. Habria que ver la manera de que no tengan que tener precio, Jugador tambien es un bloque.
* Esos getters y setters que puse en Jugador tambien estan medio feazos.
* Hacer terrenos pre-diseñados? Veremos veremos (NO ES IMPORTANTE NI URGENTE ES LO ÚLTIMO A CHUSMEAR)

# Dudas:
(Se ocupa Clari)

* Usar matriz[][] para la implementación
* La matriz es de bloques? Ta bien?
* Aplicación de Factory Method: nos quedan clases que no hacen una goma :P
* Revisar los tipos (jugador debería ser un bloque? O lo armamos de otra manera)
