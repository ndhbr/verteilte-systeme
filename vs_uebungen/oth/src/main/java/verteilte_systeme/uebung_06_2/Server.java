package verteilte_systeme.uebung_06_2;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import verteilte_systeme.uebung_06_2.interfaces.IRoentgenbild;
import verteilte_systeme.uebung_06_2.interfaces.IBericht;
import verteilte_systeme.uebung_06_2.interfaces.IFrueherkennung;

public class Server implements IFrueherkennung {
    public Server(String[] args, String host, int port) {
        try {
            IFrueherkennung stub = (IFrueherkennung)UnicastRemoteObject.exportObject(this, 0);
            Registry registry = LocateRegistry.createRegistry(port);
            registry.bind("Servus", stub);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public IBericht analysieren(IRoentgenbild roentgenbild) throws RemoteException {
        Bericht bericht = new Bericht(roentgenbild.getDate(), "Gesund", "Nichts");
        IBericht berichtStub = (IBericht) UnicastRemoteObject.exportObject(bericht, 0);

        return berichtStub;
    }
}
