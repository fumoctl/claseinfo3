package clase.upa

def reader = new BufferedReader(new InputStreamReader(System.in))

println "Ingrese la temperatura en grados Celsius: "
double celsius = reader.readLine().toDouble()

double fahrenheit = celsius * 1.8 + 32
println "Temperatura en Fahrenheit: ${fahrenheit}"
