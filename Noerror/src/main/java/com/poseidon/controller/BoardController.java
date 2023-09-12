package com.poseidon.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poseidon.entity.Board;
import com.poseidon.service.BoardService;


@Controller
public class BoardController {
	
	@Resource(name="boardService")
	private BoardService boardService;

	
	@GetMapping("/board")
	public String board(@RequestParam(name="pageNo", required = false, defaultValue = "1") int pageNo, Model model) {
		
		Page<Board> list = boardService.list(pageNo);
		model.addAttribute("list", list);
		model.addAttribute("pageNo", pageNo);
		return "board";
	}
	@GetMapping("/write")
	public String write() {
		return "write";
	}
	
	//fetch()써보기
	@ResponseBody
	@PostMapping("/insertCode")
	public String insertCode(@RequestBody Board board) throws JsonProcessingException {
		Board result = boardService.save(board);
		//System.out.println(result.getBno());
		
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("result", "0");
		
		if (result != null && result.getBno() != 0){
			resultMap.put("result", "1");
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(resultMap);
		//System.out.println(json);
		return json;
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam(name="bno", required = true) int bno, Model model) {
		Board detail = boardService.detail(bno);
		//String code = detail.getCode().replaceAll("\n", "<br>");
		//System.out.println(code);
		//detail.setCode(code);
		model.addAttribute("detail", detail);
		return "detail";
	}
}
