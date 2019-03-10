package com.rohitss.dynamicrecycler;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * <b></b>
 * <p>This class is used to </p>
 * Created by Rohit.
 */
class DummyParentDataItem implements Serializable {
    private String parentName;
    private ArrayList<DummyChildDataItem> childDataItems;

    public DummyParentDataItem(String parentName, ArrayList<DummyChildDataItem> childDataItems) {
        this.parentName = parentName;
        this.childDataItems = childDataItems;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public ArrayList<DummyChildDataItem> getChildDataItems() {
        return childDataItems;
    }

    public void setChildDataItems(ArrayList<DummyChildDataItem> childDataItems) {
        this.childDataItems = childDataItems;
    }
}
