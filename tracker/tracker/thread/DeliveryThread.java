package tracker.thread;

import tracker.model.Package;

public class DeliveryThread extends Thread {

    private Package pkg;

    public DeliveryThread(Package pkg) {
        this.pkg = pkg;
    }

    @Override
    public void run() {
        try {
            if (pkg.getDeliveryType().equalsIgnoreCase("Express")) {
                Thread.sleep(400);
            } else {
                Thread.sleep(800);
            }

            pkg.moveToNextStatus();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}