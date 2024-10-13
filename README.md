# Mutant Detector API

Esta API permite detectar secuencias de ADN mutante a través de una serie de secuencias de ADN ingresadas. Utiliza la lógica de búsqueda de patrones en secuencias de ADN para determinar si el ADN pertenece a un mutante.

## Endpoints

### 1. Detectar Mutante

- **URL**: `https://parcial-castillo-1-mutantes.onrender.com/mutant`
- **Método**: `POST`
- **Descripción**: Este endpoint recibe una matriz de secuencias de ADN y determina si el ADN es mutante.

#### **Ejemplo de Solicitud POST**

- **Cuerpo**:
```json
{
    "dna": [
        "ATGCGA",
        "CAGTGC",
        "TTATGT",
        "AGAAGG",
        "CCCCTA",
        "TCACTG"
    ]
}
```

#### Respuesta exitosa (Mutante)
- Codigo: 200 OK
- Cuerpo:
```markdown
Mutante
```
#### Respuesta fallida (No mutante)
- Codigo: 403 Forbidden
- Cuerpo:
```markdown
No mutante
```

#### Respuesta de error de validacion (Ejemplo)
- Codigo: 400 bad request
- Cuerpo:
```markdown
{
    "dna": "La matriz de ADN no puede estar vacía."
}

```

### 2. Obtener Estadísticas 

- **URL**: `https://parcial-castillo-1-mutantes.onrender.com/stats`
- **Método**: `GET`
- **Descripción**: Este endpoint devuelve estadísticas sobre las secuencias de ADN procesadas.

#### **Ejemplo de Solicitud GET**
**URL**: 
`https://parcial-castillo-1-mutantes.onrender.com/stats`


