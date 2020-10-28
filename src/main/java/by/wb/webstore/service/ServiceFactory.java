package by.wb.webstore.service;

import by.wb.webstore.service.impl.CategoryServiceImpl;
import by.wb.webstore.service.impl.UserServiceImpl;

public enum ServiceFactory {
    INSTANCE;

    private final CategoryService categoryService = new CategoryServiceImpl();
    private final UserService userService = new UserServiceImpl();

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public UserService getUserService() {
        return userService;
    }
}
