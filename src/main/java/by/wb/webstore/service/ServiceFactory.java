package by.wb.webstore.service.impl;

public enum ServiceFactory {
    INSTANCE;

    private final CategoryService categoryService = new CategoryServiceImpl();

    public CategoryService getCategoryService() {
        return categoryService;
    }
}
