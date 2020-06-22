package com.myweb.ctrl;

import java.io.IOException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.domain.Criteria;
import com.myweb.domain.PagingVO;
import com.myweb.service.NoticeService;
import com.myweb.util.FileProcess;

@Controller
@RequestMapping("/notice/*")
public class NoticeCtrl {
	private static final Logger log = LoggerFactory.getLogger(NoticeCtrl.class);

	@Inject
	private NoticeService nsv;
	@Inject
	private FileProcess fp;
	
	@GetMapping("/write")
	public void write() {
		log.info(">>> 공지 등록 페이지 출력 - GET");
	}
	
	@PostMapping("/write")
	public String write(MultipartHttpServletRequest req, RedirectAttributes reAttr) throws IllegalStateException, IOException {
		log.info(">>> 공지 등록 요청 - POST");
		nsv.write(fp.fileUp(req));
		reAttr.addFlashAttribute("result", "write_ok");
		return "redirect:/notice/list";
	}
	
	@GetMapping("/list")
	public void list(Model model, Criteria cri) {
		log.info(">>> 리스트 출력 - GET");
		model.addAttribute("list", nsv.list(cri));
		int totalCnt = nsv.totalCount();
		model.addAttribute("pgvo", new PagingVO(totalCnt, cri));
	}
	
	@GetMapping({"/detail", "/modify"})
	public void detail(@RequestParam("num") int num, Model model, @ModelAttribute("cri") Criteria cri) {
		log.info(">>> 공지 상세 페이지 출력 - GET");
		model.addAttribute("nvo", nsv.detail(num));
	}
	
	@PostMapping("/modify")
	public String modify(MultipartHttpServletRequest req, RedirectAttributes reAttr, @ModelAttribute("cri") Criteria cri) throws IllegalStateException, IOException {
		log.info(">>> 공지 수정 요청 - POST");
		nsv.modify(fp.fileReLoad(req));
		reAttr.addAttribute("pageNum", cri.getPageNum());
		reAttr.addAttribute("amount", cri.getAmount());
		reAttr.addFlashAttribute("result", "modify_ok");
		return "redirect:/notice/detail?num="+req.getParameter("num");
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("num") int num, @RequestParam("imgfile") String imgfile, RedirectAttributes reAttr, @ModelAttribute("cri") Criteria cri) {
		log.info(">>> 공지 삭제 요청 - POST");
		if(!imgfile.equals("NONE")) {
			fp.fileRemove(imgfile);
		}
		nsv.remove(num);
		reAttr.addAttribute("pageNum", cri.getPageNum());
		reAttr.addAttribute("amount", cri.getAmount());
		reAttr.addFlashAttribute("result", "remove_ok");
		return "redirect:/notice/list";
	}
	
	@PostMapping("/rmimg")
	public String removeImg(@RequestParam("num") int num, @RequestParam("imgfile") String imgfile) {
		log.info(">>> 이미지 삭제 로직 실행");
		fp.fileRemove(imgfile);
		nsv.removeImg(num);
		return "redirect:/";
	}
}
