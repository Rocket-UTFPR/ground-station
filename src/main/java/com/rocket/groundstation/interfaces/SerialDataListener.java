package com.rocket.groundstation.interfaces;

import com.rocket.groundstation.model.SerialData;


public interface SerialDataListener {
    public void onData(SerialData oldData, SerialData newdata);
}
