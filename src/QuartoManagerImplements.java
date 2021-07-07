import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class QuartoManagerImplements extends UnicastRemoteObject implements RoomManager {

    private List<Quarto> QuartoList = new ArrayList<>();
    private List<String> guests = new ArrayList<>();

    QuartoManagerImplements() throws RemoteException {
        super();
        QuartoList.add(new Quarto(10, 0, "quartos individuais", 55));
        QuartoList.add(new Quarto(20, 1, "quartos duplos", 75));
        QuartoList.add(new Quarto(5, 2, "quartos duplos", 80));
        QuartoList.add(new Quarto(3, 3, "quartos triplos", 150));
    }

    public String list() throws RemoteException {
        StringBuilder list = new StringBuilder();
        for (Quarto quarto : QuartoList) list.append(quarto.toString()).append("\n");
        return list.toString();
    }

    public String guests() throws RemoteException {
        StringBuilder list = new StringBuilder();
        for (String guest : guests) list.append(guest).append("\n");
        return list.toString();
    }

    public String reserve(int tidoDoQuarto, String nameGuests) throws RemoteException {
        return QuartoList.stream().parallel().filter(Quarto -> Quarto.getTipo().equals(tidoDoQuarto)).findAny().
                map(Quarto -> {
                    if (Quarto.getQuantDisp() == 0) {
                        return "Quartos indisponíveis do Tipo " + tidoDoQuarto;
                    } else {
                        Quarto.setQuantDisp(Quarto.getQuantDisp()-1);
                        guests.add(nameGuests);
                        return "Quarto do tipo: " + tidoDoQuarto + ", reservado para o Sr.: " + nameGuests;
                    }
                }).orElse("Reserva não criada!!");
    }
}
