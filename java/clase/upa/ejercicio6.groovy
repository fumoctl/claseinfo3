package clase.upa

import java.util.Random

def reader = new BufferedReader(new InputStreamReader(System.in))
def random = new SecureRandom()
def numeros = []

for (int i = 0; i < 10; i++) {
    numeros << (random.nextInt(100) + 1)
}

println "Lista generada: ${numeros}"
println "Ingrese un numero para buscar en la lista: "
int buscado = reader.readLine().toInteger()

if (numeros.contains(buscado)) {
    println "El numero SI se encuentra en la lista."
} else {
    println "El numero NO se encuentra en la lista."
}
