//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.mao.cn.mvpproject.utils.tools.utils;

import java.io.File;
import java.io.Serializable;

public class NotFileFilter extends AbstractFileFilter implements Serializable {
    private final IOFileFilter filter;

    public NotFileFilter(IOFileFilter filter) {
        if(filter == null) {
            throw new IllegalArgumentException("The filter must not be null");
        } else {
            this.filter = filter;
        }
    }

    public boolean accept(File file) {
        return !this.filter.accept(file);
    }

    public boolean accept(File file, String name) {
        return !this.filter.accept(file, name);
    }

    public String toString() {
        return super.toString() + "(" + this.filter.toString() + ")";
    }
}
