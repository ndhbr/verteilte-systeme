package verteilte_systeme.uebung_02;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

import javax.swing.JProgressBar;

public class Download implements Runnable {

    private final JProgressBar balken;
    private final CountDownLatch start;
    private final CountDownLatch stop;

    public Download(JProgressBar balken, CountDownLatch start, CountDownLatch stop) {
        this.balken = balken;
        this.start = start;
        this.stop = stop;
    }

    @Override
    public void run() {
        Random random = new Random();
        int sleepTime = random.nextInt(250);

        try {
            start.await();
        } catch (InterruptedException e) {
        }

        int currentValue = balken.getValue();
        int maxValue = balken.getMaximum();

        while (currentValue < maxValue) {
            currentValue++;
            balken.setValue(currentValue);

            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {}
        }

        stop.countDown();
    }

}
