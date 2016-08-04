package com.developerphil.adbidea.adb.command;

import com.android.ddmlib.IDevice;
import com.developerphil.adbidea.adb.command.receiver.GenericReceiver;
import com.intellij.openapi.project.Project;
import org.jetbrains.android.facet.AndroidFacet;

import java.util.concurrent.TimeUnit;

import static com.developerphil.adbidea.adb.AdbUtil.isAppInstalled;
import static com.developerphil.adbidea.ui.NotificationHelper.error;
import static com.developerphil.adbidea.ui.NotificationHelper.info;

/**
 * Created by konradrodzik on 11/28/14.
 */
public class ListSharedPreferencesCommand implements Command {

    @Override
    public boolean run(Project project, IDevice device, AndroidFacet facet, String packageName) {
        try {
            if (isAppInstalled(device, packageName)) {

                device.executeShellCommand("run-as " + packageName + " cat shared_prefs/" + packageName + "_preferences.xml", new GenericReceiver(), 5L, TimeUnit.MINUTES);
                info(String.format("<b>%s</b> list shared preferences for app on %s", packageName, device.getName()));
                return true;
            } else {
                error(String.format("<b>%s</b> is not installed on %s", packageName, device.getName()));
            }
        } catch (Exception e1) {
            error("Listing Shared Preferences failed... " + e1.getMessage());
        }

        return false;
    }

}
