package hexlet.code.schemas;

public class StringSchema {
    private boolean isRequired = false;
    private int minLength = 0;
    private String containsSubstring = null;

    public StringSchema required() {
        this.isRequired = true;
        return this;
    }

    public StringSchema minLength(int length) {
        if (length < 0) {
            throw new IllegalArgumentException("Minimum length cannot be negative");
        }
        this.minLength = length;
        return this;
    }

    public StringSchema contains(String substring) {
        if (substring == null || substring.isEmpty()) {
            throw new IllegalArgumentException("Substring cannot be null or empty");
        }
        this.containsSubstring = substring;
        return this;
    }

    public boolean isValid(String value) {
        // Проверяем, является ли значение null или пустой строкой
        if (isRequired && (value == null || value.isEmpty())) {
            return false;
        }

        // Если значение необязательно и равно null или пустой строке, считаем его валидным
        if (!isRequired && (value == null || value.isEmpty())) {
            return true;
        }

        // Проверяем минимальную длину
        if (minLength > 0 && value.length() < minLength) {
            return false;
        }

        // Проверяем, содержит ли строка указанную подстроку
        if (containsSubstring != null && !value.contains(containsSubstring)) {
            return false;
        }

        return true;
    }
}
