package project1.board;

public enum AuthenticatedMenuEnum {
    ADD(new Add()),
    DELETE(new Delete()),
    UPDATE(new Update())
    ;

    private AuthenticatedAction board;

    AuthenticatedMenuEnum(AuthenticatedAction board){
        this.board = board;
    }

    public void execute(Print pr, Logic lg, User user, InputReader inputReader){
        this.board.execute(pr, lg, user, inputReader);
    }

    public static AuthenticatedMenuEnum fromString(String input) {
        for (AuthenticatedMenuEnum authenticatedMenuEnum : values()) {
            if (authenticatedMenuEnum.name().equalsIgnoreCase(input)) {
                return authenticatedMenuEnum;
            }
        }
        return null;
    }




}
