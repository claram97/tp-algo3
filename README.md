# El verdadero TO-DO:
Francisquito querido, por favor, mirá la nueva implementación del tp y seguí los siguientes pasos:
* Probá las clases MejoraExplosivos y MejoraDinamita **Implemente 2 tests dinamita, habria que acomodar los casos bordes, justamente cuando explota en el borde**
* Mirá MejoraTanqueExtra y MejoraTanqueExtraTest :P dejé algo para terminar ahí jeje **Para mi deberia desaparecer y ya, one use only :P**
* Chusmea qué cosas hay que probar aun y armá una listita acá para que podamos armar los test que hagan falta
* Usé Strategy (al principio sin darme cuenta, después me dí cuenta de que era eso básicamente JAJA) para el PisoSuperior y para el Suelo, para que podamos directamente pasarles distintos Suelos y distintos PisosSuperiores sin tener que tocar las clases Suelo y PisoSuperior :P iguaaaal se viola el Principio ese de las Dependencias Explícitas pero bueno es lo que hay, habría que preguntarle a Maraggi qué piensa sino :P la idea es que hay dos Suelos: Suelo1 y Suelo2, el Suelo2 es igual al Suelo1 en este momento pero estaría bueno que hagas más Suelos y entonces podríamos tener algunos Suelos pre-diseñados y después podríamos armar un rand que decida qué Suelo generar :P.
* Hice todas las pruebas que se me ocurrieron, pero estaría buenísimo que agarres todas las clases y las vayas mirando y veas qué más se puede testear :P
* Hay que re-leer todo el código y ver qué dejamos comentado para terminarlo
* Hay que jugar bien bien el juego y ver si falla algo más :P

TE RECOMIENDO QUE ESTA LISTA LA TENGAS A MANO Y VAYAS PASANDO ACÁ ABAJO LO QUE YA HAYAS HECHO YA QUE TODAS ESTAS TAREAS TE CORRESPONDEN A VOS PORQUE YO VOY A HACER LO DE LAS EXCEPCIONES!! :DD

* EstacionDeVenta no anda por un tema de strings y no se que, por ahora lo cambie a char y listo, no es algo que sea definitivo encima.
* Explosivos ahora es dinamita pero + 1 de diametro.
* Para la posicionVieja de la prueba de MejoraTeleport le asigne una new Posicion(). No se porque funciona asi pero no es la primera vez que me sucede, las variables se tratan como punteros o algo asi, ni idea.
* MejorasInstantaneas tienen bastante poco para probar

# FINISHED
