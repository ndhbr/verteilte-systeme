package verteilte_systeme.uebung_05;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import verteilte_systeme.uebung_05.interfaces.IFrueherkennung;

public class Client {
    public Client(String[] args, String host, int port) {
        try {
            Registry registry = LocateRegistry.getRegistry(host, port);
            IFrueherkennung frueherkennung = (IFrueherkennung) registry.lookup("Servus");
            String antwort = frueherkennung.hallo("Andi");

            System.out.println(antwort);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
