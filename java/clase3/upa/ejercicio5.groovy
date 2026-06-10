package clase3.upa

import java.util.Random

def reader = new BufferedReader(new InputStreamReader(System.in))
def random = new Random()
String continuar

do {
    int numeroLoteria = random.nextInt(90) + 10

    println "Ingrese un numero de 2 digitos: "
    int numeroUsuario = reader.readLine().toInteger()

    if (numeroUsuario == numeroLoteria) {
        println "Ganaste! El numero era ${numeroLoteria}"
    } else {
        println "No ganaste. El numero era ${numeroLoteria}"
    }

    println "Desea jugar otra vez? (s/n): "
    continuar = reader.readLine().trim().toLowerCase()
} while (continuar == "s")
