package Lab07;

class Buffer {

    private int item;
    private boolean available = false;

    public synchronized void produce(int value)
            throws InterruptedException {

        while (available) {
            wait();
        }

        item = value;

        System.out.println("Produced: " + item);

        available = true;

        notify();
    }

    public synchronized void consume()
            throws InterruptedException {

        while (!available) {
            wait();
        }

        System.out.println("Consumed: " + item);

        available = false;

        notify();
    }
}

public class ProducerConsumer {

    public static void main(String[] args) {

        Buffer buffer = new Buffer();

        Thread producer = new Thread(() -> {

            try {

                for (int i = 1; i <= 5; i++) {

                    buffer.produce(i);

                    Thread.sleep(1000);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        Thread consumer = new Thread(() -> {

            try {

                for (int i = 1; i <= 5; i++) {

                    buffer.consume();

                    Thread.sleep(1000);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        producer.start();
        consumer.start();
    }
}