package com.nse.group;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class GroupChatApplication{

//	@Autowired
//	private UserRepository userRepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(GroupChatApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		
//		
//		User user = new User("russ", "russ@gmail.com", "73677466377", "russ", "russ", "russ");
//		
//		GroupInfo group1 = new GroupInfo("Team1");
//		GroupInfo group2 = new GroupInfo("Team2");
//		
//		user.getGroupInfos().add(group1);
//		user.getGroupInfos().add(group2);
//		
//		group1.getUsers().add(user);
//		group2.getUsers().add(user);
//		
//		this.userRepo.save(user);
//	}

}
