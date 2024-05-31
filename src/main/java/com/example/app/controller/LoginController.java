package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ログインコントローラクラス。
 * ログイン画面処理を行います。
 * @author yuki
 */
@Controller
public class LoginController {
	/**
	 * フォーム認証画面表示用メソッド
	 * @return ログイン画面
	 */
	@GetMapping("/login")
	String loginForm() {
		return "login/loginForm";
	}
}
