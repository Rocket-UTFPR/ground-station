package com.rocket.groundstation.serial.core.dispatch;


public interface DataDispatcher<T> {
    public void dispatch(T data);
    public void addDataListener(DataListener<T> dl);
    public void removeDataListener(DataListener<T> dl);
}
