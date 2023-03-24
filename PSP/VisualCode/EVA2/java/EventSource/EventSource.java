package EVA2.java.EventSource;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

class EventSource {
    public interface Observer {
        void update(String event);
    }
  
    private final List<Observer> observers = new ArrayList<>();
  
    private void notifyObservers(String event) {
        
        //Bucle conocido
        for(int i=0;i<observers.size();i++){
            observers.get(i).update(event);
        }

        //Mas legible
        //observers.forEach(observer -> observer.update(event));

    }
  
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
  
    public void scanSystemIn() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            notifyObservers(line);
        }
    }
}