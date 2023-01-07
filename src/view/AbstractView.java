package view;

import java.util.List;

import item.AbstractItem;

abstract class AbstractView {
    private List<AbstractView> adjacent;
    private List<AbstractItem> items;
    public abstract String getDecription();
}