package clase3.upa

def reader = new BufferedReader(new InputStreamReader(System.in))

println "Ingrese una frase: "
String frase = reader.readLine()

int totalVocales = 0
for (int i = 0; i < frase.length(); i++) {
    char c = Character.toLowerCase(frase.charAt(i))
    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
        totalVocales++
    }
}

println "Total de vocales: ${totalVocales}"
