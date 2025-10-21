package project1.board;

public enum PublicMenuEnum {


    LIST(new BoardList()),
    AUTHORLIST(new AuthorList()),
    DETAIL(new Detail()),
    EXIT(new Exit());

    private PublicMenuAction board;

    PublicMenuEnum(PublicMenuAction board){
        this.board = board;
    }

    public void execute(Print pr, Logic lg, InputReader inputReader){
        this.board.execute(pr, lg, inputReader);
    }

    public static PublicMenuEnum fromString(String input) {
        for (PublicMenuEnum publicMenuEnum : values()) {
            if (publicMenuEnum.name().equalsIgnoreCase(input)) {
                return publicMenuEnum;
            }
        }
        return null;
    }

}
