package com.rocket.groundstation.serial.interfaces;


public interface DataDispatcher<T> {
    public void dispatch(T data);
}
