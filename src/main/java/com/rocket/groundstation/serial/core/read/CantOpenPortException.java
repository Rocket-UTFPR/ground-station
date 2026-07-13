package com.rocket.groundstation.serial.core.read;


public class CantOpenPortException extends Exception {

    /**
     * Creates a new instance of <code>CantOpenPortException</code> without
     * detail message.
     */
    public CantOpenPortException() {
    }

    /**
     * Constructs an instance of <code>CantOpenPortException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CantOpenPortException(String msg) {
        super(msg);
    }
}
