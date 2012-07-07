package com.clintwn.glpimanager.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class GLPIService extends Service {
    public GLPIService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
