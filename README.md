# P1

- En un programa válido, la declaración de procedimientos y variables es opcional, pero la palabra reservada "ROBOT_R" y solo un bloque de instrucciones es obligatorio.

- Un bloque de instrucciones debe tener por lo menos una instrucción
- Los procedimientos deben tener una instrucción o más.

- Hay dos comandos de "move": move:n y move(n). Como el parser presenta dificultad con comandos con tokens comunes, se dejó move:n y eliminó move(n).

- Hay dos comandos de "put": put:n,X y put(X,n). Como el parser presenta dificultad con comandos con tokens comunes, se dejó put:n,X y eliminó put(X,n).

- Hay dos comandos de "pick": pick:n,X y pick(X,n). Como el parser presenta dificultad con comandos con tokens comunes, se dejó pick:n,X y eliminó pick(X,n).

- El comando "Go" recibe dos parametros donde el primero es la columna y el segundo es la fila.