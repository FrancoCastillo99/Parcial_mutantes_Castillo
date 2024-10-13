# Mutant Detector API

Esta API permite detectar secuencias de ADN mutante a través de una serie de secuencias de ADN ingresadas. Utiliza la lógica de búsqueda de patrones en secuencias de ADN para determinar si el ADN pertenece a un mutante.

## Endpoints

### 1. Detectar Mutante

- **URL**: `https://parcial-castillo-1-mutantes.onrender.com/mutant`
- **Método**: `POST`
- **Descripción**: Este endpoint recibe una matriz de secuencias de ADN y determina si el ADN es mutante.

#### **Ejemplo de Solicitud POST**

**Headers**:
**Cuerpo de la Solicitud**:
json
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
