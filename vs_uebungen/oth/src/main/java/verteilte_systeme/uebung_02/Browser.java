package verteilte_systeme.uebung_02;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class Browser extends JFrame implements ActionListener {

    private int downloads;
    private JProgressBar[] balken;
    private JButton startButton;

    // Concurrency
    CountDownLatch start = new CountDownLatch(1);
    CountDownLatch stop;

    // Deklaration Ihrer Synchronisations-Hilfsklassen hier:

    public Browser(int downloads) {
        super("Mein Download-Browser");
        this.downloads = downloads;

        // Initialisierung Ihrer Synchronisations-Hilfsklassen hier:
        stop = new CountDownLatch(this.downloads);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    stop.await();
                } catch (InterruptedException e) {}

                startButton.setText("FERTIG");
            }
        }).start();

        // Aufbau der GUI-Elemente:
        balken = new JProgressBar[downloads];
        JPanel zeilen = new JPanel(new GridLayout(downloads, 1));

        for (int i = 0; i < downloads; i++) {
            JPanel reihe = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 10));
            balken[i] = new JProgressBar(0, 100);
            balken[i].setPreferredSize(new Dimension(500, 20));
            reihe.add(balken[i]);
            zeilen.add(reihe);

            // neue Download-Threads erzeugen und starten
            // ggf. müssen Synchronisations-Objekte im Konstruktor übergeben werden!!
            // balken ist ebenfalls zu übergeben!
            new Thread(new Download(balken[i], start, stop)).start();
        }

        startButton = new JButton("Downloads starten");
        startButton.addActionListener(this);

        this.add(zeilen, BorderLayout.CENTER);
        this.add(startButton, BorderLayout.SOUTH);

        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Blockierte Threads jetzt laufen lassen:
        start.countDown();

        startButton.setEnabled(false);
        startButton.setSelected(false);
        startButton.setText("Downloads laufen...");

        // Auf Ende aller Download-Threads warten ... erst dann die Beschriftung ändern
        // Achtung, damit die Oberflaeche "reaktiv" bleibt dies in einem eigenen
        // Runnable ausfuehren!

    }

}
