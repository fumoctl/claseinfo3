package clase.upa;

public class test {
    public static void main(String[] args) {
        String s = "llego y dijo hola, hola a todos, hola";
        int i, apariciones = 0;
        while ((i = s.indexOf("o")) != -1) {
            ++apariciones;
            s = s.substring(i + 1);
        }        
        System.out.println("La letra 'o' aparece " + apariciones + " veces");
    }
}
