## Método a ser testado:

```java
    public boolean findElement(List list, Object element)
```

--- 
 > Legenda: `<classes de equivalencia> -> <caso de teste>`

### Interface:
- element é null e list não -> `[1,43,23], null`
- list é null e element não -> `null, 4; null, 2`
- list está vazia e element é null -> `[], null`
- list está vazia e element não é null -> `[], 2`
- list possui elementos e element é null -> `[1,2], null; [1], null`
- list possui elementos e element não é null -> `[1,2], 4; [1,2], 7`

### Funcionalidade:
- Elemento pertence à lista -> `[12,43,25], 43`
- Elemento não pertence à lista -> `[1,2], 2`
