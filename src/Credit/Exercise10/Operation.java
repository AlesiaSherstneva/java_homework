package Credit.Exercise10;

public enum Operation {
    ADD_ELEMENT("добавление элемента"),
    REMOVE_ELEMENT("удаление элемента"),
    SEARCH_ELEMENT("поиск элемента");

    private final String displayName;

    Operation(String operation) {
        this.displayName = operation;
    }

    public String getDisplayName() {
        return displayName;
    }

}
