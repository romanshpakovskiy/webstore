package by.wb.webstore.service;

public class Validator {
    private static final String EMAIL_PATTERN = "[[a-z0-9]+@(?!-)[A-Za-z0-9-]{1,63}!-)\\\\.)]+[A-Za-z]{2,6}$";
    private static final String PASSWORD_PATTERN = "([A-Za-z]+[0-9]+){8,16}$";

    public boolean checkEmailValidation(String email) {
        return email.matches(EMAIL_PATTERN);
    }

    public boolean checkPasswordValidation(String password) {
        return password.matches(PASSWORD_PATTERN);
    }

    public boolean checkCategoryValidation(String categoryId) {
        return categoryId.isEmpty() & Integer.parseInt(categoryId) > 0;
    }

    public boolean checkProductValidation(String productId) {
        return productId.isEmpty() & Integer.parseInt(productId) > 0;
    }
}
