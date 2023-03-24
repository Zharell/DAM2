package EVA2.java.EventSource;

public class ObserverDemo {
    public static void main(String[] args) {
        System.out.println("Enter Text : ");
        EventSource eventSource = new EventSource();

        
        Persona amparo = new Persona("Amparo");
        Persona joaquin = new Persona("Joaquin");

        eventSource.addObserver(amparo);
        eventSource.addObserver(joaquin);
        
        //Nuevo evento anonimo
        eventSource.addObserver(new EventSource.Observer() {
            @Override
            public void update(String event){
                System.out.println("Cabron!!! en chino HANWDANG, HANWDANG");
            }
        });
        
        eventSource.addObserver(new EventSource.Observer(){
            public void update (String event) {
                System.out.println("Receive response: "+event);
            }
        });

        eventSource.scanSystemIn();
    }
}