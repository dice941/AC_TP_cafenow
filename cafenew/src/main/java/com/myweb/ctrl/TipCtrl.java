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
import com.myweb.service.TipService;
import com.myweb.util.FileProcess;

@Controller
@RequestMapping("/tip/*")
public class TipCtrl {
	private static final Logger log = LoggerFactory.getLogger(TipCtrl.class);

	@Inject
	private TipService tsv;
	@Inject
	private FileProcess fp;
	
	@GetMapping("/write")
	public void write() {
		log.info(">>> 제보 작성 페이지 출력 - GET");
	}
	
	@PostMapping("/write")
	public String write(MultipartHttpServletRequest req, RedirectAttributes reAttr) throws IllegalStateException, IOException {
		log.info(">>> 제보 내용 등록 요청 - POST");
		tsv.write(fp.filesave(req));
		reAttr.addFlashAttribute("result", "write_ok");	//한번 전송되고 끝남. 갖고 있지 않음
		return "redirect:/tip/list";
	}
	
	@GetMapping("/list")
	public void list(Model model, Criteria cri) {
		log.info(">>> 제보 리스트 출력 - GET");
		model.addAttribute("list", tsv.list(cri));
		int totalCnt = tsv.totalCount(cri);
		model.addAttribute("pgvo", new PagingVO(totalCnt, cri));
	}
	
	@GetMapping({"/detail", "/modify"})
	public void detail(@RequestParam("tno") int tno, Model model, @ModelAttribute("cri") Criteria cri) {
		log.info(">>> 제보 상세 페이지 출력 - GET");
		model.addAttribute("tvo", tsv.detail(tno));
	}
	
	@PostMapping("/modify")
	public String modify(MultipartHttpServletRequest req, RedirectAttributes reAttr, @ModelAttribute("cri") Criteria cri) throws IllegalStateException, IOException {
		log.info(">>> 제보 수정 요청 - POST");
		tsv.modify(fp.fileModify(req));
		reAttr.addAttribute("pageNum", cri.getPageNum());
		reAttr.addAttribute("amount", cri.getAmount());
		reAttr.addFlashAttribute("result", "modify_ok");
		return "redirect:/tip/detail?tno="+req.getParameter("tno");
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("tno") int tno, @RequestParam("imgfile") String imgfile, RedirectAttributes reAttr, @ModelAttribute("cri") Criteria cri) {
		log.info(">>> 제보 삭제 요청 - POST");
		if(!imgfile.equals("NONE")) {
			fp.fileRemove(imgfile);
		}
		tsv.remove(tno);
		reAttr.addAttribute("pageNum", cri.getPageNum());
		reAttr.addAttribute("amount", cri.getAmount());
		reAttr.addFlashAttribute("result", "remove_ok");
		return "redirect:/tip/list";
	}
	
	@PostMapping("/rmimg")
	public String removeImg(@RequestParam("tno") int tno, @RequestParam("imgfile") String imgfile) {
		log.info(">>> 이미지 삭제 로직 실행");
		fp.fileRemove(imgfile);
		tsv.removeImg(tno);
		return "redirect:/";
	}
}
