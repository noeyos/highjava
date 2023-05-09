package basic;

import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
import basic.CustomerExcelWriter;
import basic.CustomerVo;
 
 
public class MainApplication {
    
    public static void main(String[] args) {
        // 엑셀로 쓸 데이터 생성
        
        List<CustomerVo> list = new ArrayList<CustomerVo>();
      /*  list.add(new CustomerVo("asdf1", "사용자1", "30", "asdf1@naver.com"));
        list.add(new CustomerVo("asdf2", "사용자2", "31", "asdf2@naver.com"));
        list.add(new CustomerVo("asdf3", "사용자3", "32", "asdf3@naver.com"));
        list.add(new CustomerVo("asdf4", "사용자4", "33", "asdf4@naver.com"));
        list.add(new CustomerVo("asdf5", "사용자5", "34", "asdf5@naver.com"));*/
        
        Scanner scanner = new Scanner(System.in);


        System.out.println("번호를 입력하세요.");
        System.out.println("1. 회원가입");
        System.out.println("2. 회원정보 조회");
        System.out.println("3. 회원정보 수정");
        
        int num=Integer.parseInt(scanner.nextLine());
        
        switch (num) {
		case 1:
			 for (int i = 0; i < 2; i++) {
		        	System.out.println("----회 원 가 입-----");
		            System.out.println("고객 정보를 입력하세요");

		            System.out.print("아이디: ");
		            String id = scanner.nextLine();

		            System.out.print("이름: ");
		            String name = scanner.nextLine();

		            System.out.print("나이: ");
		            String age = scanner.nextLine();

		            System.out.print("이메일: ");
		            String email = scanner.nextLine();
		            
		            System.out.print("전화번호: ");
		            String telno = scanner.nextLine();

		            list.add(new CustomerVo(id, name, age, email, telno));
		        }
		        
		        CustomerExcelWriter excelWriter = new CustomerExcelWriter();
		        
		        //xls 파일 쓰기
		        excelWriter.xlsWriter(list);
		        
		        //xlsx 파일 쓰기
		        excelWriter.xlsxWriter(list);
			break;

		case 2:	
			CustomerExcelReader excelReader = new CustomerExcelReader();
			excelReader.reader();
			 break;
		case 3:
			break;
		case 4:
			RemoveExcelColumn removeColumn = new RemoveExcelColumn();
			removeColumn.deleteColumn(null, 2);
			break;
		default:
			break;
		}
        
       
        
    }
}
