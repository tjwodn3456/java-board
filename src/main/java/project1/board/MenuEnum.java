package project1.board;

public enum MenuEnum {

    ADD (new Add()),
    LIST(new List()),
    DETAIL(new Detail()),
    UPDATE(new Update()),
    DELETE(new Delete()),
    EXIT(new Exit());

    private Board board;

    MenuEnum (Board board){
        this.board = board;
    }

    public void execute(Print pr, Logic lg){
        this.board.execute(pr, lg);
    }

    public static MenuEnum fromString(String input) {
        for (MenuEnum menuEnum : values()) {
            if (menuEnum.name().equalsIgnoreCase(input)) {
                return menuEnum;
            }
        }
        return null;
    }

}
