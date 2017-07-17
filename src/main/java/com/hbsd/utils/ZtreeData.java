package com.hbsd.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Hanfei
 * @Date: 2017/7/17
 * @Company:http://www.hbsddz.com
 * @Project:deomtest
 * @Class:ZtreeData
 */
public class ZtreeData {

    private Integer id;

    private String name;

    private boolean open;

    private boolean checked;

    private String iconSkin;

    private List<ZtreeData> children = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getIconSkin() {
        return iconSkin;
    }

    public void setIconSkin(String iconSkin) {
        this.iconSkin = iconSkin;
    }

    public List<ZtreeData> getChildren() {
        return children;
    }

    public void setChildren(List<ZtreeData> children) {
        this.children = children;
    }
}
