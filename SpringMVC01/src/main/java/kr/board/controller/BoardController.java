package kr.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;

@Controller
public class BoardController {
	//boardList.do
	// Spring 에서 HandlerMapping class가 요청을 받고 연결해주는 작업을 하는것
	
	@Autowired	//DI -> bean에서 생성된 객체를 주입해준다.
	private BoardMapper mapper;
	
	@RequestMapping("/boardList")	
	public String boardList(Model model) {
		List<Board> list = mapper.getLists();		
		model.addAttribute("list", list); //객체바인딩
		
		return "boardList";	//Spring에서 제공하는 ViewResolver가  /WEB-INF/views/boardList.jsp 경로를 만들어서 forward해주게 된다.
	}
	
	@RequestMapping("/boardForm")	
	public String boardForm() {		
		return "boardForm";	// /WEB-INF/view/boardForm.jsp -> forward
	}
	
	@RequestMapping("/boardInsert")	
	public String boardInsert(Board vo) { //title, content, writer => 파라메터수집(Board)
		mapper.boardInsert(vo);
		return "redirect:/boardList";
	}
	
	@RequestMapping("/boardContent")
	public String boardContent(@RequestParam("idx") int idx, Model model) {
		Board vo = mapper.boardContent(idx);
		
		//조회수증가
		mapper.boardCount(idx);
		model.addAttribute("vo", vo);
		return "boardContent";
	}
	
	@RequestMapping("/boardDelete/{idx}")
	public String boardDelete(@PathVariable("idx")int idx) {
		mapper.boardDelete(idx);
		return "redirect:/boardList";
	}
	
	@RequestMapping("/boardUpdateForm/{idx}")
	public String boardUpdateForm(@PathVariable("idx")int idx, Model model) {		
		Board vo = mapper.boardContent(idx);
		model.addAttribute("vo", vo);
		return "boardUpdate";
	}
	
	@RequestMapping("/boardUpdate")
	public String boardUpdate(Board vo) {		
		mapper.boardUpdate(vo);		
		return "redirect:/boardList";
	}
}
	

