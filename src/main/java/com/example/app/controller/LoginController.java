package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ログインコントローラクラス。
 * ログイン画面処理を行います。
 * @author yuki
 */
@Controller
@RequestMapping("loginForm")
public class LoginController {
	/**
	 * フォーム認証画面表示用メソッド
	 * @return ログイン画面
	 */
	@GetMapping
	String loginForm() {
		return "login/loginForm";
	}
}
