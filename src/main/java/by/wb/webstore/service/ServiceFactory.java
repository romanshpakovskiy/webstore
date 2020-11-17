package by.wb.webstore.service;

import by.wb.webstore.service.impl.CategoryServiceImpl;
import by.wb.webstore.service.impl.ProductServiceImpl;
import by.wb.webstore.service.impl.UserServiceImpl;

public enum ServiceFactory {
    INSTANCE;

    private final CategoryService categoryService = new CategoryServiceImpl();
    private final UserService userService = new UserServiceImpl();
    private final ProductService productService = new ProductServiceImpl();

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public UserService getUserService() {
        return userService;
    }

    public ProductService getProductService() {
        return productService;
    }
}
