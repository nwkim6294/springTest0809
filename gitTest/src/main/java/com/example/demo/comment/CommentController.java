package com.example.demo.comment;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.Post;
import com.example.demo.PostService;
import com.example.demo.user.SiteUser;
import com.example.demo.user.UserRepository;

@RequestMapping("/comment")
@Controller
public class CommentController {

	@Autowired
	private PostService postService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CommentServiceImpl commentService;

	@PreAuthorize("isAuthenticated()")
	@PostMapping("/create/{id}") // @PathVariable : ui에 있는 자바 값 가져오기
	public String createComment(Model model, @PathVariable("id") Long id,
			@RequestParam(value = "content") String content, Principal principal) {

		System.out.println(content);
		System.out.println(principal.getName());
		// 이거 꼭 필요함?
		// 필요함 : 스프링 입장에서 어떤 게시글 업데이트 해야할지 어떻게알음?
		// principal : 현재 인증된 사용자의 정보를 나타내는 객체(username)
		try {
			Post post = this.postService.상세보기구현하기(id); // 게시글 가져오기 > 왜 가져와야하는가?
			SiteUser author = this.userRepository.findByUsername(principal.getName())
					.orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
			this.commentService.create(post, content, author);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return String.format("redirect:/show/%s", id);
	}

	// comment_form.html 파일을 오픈하는 요청을 추가해주세요.
	// url : /comment/modify/{id}
	// 다른거 신경 안쓰고 댓글 수정 페이지 오픈만 신경쓰기

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/modify/{id}")
	public String modifyComment(@PathVariable("id") Long id, Model model, Principal principal) {

		Comment cmt = this.commentService.getComment(id); //해당 댓글
		// 현재 로그인한 유저와 글쓴이가 다른가를 물어보는거임
		//  -> 댓글 수정 권한 있니?
		
		if(!cmt.getAuthor().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한 x");
		}
		
		model.addAttribute("comment", cmt);
		return "comment_form";
	}

	@PreAuthorize("isAuthenticated()")
	@PostMapping("/modify/{id}")
	public String commentModify(@PathVariable("id") Long id, @RequestParam(value="content") String content, Principal principal) {
		
		Comment cmt = this.commentService.getComment(id); //해당 댓글
		// 현재 로그인한 유저와 글쓴이가 다른가를 물어보는거임
		//  -> 댓글 수정 권한 있니?
		
		if(!cmt.getAuthor().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한 x");
		}
		
		this.commentService.modify(cmt, content);
		return String.format("redirect:/show/%s", cmt.getPost().getId());
	}
	
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/delete/{id}")
	public String deleteComment(@PathVariable("id") Long id, 
			Model model, Principal principal) {

		Comment cmt = this.commentService.getComment(id); //해당 댓글
		// 현재 로그인한 유저와 글쓴이가 다른가를 물어보는거임
		//  -> 댓글 수정 권한 있니?
		
		// 사실 삭제에서는(우리 서비스 기준) 이거 없어도 이거 없어도 왠만하면 정상 작동할거임
		//  -> 다만 비정상적인 접근을 방어한다 라는 의미로 둔다한들 문제는 없음
		if(!cmt.getAuthor().getUsername().equals(principal.getName())) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한 x");
		}
		
		this.commentService.delete(cmt);
		return String.format("redirect:/show/%s", cmt.getPost().getId());
	}


}
