package com.zhuwd.rxjava.base;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.zhuwd.rxjava.commonutils.LogUtils;


public class BaseService extends Service {
    private ServiceHolder mHolder;

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtils.logd(this.getClass().getSimpleName()+"服务正在开启");
        mHolder = new ServiceHolder(this);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mHolder;
    }

    public class ServiceHolder extends Binder {
        private Service mService;

        public ServiceHolder(Service service) {
            mService = service;
        }

        public Service getService() {
            return mService;
        }
    }
}
