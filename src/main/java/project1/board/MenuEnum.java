package project1.board;

public enum MenuEnum {

    ADD (new Add()),
    LIST(new BoardList()),
    DETAIL(new Detail()),
    UPDATE(new Update()),
    DELETE(new Delete()),
    EXIT(new Exit());

    private MenuAction board;

    MenuEnum (MenuAction board){
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
