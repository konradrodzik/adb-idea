package com.developerphil.adbidea.action;

import com.developerphil.adbidea.adb.AdbFacade;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.Project;

/**
 * Created by konradrodzik on 11/28/14.
 */
public class SharedPreferencesAction extends AdbAction {

    public void actionPerformed(AnActionEvent e, Project project) {
        AdbFacade.listShowPreferences(project);
    }
}
