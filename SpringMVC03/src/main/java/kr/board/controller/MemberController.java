package kr.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.board.entity.Member;
import kr.board.mapper.MemberMapper;

@Controller
public class MemberController {
	
	@Autowired
	MemberMapper memberMapper;
	
	@RequestMapping("/memJoin")
	public String memJoin() {		
		return "member/join";
	}
	
	@RequestMapping("/memRegisterCheck")
	public @ResponseBody int memRegisterCheck(@RequestParam("memID") String memID) {
		int result = memberMapper.memRegisterCheck(memID);
		return result;	//0:노중복, 1: 중복
		
//		Member m = memberMapper.memRegisterCheck(memID);
//		if(m != null || !memID.equals("")) {
//			return 0;	// 이미존재하는 회원
//		}
//		return 1;
		
	}
	
}
