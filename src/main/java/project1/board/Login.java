package project1.board;

public class Login {


    public User execute(Print pr, Logic lg, InputReader inputReader) {
        User newUser = loginHow(pr, lg, inputReader);
        if ( newUser == null){
            pr.askLoginId();
            String inputLoginId = inputReader.getValidStringInput();
            User user = lg.findUserByLoginId(inputLoginId);
            if (user != null) {
                pr.askPassword();
                String inputPassword = inputReader.getValidStringInput();
                if (lg.isCorrectPassword(user.getPassword(), inputPassword)) {
                    return user;
                } else {
                    pr.printIncorrectPassword();
                    return null;
                }
            } else {
                pr.printIncorrectId();
                return null;
            }
        } else{
            return newUser;
        }
    }
    private User loginHow(Print pr, Logic lg, InputReader inputReader){
        Integer input;
        while (true) {
            pr.askLoginHow();
            pr.askRegisterUser();
            input = inputReader.getValidIntegerInput();
            if (input != null) {
                break;
            }
        }
        if (input != 1) {
            pr.askLoginId();
            String loginId = inputReader.getValidStringInput();
            while (true) {
                pr.askPassword();
                String password1 = inputReader.getValidStringInput();
                pr.askRePassword();
                String password2 = inputReader.getValidStringInput();
                if (password1.equals(password2)) {
                    pr.askNickName();
                    String nickName = inputReader.getValidStringInput();
                    if (nickName.isEmpty()) {
                        nickName = null;
                    }
                    User user = lg.newUser(loginId, password2, nickName);
                    return user;
                } else {
                    pr.printIncorrectPassword();
                }
            }
        } else {
            return null;
        }
    }
}
