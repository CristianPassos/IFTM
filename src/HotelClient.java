import java.rmi.Naming;

public class HotelClient {
    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                System.out.println("HOTEL ROOM RESERVATION SYSTEM");
                System.out.println("*********************************");
                System.out.println("Quartos disponíveis:");
            } else if (args.length == 1 && args[0].equals("list")) {
                RoomManager access = (RoomManager) Naming.lookup("rmi://localhost:2335/room");
                System.out.println(access.list());
            } else if (args.length == 1 && args[0].equals("Visitante")) {
                RoomManager access = (RoomManager) Naming.lookup("rmi://localhost:2335/room");
                System.out.println(access.guests());
            } else if (args.length == 3 && args[0].equals("book")) {
                if (Integer.parseInt(args[1]) < 0 || Integer.parseInt(args[1]) > 4) {
                    System.out.println("Tipo invalido!!");
                } else {
                    RoomManager access = (RoomManager) Naming.lookup("rmi://localhost:2335/room");
                    System.out.println(access.reserve(Integer.parseInt(args[1]), args[2]));
                }
            } else {
                System.out.println("Erro Tente Novamente!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
