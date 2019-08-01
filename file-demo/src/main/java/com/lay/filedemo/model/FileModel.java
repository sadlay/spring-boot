package com.lay.filedemo.model;

/***
 * @ClassName: FileModel
 * @Auther: zhaogengsheng
 * @Date: 2019/4/30 15:56
 * Copyright: 2018赛鼎科技-版权所有
 */
public class FileModel {

    private String name;
    private String path;
    private boolean isFile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isFile() {
        return isFile;
    }

    public void setFile(boolean file) {
        isFile = file;
    }
}
