package io.openmessaging;

/**
 * Created by huzhebin on 2019/07/28.
 */
public class MessagePool {
    Message[] messages = new Message[500000];

    volatile int index = 0;

    MessagePool() {
        for (int i = 0; i < 500000; i++) {
            messages[i] = new Message(0, 0, new byte[34]);
        }
    }

    public synchronized Message get() {
        index = (index + 1) % 500000;
        return messages[index];
    }
}
