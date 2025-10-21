package project1.board;


public class Print {

    public void askLoginHow(){
        System.out.println("==============Login 할 방법을 선택하세요.================");
    }

    public void askRegisterUser(){
        System.out.print(" | 1. 기존 회원 | 2. 회원 가입 진행 | : ");
    }

    public void askLoginId() {
        System.out.print("Login ID 입력: ");
    }

    public void askPassword(){
        System.out.print("Password 입력: ");
    }
    public void askRePassword(){
        System.out.print("Password 재입력: ");
    }

    public void askNickName(){
        System.out.print("닉네임을 입력하세요: ");
    }

    public void printIncorrectPassword(){
        System.out.println("비밀번호가 일치하지 않습니다.");
    }

    public void printIncorrectId(){
        System.out.println("존재하지 않거나, 일치하지 않는 ID 입니다.");
    }

    public void printTodo (){
        System.out.print("명령어를 입력하세요 (add, list, authorList ,detail, update, delete, exit): ");
    }

    public void printNoPost(){
        System.out.println("등록된 게시글이 없습니다.");
        System.out.println();
    }

    public void printAskTitle(){
        System.out.print("제목을 입력하세요: ");
    }

    public void printAskContent(){
        System.out.print("내용을 입력하세요: ");
    }

    
    public void printSuccessRegist(){
        System.out.println("게시글이 성공적으로 등록되었습니다.");
        System.out.println();
    }

    public void printNotRegist(){
        System.out.println("게시글이 등록을 실패했습니다.");
        System.out.println();
    }


    // 디테일 리스트 전용 출력
    public void printPostSummary(Post post){
        System.out.println("====================================");
        System.out.print("번호: "+ post.getPostId()+", ");
        System.out.println("제목: " + post.getTitle());
        System.out.println("내용: "+ post.getContent());
        System.out.println("작성 일자: "+ post.getCreateAt());
        System.out.println("====================================");
    }

    // 작성자 리스트 전용 출력
    public void printPostSummary(PostListItemDto dto){
        System.out.println("====================================");
        System.out.print("번호: "+ dto.getPostId()+", ");
        System.out.println("제목: " + dto.getTitle());
        System.out.println("작성자 닉네임: "+ dto.getNickName());
        System.out.println("작성 일자: "+ dto.getCreatedAt());
        System.out.println("====================================");
    }

    
    // 조회 전용 출력, 제목
    public void printTitle(String title){
        System.out.println("제목: "+ title);
    }
    // 조회 전용 출력, 내용
    public void printContent(String content){
        System.out.print("내용: " + content);
    }

    public void printRegistryTitle(String title){
        System.out.println(title);
    }

    public void printAskNumberDetail(){
        System.out.print("조회할 게시글 번호를 입력하세요: ");
    }

    public void printNotFind(){
        System.out.println("해당 번호의 게시글을 찾을 수 없습니다.");
    }

    public void printAskNumberUpdate(){
        System.out.print("수정할 게시글 번호를 입력하세요: ");
    }
    
    public void printAskUpdateTitle(){
        System.out.print("새로운 제목을 입력하세요: ");
    }

    public void printAskUpdateContent(){
        System.out.print("새로운 내용을 입력하세요: ");
    }
    
    
    public void printSuccessUpdate(){
        System.out.println("게시글이 성공적으로 수정되었습니다.");
        System.out.println();
    }

    public void printAskNumberDelete(){
        System.out.print("삭제할 게시글 번호를 입력하세요: ");
    }

    public void notYourPost(){
        System.out.println("회원님의 ID로 등록된 게시물이 아닙니다. 본인의 게시글만 수정 및 삭제가 가능합니다.");
    }

    public void printSuccessDelete(){
        System.out.println("게시글이 성공적으로 삭제되었습니다.");
        System.out.println();
    }

    public void printExit(){
        System.out.println("프로그램을 종료 합니다.");
    }

    public void printIncorrectMenu(){
        System.out.println("잘못된 입력입니다. 정확한 메뉴를 입력하세요.");
    }


}
