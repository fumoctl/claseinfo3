package clase.upa

def reader = new BufferedReader(new InputStreamReader(System.in))

println "Ingrese un numero entero: "
int numero = reader.readLine().toInteger()

boolean esPrimo(int numero) {
    if (numero <= 1) {
        return false
    }

    for (int i = 2; i * i <= numero; i++) {
        if (numero % i == 0) {
            return false
        }
    }

    return true
}

if (esPrimo(numero)) {
    println "${numero} es primo."
} else {
    println "${numero} no es primo."
}