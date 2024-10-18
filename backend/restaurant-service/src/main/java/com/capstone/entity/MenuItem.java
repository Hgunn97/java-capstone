package com.capstone.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MenuItem {
    @Id
    private int menuItemId;
    private String menuItemName;
    private String menuItemDescription;
    private String menuItemPrice;
    private String menuItemCategory;

    public int getMenuItemId() {
        return menuItemId;
    }
    public void setMenuItemId(int menuItemId) {
        this.menuItemId = menuItemId;
    }
    public String getMenuItemName() {
        return menuItemName;
    }
    public void setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
    }
    public String getMenuItemDescription() {
        return menuItemDescription;
    }
    public void setMenuItemDescription(String menuItemDescription) {
        this.menuItemDescription = menuItemDescription;
    }
    public String getMenuItemPrice() {
        return menuItemPrice;
    }
    public void setMenuItemPrice(String menuItemPrice) {
        this.menuItemPrice = menuItemPrice;
    }
    public String getMenuItemCategory() {
        return menuItemCategory;
    }
}
