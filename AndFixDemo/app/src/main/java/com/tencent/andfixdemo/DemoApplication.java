package com.tencent.andfixdemo;

import android.app.Application;
import android.os.Environment;

import com.alipay.euler.andfix.patch.PatchManager;

import java.io.File;

/**
 * author：pudgeli on 16/7/6
 * email：pudgeli@tencent.com
 */
public class DemoApplication extends Application {
    /**
     * Called when the application is starting, before any activity, service,
     * or receiver objects (excluding content providers) have been created.
     * Implementations should be as quick as possible (for example using
     * lazy initialization of state) since the time spent in this function
     * directly impacts the performance of starting the first activity,
     * service, or receiver in a process.
     * If you override this method, be sure to call super.onCreate().
     */
    @Override
    public void onCreate() {
        super.onCreate();

        PatchManager patchManager = new PatchManager(this);
        patchManager.init("1.0");

        patchManager.loadPatch();

        try {
            String patchDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + File.separator + "out.apatch";
            patchManager.addPatch(patchDir);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
