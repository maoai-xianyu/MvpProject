package com.mao.cn.mvpproject.utils.tools;


import com.mao.cn.mvpproject.MvpApplication;

import java.io.File;

public class PathU {
    private static PathU instance = null;
    private File assetsFile;
    private File testVideoPath;
    private File files;
    private File blurPath;
    private static String filePath;
    private File resourcePath;

    public File getTestVideoPath() {
        return testVideoPath;
    }

    public void setTestVideoPath(File testVideoPath) {
        this.testVideoPath = testVideoPath;
    }


    public static String getFilePath() {
        return filePath;
    }

    public static void setFilePath(String filePath) {
        PathU.filePath = filePath;
    }


    public File getFiles() {
        return files;
    }

    public String getFilesPath() {
        return files.getPath();
    }

    public File getBlurPath() {
        return blurPath;
    }


    public File getResourceFile() {
        return resourcePath;
    }

    public String getResourcePath() {
        return resourcePath.getPath();
    }


    private PathU() {
    }

    public static PathU getInstance() {
        if (instance == null) {
            instance = new PathU();
        }
        return instance;
    }

    public void initDirs() {
        files = PathUtils.getInstance().generatePath("", "files", MvpApplication.context());
        blurPath = PathUtils.getInstance().generatePath("", "blur", MvpApplication.context());
        resourcePath = PathUtils.getInstance().generatePath("", "resource", MvpApplication.context());
        assetsFile = PathUtils.getInstance().generatePath("", "files/files", MvpApplication.context());
    }

    public File getAssetsFile() {
        return assetsFile;
    }

    public static String filePath() {
        if (StringU.isEmpty(filePath)) {
            filePath = PathU.getInstance().getAssetsFile().getPath();
        }
        return filePath;
    }

}
