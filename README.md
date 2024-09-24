# Curios API Refactor 1.19.x

Este mod es el Curios Api pero refactorizado para solucionar problemas de compatibilidad con el plugin SkinsRestorer el cual sobre escribe los datos del jugador y el curios Api ya no le funciona el menú de Artifacts

### Cambios
- Se Agrego el comando `/curiosfix` para solucionar el problema de forma manual si se presenta el problema con el SkinsRestorer.
- Ahora el evento que se ejecuta cuando entra un nuevo usuario, tira de la api que usa el comando `/curiosfix` para de forma automática solventar el problema con SkinsRestorer.

### Como funciona?
- Se hace uso del método que es ejecutado cuando se cambia de dimencion en minecraft, en este caso se creo un objeto que se encargara de hacer eso de forma mas controlada.
- Una vez un usuario ingresa al mundo o servidor, el evento `PlayerLoggedInEvent` se dispara y 5 segundos despues ejecuta el objeto `InventoryCurios` el cual restaura el inventario de Artifacts, asegurándose a si, de sobre escribir los cambios del SkinsRestorer sobre un jugador y así dar solución al problema entre Curios API y el plugin SkinsRestorer.