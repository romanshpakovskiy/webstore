package by.wb.webstore.service;

import by.wb.webstore.service.impl.CategoryService;
import by.wb.webstore.service.impl.CategoryServiceImpl;

public enum ServiceFactory {
    INSTANCE;

    private final CategoryService categoryService = new CategoryServiceImpl();

    public CategoryService getCategoryService() {
        return categoryService;
    }
}
