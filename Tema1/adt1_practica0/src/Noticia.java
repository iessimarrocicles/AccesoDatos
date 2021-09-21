public class Noticia {
    private int fecha;
    private int hora;
    private String texto;
    private int lecturas;
    
    public Noticia(int f, int h, String t){
        fecha=f;
        hora=h;
        texto= new String(t);
        lecturas = 0;       
    }
    
    public int getFecha(){
        return fecha;
    }
    
    public int getLecturas(){
        return lecturas;
    }
    
    public void incLecturas(){
        lecturas++;
    }
    
    public boolean igualFecha(int d, int m, int a){
        
        int data = a*10000 + m*100 + d;
        
        if(data == fecha)
            return true;
        else                
            return false;
    }
    
    public String toString(){
        
        String s= "";
        
        s+=fecha%100 + "/" + (fecha/100)%100 + "/" + (fecha/10000) + " - ";
        s+=(hora/100) + ":" + (hora%100) + "\n";
        s+=texto + "\n";
        s+="Leída " + lecturas + " veces.\n";
        
        return s;
    }
}
