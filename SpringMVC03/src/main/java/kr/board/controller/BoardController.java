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
import org.springframework.web.bind.annotation.ResponseBody;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;

@Controller
public class BoardController {
	// boardList.do
	// Spring 에서 HandlerMapping class가 요청을 받고 연결해주는 작업을 하는것

	@Autowired
	BoardMapper boardMapper;

	@RequestMapping("/")
	public String main() {
		return "main";
	}

//	// @ResponseBody -> jakson-databind에서 자동으로 객체를 json 데이터 포멧으로 변환 시켜준다
//	@RequestMapping("/boardList")
//	public @ResponseBody List<Board> boardList() {
//		List<Board> list = boardMapper.getLists();
//		return list; // 객체 리턴이라는 말은 Json 데이터 형식으로 변환(API를 이용)해서 리턴하겠다는 의미.
//	}
//
//	@RequestMapping("/boardInsert")
//	public @ResponseBody void boardInsert(Board vo) {
//		boardMapper.boardInsert(vo);
//	}
//
//	@RequestMapping("/boardDelete")
//	public @ResponseBody void boardDelete(@RequestParam("idx") int idx) {
//		boardMapper.boardDelete(idx);
//	}
//
//	@RequestMapping("/boardUpdate")
//	public @ResponseBody void boardUpdate(Board vo) {
//		boardMapper.boardUpdate(vo);
//	}
//
//	@RequestMapping("/boardContent")
//	public @ResponseBody Board boardContent(int idx) {
//		Board vo = boardMapper.boardContent(idx);
//		return vo;
//	}
}
