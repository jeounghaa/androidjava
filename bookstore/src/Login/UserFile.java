package Login;

import java.io.FileWriter;
import java.io.IOException;

import DB.UserVO;

public class UserFile {

	public UserFile(UserVO vo) {

		try {
			FileWriter fw = new FileWriter("src/User/" + vo.getName() + ".txt");
			fw.write(vo.getId() + ", ");
			fw.write(vo.getPassword() + ", ");
			fw.write(vo.getName() + ", ");
			fw.write(vo.getTel() + ", ");
			fw.write(vo.getEmail() + ", ");
			fw.write(vo.getAddress() + ", ");
			fw.write(vo.getAddresstwo() + "\n");
			fw.close();
		} catch (IOException e) {
			System.out.println("파일 저장부분에서 에러");
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

	}

}
