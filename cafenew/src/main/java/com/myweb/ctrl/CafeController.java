package com.myweb.ctrl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myweb.domain.Criteria;
import com.myweb.domain.PagingVO;
import com.myweb.service.CafeService;

@Controller
@RequestMapping("/cafe/*")
public class CafeController {
	private static final Logger log = LoggerFactory.getLogger(CafeController.class);
	
	/*
	@Inject
	private CafeService csv;
	*/
	
	@GetMapping("/list")
	public void list(Model model, Criteria cri) {
		log.info(">>> 리스트 출력 - GET");
		/*
		model.addAttribute("list", csv.list(cri));
		int totalCnt = csv.totalCount();
		model.addAttribute("pgvo", new PagingVO(totalCnt, cri));
		*/
	}
	
	@GetMapping("/write")
	public void write() {
		log.info(">>> 카페 등록 페이지 출력 - GET");
	}
}
