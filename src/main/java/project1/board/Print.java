package project1.board;

import java.util.Scanner;

public class Print {
    Scanner scanner = new Scanner(System.in);


    public String printTodo (){
        System.out.print("명령어를 입력하세요 (add, list, detail, update, delete, exit): ");
        return scanner.nextLine();
    }

    public void printNoPost(){
        System.out.println("등록된 게시글이 없습니다.");
    }

    public String printAskTitle(){
        System.out.print("제목을 입력하세요: ");
        return scanner.nextLine();
    }

    public String printAskContent(){
        System.out.print("내용을 입력하세요: ");
        return scanner.nextLine();
    }

    
    public void printSuccessRegist(){
        System.out.println("게시글이 성공적으로 등록되었습니다.");
        System.out.println();
    }

    public void printNotRegist(){
        System.out.println("게시글이 등록을 실패했습니다.");
        System.out.println();
    }


    // 리스트 전용 출력
    public void printPostSummary(Post post){
        System.out.println("====================================");
        System.out.print("번호: "+ post.getPostId()+", ");
        System.out.println("제목: " + post.getTitle());
        System.out.println("내용: "+ post.getContent());
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

    public int printAskNumberDetail(){
        System.out.print("조회할 게시글 번호를 입력하세요: ");
        int key = scanner.nextInt();
        scanner.nextLine();
        return key;
    }

    public void printNotFind(){
        System.out.println("해당 번호의 게시글을 찾을 수 없습니다.");
        System.out.println();
    }

    public int printAskNumberUpdate(){
        System.out.print("수정할 게시글 번호를 입력하세요: ");
        int key = scanner.nextInt();
        scanner.nextLine();
        return key;
    }
    
    public String printAskUpdateTitle(){
        System.out.print("새로운 제목을 입력하세요: ");
        return scanner.nextLine();
    }

    public String printAskUpdateContent(){
        System.out.print("새로운 내용을 입력하세요: ");
        return scanner.nextLine();
    }
    
    
    public void printSuccessUpdate(){
        System.out.println("게시글이 성공적으로 수정되었습니다.");
        System.out.println();
    }

    public int printAskNumberDelete(){
        System.out.print("삭제할 게시글 번호를 입력하세요: ");
        int key = scanner.nextInt();
        scanner.nextLine();
        return key;
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
    // Scanner 버퍼 지우기
    public void clearScannerBuffer() {
        scanner.nextLine();
    }

}
