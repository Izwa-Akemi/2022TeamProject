package shopping.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import shopping.example.models.dao.UserDao;
import shopping.example.models.entity.UserEntity;



@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	  //ユーザの情報を保存する
	public boolean createAccount(String userName,String userEmail, String password) {
		//UserServiceから渡されるユーザ情報（ユーザ名、パスワード）を条件にDB検索で検索する
		List<UserEntity> userList = userDao.findByUserNameAndPassword(userName, password);

		if (userList.isEmpty()) {
			
			userDao.save(new UserEntity(userName,userEmail,password));
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validateAccount(String username, String password) { 
		UserEntity account = userDao.findByUserName(username);
		if (account == null || !account.getPassword().equals(password)) {
			return false;
		} else {
			return true;
		}
	}
	public UserEntity findByUserNameAndPassword(String userName, String password) {
		//コントローラークラスからuserNameとpasswordと受け取って結果を受け取る
		List<UserEntity> userList = userDao.findByUserNameAndPassword(userName, password);
		//もしuserListが空だった場合には、nullを返す処理
		if(userList.isEmpty()){
	        return null;
	    }else{
	        return userList.get(0);
	    }

	}
	//ユーザaddressを保存する
	public void update(Long userId,String zipCode, String address) {
		userDao.save(new UserEntity(userId,zipCode,address));
		 
	}
	
	
    //ユーザの一覧を取得する
	public List<UserEntity> getAllAccounts() {
		return userDao.findAll();
	}

	public UserEntity selectById(String userName) {
		return userDao.findByUserName(userName);
	}

}