import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class HotelServer {
    public static void main(String[] args) {
        try {
            RoomManager roomManager = new QuartoManagerImplements();
            LocateRegistry.createRegistry(1900);
            Naming.rebind("rmi://localhost:1900/HotelRoomReservation", roomManager);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
