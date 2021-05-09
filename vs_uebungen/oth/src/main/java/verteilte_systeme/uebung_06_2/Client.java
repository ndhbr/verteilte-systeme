package verteilte_systeme.uebung_06_2;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import verteilte_systeme.uebung_06_2.interfaces.IRoentgenbild;
import verteilte_systeme.uebung_06_2.interfaces.IBericht;
import verteilte_systeme.uebung_06_2.interfaces.IFrueherkennung;

public class Client {
    public Client(String[] args, String host, int port) {
        try {
            Registry registry = LocateRegistry.getRegistry(host, port);
            IFrueherkennung serverStub = (IFrueherkennung) registry.lookup("Servus");

            Roentgenbild roentgenbild = new Roentgenbild(new Date(), "Franz", null);
            IRoentgenbild roentgenbildStub = (IRoentgenbild) UnicastRemoteObject.exportObject(roentgenbild, 0);

            IBericht bericht = serverStub.analysieren(roentgenbildStub);

            System.out.println("Referenzbericht erhalten mit weiterem Vorgehen: " + bericht.getWeiteresVorgehen());
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
