package com.nadrial.rollthedice.Entities;

public class Category {

    public static String categoryName, categoryJson;
    public static int categoryMainColor, categoryIcon,categoryBarColor1,categoryBarColor2, category = -2;

    public static int getCategoryBarColor1() {
        return categoryBarColor1;
    }
    public static void setCategoryBarColor1(int newBarColor1) {
        categoryBarColor1 = newBarColor1;
    }
    public static int getCategoryBarColor2() {
        return categoryBarColor2;
    }
    public static void setCategoryBarColor2(int newCategoryBarColor2) {
        categoryBarColor2 = newCategoryBarColor2;
    }
    public static String getCategoryName() {
        return categoryName;
    }
    public static void setCategoryName(String newCategoryName) {
        categoryName = newCategoryName;
    }
    public static String getCategoryJSON() {
        return categoryJson;
    }
    public static void setCategoryJSON(String newCategoryJson) {
        categoryJson = newCategoryJson;
    }
    public static int getCategoryIcon() {
        return categoryIcon;
    }
    public static void setCategoryIcon(int newCategoryIcon) {
        categoryIcon = newCategoryIcon;
    }
    public static int getCategoryMainColor() {
        return categoryMainColor;
    }
    public static void setCategoryMainColor(int newCategoryMainColor) {
        categoryMainColor = newCategoryMainColor;
    }

    public static int getCategory() {
        return category;
    }
    public static void setCategory(int newCategory) {
        category = newCategory;
    }

}
