# Cosas a mencionar:

### Tema floats:
  En la prueba de la estacion de reparacion, para ver si el gasto es correcto, se pide una reparacion de $50. Cuando se hace el calculo de cuantos hps significan esto probablemente redondee a 3, pues 50/15 = 3,333...
  Cuando se hace la cuenta de cuanto es el gasto, 3 * 15 = $45. Se descuentan $45 del jugador, pero el test pide $50 y no se llegan a los hp maximos, por lo que deberian descontarse $50.

* Aire y Tierra son mas anemicas que no se. Habria que ver la manera de que no tengan que tener precio, Jugador tambien es un bloque.
* Hay un tema con los getters y setters de jugador y de posicion, parece que hay como 10, no se, se fueron apilando, habria que ver eso.
* Creo que el tema de mover la maquinola deberia ser mas generica, onda, en vez de hacer **-1**, quizas pedir por parametro la "cantidad de movimiento", para simplificar a futuro. Igual tampoco se me ocurre como va a terminar siendo asi queee.
* Tema tiendas, quizas implementarle una interfaz por consola?
* Hacer terrenos pre-diseñados? Veremos veremos (NO ES IMPORTANTE NI URGENTE ES LO ÚLTIMO A CHUSMEAR).
* Cuestion savegames, se puede implementar con xml?

# Dudas:

* Usar matriz[][] para la implementación.
* La matriz es de bloques? Ta bien?
* Aplicación de Factory Method: nos quedan clases que no hacen una goma :P
