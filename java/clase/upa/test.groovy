package clase.upa

def s = "llego y dijo hola, hola a todos, hola"
int apariciones = 0
int i

while ((i = s.indexOf("o")) != -1) {
    apariciones++
    s = s.substring(i + 1)
}

println "La letra 'o' aparece ${apariciones} veces"
