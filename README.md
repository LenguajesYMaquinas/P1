# P1

## Anotaciones

- En un programa válido, la declaración de procedimientos y variables es opcional, pero la palabra reservada "ROBOT_R" y solo un bloque de instrucciones es obligatorio.

- Un bloque de instrucciones debe tener por lo menos una instrucción.

- Los procedimientos deben tener una instrucción o más.

- Hay dos comandos de "move": move:n y move(n). Como el parser presenta dificultad con comandos con tokens comunes, se dejó move:n y eliminó move(n).

- Hay dos comandos de "put": put:n,X y put(X,n). Como el parser presenta dificultad con comandos con tokens comunes, se dejó put:n,X y eliminó put(X,n).

- Hay dos comandos de "pick": pick:n,X y pick(X,n). Como el parser presenta dificultad con comandos con tokens comunes, se dejó pick:n,X y eliminó pick(X,n).

- Los comandos "go" y "goto" ejecutan la misma función por lo que se dejó solo uno de ellos, "goto".

- El comando "goto" recibe dos parametros donde el primero es la columna y el segundo es la fila.

- Las direcciones de tipo izquierda o derecha dependen de la posición en que se encuentre el robot, al contrario de las cardinales, que son estandares independientemente de la posición del robot, es decir, si el robot está mirando a la derecha por ejemplo y se le indica moverse hacia el sur, se movera hacia abajo y no hacia la izquierda del tablero.

## Alcance

- Aunque en las llamadas de los procedimientos se verifica que se haya declarado antes y los argumentos que reciben, no se ejecutan las instrucciones que hay en el procedimiento cuando este se llama.

- Las estructuras de control Loop y RepeatTimes no se interpretan.