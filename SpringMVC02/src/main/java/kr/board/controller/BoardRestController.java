package kr.board.controller;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.board.entity.Board;
import kr.board.mapper.BoardMapper;

@RequestMapping("/board")
@RestController		//Ajax 통신할때 쓰는 어노테이션 : @ResponseBody 생략가능
public class BoardRestController {
	@Autowired 
	BoardMapper boardMapper;
	
	// @ResponseBody -> jakson-databind에서 자동으로 객체를 json 데이터 포멧으로 변환 시켜준다
	@GetMapping("/all")
	public List<Board> boardList() {
		List<Board> list = boardMapper.getLists();
		return list; // 객체 리턴이라는 말은 Json 데이터 형식으로 변환(API를 이용)해서 리턴하겠다는 의미.
	}

	//@RequestMapping("/boardInsert")
	@PostMapping("/new")
	public void boardInsert(Board vo) {
		boardMapper.boardInsert(vo);
	}

	@DeleteMapping("/{idx}")
	public void boardDelete(@PathVariable("idx") int idx) {
		boardMapper.boardDelete(idx);
	}

	@PutMapping("/update")
	public void boardUpdate(@RequestBody Board vo) {
		boardMapper.boardUpdate(vo);
	}

	@GetMapping("/{idx}")
	public Board boardContent(@PathVariable("idx") int idx) {
		Board vo = boardMapper.boardContent(idx);
		return vo;
	}

	@PutMapping("/count/{idx}")
	public Board boardCount(@PathVariable("idx") int idx) {
		boardMapper.boardCount(idx);
		Board vo = boardMapper.boardContent(idx);
		return vo;
	}
}
