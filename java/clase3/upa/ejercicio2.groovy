package clase3.upa

def reader = new BufferedReader(new InputStreamReader(System.in))
def numeros = []
int suma = 0

for (int i = 1; i <= 5; i++) {
    println "Ingrese el numero entero ${i}: "
    int numero = reader.readLine().toInteger()
    numeros << numero
    suma += numero
}

println "La suma total es: ${suma}"
