package com.rocket.groundstation.serial.core.dispatch;


public interface DataDispatcher<T> {
    public void dispatch(T data);
}
